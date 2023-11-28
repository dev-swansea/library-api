package com.rmsoft.library.domain.dto;

import com.rmsoft.library.domain.Classification;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Alias("BookResponse")
public class BookResponse {
  private int bookId;
  private String isbn;
  private String title;
  private String author;
  private String publisher;
  private String bookDescription;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate publishingDate;
  private boolean state;

  private Classification classification;
}
