package com.home.temperatureapi.dto;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateRequest {

  @NotBlank(message = "room must not be blank")
  private String room;
  @NotBlank(message = "temp must not be blank")
  private String temp;
}
