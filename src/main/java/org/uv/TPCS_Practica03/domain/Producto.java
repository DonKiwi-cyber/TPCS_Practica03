package org.uv.TPCS_Practica03.domain;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity (name="producto")
public class Producto {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column
    private String descripcion;
    
    @Column
    private double precio;
    
    @Column
    private int existencia;
    
    @Column
    private double costo;
    
    @OneToMany(mappedBy = "producto")
    private List<Det_Venta> det_venta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<Det_Venta> getDet_venta() {
        return det_venta;
    }

    public void setDet_venta(List<Det_Venta> det_venta) {
        this.det_venta = det_venta;
    }
    
    
}
