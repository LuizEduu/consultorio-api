package br.com.luizeduardo.consultorio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
		saveMedico.setEmail(medico.getEmail());
		saveMedico.setCrm(medico.getCrm());
		Medico getMedico = medicoRepository.save(saveMedico);

		medico.getTelefoneMedico().forEach(telefones -> {
			TelefoneMedico telefoneMedico = new TelefoneMedico();
			telefoneMedico.setTipo(telefones.getTipo());
			telefoneMedico.setNumero(telefones.getNumero());
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
		return getMedico;

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

	public void removerMedico(Long id) {
		medicoRepository.deleteById(id);
	}

	public Page<Medico> buscaPorPaginacao(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return medicoRepository.findAll(pageRequest);
	}
}
