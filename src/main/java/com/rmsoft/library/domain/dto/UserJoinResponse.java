package com.rmsoft.library.domain.dto;

import com.rmsoft.library.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinResponse {

  private String email;
  private String fullName;

  public UserJoinResponse(User user) {
    this.email = user.getEmail();
    fullName = user.getLastName() + user.getFirstName();
  }

}
