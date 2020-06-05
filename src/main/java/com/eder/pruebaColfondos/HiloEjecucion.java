package com.eder.pruebaColfondos;

import cucumber.api.cli.Main;

public class HiloEjecucion extends Thread {
	private boolean estadoHilo;
	private MainCucumberSobreEscrito obj;
	
	public HiloEjecucion() {
		estadoHilo = false;
		obj = null;
	}
	
	@Override
	public void run() {
		try {
			estadoHilo = true;
			String feature = System.getProperty("user.dir") + "\\Features\\pruebaColfondos.feature";
			String glue = "com.eder.pruebaColfondos.StepDefinitions";
			String tag = "@CasoBDD";
			String reporteHtml = "html:target/cucumber-reports";
			obj = new MainCucumberSobreEscrito();
			obj.mainXs(new String[] { "-m", "-s", "-p", "pretty", "-p", reporteHtml, "-g", glue, "-t", tag, feature });
		} catch (Throwable e) {
			estadoHilo = false;
			e.printStackTrace();			
		}
	}

	public boolean isEstadoHilo() {
		estadoHilo = obj.isEstadoEjecucion();
		return estadoHilo;
	}

	
	
	
	
	
	
	
}
