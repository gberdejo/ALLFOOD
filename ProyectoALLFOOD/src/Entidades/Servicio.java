
package Entidades;

import java.io.InputStream;

public class Servicio {
	
	private int cod_servicio;
	private String nom_servico;
	private int cod_chef;
	private String nombre_chef;
	private String platillos;
	private String descripcion;
	private InputStream logo;
	private double precio_persona;
	private String fec_publicacion;
	
	public int getCod_servicio() {
		return cod_servicio;
	}
	public void setCod_servicio(int cod_servicio) {
		this.cod_servicio = cod_servicio;
	}
	public String getNom_servico() {
		return nom_servico;
	}
	public void setNom_servico(String nom_servico) {
		this.nom_servico = nom_servico;
	}
	public int getCod_chef() {
		return cod_chef;
	}
	public void setCod_chef(int cod_chef) {
		this.cod_chef = cod_chef;
	}
	public String getNombre_chef() {
		return nombre_chef;
	}
	public void setNombre_chef(String nombre_chef) {
		this.nombre_chef = nombre_chef;
	}
	public String getPlatillos() {
		return platillos;
	}
	public void setPlatillos(String platillos) {
		this.platillos = platillos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio_persona() {
		return precio_persona;
	}
	public void setPrecio_persona(double precio_persona) {
		this.precio_persona = precio_persona;
	}
	public String getFec_publicacion() {
		return fec_publicacion;
	}
	public void setFec_publicacion(String fec_publicacion) {
		this.fec_publicacion = fec_publicacion;
	}
	public InputStream getLogo() {
		return logo;
	}
	public void setLogo(InputStream logo) {
		this.logo = logo;
	}
	
}

