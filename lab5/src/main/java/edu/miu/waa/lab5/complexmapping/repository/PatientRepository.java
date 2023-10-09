package edu.miu.waa.lab5.complexmapping.repository;

import edu.miu.waa.lab5.complexmapping.model.Doctor;
import edu.miu.waa.lab5.complexmapping.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
