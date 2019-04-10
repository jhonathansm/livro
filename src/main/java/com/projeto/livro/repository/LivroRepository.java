package com.projeto.livro.repository;

import org.springframework.data.repository.CrudRepository;

import com.projeto.livro.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, String>{

	Livro findById(long id);
}
