package com.eder.pruebaColfondos;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.eder.pruebaColfondos.Driver.Driver;
import com.eder.pruebaColfondos.PagesObjects.PaginaResultadoGoogle;
import com.eder.pruebaColfondos.PagesObjects.PrincipalGoogle;




/**
 * Hello world!
 * 
 * @author Eder Carbonero
 */
public class App {
	static String variable = "Salida";
	public static void main(String[] args) {
//		WebDriver webDriver= null;
//		PaginaResultadoGoogle objh = new PaginaResultadoGoogle(webDriver);
//		System.out.println(objh.cantidadResultados(("Cerca de 262.000 resultados (0,40 segundos) ")));
//		new Steps().pruebaInicial();
//		HiloEjecucion ejecucion = new HiloEjecucion();
//		ejecucion.start();
		

			
	}
	
	public void pruebaInicial() {
		Driver driver = new Driver();
		driver.inicializarDriver("google");
		PrincipalGoogle principalGoogle = new PrincipalGoogle(driver.getWebDriver());
		principalGoogle.ingresarValorEnCajaTexto("BDD");
		principalGoogle.enviarCajaTexto();
		driver.cerrarDriver();
	}
	
	

	
}
