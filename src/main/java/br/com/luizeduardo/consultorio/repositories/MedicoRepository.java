package br.com.luizeduardo.consultorio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizeduardo.consultorio.dominio.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

	public Optional<Medico> findByCpf(String cpf);
}
