package br.com.luizeduardo.consultorio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizeduardo.consultorio.dominio.Paciente;
import br.com.luizeduardo.consultorio.dto.PacienteDTO;
import br.com.luizeduardo.consultorio.repositories.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public Paciente adicionar(Paciente paciente) {
		PacienteDTO pacienteDTO = new PacienteDTO(paciente);
		pacienteDTO.savePaciente(pacienteDTO);
		return paciente;
	}

	public Optional<Paciente> findById(Long id) {
		return pacienteRepository.findById(id);
	}

	public Optional<Paciente> findByCpf(String cpf) {
		Optional<Paciente> paciente = pacienteRepository.findByCpf(cpf);
		return paciente;
	}

	public void removerPaciente(Long id) {
		pacienteRepository.deleteById(id);
	}

	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}
}
