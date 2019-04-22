package com.projeto.livro.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "livro")
public class Livro implements Serializable{
	
	private static final long SerialVersionUID =  1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome, autor, editora;
	
	private Date dataSaida, dataRetorno;
	private int ano, edicao, codigoBarras, preco, quantidade;
	
	public long getId() {
		return id;
	}
	
	public Date getDataSaida() {
		return dataSaida;
	}
	
	public Date getDataRetorno() {
		return dataRetorno;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public int getAno() {
		return ano;
	}
	
	public int getEdicao() {
		return edicao;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public int getCodigoBarras() {
		return codigoBarras;
	}
	
	public int getPreco() {
		return preco;
	}
	
	//Setters
	
	
	public void setId(long l) {
		this.id = l;
	}
	
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	
	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public void setPreco(int preco) {
		this.preco = preco;
	}
}
