package spring;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import clases.Pais;
import clases.Validar;

@Service //Funciones y metodos a implementar USANDO AOP
public class Servicio
{
	
	public List<String> leerArchivo(String nombreArchivo) {
		List<String> lineas = new ArrayList<String>();
		File documento = new File(nombreArchivo);
		try {
			Scanner sc = new Scanner(documento);
			while (sc.hasNextLine())
			{
				lineas.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineas;
	}

	public List<Pais> obtenerPaises(List<String> lineas) {
		List<Pais> paises = new ArrayList<Pais>();
		for (int i = 0; i < lineas.size(); i+=6) {
			String nombre = lineas.get(i).split(":")[1];
			String continente = lineas.get(i+1).split(":")[1];
			String capital = lineas.get(i+2).split(":")[1];
			String habitantes = lineas.get(i+3).split(":")[1].replace(" ", "").replace(".", "");
			String clima = lineas.get(i+4).split(":")[1];
			String salario = lineas.get(i+5).split(":")[1].replace(" ", "").replace(",", "").replace(".00", "");
			Validar validar = new Validar();
			paises.add(new Pais(nombre, continente, capital, validar.validarEntero(habitantes), clima, validar.validarEntero(salario)));
		}
		return paises;
	}
	
	public void generarArchivos(List<Pais> paises) {
		for (Pais pais : paises) {
			List<String> lineas = new ArrayList<String>();
			lineas.add("PAIS: " + pais.getNombre());
			lineas.add("Continente: " + pais.getContinente());
			lineas.add("Capital: " + pais.getCapital());
			lineas.add("Habitantes: " + pais.getHabitantes());
			lineas.add("Clima Predominante: " + pais.getClima());
			lineas.add("Salario Minimo: " + pais.getSalario());
			lineas.add("PIB: " + pais.getPIB());
			Path file = Paths.get(pais.getNombre() + ".txt");
			try {
				Files.write(file, lineas, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
	}
	
}