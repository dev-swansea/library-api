package com.rmsoft.library.book;

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
  public void saveTest() {
    //bookMapper.insertBook(new BookRequest("100", null, "윗집애기는 왜이리 울어", "불쌍하다", "당진", "윗집 애기가 맨날 울어요", "2021-12-01"));
  }

  @Test
  public void findTest() {
    BookResponse 윗집애 = bookMapper.selectBookByTitle("윗집애");
    System.out.println(윗집애.getPublishingDate());
  }

}