package br.com.luizeduardo.consultorio.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luizeduardo.consultorio.dominio.Medico;
import br.com.luizeduardo.consultorio.dto.MedicoDto;
import br.com.luizeduardo.consultorio.services.MedicoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {

	@Autowired
	private MedicoService medicoService;

	@PostMapping
	public ResponseEntity<Medico> saveMedico(@RequestBody Medico medico) {
		Optional<Medico> getMedico = medicoService.findByCpf(medico.getCpf());

		if (getMedico.isPresent()) {
			try {
				throw new ObjectNotFoundException("Médico" + getMedico.get().getNome() + "já cadastrado");
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
		}

		medicoService.saveMedico(medico);

		return ResponseEntity.status(HttpStatus.CREATED).body(medico);
	}

	@GetMapping("/{id}")
	public Medico findById(@PathVariable Long id) {
		Optional<Medico> medico = medicoService.findById(id);
		return medico.get();
	}

	@GetMapping
	public List<Medico> findAll() {
		return medicoService.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerMedico(@PathVariable Long id) {
		Optional<Medico> medico = medicoService.findById(id);

		if (medico == null) {
			try {
				throw new ObjectNotFoundException("Medico não encontrado");
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
		}

		medicoService.removerMedico(id);
		return ResponseEntity.ok("Medico Removido com Sucesso");
	}

	@GetMapping("/page")
	public ResponseEntity<Page<MedicoDto>> buscaPorPaginacao(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

		Page<Medico> medicos = medicoService.buscaPorPaginacao(page, linesPerPage, direction, orderBy);
		Page<MedicoDto> medicosDto = medicos.map(medico -> new MedicoDto(medico));
		return ResponseEntity.ok().body(medicosDto);
	}
}
