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
	    System.out.println(beancli.getNome());
	    System.out.println(beancli.getCPF());
	    System.out.println(beancli.getCondutor());
	    System.out.println(beancli.getEndereco());
		enviaPostMongo(beancli);
		
	}
	
	public void enviaPostMongo(BeanCsvCliente bean) throws UnknownHostException{
		
		//Mongo mongo = new Mongo("104.197.117.81", 27017);
		//MongoClient mongo = new MongoClient( "104.197.117.81" , 27017 );//104.198.207.77  andre:andre@ds149743.mlab.com:49743
		//MongoClient mongoClient = new MongoClient();
        MongoClientURI uri  = new MongoClientURI("mongodb://andre:andre@ds149743.mlab.com:49743/mamalujo"); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
		MongoCollection cliente = db.getCollection("cliente");
        
		Document document = new Document();
		document.put("nome", bean.getNome());
		document.put("cpf", bean.getCPF());
		document.put("condutor", bean.getCondutor());
		document.put("condutor", bean.getEndereco());

        cliente.insertOne(document);


        //Document findQuery = new Document("item", 1);
        //Document orderBy = new Document("item", 1);

        MongoCursor<Document> cursor = cliente.find().iterator();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println("nome:");
                System.out.println(doc.get("nome"));
            }
        } finally {
            cursor.close();
        }		
		
	}
	
	public void ExportDataAuto(BeanCsvAuto beanauto) throws UnknownHostException{
	    System.out.println(beanauto.getNome());
	    System.out.println(beanauto.getVeiculo());
	    System.out.println(beanauto.getSeguradora());
	    System.out.println(beanauto.getVigencia());
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
        
		Document document = new Document();
		document.put("nome", beanauto.getNome());
		document.put("veiculo", beanauto.getVeiculo());
		document.put("ano", beanauto.getAno());
		document.put("placa", beanauto.getPlaca());
		document.put("vigencia", beanauto.getVigencia());
		document.put("seguradora", beanauto.getSeguradora());
		document.put("franquia", beanauto.getFranquia());
		document.put("carroreserva", beanauto.getCarroReserva());
		
		auto.insertOne(document);


        //Document findQuery = new Document("item", 1);
        //Document orderBy = new Document("item", 1);

        MongoCursor<Document> cursor = auto.find().iterator();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println("nome:");
                System.out.println(doc.get("nome"));
                
                System.out.println("veiculo:");
                System.out.println(doc.get("veiculo"));
            }
        } finally {
            cursor.close();
        }		
		
	}
	
}
