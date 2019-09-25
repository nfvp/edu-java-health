package pt.dlt.health.dto;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Patient extends Person {

    private long socialSecurityNumber;
    private String insuranceNumber;

    public Patient() {

    }
    
    public Patient(String name, char gender, LocalDate birthdate, int citizenCard, int fiscalNumber, int phoneNumber, String address, long socialSecurityNumber, String insuranceNumber) {
        super(name, gender, birthdate, citizenCard, fiscalNumber, phoneNumber, address);
        this.setSocialSecurityNumber(socialSecurityNumber);
        this.setInsuranceNumber(insuranceNumber);
    }

    @Override
    public String getName() {
        if (this.gender == 'F') {
            return "Sra. " + this.name;
        } else if (this.gender == 'M') {
            return "Sr. " + this.name;
        } else {
            return super.getName();
        }
    }

    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
    
}