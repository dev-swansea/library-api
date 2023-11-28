package com.rmsoft.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Alias("BookUpdateDto")
public class BookUpdateDto {
  private int bookId;
  private String title;
  private String author;
  private String publisher;
  private String bookDescription;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate publishingDate;
}
