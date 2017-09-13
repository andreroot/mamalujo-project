package com.mamalujo;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
* Importacao de dados de origem externa
*
*/

public class ImportDadosExterno{
	
	private Scanner scanner;
	
	String caminho, nome, cpf , condutor, endereco;
	String veiculo, ano, placa, vigencia, seguradora, franquia, carroreserva;
	BeanCsvCliente beancli;
	BeanCsvAuto beanauto;
	
	public void lerArquivo() {
		
		try
			{
				File dir = new File("/home/andre/Documentos/cloud/teste/origem_csv");
				File arquivos[];
				arquivos = dir.listFiles();	
				ExportData export = new ExportData();
				
				for(int i = 0; i < arquivos.length; i++){
				    String sfileinfo = arquivos[i].toString();
				    System.out.println(sfileinfo);
				    if(sfileinfo.contains("C.C")) {
				    	resultExcelCliente(sfileinfo);
				    	export.ExportDataCliente(beancli);
				    }else if(sfileinfo.contains("C.V")){
				    	resultExcelAuto(sfileinfo);
				    	export.ExportDataAuto(beanauto);
				    }
				    
				}
			}
	    	catch (Exception e) {
	    			e.printStackTrace();
	    			System.out.println(e);
	    		
	    	}
		}
		
	public void resultTxt(String arquivo) throws FileNotFoundException{
		File file = new File(arquivo);
		FileInputStream in = new FileInputStream(file);
		scanner = new Scanner(in);
		scanner.useDelimiter("\\n");			

		while (scanner.hasNext()) {
			System.out.println(scanner.next());
			String readLine = scanner.next();
			if(readLine.contains("NOME")){
				nome = readLine.substring(readLine.indexOf("NOME")+1, readLine.length());
				System.out.println(nome);
			}
		}
	}
	public BeanCsvCliente resultExcelCliente(String arquivo) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File(arquivo));  
	     /* pega a primeira planilha dentro do arquivo XLS */
	     Sheet sheet = workbook.getSheet(0); 
	     /* pega os valores das célular como se numa matriz */
	     Cell nomexls = sheet.getCell(1,0);
	     Cell cpfxls = sheet.getCell(1,1);
	     Cell condutorxls = sheet.getCell(1,2);
	     Cell endereco_axls = sheet.getCell(1,7);
	     Cell endereco_bxls = sheet.getCell(1,8);
	     Cell endereco_cxls = sheet.getCell(1,9);

	     /* pega os conteúdos das células */
	     nome = nomexls.getContents();
	     cpf = cpfxls.getContents();
	     condutor = condutorxls.getContents();
	     endereco = endereco_axls.getContents()+" "+endereco_bxls.getContents()+" "+endereco_cxls.getContents();
	     beancli = new BeanCsvCliente(nome, cpf, condutor, endereco);
	     
	     return beancli;
	     
	}
	public BeanCsvAuto resultExcelAuto(String arquivo) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File(arquivo));  
	     /* pega a primeira planilha dentro do arquivo XLS */
	     Sheet sheet = workbook.getSheet(0); 
	     /* pega os valores das célular como se numa matriz */
	     Cell nomexls = sheet.getCell(0,0);
	     Cell veiculoxls = sheet.getCell(1,1);
	     Cell anoxls = sheet.getCell(1,2);
	     Cell placaxls = sheet.getCell(1,3);
	     Cell vigenciaxls = sheet.getCell(1,9);
	     Cell seguradoraxls = sheet.getCell(1,16);
	     Cell franquiaxls = sheet.getCell(1,17);
	     Cell carroreservaxls = sheet.getCell(1,22);

	     /* pega os conteúdos das células */
	     nome = nomexls.getContents();
	     veiculo = veiculoxls.getContents();
	     ano = anoxls.getContents();
	     placa = placaxls.getContents();
	     vigencia = vigenciaxls.getContents();
	     seguradora = seguradoraxls.getContents();
	     franquia = franquiaxls.getContents();
	     carroreserva = carroreservaxls.getContents();
	     
	     beanauto = new BeanCsvAuto(nome, veiculo, ano, placa, vigencia, seguradora, franquia, carroreserva);
	     
	     return beanauto;
	     
	}	
	public File criarDiretorio(String dir){
		File diretorio = new File(dir);
		if (!diretorio.exists()) {
			   diretorio.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.
			} else {
			   System.out.println("Diretório já existente");
			}
		return diretorio;
	}
	
	
  public static void main( String[] args ) throws IOException 
  {

      ImportDadosExterno teste = new ImportDadosExterno();
      teste.lerArquivo();

  }
}
