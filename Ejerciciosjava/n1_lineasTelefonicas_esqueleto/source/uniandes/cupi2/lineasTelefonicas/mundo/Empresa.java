/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa la empresa.
 */
public class Empresa
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Línea telefónica número 1.
     */
    private LineaTelefonica linea1;

    /**
     * Línea telefónica número 2.
     */
    private LineaTelefonica linea2;

    /**
     * Línea telefónica número 3.
     */
    private LineaTelefonica linea3;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Inicializa las líneas telefónicas de la empresa. <br>
     * <b>post: </b> Se inicializaron las 3 líneas telefónicas.
     */
    public Empresa( )
    {
        linea1 = new LineaTelefonica( );
        // TODO Parte3 PuntoA: Construir linea2 y linea3.
        linea2 = new LineaTelefonica();
        linea3 = new LineaTelefonica();

    }

    /**
     * Retorna la línea 1.
     * @return Línea 1.
     */
    public LineaTelefonica darLinea1( )
    {
        // TODO Parte3 PuntoB: Completar el método según la documentación dada.
    	return linea1;
    }

    /**
     * Retorna la línea 2.
     * @return Línea 2.
     */
    public LineaTelefonica darLinea2( )
    {
        // TODO Parte3 PuntoC: Completar el método según la documentación dada.
    	return linea2;
    }

    /**
     * Retorna la línea 3.
     * @return Línea 3.
     */
    public LineaTelefonica darLinea3( )
    {
        // TODO Parte3 PuntoD: Completar el método según la documentación dada.
    	return linea3;
    }

    /**
	 * Retorna el número total de llamadas realizadas.
	 * @return Total de llamadas de las tres líneas.
	 */
	public int darTotalNumeroLlamadas( )
	{
        // TODO Parte3 PuntoE: Completar el método según la documentación dada.
		int totalNumeroLlamadas = linea1.darNumeroLlamadas() + linea2.darNumeroLlamadas() + linea3.darNumeroLlamadas();
		return totalNumeroLlamadas;
	}

	/**
	 * Retorna el total de minutos consumidos.
	 * @return Total de minutos de las tres líneas.
	 */
	public int darTotalMinutos( )
	{
        // TODO Parte3 PuntoF: Completar el método según la documentación dada.
		int totalMinutos = linea1.darNumeroMinutos() + linea2.darNumeroMinutos() + linea3.darNumeroMinutos();
		return totalMinutos;
	}

	/**
	 * Retorna el costo total de las llamadas realizadas.
	 * @return Costo total de las tres líneas.
	 */
	public double darTotalCostoLlamadas( )
	{        
        // TODO Parte3 PuntoG: Completar el método según la documentación dada.
		double totalCostoLlamadas = linea1.darCostoLlamadas() + linea2.darCostoLlamadas() + linea3.darCostoLlamadas();
		return totalCostoLlamadas;
	}

	/**
	 * Retorna el costo promedio de un minuto, según los minutos consumidos. <br>
	 * @return Costo promedio por minuto.
	 */
	public double darCostoPromedioMinuto( )
	{
        // TODO Parte3 PuntoH: Completar el método según la documentación dada.
		double costoPromedioMinuto = darTotalCostoLlamadas() / darTotalMinutos();
		return costoPromedioMinuto;
	}

	/**
     * Agrega una llamada local a la línea telefónica 1 <br>
     * <b>post: </b> Se agregó la llamada a la línea 1.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea1( int pMinutos )
    {
        linea1.agregarLlamadaLocal( pMinutos );
    }

    /**
     * Agrega una llamada local a la línea telefónica 2. <br>
     * <b>post: </b> Se agregó la llamada a la línea 2.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea2( int pMinutos )
    {
        // TODO Parte3 PuntoI: Completar el método según la documentación dada.
    	linea2.agregarLlamadaLocal(pMinutos);
    }

    /**
     * Agrega una llamada local a la línea telefónica 3. <br>
     * <b>post: </b> Se agrega la llamada a la línea 3.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea3( int pMinutos )
    {
        // TODO Parte3 PuntoJ: Completar el método según la documentación dada.
    	linea3.agregarLlamadaLocal(pMinutos);
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 1. <br>
     * <b>post: </b> Se agrega la llamada a la línea 1.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea1( int pMinutos )
    {
    	linea1.agregarLlamadaLargaDistancia( pMinutos );
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 2. <br>
     * <b>post: </b> Se agrega la llamada a la línea 2.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea2( int pMinutos )
    {
        // TODO Parte3 PuntoK: Completar el método según la documentación dada.
    	linea2.agregarLlamadaLargaDistancia(pMinutos);
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 3. <br>
     * <b>post: </b> Se agrega la llamada a la línea 3.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea3( int pMinutos )
    {
        // TODO Parte3 PuntoL: Completar el método según la documentación dada.
    	linea3.agregarLlamadaLargaDistancia(pMinutos);
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 1. <br>
     * <b>post: </b> Se agrega la llamada a la línea 1.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea1( int pMinutos )
    {
    	linea1.agregarLlamadaCelular( pMinutos );
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 2. <br>
     * <b>post: </b> Se agrega la llamada a la línea 2.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea2( int pMinutos )
    {
        // TODO Parte3 PuntoM: Completar el método según la documentación dada.
    	linea2.agregarLlamadaCelular(pMinutos);
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 3. <br>
     * <b>post: </b> Se agrega la llamada a la línea 3.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea3( int pMinutos )
    {
        // TODO Parte3 PuntoN: Completar el método según la documentación dada.
    	linea3.agregarLlamadaCelular(pMinutos);
    }

    /**
     * Reinicia todas las líneas telefónicas.
     * <b>post: </b> Se reinició la llamada a la línea 1, 2 y 3.
     */
    public void reiniciar( )
    {
        linea1.reiniciar( );
        // TODO Parte3 PuntoB: Completar el método para reiniciar las lineas 2 y 3.
        linea2.reiniciar();
        linea3.reiniciar();
    }

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
