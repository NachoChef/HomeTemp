package com.home.temperatureapi.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomTempResponse {

  @ApiModelProperty
  private String lastTemp;

  @ApiModelProperty
  private Map<String, String> averages;

}
