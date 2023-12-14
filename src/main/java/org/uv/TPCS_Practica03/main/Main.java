package org.uv.TPCS_Practica03.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.uv.TPCS_Practica03.domain.Cliente;
import org.uv.TPCS_Practica03.domain.Producto;
import org.uv.TPCS_Practica03.hibernate.HibernateUtil;

/* @author miran */

public class Main {

    public static void main(String[] args) {
        
        //Declaración de hibernate
        SessionFactory sessionFac= HibernateUtil.getSessionFactory();
        
        //Cliente N1
        Cliente cli=new Cliente();
        cli.setNombre("Ian");
        cli.setRfc("ROPI021021");
        cli.setId(Long.MIN_VALUE);
        
        //Cliente N2
        cli.setNombre("Emmanuel");
        cli.setRfc("GOMA021023");
        cli.setId(Long.MIN_VALUE);
        
        //Producto 
        Producto prod = new Producto();
        prod.setId(Long.MIN_VALUE);
        prod.setDescripcion("Dr. Pepper");
        prod.setPrecio(23);
        prod.setExistencia(100);
        prod.setCosto(20);
        
        //Conexión a Postgres
        Session session=sessionFac.openSession();
        Transaction t = session.beginTransaction();
        
        //Guardado de datos
        session.save(cli);
        session.save(prod);      
        t.commit();
        
        //Cierre de la conexión
        session.close();
    }
}
