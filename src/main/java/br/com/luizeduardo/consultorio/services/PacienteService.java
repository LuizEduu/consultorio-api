package br.com.luizeduardo.consultorio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizeduardo.consultorio.dominio.EnderecoPaciente;
import br.com.luizeduardo.consultorio.dominio.Paciente;
import br.com.luizeduardo.consultorio.dominio.TelefonePaciente;
import br.com.luizeduardo.consultorio.repositories.EnderecoPacienteRepository;
import br.com.luizeduardo.consultorio.repositories.PacienteRepository;
import br.com.luizeduardo.consultorio.repositories.TelefonePacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private TelefonePacienteRepository telefonePacienteRepository;

	@Autowired
	private EnderecoPacienteRepository enderecoPacienteRepository;

	public Paciente adicionar(Paciente paciente) {

		Paciente savePaciente = new Paciente();
		savePaciente.setNome(paciente.getNome());
		savePaciente.setCpf(paciente.getCpf());
		savePaciente.setSexo(paciente.getSexo());
		savePaciente.setEmail(paciente.getEmail());
		savePaciente.setDataNascimento(paciente.getDataNascimento());
		Paciente getPaciente = pacienteRepository.save(savePaciente);

		paciente.getTelefones().forEach(telefones -> {
			TelefonePaciente telefonePaciente = new TelefonePaciente();
			telefonePaciente.setTipo(telefones.getTipo());
			telefonePaciente.setNumero(telefones.getNumero());
			telefonePaciente.setPaciente(getPaciente);
			telefonePacienteRepository.save(telefonePaciente);

		});

		EnderecoPaciente enderecoPaciente = new EnderecoPaciente();
		enderecoPaciente.setRua(paciente.getEnderecoPaciente().getRua());
		enderecoPaciente.setNumero(paciente.getEnderecoPaciente().getNumero());
		enderecoPaciente.setBairro(paciente.getEnderecoPaciente().getBairro());
		enderecoPaciente.setCidade(paciente.getEnderecoPaciente().getCidade());
		enderecoPaciente.setPaciente(getPaciente);
		enderecoPacienteRepository.save(enderecoPaciente);
		return getPaciente;
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

	public Paciente editPaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}
}
