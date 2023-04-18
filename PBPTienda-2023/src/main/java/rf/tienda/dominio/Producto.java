package rf.tienda.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import rf.tienda.exception.DomainException;
import rf.tienda.util.Validator;

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_producto; 
	
	@Column(name = "descripcion corta", nullable = false)
	private String pro_descripcion;
	
	@Column(name = "explicacion")
	private String pro_desLarga;
	
	@Column(name = "precio" , scale=2)
	private double pro_precio;
	
	@Column(name = "stock")
	private int pro_stock; 
	
	@Column(name = "fecha prevista", nullable=false)
	private Date pro_fecRepos; 
	
	@Column(name = "fecha activacion", nullable=false)
	private Date pro_fecActi; 
	
	@Column(name = "fecha desactivacion", nullable=false)
	private Date pro_fecDesacti; 
	
	@Column(name = "unidad de venta")
	private String pro_uniVenta; 
	
	@Column(name = "cantidad de unidades")
	private double pro_cantXUniVenta; 
	
	@Column(name = "unidad ultima")
	private String pro_uniUltNivel;
	
	@Column(name = "pais de origen")
	private int id_pais; 
	
	@Column(name = "uso recomendado")
	private String pro_usoRecomendado; 
	
	@Column(name = "categoria")
	private int id_categoria; 
	
	@Column(name = "stock reservado")
	private int pro_stkReservado; 
	
	@Column(name = "stock para nivel alto")
	private int pro_nStkAlto; 
	
	@Column(name = "stock para nivel bajo")
	private int pro_nStkBajo; 
	
	@Column(name = "estado")
	private char pro_stat;

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) throws DomainException {
		if(Validator.cumpleLongitudMax(pro_desLarga, 5)) {
			this.id_producto = id_producto;
		}else {
			throw new DomainException("Error");
		}
		
	}

	public String getPro_descripcion() {
		return pro_descripcion;
	}

	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if(Validator.cumpleLongitudMax(pro_descripcion, 100)) {
			this.pro_descripcion = pro_descripcion;
		}else {
			throw new DomainException("Error");
		}
	}

	public String getPro_desLarga() {
		return pro_desLarga;
	}

	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if(Validator.cumpleLongitudMax(pro_desLarga, 2000)) {
			this.pro_desLarga = pro_desLarga;
		}else {
			throw new DomainException("Error");
		}
	}

	public double getPro_precio() {
		return pro_precio;
	}

	public void setPro_precio(double pro_precio) {
		this.pro_precio = pro_precio;
	}

	public int getPro_stock() {
		return pro_stock;
	}

	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	public Date getPro_fecRepos() {
		return pro_fecRepos;
	}

	public void setPro_fecRepos(Date pro_fecRepos) {
		this.pro_fecRepos = pro_fecRepos;
	}

	public Date getPro_fecActi() {
		return pro_fecActi;
	}

	public void setPro_fecActi(Date pro_fecActi) {
		this.pro_fecActi = pro_fecActi;
	}

	public Date getPro_fecDesacti() {
		return pro_fecDesacti;
	}

	public void setPro_fecDesacti(Date pro_fecDesacti) {
		this.pro_fecDesacti = pro_fecDesacti;
	}

	public String getPro_uniVenta() {
		return pro_uniVenta;
	}

	public void setPro_uniVenta(String pro_uniVenta) {
		this.pro_uniVenta = pro_uniVenta;
	}

	public double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}

	public void setPro_cantXUniVenta(double pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}

	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}

	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}

	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}

	public void setPro_usoRecomendado(String pro_usoRecomendado) throws DomainException {
		if(Validator.cumpleLongitudMax(pro_usoRecomendado, 2000)) {
			this.pro_usoRecomendado = pro_usoRecomendado;
		}else {
			throw new DomainException("Error");
		}
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getPro_stkReservado() {
		return pro_stkReservado;
	}

	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}

	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}

	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}

	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}

	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}

	public char getPro_stat() {
		return pro_stat;
	}

	public void setPro_stat(char pro_stat) {
		this.pro_stat = pro_stat;
	}
	
}
