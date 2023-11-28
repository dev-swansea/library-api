package com.rmsoft.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("Authentication")
@AllArgsConstructor
public class Authentication {

  private Long userId;
  private String authority;

}
