package br.com.bilheteunico.domain;

import java.util.Date;

public class Bilhete {
	
	private Long  id;
	private String dscBilhete;
	private Double saldo;
	private Date ultimaAtualizacao;
	
	public Bilhete (Long id, String dscBilhete, Double saldo, Date ultimaAtualizacao) {
		this.id = id;
		this.dscBilhete = dscBilhete;
		this.saldo = saldo;
		this.ultimaAtualizacao = ultimaAtualizacao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDscBilhete() {
		return dscBilhete;
	}
	public void setDscBilhete(String dscBilhete) {
		this.dscBilhete = dscBilhete;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}
	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

}
