package br.com.luizeduardo.consultorio.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "consultorio", name = "paciente")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "paciente_id_seq", sequenceName = "paciente_id_seq")
	@GeneratedValue(generator = "paciente_id_seq")
	private Long id;

	@Column(nullable = false)
	@NotNull(message = "Nome não pode ser Vazio")
	private String nome;

	@Column(nullable = false)
	@NotNull(message = "cpf não pode ser Vazio")
	private String cpf;

	@Column(nullable = false)
	@NotNull(message = "sexo não pode ser Vazio")

	private String sexo;
	@Column(nullable = false)
	@NotNull(message = "email não pode ser Vazio")
	private String email;

	@NotNull(message = "Data de Nascimento não pode ser Vazio")
	@DateTimeFormat(pattern = "yyy-MM-dd")
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;

//	@NotNull(message = "Telefone não pode ser Vazio")
//	@OneToMany(mappedBy = "paciente")
//	private List<TelefonePaciente> telefones = new ArrayList<TelefonePaciente>();
//
//	@NotNull(message = "Endereço não pode ser Vazio")
//	@OneToOne(mappedBy = "paciente")
//	private EnderecoPaciente enderecoPaciente;

	public Paciente() {
	}

	public Paciente(Long id, String nome, String cpf, String sexo, String email, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
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
