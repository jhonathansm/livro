package com.projeto.livro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projeto.livro.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	Usuario findById(int id);
	Usuario findByLogin(String login);
}
