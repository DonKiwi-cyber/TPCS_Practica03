package org.uv.tpcs_practica03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* @author miran */

public class TPCS_Practica03 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        SessionFactory sessionFac= HibernateUtil.getSessionFactory();
        Cliente cli=new Cliente();
        cli.setNombre("Natalia LM");
        cli.setRfc("LOMN030602ZYX");
        cli.setId(Long.MIN_VALUE);
        
        Session session=sessionFac.openSession();
        Transaction t = session.beginTransaction();
        session.save(cli);
        t.commit();
        session.close();
    }
}
