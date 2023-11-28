package com.rmsoft.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@NoArgsConstructor
@Alias("Classification")
@Setter
@Getter
public class Classification {
  private int cId;
  private String cName;
}
