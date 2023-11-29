package com.rmsoft.library.controller;

import com.rmsoft.library.domain.Book;
import com.rmsoft.library.domain.dto.BookResponse;
import com.rmsoft.library.domain.dto.OutBookRequest;
import com.rmsoft.library.domain.dto.OutRequest;
import com.rmsoft.library.jwt.JwtTokenUtil;
import com.rmsoft.library.service.BookService;
import com.rmsoft.library.service.OutService;
import com.rmsoft.library.service.UserService;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class OutController {

  private final OutService outService;
  private final BookService bookService;

  /**
   * 도서를 대출한다.
   *
   * @param request   isbn
   * @param principal principal
   * @return 결과
   */
  @PostMapping("/books/book")
  public ResponseEntity<String> outBook(@RequestBody OutBookRequest request, Principal principal) {
    Book book = bookService.findBookByIsbn(request.getIsbn());
    String[] principalArr = principal.getName().replaceAll("[\\[\\]]", "").split(",");

    if (book == null) {
      return ResponseEntity.badRequest().body("해당 도서가 없습니다.");
    } else if (!book.isState()) {
      return ResponseEntity.badRequest().body("해당 도서가 이미 대출중 입니다.");
    }


    outService.saveOut(new OutRequest(principalArr[1].trim(), Long.parseLong(principalArr[0]), book.getBookId()));

    return ResponseEntity.ok().body("대출되었습니다.");
  }

  /**
   * @param request request
   * @return 결과
   */
  @RequestMapping(value = "/books/book", method = {RequestMethod.PUT, RequestMethod.PATCH})
  public ResponseEntity<String> returnBook(@RequestBody OutBookRequest request) {
    Book book = outService.updateOut(request);

    if (book.isState()) {
      throw new IllegalArgumentException("해당 도서는 반납이 불가능 합니다.");
    }

    return ResponseEntity.ok().body(book.getTitle() + "책이 반납되었습니다.");
  }

}
