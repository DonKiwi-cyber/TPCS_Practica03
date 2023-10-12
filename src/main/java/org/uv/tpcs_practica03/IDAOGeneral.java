package org.uv.tpcs_practica03;
import java.util.List;

/*@author miran */

public interface IDAOGeneral <T, ID>{
    public T create (T t);
     public boolean delete(ID id);
    public T update(T t, ID id);
    
    public List<T> findAll();
    public T findByID(ID id);
    
}
