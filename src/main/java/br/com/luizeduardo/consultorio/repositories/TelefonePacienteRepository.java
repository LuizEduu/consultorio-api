package br.com.luizeduardo.consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizeduardo.consultorio.dominio.TelefonePaciente;

@Repository
public interface TelefonePacienteRepository extends JpaRepository<TelefonePaciente, Long> {

}
