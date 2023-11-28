package com.rmsoft.library.domain.dto;

import com.rmsoft.library.domain.Out;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;


public class OutResponse {
  private LocalDate outDate;
  private LocalDate returnDete;
  private String email;

  public OutResponse(Out out) {
    this.outDate = out.getOutDate();
    this.returnDete = out.getReturnDete();
    this.email = out.getEmail();
  }
}
