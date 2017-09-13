package com.mamalujo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BeanCsvCliente{
	
	public String nome;
	public String cpf;
	public String condutor;
	public String endereco;
	
	public BeanCsvCliente() {
		
	}
	
	public BeanCsvCliente(String nome, String cpf, String condutor, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.condutor = condutor;
		this.endereco = endereco;
		
	}	
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getCPF(){
		return cpf;
	}
	
	public void setCPF(String cpf){
		this.cpf = cpf;
	}
	public String getCondutor(){
		return condutor;
	}
	
	public void setCondutor(String endereco){
		this.endereco = endereco;
	}
	public String getEndereco(){
		return endereco;
	}
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	
}
