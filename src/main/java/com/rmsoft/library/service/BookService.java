package com.rmsoft.library.service;

import com.rmsoft.library.domain.Book;
import com.rmsoft.library.domain.dto.BookRequest;
import com.rmsoft.library.domain.dto.BookUpdateDto;
import com.rmsoft.library.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookMapper bookMapper;

  public List<Book> findAll() {
    return bookMapper.selectAll();
  }

  public List<Book> findBookByTitle(String title) {
    return bookMapper.selectBookByTitle(title.replaceAll(" ", ""));
  }

  public Book findBookByIsbn(String isbn) {
    return bookMapper.selectBookByIsbn(isbn);
  }

  public void saveBook(BookRequest request) {
    String isbn = Arrays.toString(makeIsbnNum()).replace(",", "")
            .replace(" ", "").replaceAll("[\\[\\]]", "");
    request.setIsbn(isbn);
    bookMapper.insertBook(request);
  }

  public void updateBook(BookUpdateDto bookUpdateDto) {
    bookMapper.updateBook(bookUpdateDto);
  }


  private int[] makeIsbnNum() {
    int[] oneToTen = new int[10];
    if (!checkIsbnNum(oneToTen)) {
      oneToTen = makeIsbnNum();
    }
    return oneToTen;
  }

  private boolean checkIsbnNum(int[] oneToTen) {
    Random random = new Random();
    int result = 0;
    int cnt = 1;

    for (int i = 0; i < oneToTen.length; i++) {
      oneToTen[i] = random.nextInt(10);
    }

    for (int i = 0; i < 10; i++) {
      result += oneToTen[i] * cnt++;
    }

    if (result % 11 == 0) {
      return true;
    } else {
      return false;
    }
  }

}
