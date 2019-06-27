package br.com.luizeduardo.consultorio.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.luizeduardo.consultorio.dominio.EnderecoPaciente;
import br.com.luizeduardo.consultorio.dominio.Paciente;
import br.com.luizeduardo.consultorio.dominio.TelefonePaciente;
import br.com.luizeduardo.consultorio.repositories.PacienteRepository;

public class PacienteDTO {

	@Autowired
	private PacienteRepository pacienteRepository;

	private Long id;
	private String nome;
	private String cpf;
	private String sexo;
	private String email;
	private Date dataNascimento;
	private List<TelefonePaciente> telefones = new ArrayList<>();
	private EnderecoPaciente enderecoPaciente;

	public PacienteDTO(Long id, String nome, String cpf, String sexo, String email, Date dataNascimento,
			List<TelefonePaciente> telefonePacientes, EnderecoPaciente enderecoPaciente) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefones = telefonePacientes;
		this.enderecoPaciente = enderecoPaciente;
	}

	public PacienteDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public Paciente savePaciente(PacienteDTO paciente) {
		Paciente pacienteReturn = new Paciente(paciente.getId(), paciente.getNome(), paciente.getCpf(),
				paciente.getSexo(), paciente.getEmail(), paciente.getDataNascimento(), paciente.getEnderecoPaciente());

		for (TelefonePaciente t : paciente.getTelefones()) {
			TelefonePaciente telefonePaciente = new TelefonePaciente();
			telefonePaciente.setTipo(t.getTipo());
			telefonePaciente.setNumero(t.getNumero());
			telefonePaciente.setPaciente(pacienteReturn);
		}

		EnderecoPaciente enderecoPaciente = new EnderecoPaciente();
		enderecoPaciente.setRua(paciente.getEnderecoPaciente().getRua());
		enderecoPaciente.setNumero(paciente.getEnderecoPaciente().getNumero());
		enderecoPaciente.setBairro(paciente.getEnderecoPaciente().getBairro());
		enderecoPaciente.setCidade(paciente.getEnderecoPaciente().getCidade());
		enderecoPaciente.setPaciente(pacienteReturn);

		return pacienteRepository.save(pacienteReturn);
	}

}
