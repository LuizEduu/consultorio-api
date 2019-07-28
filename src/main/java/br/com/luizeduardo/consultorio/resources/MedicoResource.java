package br.com.luizeduardo.consultorio.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luizeduardo.consultorio.dominio.Medico;
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

	public List<Medico> findAll() {
		return medicoService.findAll();
	}
}
