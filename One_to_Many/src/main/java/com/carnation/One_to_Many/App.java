package com.carnation.One_to_Many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Document;
import Entity.User;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration()
				.configure()
				.addAnnotatedClass(User.class)
		        .addAnnotatedClass(Document.class);
				
				SessionFactory sf=cfg.buildSessionFactory();
				
				Session session=sf.openSession();
				session.beginTransaction();
				//-------START
				
				User u1=new User();
				u1.setUserId(101);
				u1.setName("Siddharth");
				u1.setAddress("Pune");
				
				User u2=new User();
				u2.setUserId(102);
				u2.setName("Don");
				u2.setAddress("Pune");
			
				
				
				session.save(u1);
				session.save(u2);
			
				
				
				Document d1=new Document();
				d1.setId(201);
				d1.setType("Pan");
				d1.setNumber("1324");

				Document d2=new Document();
				d2.setId(202);
				d2.setType("Liscence");
				d2.setNumber("1324");

				Document d3=new Document();
				d3.setId(203);
				d3.setType("AADHAR");
				d3.setNumber("45465");
				
				
				session.save(d1);
				session.save(d2);
				session.save(d3);
				
				
				User u3=new User();
				u3.setUserId(103);
				u3.setName("Alia");
				u3.setAddress("Bombay");
				
				List<Document> docs=new ArrayList<Document>();
				docs.add(d1);
				docs.add(d2);
				docs.add(d3);
				u3.setDocument(docs);
				
				session.save(u3);
				
				
				
				User usr= session.get(User.class,103);
				System.out.println(usr.toString());
				
				//Check one to many
//				User u2=new User();
//				u2.setUserId(102);
//				u2.setName("Don");
//				u2.setAddress("Pune");
//				
//				u2.setDocument(usr.getDocument());
//				session.save(u2);
				
				
				//-------END
				
				session.getTransaction().commit();
				session.close();
	
    }
}
