package edu.miu.waa.lab5.complexmapping.controller;

import edu.miu.waa.lab5.complexmapping.model.Appointment;
import edu.miu.waa.lab5.complexmapping.repository.AppointmentRepository;
import edu.miu.waa.lab5.complexmapping.repository.DoctorRepository;
import edu.miu.waa.lab5.complexmapping.repository.PatientRepository;
import edu.miu.waa.lab5.exception.RecordNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @PostMapping
    public Appointment createCustomerWithOrders(@RequestBody Appointment appointment) {
        patientRepository.save(appointment.getPatient());
        doctorRepository.save(appointment.getDoctor());
        return appointmentRepository.save(appointment);
    }

    @GetMapping("{appointmentId}")
    public Appointment getAppointment(@PathVariable long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RecordNotFoundException("Appointment not found"));
    }
}
