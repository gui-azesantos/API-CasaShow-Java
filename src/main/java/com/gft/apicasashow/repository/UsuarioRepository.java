package com.gft.apicasashow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.apicasashow.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByEmailContaining(String email);
	Usuario findByEmail(String email);

}
