package com.home.temperatureapi.repository;

import com.home.temperatureapi.model.TempRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<TempRecord, String> {

  List<TempRecord> findAllByRoom(String room);

}
