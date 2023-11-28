package com.rmsoft.library.domain.dto;

import com.rmsoft.library.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class BookRequest {

  private int cId;
  private String isbn;
  private String title;
  private String author;
  private String publisher;
  private String bookDescription;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate publishingDate;

  public Book toEntity() {
    return new Book(cId, isbn, title, author, publisher, bookDescription, publishingDate);
  }
}
