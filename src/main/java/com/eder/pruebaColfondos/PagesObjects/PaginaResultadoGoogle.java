package com.eder.pruebaColfondos.PagesObjects;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.Exit;

public class PaginaResultadoGoogle {
	private WebDriver webDriver;
	private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	public PaginaResultadoGoogle(WebDriver webDriver) {
		setWebDriver(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "result-stats")
	public WebElement etiquetaResultados;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public long cantidadResultados() {
		long respuesta = 0;
		String texto = etiquetaResultados.getText().toLowerCase().trim();
		String cadenaNumeros = "";
		if (texto.contains("cerca de")) {
			texto = texto.replace("cerca de ", "").trim();
			for (int i = 0; i < texto.length(); i++) {
				String caracter = String.valueOf(texto.charAt(i));
				if (isNumeric(caracter) || caracter.contains(".")) {
					if (!caracter.contains(".")) {
						cadenaNumeros += caracter;
					}
				} else {
					i = texto.length();
				}
			}
			respuesta = Long.parseLong(cadenaNumeros);
		}
		return respuesta;
	}

	public boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		return pattern.matcher(strNum).matches();
	}
}
