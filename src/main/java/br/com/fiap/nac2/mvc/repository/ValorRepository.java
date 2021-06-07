package br.com.fiap.nac2.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.nac2.mvc.entity.ValorEntity;

@Repository
public interface ValorRepository extends JpaRepository<ValorEntity, Long> {

}
