package org.uv.tpcs_practica03;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/* @author miran */

public class DAOVenta implements IDAOGeneral<Venta, Long>{

    @Override
    public Venta create(Venta t) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(t);
        for(Det_Venta detalle:t.getDetalles()){
            detalle.setVenta(t);
            session.save(detalle);
            Producto producto=session.get(Producto.class, detalle.getProducto().getId());
            producto.setExistencia(producto.getExistencia()-detalle.getCantidad());
            session.update(producto);
            
            /*Faltan validar reglas del negocio*/
        }
        transaction.commit();
        session.close();
        return t;
    }

    @Override
    public boolean delete(Long id) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        Venta venta=session.get(Venta.class, id);
        boolean pase=false;
        if(venta!=null){
            session.delete(venta);
            pase=true;
        }
        transaction.commit();
        session.close();
        return pase;
    }

    @Override
    public Venta update(Venta t, Long id) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        Venta venta=session.get(Venta.class, id);
        if(venta!=null){
            for(Det_Venta detalle:t.getDetalles()){
                detalle.setVenta(t);
            }
            session.merge(t);
            transaction.commit();
        }
        session.close();
        return t;
    }

    @Override
    public List<Venta> findAll() {
        Session session=HibernateUtil.getSession();
        List<Venta> ventas=session.createQuery("From Venta e order by e.ventaId").list();
        session.close();
        return ventas;
    }

    @Override
    public Venta findByID(Long id) {
        Session session=HibernateUtil.getSession();
        Venta venta=session.get(Venta.class, id);
        session.close();
        return venta;
    }
    
}
