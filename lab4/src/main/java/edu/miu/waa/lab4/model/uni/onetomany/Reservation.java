package edu.miu.waa.lab4.model.uni.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    private int id;
    private String reservationCode;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean confirmed;
}
