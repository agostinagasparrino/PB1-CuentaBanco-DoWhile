package ar.edu.unlam.cuenta.dowhile;

import java.util.Scanner;

public class CuentaBanco {
	
	private static final String cuenta = null;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Cuenta cuentaUno = crearCuenta();
		Cuenta cuentaDos = crearCuenta();
		// opciones del ususario
		boolean salir = false;
		int opcion;
		// menu
		do {
			System.out.println("Elija una opción : " + "\n1 para DEPOSITAR" + "\n2 para EXTRAER" + "\n3 para TRANSFERIR"
					+ "\n0 para FINALIZAR");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("DEPOSITAR");
				switch (seleccionarCuenta()) {
				case 1:
					menuDepositar(cuentaUno);
					break;
				case 2:
					menuDepositar(cuentaDos);
					break;

				default:
					System.out.println("numero de cuenta erronea");
					break;
				}

				break;
			case 2:
				System.out.println("EXTRAER");
				switch (seleccionarCuenta()) {
				case 1:
					menuExtraer(cuentaUno);
					break;
				case 2:
					menuExtraer(cuentaDos);
					break;

				default:
					System.out.println("numero de cuenta erronea");
					break;
				}

				break;
			case 3:
				System.out.println("TRANSFERIR");
				switch (seleccionarCuenta()) {
				case 1:
					System.out.println("transferir de cuenta 1 a cuenta 2");
					menuTransferirUno(cuentaUno, cuentaDos);
					break;
				case 2:
					System.out.println("transferir de cuenta 2 a cuenta 1");
					menuTransferirDos(cuentaDos, cuentaUno);
					break;

				default:
					System.out.println("Opcion incorrecta");
					break;
				}

				break;
			case 0:
				System.out.println("FINALIZAR");
				salir = true;
				break;

			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		} while (!salir);

		System.out.println("mostrar Saldo de cuentas");
		System.out.println("el saldo de la cuenta " + cuentaUno.getNombre() + " es " + cuentaUno.getSaldo());
		System.out.println("el saldo de la cuenta " + cuentaDos.getNombre() + " es " + cuentaDos.getSaldo());
	}

	private static void menuTransferirUno(Cuenta cuentaUno, Cuenta cuentaDos) {
		char continuar = 'A';
		do {
			System.out.println("ingrese el monto a transferir");
			Double monto = teclado.nextDouble();
			boolean transferenciaExitosa = cuentaUno.transferir(monto);
			if (transferenciaExitosa) {
				System.out.println("Se realizo la transferencia correctamente");
				cuentaDos.transferenciaExitosa(monto);
				System.out.println("Se transfirieron " + monto + " a " + cuentaDos.getNombre());
			} else {
				System.out.println("Monto insuficiente ");
				System.out.println("no se puede transferir " + monto);
				System.out.println("el monto maximo a transferir es " + cuentaUno.getSaldo());
				System.out.println(
						"ingrese B(i) para repetir la operacion o presione cuanlquer tecla para volver al menu anterior");
				continuar = teclado.next().toUpperCase().charAt(0);
			}
		} while (continuar == 'B');
	}

	private static void menuTransferirDos(Cuenta cuentaDos, Cuenta cuentaUno) {

		char continuar = 'A';
		do {
			System.out.println("ingrese el monto a transferir");
			Double monto = teclado.nextDouble();
			boolean transferenciaExitosa = cuentaDos.transferir(monto);
			if (transferenciaExitosa) {
				System.out.println("Se realizo la transferencia correctamente");
				cuentaUno.transferenciaExitosa(monto);
				System.out.println("Se transfirieron " + monto + " a " + cuentaUno.getNombre());
			} else {
				System.out.println("Monto insuficiente ");
				System.out.println("no se puede transferir " + monto);
				System.out.println("el monto maximo a transferir es " + cuentaDos.getSaldo());
				System.out.println(
						"ingrese B(i) para repetir la operacion o presione cuanlquer tecla para volver al menu anterior");
				continuar = teclado.next().toUpperCase().charAt(0);
			}
		} while (continuar == 'B');
	}

	private static void menuExtraer(Cuenta cuenta) {
		char continuar = 'N';
		do {
			System.out.println("Usted tiene en la cuenta " + cuenta.getSaldo());
			System.out.println("ingrese el monto a extraer");
			Double monto = teclado.nextDouble();
			boolean extraccionExitosa = cuenta.extraer(monto);
			if (extraccionExitosa)
				System.out.println("se realizo la extraccion correctamente");
			else {
				System.out.println("Monto insuficiente para la extracción");
				System.out.println("no se puede retirar " + monto);
				System.out.println("el monto maximo a retirar es " + cuenta.getSaldo());
				System.out.println(
						"ingrese S(i) para repetir la operacion o presione cuanlquer tecla para volver al menu anterior");
				continuar = teclado.next().toUpperCase().charAt(0);
			}
		} while (continuar == 'S');
	}

	private static void menuDepositar(Cuenta cuenta) {
		System.out.println("deposito en cuenta ");
		System.out.println("ingrese el monto a depositar");
		Double montoAdepositar = teclado.nextDouble();
		cuenta.depositar(montoAdepositar);
	}

	private static int seleccionarCuenta() {
		System.out.println("seleccione la cuenta para la extraccion ");
		int numeroDeCuenta = teclado.nextInt();
		return numeroDeCuenta;
	}

	private static Cuenta crearCuenta() {
		System.out.println("ingrese los datos para crear la cuenta " + Cuenta.getContadorDeCuentas());
		System.out.println("Ingrese el nombre de la cuenta ");
		String nombre = teclado.next();
		System.out.println("Ingrese el saldo inicial de la cuenta");
		Double saldoInicial = teclado.nextDouble();
		Cuenta cuenta = new Cuenta(nombre, saldoInicial);
		return cuenta;
	}

	public static String getCuenta() {
		return cuenta;
	}
}