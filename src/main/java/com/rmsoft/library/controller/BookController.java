package com.rmsoft.library.controller;

import com.rmsoft.library.domain.Book;
import com.rmsoft.library.domain.dto.BookRequest;
import com.rmsoft.library.domain.dto.BookResponse;
import com.rmsoft.library.domain.dto.BookUpdateDto;
import com.rmsoft.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
   * 특정 도서 제목으로 검색
   *
   * @param title 책 제목
   * @return 특정 도서
   */
  @GetMapping("/books/{title}")
  public ResponseEntity<List<BookResponse>> findBookByTitle(@PathVariable String title) {
    List<Book> books = bookService.findBookByTitle(title);
    List<BookResponse> response = new ArrayList<>();
    books.forEach(e -> {
      response.add(new BookResponse(e));
    });
    return ResponseEntity.ok().body(response);
  }

  /**
   * 도서에 대한 개별 정보 확인
   *
   * @param isbn isbn
   * @return BookResponse
   */
  @GetMapping("/books/book/{isbn}")
  public ResponseEntity<BookResponse> findBookByIsbn(@PathVariable String isbn) {
    Book book = bookService.findBookByIsbn(isbn);
    return ResponseEntity.ok().body(new BookResponse(book));
  }

  /**
   * 도서 저장
   *
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
   * @param isbn          책 제목 => 필수
   * @param bookUpdateDto bookUpdateDto
   * @return 결과
   */
  @RequestMapping(value = "/books/{isbn}", method = {RequestMethod.PUT, RequestMethod.PATCH})
  public ResponseEntity<String> updateBook(@PathVariable String isbn, @RequestBody BookUpdateDto bookUpdateDto) {
    Book book = bookService.findBookByIsbn(isbn);
    bookUpdateDto.setBookId(book.getBookId());
    bookService.updateBook(bookUpdateDto);
    return ResponseEntity.ok().body("수정되었습니다.");
  }

}
