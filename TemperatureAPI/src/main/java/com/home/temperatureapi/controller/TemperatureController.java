package com.home.temperatureapi.controller;

import com.home.temperatureapi.model.TempRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {

    //todo add jpa repository

    @RequestMapping(value = "/updateTemp/{room}/{temp}", method = RequestMethod.PUT)
    public void updateTemp(@PathVariable("room") String room, @PathVariable("temp") String temp) {
        TempRecord record = new TempRecord();
        record.setTemperature(temp);
        //repository.save(record);
    }

    @RequestMapping(value = "/getTemp/{room}")
    public ResponseEntity<String> getRoomTemp(@PathVariable String room) {
        String temp;
        //temp = repository.findLastByRoom(room);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

}
