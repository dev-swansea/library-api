package com.rmsoft.library.book;

import com.rmsoft.library.domain.Book;
import com.rmsoft.library.domain.dto.BookRequest;
import com.rmsoft.library.domain.dto.BookResponse;
import com.rmsoft.library.mappers.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTest {

  @Autowired
  BookMapper bookMapper;


  @Test
  public void findTest() {
    //Book 윗집애 = bookMapper.selectBookByTitle("윗집애");
    //System.out.println(윗집애.getPublishingDate());
  }

}