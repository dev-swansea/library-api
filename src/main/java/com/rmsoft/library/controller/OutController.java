package com.rmsoft.library.controller;

import com.rmsoft.library.domain.dto.BookResponse;
import com.rmsoft.library.domain.dto.OutBookRequest;
import com.rmsoft.library.domain.dto.OutRequest;
import com.rmsoft.library.service.BookService;
import com.rmsoft.library.service.OutService;
import com.rmsoft.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OutController {

  private final OutService outService;
  private final UserService userService;
  private final BookService bookService;

  @PostMapping("/books/book")
  public ResponseEntity<String> outBook(@PathVariable String title, @RequestBody OutBookRequest request) {
    BookResponse book = bookService.findBookByIsbn(request.getIsbn());
    if (book == null) {
      return ResponseEntity.badRequest().body("해당 도서가 없습니다.");
    } else if (!book.isState()) {
      return ResponseEntity.badRequest().body("해당 도서가 이미 대출중 입니다.");
    }

    bookService.updateStatus(0);
    //outService.saveOut(new OutRequest(book.getBookId()));

    return ResponseEntity.ok().body("대출되었습니다.");
  }

}
