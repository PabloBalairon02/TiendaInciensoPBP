package rf.tienda.dominio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import rf.tienda.exception.DomainException;
import rf.tienda.util.Validator;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	@Column(name = "nombre", nullable = false)
    private String nombre;
	@Column(name = "correo", nullable = false)
    private String correoElectronico;
	@Column(name = "password", nullable = false)
    private String contrasena;
	@Column(name = "tipo", nullable = false)
    private String tipoUsuario;
	@Column(name = "DNI")
    private String numDNI;
	@Column(name = "fecha_alta")
    private LocalDate fechaAlta;
	@Column(name = "fecha_confir")
    private LocalDate fechaConfirmacion;
    
	public Usuario() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) throws DomainException {
		if(Validator.cumpleLongitud(nombre,5,  100)) {
			this.nombre = nombre;
		}else {
			throw new DomainException("Error");
		}
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public void setCorreoElectronico(String correoElectronico) throws DomainException {
		if(Validator.isEmailValido(correoElectronico)) {
			this.correoElectronico = correoElectronico;
		}else {
			throw new DomainException("Error");
		}
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) throws DomainException {
		if(Validator.esPasswordValida(contrasena)) {
			this.contrasena = contrasena;
		}else {
			throw new DomainException("Error");
		}
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getNumDNI() {
		return numDNI;
	}
	
	public void setNumDNI(String numDNI) throws DomainException {
		if(Validator.cumpleDNI(numDNI)) {
			this.numDNI = numDNI;
		}else {
			throw new DomainException("Error");
		}
	}
	
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public LocalDate getFechaConfirmacion() {
		return fechaConfirmacion;
	}
	
	public void setFechaConfirmacion(LocalDate fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}
    
 
}	
