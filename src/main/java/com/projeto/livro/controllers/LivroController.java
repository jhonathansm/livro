package com.projeto.livro.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.livro.model.Livro;
import com.projeto.livro.repository.LivroRepository;

@Controller
public class LivroController {
	
	@Autowired
	private LivroRepository lr;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

	
	@RequestMapping(value="/adclivro", method = RequestMethod.POST)
	public String inserirLivro(Livro livro) {
		
		lr.save(livro);
		return "redirect:/adclivro";
	}
	
	
	
	
	@RequestMapping(value="/adclivro", method = RequestMethod.GET)
	public ModelAndView retornaLivro() {	
		ModelAndView liv = new ModelAndView("livro/adclivro");
		liv.addObject("livro", lr.count()+1);
	
		return liv;
	}
	
	
	@RequestMapping(value="/livroLivro", method = RequestMethod.GET)
	public ModelAndView listaLivro() {
		Iterable<Livro> livro = lr.findAll();
		ModelAndView lista = new ModelAndView("livro/livroLivro");
		lista.addObject("livro", livro);
		return lista;
	}
	
	@RequestMapping("/delete")
	public String deletarLivro(long id) {
		Livro livro = lr.findById(id);
		lr.delete(livro);
		return "redirect:/livroLivro";
		
	}
	
	@RequestMapping("/adicionarlivro")
	public String adicionarLivro(long id) {
		Livro l = lr.findById(id);
		l.setQuantidade(l.getQuantidade()+1);
		lr.save(l);
		return "redirect:/livroLivro";
	}
	
	@RequestMapping("/removerlivro")
	public String removerLivro(long id) {
		Livro v = lr.findById(id);
		v.setQuantidade(v.getQuantidade()-1);
		lr.save(v);
		return "redirect:/livroLivro";
	}
	
	@RequestMapping("/adicionarData")
	public String adicionarData(long id, Date dataSaida, Date dataRetorno) {
		Livro livro = lr.findById(id);
		livro.setDataSaida(dataSaida);
		livro.setDataRetorno(dataRetorno);
		livro.setQuantidade(livro.getQuantidade()-1);
		
		
		//livro.duracao();
		lr.save(livro);
		return "redirect:/index";
	}
}
