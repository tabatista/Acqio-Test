package br.com.acqio.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acqio.transaction.model.Payload;

public interface PayloadRepository extends JpaRepository<Payload, Long> {

}
