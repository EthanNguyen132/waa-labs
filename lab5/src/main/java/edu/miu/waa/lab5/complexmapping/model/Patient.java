package edu.miu.waa.lab5.complexmapping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Address")
@SecondaryTable(name = "Patient",
        pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "patent_id")
        })
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patent_id")
    private Long id;

    @Column(table = "Patient")
    private String name;

    private String street;
    private String zip;
    private String city;
}
