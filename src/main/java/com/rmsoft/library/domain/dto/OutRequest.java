package com.rmsoft.library.domain.dto;

import lombok.AllArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@AllArgsConstructor
@Alias("OutRequest")
public class OutRequest {
  private int userId;
  private int bookId;
}
