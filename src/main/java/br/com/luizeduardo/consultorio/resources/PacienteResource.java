package br.com.luizeduardo.consultorio.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luizeduardo.consultorio.dominio.Paciente;
import br.com.luizeduardo.consultorio.dto.PacienteDto;
import br.com.luizeduardo.consultorio.services.PacienteService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {

	@Autowired
	PacienteService pacienteService;

	@PostMapping
	public ResponseEntity<Paciente> adicionar(@Valid @RequestBody Paciente paciente) {
		Optional<Paciente> pacienteReturn = pacienteService.findByCpf(paciente.getCpf());

		if (pacienteReturn.isPresent()) {
			try {
				throw new ObjectNotFoundException("Paciente Já Cadastrado");
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
		}

		pacienteService.adicionar(paciente);

		return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Long id) {
		Optional<Paciente> paciente = pacienteService.findById(id);

		if (paciente == null) {
			try {
				throw new ObjectNotFoundException("Paciente Não Encontrado");
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
		}

		return ResponseEntity.ok(paciente.get());
	}

	@GetMapping
	public List<Paciente> findAll() {
		List<Paciente> paciente = new ArrayList<>();
		paciente = pacienteService.findAll();
		return paciente;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Paciente> editarPaciente(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
		Optional<Paciente> pacienteReturn = pacienteService.findById(id);

		if (pacienteReturn == null) {
			try {
				throw new ObjectNotFoundException("Paciente Não Encontrado");
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
		}

		pacienteService.editPaciente(id, pacienteReturn.get());
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteReturn.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerPaciente(@PathVariable Long id) {
		Optional<Paciente> paciente = pacienteService.findById(id);

		if (paciente == null) {
			try {
				throw new ObjectNotFoundException("Paciente Não Encontrado");
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
		}

		pacienteService.removerPaciente(id);
		return ResponseEntity.ok("Paciente Removido com Sucesso");

	}

	@GetMapping("/page")
	public ResponseEntity<Page<PacienteDto>> buscaPorPaginacao(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Paciente> pacientes = pacienteService.buscaPorPaginacao(page, linesPerPage, orderBy, direction);
		Page<PacienteDto> pacientesDto = pacientes.map(paciente -> new PacienteDto(paciente));
		return ResponseEntity.ok().body(pacientesDto);
	}

}
