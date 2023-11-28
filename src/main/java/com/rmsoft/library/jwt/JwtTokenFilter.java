package com.rmsoft.library.jwt;

import com.rmsoft.library.domain.User;
import com.rmsoft.library.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

  private final UserService userService;
  private final String secreyKey;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (auth == null || !auth.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    String token;
    try {
      token = auth.split(" ")[1];
    } catch (Exception e) {
      log.error("token 추출에 실패하였습니다.");
      filterChain.doFilter(request, response);
      return;
    }

    if (JwtTokenFilter.isExpired(token, secreyKey)) {
      filterChain.doFilter(request, response);
      return;
    }

    String userEmail = JwtTokenUtil.getUserEmail(extractClaim(token, secreyKey));
    User user = userService.findUserByEmail(userEmail);

    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserId(), null, List.of(new SimpleGrantedAuthority(user.getAuthList().get(0).toString())));

    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

    filterChain.doFilter(request, response);
  }

  private static Claims extractClaim(String token, String secreyKey) {
    return Jwts.parser().setSigningKey(secreyKey).parseClaimsJws(token).getBody();
  }

  private static boolean isExpired(String token, String secreyKey) {
    return extractClaim(token, secreyKey).getExpiration().before(new Date());
  }

}
