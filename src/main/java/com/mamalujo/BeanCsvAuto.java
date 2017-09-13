package com.mamalujo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class BeanCsvAuto{
	
	public String nome;
	public String veiculo;
	public String ano;
	public String placa;
	public String vigencia;
	public String seguradora;
	public String franquia;
	public String carroreserva;
	
	public BeanCsvAuto() {
		
	}
	
	public BeanCsvAuto(String nome, String veiculo, String ano, String placa, String vigencia, String seguradora, String franquia, String carroreserva) {
		super();
		this.nome = nome;
		this.veiculo = veiculo;
		this.ano = ano;
		this.placa = placa;
		this.vigencia = vigencia;
		this.seguradora = seguradora;
		this.franquia = franquia;
		this.carroreserva = carroreserva;
		
	}	
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getVeiculo(){
		return veiculo;
	}
	
	public void setVeiculo(String veiculo){
		this.veiculo = veiculo;
	}
	
	public String getAno(){
		return ano;
	}
	
	public void setAno(String ano){
		this.ano = ano;
	}
	
	public String getPlaca(){
		return placa;
	}
	
	public void setPlaca(String placa){
		this.placa = placa;
	}
	
	public String getVigencia(){
		return vigencia;
	}
	public void setVigencia(String vigencia){
		this.vigencia = vigencia;
	}
	public String getSeguradora(){
		return seguradora;
	}
	
	public void setSeguradora(String seguradora){
		this.seguradora = seguradora;
	}
	
	public String getFranquia(){
		return franquia;
	}
	
	public void setFranquia(String franquia){
		this.franquia = franquia;
	}
	
	public String getCarroReserva(){
		return carroreserva;
	}
	
	public void setCarroReserva(String carroreserva){
		this.carroreserva = carroreserva;
	}	
}
