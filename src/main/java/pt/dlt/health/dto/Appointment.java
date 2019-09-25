package pt.dlt.health.dto;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToOne(targetEntity=Patient.class)
    private Patient patient;
    @OneToOne(targetEntity=Doctor.class)
    private Doctor doctor;

    public Appointment() {

    }
    
    public Appointment(LocalDateTime startDate, LocalDateTime endDate, Patient patient, Doctor doctor) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.patient = patient;
        this.doctor = doctor;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Duration getDuration() {
        return Duration.between(startDate, endDate);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


}