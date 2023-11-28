package com.rmsoft.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
  private LocalDate publishingDate;
  private boolean state;
  private Classification classification;

  public Book(int cId, String isbn, String title, String author, String publisher, String bookDescription, LocalDate publishingDate) {
    this.cId = cId;
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.bookDescription = bookDescription;
    this.publishingDate = publishingDate;
  }
}
