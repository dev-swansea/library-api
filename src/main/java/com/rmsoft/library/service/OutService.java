package com.rmsoft.library.service;

import com.rmsoft.library.domain.Book;
import com.rmsoft.library.domain.dto.OutBookRequest;
import com.rmsoft.library.mappers.BookMapper;
import com.rmsoft.library.mappers.OutMapper;
import com.rmsoft.library.domain.dto.OutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OutService {

  private final OutMapper outMapper;
  private final BookMapper bookMapper;

  @Transactional
  public void saveOut(OutRequest request) {
    outMapper.updateState(false, request.getBookId());
    outMapper.insertOut(request);
  }

  public Book updateOut(OutBookRequest request) {
    Book book = bookMapper.selectBookByIsbn(request.getIsbn());
    outMapper.updateState(true, book.getBookId());
    outMapper.updateReturnDate(book.getBookId());
    return book;
  }
}
