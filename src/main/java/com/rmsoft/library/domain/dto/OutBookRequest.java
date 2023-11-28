package com.rmsoft.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OutBookRequest {
  private String email;
  private String isbn;
}
