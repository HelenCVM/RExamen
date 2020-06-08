package ups.edu.ec.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity

public class Pedido implements Serializable {

	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    @Temporal(TemporalType.DATE)
    private java.util.Calendar fecha;
    private String cliente;
    private double total;
    private String observaciones;
    @OneToMany(cascade =CascadeType.ALL,mappedBy ="pedidos")
    private Set<Comida>comidas=new HashSet<Comida>();
    @ManyToOne
    @JoinColumn
    private TarjetaCredito tarjeta;
    
	
    
	public Pedido() {
		super();
	}



	



	public Pedido(Calendar fecha, String cliente, TarjetaCredito tarjeta) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.tarjeta = tarjeta;
	}







	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}






	public String getFecha() {
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		
		return formato.format(fecha.getTime());
		
	}







	public void setFecha(java.util.Calendar fecha) {
		this.fecha = fecha;
	}







	public String getCliente() {
		return cliente;
	}



	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public String getObservaciones() {
		return observaciones;
	}



	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}



	public Set<Comida> getComidas() {
		return comidas;
	}



	public void setComidas(Set<Comida> comidas) {
		this.comidas = comidas;
	}



	public TarjetaCredito getTarjeta() {
		return tarjeta;
	}



	public void setTarjeta(TarjetaCredito tarjeta) {
		this.tarjeta = tarjeta;
	}



	



	public void addComida(Comida comida) {
		this.comidas.add(comida);
	}

	public void removeComida(Comida comida) {
		this.comidas.remove(comida);
	}
	
	public void calcularComidas() {
		double s=0;
		for (Comida comidass : comidas) {
			s+=comidass.getPreciouni();
		}
		setTotal(s);
	}

	

	
		



		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
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
		Pedido other = (Pedido) obj;
		if (numero != other.numero)
			return false;
		return true;
	}







		@Override
		public String toString() {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
			return "Pedido [numero=" + numero + ", fecha=" + formato.format(fecha.getTime()) + ", cliente=" + cliente + ", total=" + total
					+ ", observaciones=" + observaciones + ", comidas=" + comidas + ", tarjeta=" + tarjeta + "]";
		}
		
	
	
	
   
}
