package com.home.temperatureapi.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CalculationsService {

  public String calculateAverages(List<String> averages) {
    // calculating total average for now
    double sum = averages.stream()
            .mapToDouble(Double::parseDouble)
            .sum();
    return String.valueOf(sum / averages.size());
  }

}
