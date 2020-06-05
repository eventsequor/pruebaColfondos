package com.eder.pruebaColfondos;

import cucumber.api.cli.Main;

public class MainCucumberSobreEscrito extends Main {
	public MainCucumberSobreEscrito() {
		estadoEjecucion = false;
	}
	
	private boolean estadoEjecucion;
	
	public boolean isEstadoEjecucion() {
		return estadoEjecucion;
	}
	
	public void setEstadoEjecucion(boolean estadoEjecucion) {
		this.estadoEjecucion = estadoEjecucion;
	}
	
	public void mainXs(String[] argv) throws Throwable {
		estadoEjecucion = true;
        byte exitstatus = run(argv, Thread.currentThread().getContextClassLoader());
        if(exitstatus == 0) {
        	System.out.println("EJECUCIÓN EXITOSA");
        	estadoEjecucion = false;
        }else {
        	System.out.println("FALLOS EN LA EJECUCIÓN");
        	estadoEjecucion = false;
        }
//        System.exit(exitstatus);
    }
	
}