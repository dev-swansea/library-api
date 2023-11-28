package com.rmsoft.library.controller;

import com.rmsoft.library.service.BookService;
import com.rmsoft.library.domain.dto.BookRequest;
import com.rmsoft.library.domain.dto.BookResponse;
import com.rmsoft.library.domain.dto.BookUpdateDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("/books")
  public List<BookResponse> findAll(HttpServletRequest req) {
    return bookService.findAll();
  }

  @GetMapping("/books/{title}")
  public BookResponse findBookByTitle(@PathVariable String title) {
    return bookService.findBookByTitle(title);
  }

  @PostMapping("/books")
  public ResponseEntity<String> saveBook(@RequestBody BookRequest request) {
    bookService.saveBook(request);
    return ResponseEntity.ok().body("등록되었습니다.");
  }

  @RequestMapping(value = "/books/{title}", method = {RequestMethod.PUT, RequestMethod.PATCH})
  public ResponseEntity<String> updateBook(@PathVariable String title, @RequestBody BookUpdateDto bookUpdateDto) {
    BookResponse book = findBookByTitle(title);
    bookUpdateDto.setBookId(book.getBookId());
    bookUpdateDto.setTitle(title);
    bookService.updateBook(bookUpdateDto);
    return ResponseEntity.ok().body("수정되었습니다.");
  }

}
