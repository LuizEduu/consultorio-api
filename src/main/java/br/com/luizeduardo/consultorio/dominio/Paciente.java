package br.com.luizeduardo.consultorio.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "consultorio", name = "paciente")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cpf;
	private String sexo;
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@OneToMany(mappedBy = "paciente")
	private List<TelefonePaciente> telefones = new ArrayList<TelefonePaciente>();

	@OneToOne(mappedBy = "paciente")
	private EnderecoPaciente enderecoPaciente;

	public Paciente() {
	}

	public Paciente(Long id, String nome, String cpf, String sexo, String email, Date dataNascimento,
			EnderecoPaciente enderecoPaciente) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.enderecoPaciente = enderecoPaciente;
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

	public EnderecoPaciente getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(EnderecoPaciente enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
