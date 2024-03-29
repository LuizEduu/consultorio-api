package br.com.luizeduardo.consultorio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizeduardo.consultorio.dominio.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	public Optional<Paciente> findByCpf(String cpf);
}
