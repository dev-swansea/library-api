package com.rmsoft.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Alias("Book")
@NoArgsConstructor
public class Book {
  private Long bookId;
  private int cId;
  private String isbn;
  private String title;
  private String author;
  private String publisher;
  private String bookDescription;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private String publishingDate;
  private boolean state;
  private Classification classification;
}
