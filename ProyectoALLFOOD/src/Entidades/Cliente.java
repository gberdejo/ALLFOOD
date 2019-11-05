package Entidades;

public class Cliente {
private int cod_cli;
private String nom_cli;
private String ape_cli;
private int edad;
private String celular_cli;
private double saldo_cli;

public int getCod_cli() {
	return cod_cli;
}
public void setCod_cli(int cod_cli) {
	this.cod_cli = cod_cli;
}
public String getNom_cli() {
	return nom_cli;
}
public void setNom_cli(String nom_cli) {
	this.nom_cli = nom_cli;
}
public String getApe_cli() {
	return ape_cli;
}
public void setApe_cli(String ape_cli) {
	this.ape_cli = ape_cli;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public String getCelular_cli() {
	return celular_cli;
}
public void setCelular_cli(String celular_cli) {
	this.celular_cli = celular_cli;
}
public double getSaldo_cli() {
	return saldo_cli;
}
public void setSaldo_cli(double saldo_cli) {
	this.saldo_cli = saldo_cli;
}


}
