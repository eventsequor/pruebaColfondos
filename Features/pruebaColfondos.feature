Feature: Esto es una prueba para Colfondos creada por Eder Carbonero
	
@CasoBDD 
Scenario Outline: Busqueda BDD 
	Given El usuario inicia el navegador "<navegador>" 
	Given El usuario ingresa a la pagina con url "<pagina>" web
	When El usuario ingresa en la caja de texto el valor "<valorA_Buscar>"
	When El usuario envia el valor de la caja de texto
	Then El usuario valida que la cantidad de resultados sea aproximadamente <cantidadResultados>
	
	Examples: 
		|navegador|pagina|valorA_Buscar|tiempo|cantidadResultados|
		|google|https://www.google.com/|Gherkin Tutorial|tiempo|260000|
		
		