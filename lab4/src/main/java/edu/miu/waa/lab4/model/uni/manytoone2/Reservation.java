package edu.miu.waa.lab4.model.uni.manytoone2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity(name="reservation2")
public class Reservation {

    @Id
    private int id;
    private String reservationCode;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean confirmed;

    @ManyToOne
    private Book book;
}