package br.com.luizeduardo.consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizeduardo.consultorio.dominio.EnderecoPaciente;

@Repository
public interface EnderecoPacienteRepository extends JpaRepository<EnderecoPaciente, Long> {

}
