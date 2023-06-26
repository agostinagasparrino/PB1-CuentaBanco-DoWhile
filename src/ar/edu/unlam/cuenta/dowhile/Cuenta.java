package ar.edu.unlam.cuenta.dowhile;

public class Cuenta {

	private String nombre;
	private Double saldo;
	private static int contadorDeCuentas = 1;

	public Cuenta(String nombre, Double saldoInicial) {

		this.nombre = nombre;
		this.saldo = saldoInicial;
		contadorDeCuentas++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldoInicial) {
		this.saldo = saldoInicial;
	}

	public static int getContadorDeCuentas() {
		return contadorDeCuentas;
	}

	public void depositar(Double montoAdepositar) {
		this.saldo += montoAdepositar;
	}

	public boolean extraer(Double monto) {
		boolean extraccionExitosa = false;
		if (monto <= this.saldo) {
			this.saldo -= monto;
			extraccionExitosa = true;
		}
		return extraccionExitosa;

	}

	public boolean transferir(Double monto) {

		boolean transferenciaExitosa = false;
		if (monto <= this.saldo) {
			this.saldo -= monto;
			transferenciaExitosa = true;
		}
		return transferenciaExitosa;
	}

	public void transferenciaExitosa(Double monto) {
		if (monto <= this.saldo) {
			this.saldo += monto;
		}

	}

}
