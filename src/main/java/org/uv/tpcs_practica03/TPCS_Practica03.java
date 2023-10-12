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
        
        cli.setNombre("Ayrton BW");
        cli.setRfc("BOWA010505XYZ");
        cli.setId(Long.MIN_VALUE);
        
        Producto prod = new Producto();
        prod.setId(Long.MIN_VALUE);
        prod.setDescripcion("DelawerPunch");
        prod.setPrecio(20);
        prod.setExistencia(50);
        prod.setCosto(25);
        
        Session session=sessionFac.openSession();
        Transaction t = session.beginTransaction();
        session.save(cli);
        session.save(prod);
        
        t.commit();
        session.close();
    }
}
