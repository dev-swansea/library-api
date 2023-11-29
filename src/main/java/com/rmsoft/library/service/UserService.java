package com.rmsoft.library.service;

import com.rmsoft.library.domain.Authentication;
import com.rmsoft.library.domain.User;
import com.rmsoft.library.jwt.JwtTokenUtil;
import com.rmsoft.library.mappers.AuthenticationMapper;
import com.rmsoft.library.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

  private final UserMapper userMapper;
  private final AuthenticationMapper authenticationMapper;
  private final PasswordEncoder passwordEncoder;
  @Value("${jwt.secret-key}")
  private String secretKey;
  private long expriedTimeMs = 1000 * 60 * 60;

  @Transactional
  public User join(User user) {
    userMapper.findByEmail(user.getEmail())
            .ifPresent(u -> {
              throw new IllegalArgumentException("해당 사용자가 없습니다.");
            });
    userMapper.insertUser(user);
    authenticationMapper.insertRole(new Authentication(user.getUserId(), "USER"));
    return user;
  }

  public String login(String email, String password) {

    User user = userMapper.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException(email + "님은 없는 회원입니다."));

    List<Authentication> authList = user.getAuthList();

    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new IllegalArgumentException("email 또는 password를 틀렸습니다.");
    }

    return JwtTokenUtil.createToken(email, authList, secretKey, expriedTimeMs);
  }

  public User findUserByEmail(String email) {
    return userMapper.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException(email + "님은 없는 회원입니다."));
  }

}
