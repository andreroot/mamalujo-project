package com.mamalujo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class YamlBeanConjuntoInfo{
	
	public String columns;
	public String values;
	
	public YamlBeanConjuntoInfo() {
		
	}
	
	public YamlBeanConjuntoInfo(String columns, String values) {
		super();
		this.columns = columns;
		this.values = values;
		
	}	
	
	public String getColumns(){
		return columns;
	}
	
	public void setColumns(String columns){
		this.columns = columns;
	}
	
	public String getValues(){
		return values;
	}
	
	public void setValues(String values){
		this.values = values;
	}
	
}
