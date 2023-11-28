package com.rmsoft.library.domain.dto;

import com.rmsoft.library.domain.Out;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class OutRequest {
  private String email;
  private Long userId;
  private Long bookId;

  public Out toEntity() {
    return new Out(email, userId, bookId);
  }
}
