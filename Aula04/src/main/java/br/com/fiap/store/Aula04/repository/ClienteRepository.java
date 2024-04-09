package br.com.fiap.store.Aula04.repository;

import br.com.fiap.store.Aula04.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {

}
