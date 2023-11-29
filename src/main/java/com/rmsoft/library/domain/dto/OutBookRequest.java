package com.rmsoft.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutBookRequest {
  private String email;
  private String isbn;
}
