package Entidades;

public class Pedido {
	
	private int codigo_pedido;
	private int codigo_cliente;
	private String nombre_cliente;
	private String apellido_cliente;
	private int codigo_servicio;
	private String nombre_servicio;
	private double precio_persona;
	private int codigo_chef;
	private String usuario_chef;
	private String nombre_chef;
	private String apellido_chef;
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
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getApellido_cliente() {
		return apellido_cliente;
	}
	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}
	public String getNombre_servicio() {
		return nombre_servicio;
	}
	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}
	public double getPrecio_persona() {
		return precio_persona;
	}
	public void setPrecio_persona(double precio_persona) {
		this.precio_persona = precio_persona;
	}
	public int getCodigo_chef() {
		return codigo_chef;
	}
	public void setCodigo_chef(int codigo_chef) {
		this.codigo_chef = codigo_chef;
	}
	public String getNombre_chef() {
		return nombre_chef;
	}
	public void setNombre_chef(String nombre_chef) {
		this.nombre_chef = nombre_chef;
	}
	public String getApellido_chef() {
		return apellido_chef;
	}
	public void setApellido_chef(String apellido_chef) {
		this.apellido_chef = apellido_chef;
	}
	public String getUsuario_chef() {
		return usuario_chef;
	}
	public void setUsuario_chef(String usuario_chef) {
		this.usuario_chef = usuario_chef;
	}
	
	




}
