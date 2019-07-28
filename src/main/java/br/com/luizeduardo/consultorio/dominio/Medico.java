package br.com.luizeduardo.consultorio.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "consultorio", name = "medico")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(sequenceName = "consultorio.medico_sequence_id", name = "consultorio.medico_sequence_id")
	@GeneratedValue(generator = "consultorio.medico_sequence_id")
	@Column(name = "id_medico")
	private Long id;
	@NotNull
	@Column(name = "nome_medico", nullable = false)
	private String nome;
	@NotNull
	@Column(name = "cpf_medico", nullable = false)
	private String cpf;
	@NotNull
	@Column(name = "sexo_medico", nullable = false)
	private String sexo;
	@NotNull
	@Column(name = "crm_medico", nullable = false)
	private String crm;

	@OneToMany(mappedBy = "medico", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TelefoneMedico> telefoneMedico;

	@OneToOne(mappedBy = "medico", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private EnderecoMedico enderecoMedico;

	public Medico() {
	}

	public Medico(Long id, String nome, String cpf, String sexo, String crm) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.crm = crm;
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<TelefoneMedico> getTelefoneMedico() {
		return telefoneMedico;
	}

	public void setTelefoneMedico(List<TelefoneMedico> telefoneMedico) {
		this.telefoneMedico = telefoneMedico;
	}

	public EnderecoMedico getEnderecoMedico() {
		return enderecoMedico;
	}

	public void setEnderecoMedico(EnderecoMedico enderecoMedico) {
		this.enderecoMedico = enderecoMedico;
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
		Medico other = (Medico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
