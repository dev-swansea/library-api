package com.rmsoft.library.service;

import com.rmsoft.library.mappers.OutMapper;
import com.rmsoft.library.domain.dto.OutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutService {

  private final OutMapper outMapper;

  public void saveOut(OutRequest request) {
    outMapper.insertOut(request);
  }
}
