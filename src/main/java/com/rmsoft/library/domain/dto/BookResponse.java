package com.rmsoft.library.domain.dto;

import com.rmsoft.library.domain.Book;
import com.rmsoft.library.domain.Classification;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class BookResponse {
  private String isbn;
  private String title;
  private String author;
  private String publisher;
  private String bookDescription;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate publishingDate;
  private boolean state;
  private Classification classification;

  public BookResponse(Book book) {
    this.isbn = book.getIsbn();
    this.title = book.getTitle();
    this.author = book.getAuthor();
    this.publisher = book.getPublisher();
    this.bookDescription = book.getBookDescription();
    this.publishingDate = book.getPublishingDate();
    this.state = book.isState();
    this.classification = book.getClassification();
  }
}
