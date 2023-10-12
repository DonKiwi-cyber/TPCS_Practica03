package org.uv.tpcs_practica03;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*@author miran */

@Entity (name="cliente")

public class Cliente {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column
    private String nombre;
    
    @Column
    private String rfc;
    
//    @OneToMany(mappedBy = "cliente")
//    private List<Venta> venta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

//    public List<Venta> getVenta() {
//        return venta;
//    }
//
//    public void setVenta(List<Venta> venta) {
//        this.venta = venta;
//    }
    
    
    
}
