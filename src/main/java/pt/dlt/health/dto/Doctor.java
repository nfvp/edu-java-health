package pt.dlt.health.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Doctor extends Person {

    private Double wage;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    public Doctor() {

    }
    
    public Doctor(String name, char gender, LocalDate birthdate, int citizenCard, int fiscalNmber, int phoneNumber, String address, Double wage, String speciality) {
        super(name, gender, birthdate, citizenCard, fiscalNmber, phoneNumber, address);
        this.wage = wage;
        this.speciality = Speciality.valueOf(speciality);
    }

    @Override
    public String getName() {
        if (this.gender == 'F') {
            return "Dra. " + this.name;
        } else if (this.gender == 'M') {
            return "Dr. " + this.name;
        } else {
            return super.getName();
        }
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

}