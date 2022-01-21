/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Pablo Barvo - 06-Dec-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa la empresa
 */
public class Empresa
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Línea telefónica número 1
     */
    private LineaTelefonica linea1;

    /**
     * Línea telefónica número 2
     */
    private LineaTelefonica linea2;

    /**
     * Línea telefónica número 3
     */
    private LineaTelefonica linea3;
    
    /**
     * Línea telefónica celular número 1
     */
    private LineaCelular lineaCelular1;

    /**
     * Línea telefónica Voz IP número 1
     */
 // TODO Declarar el atributo para modelar la linea VozIP llamada lineaVozIP1.
    private LineaVozIP lineaVozIP1;
    
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Constructor que inicializa las líneas telefónicas de la empresa <br>
     * <b>post: </b> Se inicializaron las 3 líneas telefónicas básicas y la línea celular.
     */
    public Empresa( )
    {
        //Crea la línea telefónica 1
        linea1 = new LineaTelefonica( );

        //Crea la línea telefónica 2
        linea2 = new LineaTelefonica( );

        //Crea la línea telefónica 3
        linea3 = new LineaTelefonica( );
        
        //Crea la línea telefónica celular 1
        lineaCelular1 = new LineaCelular( );
        
      //Crea la línea telefónica Voz IP 1
        // Inicializa la linea VozIP 1
        // TODO Crear e inicializar la linea VozIP 1.
        lineaVozIP1 = new LineaVozIP();
        
    }

    /**
     * Devuelve la línea 1
     * @return Línea 1
     */
    public LineaTelefonica darLinea1( )
    {
        return linea1;
    }

    /**
     * Devuelve la línea 2
     * @return Línea 2
     */
    public LineaTelefonica darLinea2( )
    {
        return linea2;
    }

    /**
     * Devuelve la línea 3
     * @return Línea 3
     */
    public LineaTelefonica darLinea3( )
    {
        return linea3;
    }

    /**
     * Devuelve la línea telefónica celular 1
     * @return Línea telefónica celular 1
     */
    public LineaCelular darLineaCelular1( )
    {
        return lineaCelular1;
    }
    
    /**
     * Devuelve la línea telefónica Voz IP número 1
     * @return Línea telefónica Voz IP número 1
     * //TODO
     */
    public LineaVozIP darLineaVozIP1( )
    {
    	return lineaVozIP1;
    }
        
    
    /**
     * Agrega una llamada local a la línea telefónica 1 <br>
     * <b>post: </b> Se agrega la llamada a la línea 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLocalLinea1( int minutos )
    {
        linea1.agregarLlamadaLocal( minutos );
    }

    /**
     * Agrega una llamada local a la línea telefónica 2 <br>
     * <b>post: </b> Se agrega la llamada a la línea 2
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLocalLinea2( int minutos )
    {
        linea2.agregarLlamadaLocal( minutos );
    }

    /**
     * Agrega una llamada local a la línea telefónica 3 <br>
     * <b>post: </b> Se agrega la llamada a la línea 3
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLocalLinea3( int minutos )
    {
        linea3.agregarLlamadaLocal( minutos );
    }

    /**
     * Agrega una llamada local a la línea telefónica celular 1 <br>
     * <b>post: </b> Se agrega la llamada local a la línea telefónica celular 1 si hay saldo local disponible en la línea
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public boolean agregarLlamadaLocalLineaCelular1( int minutos )
    {
    	if(lineaCelular1.darSaldoDisponibleLocal() < minutos*20)
    	{
    		return false;
    	}
    	else
    	{  	
    		lineaCelular1.agregarLlamadaLocal( minutos );
    		return true;
    	}
    }    
    
    /**
     * Agrega una llamada local a la línea telefónico VozIP 1 <br>
     * <b>post: </b> Se agrega la llamada a la línea VozIP 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     *  //TODO
     */
    public void agregarLlamadaLocalLineaVozIP1( int minutos )
    {
    	lineaVozIP1.agregarLlamadaLocal(minutos);
    }    
    
    /**
     * Agrega una llamada de larga distancia a la línea telefónica 1 <br>
     * <b>post: </b> Se agrega la llamada a la línea 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea1( int minutos )
    {
        linea1.agregarLlamadaLargaDistancia( minutos );
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 2 <br>
     * <b>post: </b> Se agrega la llamada a la línea 2
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea2( int minutos )
    {
        linea2.agregarLlamadaLargaDistancia( minutos );
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 3 <br>
     * <b>post: </b> Se agrega la llamada a la línea 3
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea3( int minutos )
    {
        linea3.agregarLlamadaLargaDistancia( minutos );
    }
    
    /**
     * Agrega una llamada a larga distancia a la línea telefónica VozIP 1 <br>
     * <b>post: </b> Se agrega la llamada a larga distancia a la línea telefónica VozIP 1 si hay saldo disponible en la línea para descontar los minutos.
     * @param minutos Número de minutos de la llamada. minutos > 0.
     *  //TODO
     */
    public boolean agregarLlamadaLargaDistanciaLineaVozIP1( int minutos )
    {
    	if (lineaVozIP1.darSaldoDisponible() < minutos *80)
    	{
    		return false;
    	}
    	else
    	{
    		lineaVozIP1.agregarLlamadaLargaDistancia(minutos);
    		return true;
    	}
    }     
    
    /**
     * Agrega una llamada a celular a la línea telefónica 1 <br>
     * <b>post: </b> Se agrega la llamada a la línea 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLinea1( int minutos )
    {
        linea1.agregarLlamadaCelular( minutos );
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 2 <br>
     * <b>post: </b> Se agrega la llamada a la línea 2
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLinea2( int minutos )
    {
        linea2.agregarLlamadaCelular( minutos );
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 3 <br>
     * <b>post: </b> Se agrega la llamada a la línea 3
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLinea3( int minutos )
    {
        linea3.agregarLlamadaCelular( minutos );
    }
    
    /**
     * Agrega una llamada a celular a la línea telefónica celular 1 <br>
     * <b>post: </b> Se agrega la llamada celular a la línea telefónica celular 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLineaCelular1( int minutos )
    {
        lineaCelular1.agregarLlamadaCelular( minutos );
    }

    /**
     * Agrega una llamada a celular a la línea telefónica VozIP 1 <br>
     * <b>post: </b> Se agrega la llamada a celular a la línea telefónica VozIP 1 si hay saldo disponible en la línea para descontar los minutos.
     * @param minutos Número de minutos de la llamada. minutos > 0.
     * //TODO
     */
    public boolean agregarLlamadaCelularLineaVozIP1( int minutos )
    {
    	if (lineaVozIP1.darSaldoDisponible() < minutos *7 )
    	{
    		return false;
    	}
    	else
    	{
    		lineaVozIP1.agregarLlamadaCelular(minutos);
    		return true;
    	}
    }      
    
    /**
     * Devuelve el nú8mero total de llamadas realizadas desde lineas telefónicas alternativas
     * @return total de llamadas de las tres líneas
     */
    public int darTotalNumeroLlamadasDesdeLineasNoAlternativas( )
    {
        int total = linea1.darNumeroLlamadas( ) + linea2.darNumeroLlamadas( ) + linea3.darNumeroLlamadas( );
        return total;
    }
    
    /**
     * Devuelve el número total de llamadas realizadas desde lineas telefónicas alternativas
     * @return
     * //TODO
     */
    public int darTotalNumeroLlamadasDesdeLineasAlternativas()
    {
    	int total = lineaCelular1.darNumeroLlamadas() + lineaVozIP1.darNumeroLlamadas();
    	return total;
    }

    /**
     * Devuelve el total de minutos consumidos
     * @return total de minutos de las tres líneas
     */
    public int darTotalMinutosDesdeLineasNoAlternativas( )
    {
        int total = linea1.darNumeroMinutos( ) + linea2.darNumeroMinutos( ) + linea3.darNumeroMinutos( );
        return total;
    }
    
    /**
     * Devuelve el total de minutos consumidos desde líneas alternativas
     * @return total de minutos de las líneas alternativas
     *  //TODO
     */
    public int darTotalMinutosDesdeLineasAlternativas()
    {
    	int total = lineaCelular1.darNumeroMinutos() + lineaVozIP1.darNumeroMinutos();
    	return total; 
    }

    /**
     * Devuelve el costo total de las llamadas realizadas
     * @return costo total de las tres líneas
     */
    public double darTotalCostoLlamadasDesdeLineasNoAlternativas( )
    {
        double total = linea1.darCostoLlamadas( ) + linea2.darCostoLlamadas( ) + linea3.darCostoLlamadas( );
        return total;
    }

    /**
     * Devuelve el costo total de las llamadas realizadas desde líneas alternativas
     * @return costo total de las líneas alternativas
     *  //TODO
     */
    public double darTotalCostoLlamadasDesdeLineasAlternativas()
    {
    	double total = lineaCelular1.darCostoLlamadas() + lineaVozIP1.darCostoLlamadas();
    	return total;
    }
    
    /**
     * Devuelve el costo promedio de un minuto, según los minutos consumidos <br>
     * <b>pre: </b> TotalMinutos > 0
     * @return Costo promedio por minuto.
     */
    public double darCostoPromedioMinutoDesdeLineasNoAlternativas( )
    {
        double promedio = darTotalCostoLlamadasDesdeLineasNoAlternativas( ) / darTotalMinutosDesdeLineasNoAlternativas( );
        return promedio;
    }
    
    /**
     * Devuelve el costo promedio de un minuto desde una línea alternativa, según los minutos consumidos <br>
     * <b>pre: </b> TotalMinutos > 0
     * @return Costo promedio por minuto.
     */
    public double darCostoPromedioMinutoDesdeLineasAlternativas( )
    {
        double promedio = darTotalCostoLlamadasDesdeLineasAlternativas( ) / darTotalMinutosDesdeLineasAlternativas( );
        return promedio;
    }


    /**
     * Reinicia todas las líneas telefónicas.
     */
    public void reiniciarLineasNoAlternativas( )
    {
        linea1.reiniciar( );
        linea2.reiniciar( );
        linea3.reiniciar( );
    }

    public void reiniciarLineasAlternativas()
    {
    	lineaCelular1.reiniciar();
    	lineaVozIP1.reiniciar();
    }
    
    
    
    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return Respuesta 1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return Respuesta 2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}