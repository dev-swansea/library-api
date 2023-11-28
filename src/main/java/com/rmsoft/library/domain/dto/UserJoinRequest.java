package com.rmsoft.library.domain.dto;

import com.rmsoft.library.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserJoinRequest {
  private String email;
  private String password;
  private String lastName;
  private String firstName;
  private String address;
  private String phone;
  private LocalDate createDate;

  public User toEntity(String password) {
    return new User(email, password, lastName, firstName, address, phone, createDate);
  }
}
