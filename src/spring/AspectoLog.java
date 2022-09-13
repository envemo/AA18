package spring;

import java.time.LocalDate;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import clases.Usuario;

@Aspect
@Component


public class AspectoLog
{
	
	@Before("execution(* leerArchivo(String)) && args(archivo)") //* cualquier generarTxt Antes
	public void log(String archivo)
	{
		
		System.out.println("Leyendo archivo \"" + archivo + "\"");
		
		/*try {
            Paths.get(archivo);
            System.out.println("Archivo válido: " + archivo);
        } catch (InvalidPathException ex) {
            ex.printStackTrace();
            System.out.println("Archivo inválido: " + archivo);
        }*/

	}
	
	@After("execution(* leerArchivo(String)) && args(archivo)") //* cualquier generarTxt Antes
	public void log2(String archivo)
	{
		
		System.out.println("Lectura OK \"" + archivo + "\"");

	}
	
	@Before("execution(* obtenerPaises(java.util.List))") //* cualquier generarTxt Antes
	public void log3()
	{
		System.out.println("obteniendo países");
	}
	
	@After("execution(* obtenerPaises(java.util.List))") //* cualquier generarTxt Antes
	public void log4()
	{
		System.out.println("obtener países OK");
	}
	
	@Before("execution(* generarArchivos(java.util.List))") //* cualquier generarTxt Antes
	public void log5()
	{
		System.out.println("generando archivos");
	}
	
	@After("execution(* generarArchivos(java.util.List))") //* cualquier generarTxt Antes
	public void log6()
	{
		System.out.println("archivos generados a fecha de " + LocalDate.now() + " por " + Usuario.nombre);
	}
	
}
/*
ASPECTOS: El concepto de aspecto es el ELEMENTO FUNDAMENTAL DEL PARADIGMA. SE EMPLEA PARA DEFINIR
UNA FUNCIONALIDAD TRANSVERSAL!!!!! AL SOFTWARE. 
PUNTO DE CORTE
CONSEJO O ADVICE 
*/