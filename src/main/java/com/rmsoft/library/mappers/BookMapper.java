package com.rmsoft.library.mappers;

import com.rmsoft.library.domain.dto.BookRequest;
import com.rmsoft.library.domain.dto.BookResponse;
import com.rmsoft.library.domain.dto.BookUpdateDto;

import java.util.List;

public interface BookMapper {

  List<BookResponse> selectAll();

  BookResponse selectBookByTitle(String title);

  BookResponse selectBookByIsbn(String isbn);

  void insertBook(BookRequest request);

  void updateBook(BookUpdateDto dto);

  void updateState(int flag);
}
