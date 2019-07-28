package br.com.luizeduardo.consultorio.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.luizeduardo.consultorio.dominio.EnderecoMedico;
import br.com.luizeduardo.consultorio.dominio.Medico;
import br.com.luizeduardo.consultorio.dominio.TelefoneMedico;

public class MedicoDto {

	private String nome;
	private String cpf;
	private String sexo;
	private String email;
	private String crm;
	private List<TelefoneMedico> telefones = new ArrayList<>();
	private EnderecoMedico enderecoMedico;

	public MedicoDto(Medico medico) {
		this.nome = medico.getNome();
		this.cpf = medico.getCpf();
		this.sexo = medico.getSexo();
		this.email = medico.getEmail();
		this.crm = medico.getCrm();
		this.telefones = medico.getTelefoneMedico();
		this.enderecoMedico = medico.getEnderecoMedico();
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<TelefoneMedico> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneMedico> telefones) {
		this.telefones = telefones;
	}

	public EnderecoMedico getEnderecoMedico() {
		return enderecoMedico;
	}

	public void setEnderecoMedico(EnderecoMedico enderecoMedico) {
		this.enderecoMedico = enderecoMedico;
	}

}
