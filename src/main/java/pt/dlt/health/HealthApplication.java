package pt.dlt.health;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.dto.Patient;
import pt.dlt.health.repository.AppointmentRepository;
import pt.dlt.health.repository.DoctorRepository;
import pt.dlt.health.repository.PatientRepository;

@SpringBootApplication
public class HealthApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HealthApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(HealthApplication.class, args);
	}

	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*/**").allowedHeaders("*").allowedOrigins("*").allowedMethods("*").allowCredentials(true);
			}
		};
	}

	@Bean
	public CommandLineRunner demo(DoctorRepository doctorRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
		return (args) -> {
			if (doctorRepository.count() == 0) {
				Doctor d1 = new Doctor("João Silva", 'M', LocalDate.parse("1980-03-14"), 13615516, 252945644, 916338296, "Rua da Agonia", 30000.00, "FAMILY_MEDICINE");
				Doctor d2 = new Doctor("Joana Silva", 'F', LocalDate.parse("1975-05-04"), 13615515, 252945642, 916338298, "Rua dos Prazeres", 38000.00, "UROLOGY");
				Doctor d3 = new Doctor("Maria Silva", 'F', LocalDate.parse("1970-06-30"), 13615514, 252945640, 916338294, "Rua da Desgraça", 35000.00, "PSYCHIATRY");
				doctorRepository.save(d1);
				doctorRepository.save(d2);
				doctorRepository.save(d3);

				Patient p1 = new Patient("Pedro Silva", 'M', LocalDate.parse("1980-03-14"), 13615513, 252945638, 916338292, "Rua da Agonia", 82537843203l, "SA4314819-B");
				Patient p2 = new Patient("Beatriz Silva", 'F', LocalDate.parse("1975-05-04"), 13615512, 252945636, 916338290, "Rua dos Prazeres", 82537843202l, "SA4314832-A");
				Patient p3 = new Patient("José Silva", 'M', LocalDate.parse("1970-06-30"), 13615511, 252945634, 916338288, "Rua da Desgraça", 82537843201l, "SA4314856-B");
				Patient p4 = new Patient("Rute Silva", 'F', LocalDate.parse("1980-03-14"), 13615510, 252945632, 916338286, "Rua da Agonia", 82537843200l, "SA4314834-C");
				Patient p5 = new Patient("Manuel Silva", 'M', LocalDate.parse("1980-03-14"), 13615513, 252945638, 916338292, "Rua da Agonia", 82537843203l, "SA4314819-B");
				Patient p6 = new Patient("Filipa Silva", 'F', LocalDate.parse("1975-05-04"), 13615512, 252945636, 916338290, "Rua dos Prazeres", 82537843202l, "SA4314832-A");
				Patient p7 = new Patient("Joaquim Silva", 'M', LocalDate.parse("1970-06-30"), 13615511, 252945634, 916338288, "Rua da Desgraça", 82537843201l, "SA4314856-B");
				Patient p8 = new Patient("Sara Silva", 'F', LocalDate.parse("1980-03-14"), 13615510, 252945632, 916338286, "Rua da Agonia", 82537843200l, "SA4314834-C");
				patientRepository.save(p1);
				patientRepository.save(p2);
				patientRepository.save(p3);
				patientRepository.save(p4);
				patientRepository.save(p5);
				patientRepository.save(p6);
				patientRepository.save(p7);
				patientRepository.save(p8);

				appointmentRepository.save(new Appointment(LocalDateTime.parse("2019-09-28T09:00:00"), LocalDateTime.parse("2019-09-28T10:00:00"), p1, d3));
				appointmentRepository.save(new Appointment(LocalDateTime.parse("2019-09-26T11:00:00"), LocalDateTime.parse("2019-09-26T12:00:00"), p2, d1));
				appointmentRepository.save(new Appointment(LocalDateTime.parse("2019-09-26T13:00:00"), LocalDateTime.parse("2019-09-26T14:00:00"), p3, d3));
				appointmentRepository.save(new Appointment(LocalDateTime.parse("2019-09-26T15:30:00"), LocalDateTime.parse("2019-09-26T16:30:00"), p4, d2));
				appointmentRepository.save(new Appointment(LocalDateTime.parse("2019-09-27T09:00:00"), LocalDateTime.parse("2019-09-27T10:00:00"), p5, d3));
				appointmentRepository.save(new Appointment(LocalDateTime.parse("2019-09-27T12:00:00"), LocalDateTime.parse("2019-09-27T13:00:00"), p6, d2));
				appointmentRepository.save(new Appointment(LocalDateTime.parse("2019-09-27T14:30:00"), LocalDateTime.parse("2019-09-27T15:30:00"), p7, d3));
				appointmentRepository.save(new Appointment(LocalDateTime.parse("2019-09-27T17:00:00"), LocalDateTime.parse("2019-09-27T18:00:00"), p8, d1));
			}
		};
	}

}
