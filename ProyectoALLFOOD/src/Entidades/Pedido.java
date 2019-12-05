package Entidades;

public class Pedido {
	
	private int codigo_pedido;
	private int codigo_cliente;
	private int codigo_servicio;
	private int cantidad_personas;
	private String fecha_compra;
	private String fecha_entrega;
	private Double pago_total;
	private String direccion_entrega;
	public int getCodigo_pedido() {
		return codigo_pedido;
	}
	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}
	public int getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	public int getCodigo_servicio() {
		return codigo_servicio;
	}
	public void setCodigo_servicio(int codigo_servicio) {
		this.codigo_servicio = codigo_servicio;
	}
	public int getCantidad_personas() {
		return cantidad_personas;
	}
	public void setCantidad_personas(int cantidad_personas) {
		this.cantidad_personas = cantidad_personas;
	}
	public String getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public String getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(String fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public Double getPago_total() {
		return pago_total;
	}
	public void setPago_total(Double pago_total) {
		this.pago_total = pago_total;
	}
	public String getDireccion_entrega() {
		return direccion_entrega;
	}
	public void setDireccion_entrega(String direccion_entrega) {
		this.direccion_entrega = direccion_entrega;
	}
	
	




}
