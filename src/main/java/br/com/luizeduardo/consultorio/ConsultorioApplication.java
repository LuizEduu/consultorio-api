package br.com.luizeduardo.consultorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.luizeduardo.consultorio.repositories.PacienteRepository;

@SpringBootApplication
public class ConsultorioApplication{

	@Autowired
	PacienteRepository pacienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(ConsultorioApplication.class, args);
	}

}
