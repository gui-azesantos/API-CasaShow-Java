package com.gft.apicasashow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.apicasashow.domain.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {
	 
	List<Local> findByNomeContaining(String nome);
	Local findByNome(String nomeCasa);

}
