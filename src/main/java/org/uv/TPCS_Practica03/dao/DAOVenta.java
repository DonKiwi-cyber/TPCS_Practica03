package org.uv.TPCS_Practica03.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.uv.TPCS_Practica03.domain.Det_Venta;
import org.uv.TPCS_Practica03.domain.Producto;
import org.uv.TPCS_Practica03.domain.Venta;
import org.uv.TPCS_Practica03.hibernate.HibernateUtil;

/* @author miran */

public class DAOVenta implements IDAOGeneral<Venta, Long>{

    @Override
    public Venta crear(Venta t) {
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
    public boolean eliminar(Long id) {
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
    public Venta actualizar(Venta t, Long id) {
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
    public List<Venta> buscar() {
        Session session=HibernateUtil.getSession();
        List<Venta> ventas=session.createQuery("From Venta e order by e.ventaId").list();
        session.close();
        return ventas;
    }

    @Override
    public Venta buscarUno(Long id) {
        Session session=HibernateUtil.getSession();
        Venta venta=session.get(Venta.class, id);
        session.close();
        return venta;
    }
    
}
