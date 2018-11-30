package com.home.temperatureapi.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "temps")
public class TempRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", updatable = false, nullable = false)
  private int id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "temp")
  private String temperature;

  @Column(name = "room")
  private String room;

  @Column(name = "create_time")
  private Timestamp createTimestamp;

  @PrePersist
  protected void onCreate() {
    createTimestamp = new Timestamp(System.currentTimeMillis());
    ;
  }
}
