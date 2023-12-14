package org.uv.TPCS_Practica03.domain;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity (name="venta")
public class Venta {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column
    private Date fecha;
    
    @Column
    private float total;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    
    @OneToMany(mappedBy="venta", cascade={CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval=true, fetch=FetchType.EAGER)
    private List<Det_Venta> detalles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Det_Venta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Det_Venta> detalles) {
        this.detalles = detalles;
        this.total=0;
        for(Det_Venta detalle:detalles){
            this.total+=detalle.getPrecio()*detalle.getCantidad();
        }
    }
    
    
}
