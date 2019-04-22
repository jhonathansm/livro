package com.projeto.livro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.livro.model.Usuario;
import com.projeto.livro.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository ur;
	private String recebeLogin;
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String inserirUsuario(Usuario usuario, RedirectAttributes attributes) {
		usuario.setId(ur.count()+1);
		usuario.setTipo(1);
		ur.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
		return "redirect:/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String enderecoUsuario() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Usuario usuario) {
		if(ur.findByLogin(usuario.getLogin()) != null && 
				ur.findByLogin(usuario.getLogin()).getSenha().equals(usuario.getSenha())) {
				if(ur.findByLogin(usuario.getLogin()).getTipo() == 2){
					
					return "redirect:/efetuouLoginAdm";
				}else {
					
					return "redirect:/efetuouLogin";
				}
			}else {
				
				return "redirect:/index";
			}
		}
		
				
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String retornaLogin() {
		return "livro/login";
	}
	
	@RequestMapping(value="/efetuouLoginAdm", method = RequestMethod.GET)
	public ModelAndView efetuouLoginAdm() {
		Usuario usuario = ur.findByLogin(recebeLogin);
		ModelAndView logg = new ModelAndView("livro/efetuouLoginAdm");		
		logg.addObject("usuario", usuario);
		return logg;
	}
		
	@RequestMapping(value="/cadastroAdm", method = RequestMethod.GET)
	public ModelAndView cadastroLoginAdm() {
		Usuario usuario = ur.findByLogin(recebeLogin);
		ModelAndView logg = new ModelAndView("livro/cadastroAdm");
		usuario.setId(ur.count()+1);		
		logg.addObject("usuario", usuario);
		
		return logg;
	}
	
	@RequestMapping(value="/cadastroAdm", method = RequestMethod.POST)
	public String inserirUsuarioPagAdm(Usuario usuario, RedirectAttributes attributes) {
		ur.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
		return "redirect:/cadastroAdm";
	}

	@RequestMapping(value="/efetuouLogin", method=RequestMethod.GET)
	public ModelAndView efetuouLogin() {
		Usuario usuario = ur.findByLogin(recebeLogin);
		ModelAndView login = new ModelAndView("livro/efetuouLogin");
		login.addObject("usuario", usuario);
		return login;
	}
	
	@RequestMapping(value="/lista", method = RequestMethod.GET)
	public ModelAndView lista() {
		List<Usuario> usuario = ur.findAll();
		ModelAndView lista = new ModelAndView("livro/lista");
		lista.addObject("usuario", usuario);
		return lista;
		
	}
	
	@RequestMapping("/deletar")
	public String deletarUsuario(String login, RedirectAttributes attributes) {
		Usuario usuario = ur.findByLogin(login);
		ur.delete(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário removido com sucesso!!");
		return "redirect:/lista";
		
	}
}
