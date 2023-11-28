package com.rmsoft.library.domain.dto;

import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@NoArgsConstructor
@Alias("OutResponse")
public class OutResponse {
  private int outId;
  private LocalDate outDate;
  private LocalDate returnDete;
  private int userId;
  private int bookId;
}
