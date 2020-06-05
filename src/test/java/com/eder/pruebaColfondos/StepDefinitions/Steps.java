package com.eder.pruebaColfondos.StepDefinitions;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.eder.pruebaColfondos.Driver.Driver;
import com.eder.pruebaColfondos.PagesObjects.PaginaResultadoGoogle;
import com.eder.pruebaColfondos.PagesObjects.PrincipalGoogle;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;



public class Steps {
	Driver driver;
	PrincipalGoogle paginaInicio;
	PaginaResultadoGoogle paginaResultadoGoogle;

	@Before
	public void inicializarVariables() {
		System.out.println("Inicializando variables");
		driver = new Driver();
	}

	@After
	public void finalizandoVariables() {
		System.out.println("Finalizando variables");
		driver.cerrarDriver();
		paginaInicio = null;
	}

	@Given("Nuevo")
	public void nuevo() {
		System.out.println("Prueba exitosa");

	}

	@Given("^El usuario inicia el navegador \"([^\"]*)\"$")
	public void navegador(String navegador) {
		driver.inicializarDriver(navegador);
	}

	@Given("^El usuario ingresa a la pagina con url \"([^\"]*)\" web$")
	public void ingresoPagina(String pagina) {
		driver.establecerPagina(pagina);
	}

	@When("^El usuario ingresa en la caja de texto el valor \"([^\"]*)\"$")
	public void ingresarTextoEnCaja(String valor) {
		paginaInicio = new PrincipalGoogle(driver.getWebDriver());
		paginaInicio.ingresarValorEnCajaTexto(valor);
	}

	@When("^El usuario envia el valor de la caja de texto$")
	public void summit() {
		paginaInicio.enviarCajaTexto();
	}

	@Then("^El usuario valida que la cantidad de resultados sea aproximadamente (\\d+)$")
	public void validarCantiResultados(long cantidad) {
		paginaResultadoGoogle = new PaginaResultadoGoogle(driver.getWebDriver());
		assertEquals(cantidad, paginaResultadoGoogle.cantidadResultados(), cantidad * 0.25);
	}

}
