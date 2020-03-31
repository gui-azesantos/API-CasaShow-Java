package com.gft.apicasashow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.apicasashow.domain.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
