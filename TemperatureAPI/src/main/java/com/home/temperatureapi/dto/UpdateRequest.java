package com.home.temperatureapi.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateRequest {

  @ApiModelProperty(required = true)
  @NotBlank(message = "room must not be blank")
  private String room;

  @ApiModelProperty(required = true)
  @NotBlank(message = "temp must not be blank")
  private String temp;
}
