package ups.edu.ec.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comida
 *
 */

@Entity
public class Comida implements Serializable {
    
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nombre;
    private double preciouni;
    @ManyToOne
    @JoinColumn
    private Pedido pedidos;
	
    
	public Comida() {
		super();
	}


	public Comida(String nombre, double preciouni, Pedido pedidos) {
		super();
		this.nombre = nombre;
		this.preciouni = preciouni;
		this.pedidos = pedidos;
	}






	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPreciouni() {
		return preciouni;
	}



	public void setPreciouni(double preciouni) {
		this.preciouni = preciouni;
	}



	public Pedido getPedidos() {
		return pedidos;
	}



	public void setPedidos(Pedido pedidos) {
		this.pedidos = pedidos;
	}






	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comida other = (Comida) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Comida [codigo=" + codigo + ", nombre=" + nombre + ", preciouni=" + preciouni + ", pedidos=" + pedidos
				+ "]";
	}
   
	
	
}
