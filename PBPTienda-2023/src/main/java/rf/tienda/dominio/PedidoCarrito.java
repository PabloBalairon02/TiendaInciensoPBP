package rf.tienda.dominio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PedidoCarrito {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id_pedido;
	
    private int id_usuario;
    
    private String id_producto;
    
    @Column(nullable = false)
    private int car_cantidad;
    
    @Column( nullable = false)
    private double car_precio;
    
    @Column( nullable = false)
    private String car_envio;
    
    @Column( nullable = false)
    private String car_pago;
    
    @Column( nullable = false)
    private String car_tarjeta;
    
    @Column( nullable = false)
    private LocalDate car_feCadud;
    
    @Column( nullable = false)
    private int car_ccv;
    
    @Column( nullable = false)
    private String car_nombre;
    
    @Column( nullable = false)
    private int car_stat;
    
    private List<String> car_feCambio;
    
	public int getId_pedido() {
		return id_pedido;
	}
	
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getId_producto() {
		return id_producto;
	}
	
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	
	public int getCar_cantidad() {
		return car_cantidad;
	}
	
	public void setCar_cantidad(int car_cantidad) {
		if(car_cantidad>0) {
			this.car_cantidad = car_cantidad;
		}
	}
	
	public double getCar_precio() {
		return car_precio;
	}
	
	public void setCar_precio(double car_precio) {
		this.car_precio = car_precio;
	}
	
	public String getCar_envio() {
		return car_envio;
	}
	
	public void setCar_envio(String car_envio) {
		this.car_envio = car_envio;
	}
	
	public String getCar_pago() {
		return car_pago;
	}
	
	public void setCar_pago(String car_pago) {
		this.car_pago = car_pago;
	}
	
	public String getCar_tarjeta() {
		return car_tarjeta;
	}
	
	public void setCar_tarjeta(String car_tarjeta) {
		this.car_tarjeta = car_tarjeta;
	}
	
	public LocalDate getCar_feCadud() {
		return car_feCadud;
	}
	
	public void setCar_feCadud(LocalDate car_feCadud) {
		this.car_feCadud = car_feCadud;
	}
	
	public int getCar_ccv() {
		return car_ccv;
	}
	
	public void setCar_ccv(int car_ccv) {
		this.car_ccv = car_ccv;
	}
	
	public String getCar_nombre() {
		return car_nombre;
	}
	
	public void setCar_nombre(String car_nombre) {
		this.car_nombre = car_nombre;
	}
	
	public int getCar_stat() {
		return car_stat;
	}
	
	public void setCar_stat(int car_stat) {
		this.car_stat = car_stat;
	}
	
	public List<String> getCar_feCambio() {
		return car_feCambio;
	}
	
	public void setCar_feCambio(List<String> car_feCambio) {
		this.car_feCambio = car_feCambio;
	}
}
