package br.com.luizeduardo.consultorio.dto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.luizeduardo.consultorio.dominio.EnderecoPaciente;
import br.com.luizeduardo.consultorio.dominio.Paciente;
import br.com.luizeduardo.consultorio.dominio.TelefonePaciente;
import br.com.luizeduardo.consultorio.repositories.EnderecoPacienteRepository;
import br.com.luizeduardo.consultorio.repositories.PacienteRepository;
import br.com.luizeduardo.consultorio.repositories.TelefonePacienteRepository;

public class PacienteDto {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private TelefonePacienteRepository telefonePacienteRepository;

	@Autowired
	private EnderecoPacienteRepository enderecoPacienteRepository;

	private String nome;
	private String cpf;
	private String email;
	private Date dataNascimento;
	private List<TelefonePaciente> telefones;
	private EnderecoPaciente enderecoPaciente;

	public PacienteDto(Paciente paciente) {
		this.nome = paciente.getNome();
		this.cpf = paciente.getCpf();
		this.email = paciente.getEmail();
		this.dataNascimento = paciente.getDataNascimento();
		this.enderecoPaciente = paciente.getEnderecoPaciente();
		this.telefones = paciente.getTelefones();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<TelefonePaciente> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefonePaciente> telefones) {
		this.telefones = telefones;
	}

	public EnderecoPaciente getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(EnderecoPaciente enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	public Paciente savePaciente(Paciente paciente) {

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

}
