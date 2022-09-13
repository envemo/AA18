package clases;

import interfaces.ValidarCampos;

public class Validar implements ValidarCampos {

	@Override
	public int validarEntero(String campo) {
		try {
			return Integer.valueOf(campo);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	@Override
	public int validarEntero(int campo) {
		return campo;
	}

}
