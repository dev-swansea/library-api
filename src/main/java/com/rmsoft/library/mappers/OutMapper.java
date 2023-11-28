package com.rmsoft.library.mappers;

import com.rmsoft.library.domain.dto.OutRequest;
import org.apache.ibatis.annotations.Param;

public interface OutMapper {

  void insertOut(OutRequest request);

  void updateState(@Param("state") boolean state, @Param("bookId") long bookId);

  void updateReturnDate(long bookId);
}
