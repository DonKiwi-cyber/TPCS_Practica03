package org.uv.TPCS_Practica03.dao;
import java.util.List;


public interface IDAOGeneral <T, ID>{
    
    //Métodos de entrada
    public T crear (T t);
    public boolean eliminar(ID id);
    public T actualizar(T t, ID id);
    
    //Métodos de salida
    public List<T> buscar();
    public T buscarUno(ID id);
    
}
