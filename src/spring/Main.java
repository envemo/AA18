package spring;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import clases.Pais;

public class Main 
{
	public static void main (String [] args)
	{
	
		try (
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
			Servicio servicio = ctx.getBean(Servicio.class);
			List<String> lineas = servicio.leerArchivo("INFO_PAISES.txt");
			List<Pais> paises = servicio.obtenerPaises(lineas);
			servicio.generarArchivos(paises);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

/*EJERCICIO AA18
Nos contrataron de las naciones unidas para diversificar información que hoy se tiene de distintos paises y entregar
la misma a los distintos responsables de los paises para que la tengan a disposición y mas clara. Para esto
Se debe agarrar una base de datos vieja que posee las Naciones Unidas con información relevante para los distintos
paises.

ESTRUCTURA DEL EJERCICIO:
- 2 Interfaces, 1 debe implementar una función lambda
- 1 Función Lambda
- 3 clases (como minimo)
  - Clase de usuario
  - Clase de Pais
  - Clase Continente
- Generacioón de N archivos (1 por cada Pais con cada información pertinente a cada pais)
- AOP que analice la función que genera archivos e informe cuando finalizo la misma y tambien la información
del usuario que corrio el proceso de generación de archivos

ENTREGABLES:
- Codigo del proyecto
- N txts

EXTRA: Agregar a la salida el PBI de cada país, se calcula en base a CANTIDAD DE HABITANTES * Salario minimo

*/