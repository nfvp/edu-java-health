package pt.dlt.health.dto;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    protected String name;
    protected char gender;
    protected LocalDate birthdate;
    protected int citizenCard;
    protected int fiscalNumber;
    protected int phoneNumber;
    protected String address;
    
    public Person() {

    }
    
    public Person(String name, char gender, LocalDate birthdate, int citizenCard, int fiscalNumber, int phoneNumber, String address) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.citizenCard = citizenCard;
        this.fiscalNumber = fiscalNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
    } 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthdate.getYear();
    }

    public int getCitizenCard() {
        return citizenCard;
    }

    public int getFiscalNumber() {
        return fiscalNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}