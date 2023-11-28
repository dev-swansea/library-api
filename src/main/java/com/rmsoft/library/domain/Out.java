package com.rmsoft.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Alias("Out")
public class Out {
  private int outId;
  private LocalDate outDate;
  private LocalDate returnDete;
  private String email;
  private Long userId;
  private Long bookId;

  public Out(String email, Long userId, Long bookId) {
    this.email = email;
    this.userId = userId;
    this.bookId = bookId;
  }
}
