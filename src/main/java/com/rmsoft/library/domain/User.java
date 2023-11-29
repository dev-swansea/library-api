package com.rmsoft.library.domain;

import com.rmsoft.library.domain.dto.UserJoinRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Alias("User")
@Getter
@Setter
public class User {

  private Long userId;
  private String email;
  private String password;
  private String lastName;
  private String firstName;
  private String address;
  private String phone;
  private LocalDate createDate;

  private List<Authentication> authList;

  public User(String email, String password, String lastName, String firstName, String address, String phone) {
    this.email = email;
    this.password = password;
    this.lastName = lastName;
    this.firstName = firstName;
    this.address = address;
    this.phone = phone;
  }

}
