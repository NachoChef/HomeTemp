package com.home.temperatureapi.service;

import com.home.temperatureapi.model.TempRecord;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CalculationsService {

  public HashMap<String, String> calculateAverages(List<TempRecord> records) {
    double average = records.stream()
        .mapToDouble(d -> Double.parseDouble(d.getTemperature()) / records.size())
        .sum();
    return new HashMap<String, String>(){{
      put("default", String.valueOf(average));
    }};
  }

}
