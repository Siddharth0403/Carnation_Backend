package com.carnation.Hibernet_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.carnation.Hibernet_one_to_one.Entity.Marks;
import com.carnation.Hibernet_one_to_one.Entity.Student;




 
public class App 
{
	public static void main(String[] args) {
		{
	        Configuration cfg=new Configuration()
	        									.configure()
	        									.addAnnotatedClass(Student.class)
										        .addAnnotatedClass(Marks.class);
	        
	        SessionFactory sf=cfg.buildSessionFactory();
	        
	        Session session=sf.openSession();
	        session.beginTransaction();
			//-------START
	        
	        Student s=new Student();
	        s.setRollno(2);
	        s.setName("Siddharth");
	        s.setAddress("Pune");
	        
	        session.save(s);
	        
	        Marks m=new Marks();
	        m.setId(102);
	        m.setEnglish(96);
	        m.setMath(80);
	        Student std=session.get(Student.class, 1);
	        m.setStudent(std);
	        
	        session.save(m);
	        
	        
	        //-------END
	        
	        session.getTransaction().commit();
	        session.close();
		}	
       
        
   
	}
}