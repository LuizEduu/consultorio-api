package br.com.luizeduardo.consultorio.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "consultorio", name = "telefone_paciente")
public class TelefonePaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "consultorio.paciente_telefone_sequence_id", sequenceName = "consultorio.paciente_telefone_sequence_id")
	@GeneratedValue(generator = "consultorio.paciente_telefone_sequence_id")
	@Column(name = "id_telefone_paciente")
	private Long id;
	@Column(name = "tipo_telefone_paciente")
	private String tipo;
	@Column(name = "numero_telefone_paciente")
	private String numero;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	public TelefonePaciente() {
	}

	public TelefonePaciente(Long id, String tipo, String numero, Paciente paciente) {
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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
		TelefonePaciente other = (TelefonePaciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
