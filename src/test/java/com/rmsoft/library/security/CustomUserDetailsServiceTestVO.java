package com.rmsoft.library.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomUserDetailsServiceTestVO {

  @Autowired
  CustomUserDetailsService service;

  @Test
  void loadUserByUsername() {
    service.loadUserByUsername("suwan");
  }
}