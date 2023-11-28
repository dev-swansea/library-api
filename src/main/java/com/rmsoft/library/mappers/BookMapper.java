package com.rmsoft.library.mappers;

import com.rmsoft.library.domain.Book;
import com.rmsoft.library.domain.dto.BookRequest;
import com.rmsoft.library.domain.dto.BookResponse;
import com.rmsoft.library.domain.dto.BookUpdateDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

  List<Book> selectAll();

  Book selectBookByTitle(String title);

  Book selectBookByIsbn(String isbn);

  void insertBook(BookRequest request);

  void updateBook(BookUpdateDto dto);

}
