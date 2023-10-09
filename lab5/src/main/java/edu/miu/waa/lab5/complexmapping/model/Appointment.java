package edu.miu.waa.lab5.complexmapping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String appdate;

    @ManyToOne
    private Patient patient;

    @Embedded
    private Payment payment;

    @ManyToOne
    private Doctor doctor;
}
