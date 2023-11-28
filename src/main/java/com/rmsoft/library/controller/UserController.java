package com.rmsoft.library.controller;

import com.rmsoft.library.domain.User;
import com.rmsoft.library.domain.dto.UserJoinRequest;
import com.rmsoft.library.domain.dto.UserJoinResponse;
import com.rmsoft.library.domain.dto.UserLoginRequest;
import com.rmsoft.library.domain.dto.UserLoginResponse;
import com.rmsoft.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  @PostMapping("/join")
  public ResponseEntity<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
    User user = userService.join(request.toEntity(passwordEncoder.encode(request.getPassword())));
    return ResponseEntity.ok().body(new UserJoinResponse(user));
  }

  @PostMapping("/login")
  public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
    String token = userService.login(request.getEmail(), request.getPassword());
    return ResponseEntity.ok().body(new UserLoginResponse(token));
  }
}
