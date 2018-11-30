package com.home.temperatureapi.controller;

import com.home.temperatureapi.dto.RoomTempResponse;
import com.home.temperatureapi.dto.UpdateRequest;
import com.home.temperatureapi.model.TempRecord;
import com.home.temperatureapi.repository.TemperatureRepository;
import com.home.temperatureapi.service.CalculationsService;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {

  //todo add jpa repository
  private final CalculationsService calculationsService;
  private final TemperatureRepository temperatureRepository;

  @Autowired
  public TemperatureController(CalculationsService calculationsService,
      TemperatureRepository temperatureRepository) {
    this.calculationsService = calculationsService;
    this.temperatureRepository = temperatureRepository;
  }

  @RequestMapping(value = "/updateTemp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity updateTemp(@Valid @RequestBody UpdateRequest updateRequest) {
    TempRecord record = buildRecordFromRequest(updateRequest);
    //repository.save(record);
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/getTemp", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomTempResponse> getRoomTemp(@RequestParam("room") String room) {
    return ResponseEntity.ok(new RoomTempResponse());
  }

  private TempRecord buildRecordFromRequest(UpdateRequest request) {
    return TempRecord.builder().room(request.getRoom()).temperature(request.getTemp()).build();
  }

}
