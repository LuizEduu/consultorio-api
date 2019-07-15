package br.com.luizeduardo.consultorio.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.luizeduardo.consultorio.dominio.Paciente;
import br.com.luizeduardo.consultorio.repositories.PacienteRepository;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PacienteRepository pacienteRepository;

	private Long id;
	private String nome;
	private String cpf;
	private String sexo;
	private String email;
	private Date dataNascimento;
//	private List<TelefonePaciente> telefones = new ArrayList<>();
//	private EnderecoPaciente enderecoPaciente;

	public PacienteDTO(Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.cpf = paciente.getCpf();
		this.sexo = paciente.getSexo();
		this.email = paciente.getEmail();
		this.dataNascimento = paciente.getDataNascimento();
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

//	public List<TelefonePaciente> getTelefones() {
//		return telefones;
//	}
//
//	public void setTelefones(List<TelefonePaciente> telefones) {
//		this.telefones = telefones;
//	}
//
//	public EnderecoPaciente getEnderecoPaciente() {
//		return enderecoPaciente;
//	}
//
//	public void setEnderecoPaciente(EnderecoPaciente enderecoPaciente) {
//		this.enderecoPaciente = enderecoPaciente;
//	}

	public Paciente savePaciente(Paciente pacienteDto) {
		Paciente paciente = new Paciente();
		paciente.setNome(pacienteDto.getNome());
		paciente.setCpf(pacienteDto.getCpf());
		paciente.setSexo(pacienteDto.getSexo());
		paciente.setEmail(pacienteDto.getEmail());
		paciente.setDataNascimento(pacienteDto.getDataNascimento());
		pacienteRepository.save(paciente);
		return paciente;
	}

}
