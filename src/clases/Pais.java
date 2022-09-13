package clases;

import interfaces.CalcularPIB;

public class Pais extends Continente {
	
	private String nombre;
	private String capital;
	private int habitantes;
	private String clima;
	private int salario;
	private double PIB;
	
	CalcularPIB calcularPIB = (n1, n2) -> Double.valueOf(habitantes) * Double.valueOf(salario);
	
	public Pais(String nombre, String continente, String capital, int habitantes, String clima, int salario) {
		super();
		this.setNombre(nombre);
		super.nombre = continente;
		this.setCapital(capital);
		this.setHabitantes(habitantes);
		this.clima = clima;
		this.salario = salario;
		setPIB(calcularPIB.multiplicar(salario, habitantes));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContinente() {
		return super.nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getHabitantes() {
		return String.valueOf(habitantes);
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getSalario() {
		return String.valueOf(salario);
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Double getPIB() {
		return Double.valueOf(PIB);
	}

	public void setPIB(double pIB) {
		PIB = pIB;
	}
	
}
