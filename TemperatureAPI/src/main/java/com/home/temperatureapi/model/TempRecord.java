package com.home.temperatureapi.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "temps")
public class TempRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "temp")
    private String temperature;

    @Column(name = "create_time")
    private Timestamp createTimestamp;
}
