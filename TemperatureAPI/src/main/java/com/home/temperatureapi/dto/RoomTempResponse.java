package com.home.temperatureapi.dto;

import java.util.Map;
import lombok.Data;

@Data
public class RoomTempResponse {

  private String lastTemp;
  private Map<String, String> averages;

}
