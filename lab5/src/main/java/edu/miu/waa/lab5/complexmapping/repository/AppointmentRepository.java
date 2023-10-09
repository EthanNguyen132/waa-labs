package edu.miu.waa.lab5.complexmapping.repository;

import edu.miu.waa.lab5.complexmapping.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
