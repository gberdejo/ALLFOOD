package Entidades;

public class Pedido {
private int cod_pedido;
private int cod_cli;
private int cod_servicio;
private int cant_personas;
private String fec_compra;
private String fec_entrega;
private double pago_total;
private int valoracion;


public int getCod_pedido() {
	return cod_pedido;
}
public void setCod_pedido(int cod_pedido) {
	this.cod_pedido = cod_pedido;
}
public int getCod_cli() {
	return cod_cli;
}
public void setCod_cli(int cod_cli) {
	this.cod_cli = cod_cli;
}
public int getCod_servicio() {
	return cod_servicio;
}
public void setCod_servicio(int cod_servicio) {
	this.cod_servicio = cod_servicio;
}
public int getCant_personas() {
	return cant_personas;
}
public void setCant_personas(int cant_personas) {
	this.cant_personas = cant_personas;
}
public String getFec_compra() {
	return fec_compra;
}
public void setFec_compra(String fec_compra) {
	this.fec_compra = fec_compra;
}
public String getFec_entrega() {
	return fec_entrega;
}
public void setFec_entrega(String fec_entrega) {
	this.fec_entrega = fec_entrega;
}
public double getPago_total() {
	return pago_total;
}
public void setPago_total(double pago_total) {
	this.pago_total = pago_total;
}
public int getValoracion() {
	return valoracion;
}
public void setValoracion(int valoracion) {
	this.valoracion = valoracion;
}


}
