package com.mamalujo;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.bson.Document;

public class ExportData{
	
	public ExportData(){
		
	}
	
	public void ExportDataCliente(BeanCsvCliente beancli) throws UnknownHostException{
	    //System.out.println(beancli.getNome());
	    //System.out.println(beancli.getCPF());
	    //System.out.println(beancli.getCondutor());
	    //System.out.println(beancli.getEndereco());
	    //System.out.println(beancli.getNomearquivo());
		enviaPostMongo(beancli);
		
	}
	
	public void enviaPostMongo(BeanCsvCliente beancli) throws UnknownHostException{
		
		//Mongo mongo = new Mongo("104.197.117.81", 27017);
		//MongoClient mongo = new MongoClient( "104.197.117.81" , 27017 );//104.198.207.77  andre:andre@ds149743.mlab.com:49743
		//MongoClient mongoClient = new MongoClient();
        MongoClientURI uri  = new MongoClientURI("mongodb://andre:andre@ds149743.mlab.com:49743/mamalujo"); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
		MongoCollection cliente = db.getCollection("cliente");
        
        MongoCursor<Document> cursor = cliente.find().iterator();
        String validaddaos = "0";
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println("verificacao de dados para inclusão");
                if((doc.get("NomeArquivo")!=(beancli.getNomearquivo())) || (doc.get("NomeArquivo") != null)){
                	System.out.println("verificacao de dados para inclusão");
                	validaddaos = "1";
                }
            }
        } finally {
            cursor.close();
        }	
        if(validaddaos.equals("1") || cursor!=null){
        	System.out.println("dados para incluidos em tabela existente");
    		Document document = new Document();
    		document.put("nome", beancli.getNome());
    		document.put("cpf", beancli.getCPF());
    		document.put("condutor", beancli.getCondutor());
    		document.put("endereco", beancli.getEndereco()); 
    		document.put("NomeArquivo", beancli.getNomearquivo());
            cliente.insertOne(document);
        }
	}
	
	public void ExportDataAuto(BeanCsvAuto beanauto) throws UnknownHostException{
	    //System.out.println(beanauto.getNome());
	    //System.out.println(beanauto.getVeiculo());
	    //System.out.println(beanauto.getSeguradora());
	    //System.out.println(beanauto.getVigencia());
	    enviaPostAutoMongo(beanauto);
		
	}
	
	public void enviaPostAutoMongo(BeanCsvAuto beanauto) throws UnknownHostException{
		
		//Mongo mongo = new Mongo("104.197.117.81", 27017);
		//MongoClient mongo = new MongoClient( "104.197.117.81" , 27017 );//104.198.207.77  andre:andre@ds149743.mlab.com:49743
		//MongoClient mongoClient = new MongoClient();
        MongoClientURI uri  = new MongoClientURI("mongodb://andre:andre@ds149743.mlab.com:49743/mamalujo"); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
		MongoCollection auto = db.getCollection("auto");
        
		String validaddaos = "0";

        MongoCursor<Document> cursor = auto.find().iterator();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println("verificacao de dados para inclusão");
                if((doc.get("NomeArquivo")!=(beanauto.getNomearquivo())) || (doc.get("NomeArquivo") != null)){
                	validaddaos = "1";
                }
                
            }
        } finally {
            cursor.close();
        }		
        if(validaddaos.equals("1") || cursor!=null){
        	System.out.println("dados para incluidos em tabela vazia");
    		Document document = new Document();
    		document.put("nome", beanauto.getNome());
    		document.put("veiculo", beanauto.getVeiculo());
    		document.put("ano", beanauto.getAno());
    		document.put("placa", beanauto.getPlaca());
    		document.put("vigencia", beanauto.getVigencia());
    		document.put("seguradora", beanauto.getSeguradora());
    		document.put("franquia", beanauto.getFranquia());
    		document.put("carroreserva", beanauto.getCarroReserva());
    		document.put("NomeArquivo", beanauto.getNomearquivo());
    		
    		auto.insertOne(document);
        }
	}
	
}
