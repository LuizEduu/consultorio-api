package br.com.luizeduardo.consultorio.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "consultorio", name = "endereco_paciente")
public class EnderecoPaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(sequenceName = "consultorio.paciente_endereco_sequence_id", name = "consultorio.paciente_endereco_sequence_id")
	@GeneratedValue(generator = "consultorio.paciente_endereco_sequence_id")
	@Column(name = "id_endereco_paciente")
	private Long id;

	@NotNull
	@Column(name = "rua_endereco_paciente", nullable = false)
	private String rua;

	@NotNull
	@Column(name = "numero_endereco_paciente", nullable = false)
	private String numero;

	@NotNull
	@Column(name = "bairro_endereco_paciente", nullable = false)
	private String bairro;

	@NotNull
	@Column(name = "cidade_endereco_paciente", nullable = false)
	private String cidade;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	public EnderecoPaciente() {
	}

	public EnderecoPaciente(Long id, String rua, String numero, String bairro, String cidade, Paciente paciente) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.paciente = paciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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
		EnderecoPaciente other = (EnderecoPaciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
