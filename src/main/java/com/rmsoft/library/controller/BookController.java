package com.rmsoft.library.controller;

import com.rmsoft.library.domain.Book;
import com.rmsoft.library.domain.dto.BookRequest;
import com.rmsoft.library.domain.dto.BookResponse;
import com.rmsoft.library.domain.dto.BookUpdateDto;
import com.rmsoft.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  /**
   * 전체 도서 검색
   *
   * @return 전체 도서
   */
  @GetMapping("/books")
  public ResponseEntity<List<BookResponse>> findAll() {
    List<Book> books = bookService.findAll();
    List<BookResponse> bookResponses = new ArrayList<>();

    books.forEach(e -> {
      bookResponses.add(new BookResponse(e));
    });

    return ResponseEntity.ok().body(bookResponses);
  }

  /**
   * 특정 도서 검색
   *
   * @param title 책 제목
   * @return 특정 도서
   */
  @GetMapping("/books/{title}")
  public ResponseEntity<BookResponse> findBookByTitle(@PathVariable String title) {
    Book book = bookService.findBookByTitle(title);
    return ResponseEntity.ok().body(new BookResponse(book));
  }

  /**
   * @param request BookRequest
   * @return 결과
   */
  @PostMapping("/books")
  public ResponseEntity<String> saveBook(@RequestBody BookRequest request) {
    bookService.saveBook(request);
    return ResponseEntity.ok().body("등록되었습니다.");
  }

  /**
   * 도서 수정
   *
   * @param title         책 제목
   * @param bookUpdateDto bookUpdateDto
   * @return 결과
   */
  @RequestMapping(value = "/books/{title}", method = {RequestMethod.PUT, RequestMethod.PATCH})
  public ResponseEntity<String> updateBook(@PathVariable String title, @RequestBody BookUpdateDto bookUpdateDto) {
    Book book = bookService.findBookByTitle(title);
    bookUpdateDto.setBookId(book.getBookId());
    bookUpdateDto.setTitle(title);
    bookService.updateBook(bookUpdateDto);
    return ResponseEntity.ok().body("수정되었습니다.");
  }

}
