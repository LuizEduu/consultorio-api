package br.com.luizeduardo.consultorio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizeduardo.consultorio.dominio.EnderecoMedico;
import br.com.luizeduardo.consultorio.dominio.Medico;
import br.com.luizeduardo.consultorio.dominio.TelefoneMedico;
import br.com.luizeduardo.consultorio.repositories.EnderecoMedicoRepository;
import br.com.luizeduardo.consultorio.repositories.MedicoRepository;
import br.com.luizeduardo.consultorio.repositories.TelefoneMedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private TelefoneMedicoRepository telefoneMedicoRepository;

	@Autowired
	private EnderecoMedicoRepository enderecoMedicoRepository;

	public Medico saveMedico(Medico medico) {
		Medico saveMedico = new Medico();
		saveMedico.setNome(medico.getNome());
		saveMedico.setCpf(medico.getCpf());
		saveMedico.setSexo(medico.getSexo());
		saveMedico.setCrm(medico.getCrm());
		Medico getMedico = medicoRepository.save(medico);

		medico.getTelefoneMedico().forEach(telefone -> {
			TelefoneMedico telefoneMedico = new TelefoneMedico();
			telefoneMedico.setTipo(telefone.getTipo());
			telefoneMedico.setNumero(telefone.getNumero());
			telefoneMedico.setMedico(getMedico);
			telefoneMedicoRepository.save(telefoneMedico);
		});

		EnderecoMedico enderecoMedico = new EnderecoMedico();
		enderecoMedico.setRua(medico.getEnderecoMedico().getRua());
		enderecoMedico.setNumero(medico.getEnderecoMedico().getNumero());
		enderecoMedico.setBairro(medico.getEnderecoMedico().getBairro());
		enderecoMedico.setCidade(medico.getEnderecoMedico().getCidade());
		enderecoMedico.setMedico(getMedico);
		enderecoMedicoRepository.save(enderecoMedico);

		return saveMedico;
	}

	public Optional<Medico> findById(Long id) {
		return medicoRepository.findById(id);
	}

	public Optional<Medico> findByCpf(String cpf) {
		return medicoRepository.findByCpf(cpf);
	}

	public List<Medico> findAll() {
		return medicoRepository.findAll();
	}
}
