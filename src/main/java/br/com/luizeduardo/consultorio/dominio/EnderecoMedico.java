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
@Table(schema = "consultorio", name = "endereco_medico")
public class EnderecoMedico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(sequenceName = "consultorio.medico_endereco_sequence_id", name = "consultorio.medico_endereco_sequence_id")
	@GeneratedValue(generator = "consultorio.medico_endereco_sequence_id")
	@Column(name = "id_endereco_medico", nullable = false)
	@NotNull
	private Long id;
	@Column(name = "rua_endereco_medico", nullable = false)
	@NotNull
	private String rua;
	@Column(name = "numero_endereco_medico", nullable = false)
	@NotNull
	private String numero;
	@Column(name = "bairro_endereco_medico", nullable = false)
	@NotNull
	private String bairro;
	@Column(name = "cidade_endereco_medico", nullable = false)
	@NotNull
	private String cidade;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_medico")
	private Medico medico;

	public EnderecoMedico() {
	}

	public EnderecoMedico(Long id, String rua, String numero, String bairro, String cidade) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
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
		EnderecoMedico other = (EnderecoMedico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
