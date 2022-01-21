package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa una l�nea telef�nica VozIP.  Hereda la clase LineaTelefonica.
 */
public class LineaVozIP extends LineaTelefonica
{
	//-----------------------------------------------------------------
	// Atributos
    //-----------------------------------------------------------------
	
	/**
     * N�mero de minutos larga distancia consumidos.
     */
	private int numeroMinutosLargaDistancia;
	/**
     * N�mero de minutos celulares consumidos.
     */
	private int numeroMinutosCelular;
	/**
     * Saldo o dinero disponible para realizar llamadas.
     */
	private double saldoDisponible;
	
	//-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------
    
	/**
	 * Constructor que inicializa la l�nea telef�nica LineaVozIP
	 */
	public LineaVozIP() 
	{
		super();
		numeroMinutosLargaDistancia = 0;
		numeroMinutosCelular = 0;
		saldoDisponible = 100000;		
	}
	
	/**
	 * Devuelve el n�mero de minutos larga distancia consumidos
     * @return N�mero de minutos larga distancia consumidos
	 */
	public int darNumeroMinutosLargaDistancia ()
	{
		return numeroMinutosLargaDistancia;
	}
	/**
	 * Devuelve el n�mero de minutos de celular consumidos
     * @return N�mero de minutos de celular consumidos
	 */
	public int darNumeroMinutosCelular ()
	{
		return numeroMinutosCelular;
	}
	/**
	 * Devuelve el saldo disponible para realizar llamadas larga distancia.
     * @return Saldo disponible para realizar llamadas larga distancia.
	 */
	public double darSaldoDisponible()
	{
		return saldoDisponible;
	}
	
	
	/**
     * Agrega una llamada a celular a la l�nea VozIP <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 999 )
     * 				 y se incremento numeroMinutosCelular en minutos.
     *               saldoDisponibleLocal disminuye en ( minutos * 7 )
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
	public void agregarLlamadaCelular(int minutos )
	{
		//Se invoca el m�todo agregarLlamadaCelular de la clase hereda a trav�s de la palabra reservada "super".
    	//Esta invocaci�n incrementa en 1 numeroDeLlamadas, incrementa numeroDeMinutos en minutos y aumenta costoLlamadas en ( minutos * 999 )
		super.agregarLlamadaCelular(minutos);
		
		//Modifica el costo total de las llamadas con el valor dado por par�metro (7 pesos).
		modificarCostoLlamada( darCostoLlamadas() - minutos*992 );
		
		//Suma los minutos a celular consumidos. Se modifica el atributo propio de esta clase.
		numeroMinutosCelular += minutos;
		
		//Disminuye el saldo disponible para realizar llamadas locales (costo por minuto: 7 pesos)
		saldoDisponible = saldoDisponible - (minutos * 7);
	}
	
	/**
     * Agrega una llamada a larga distancia a la l�nea VozIP <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 380 )
     * 				 y se incremento numeroMinutosLargaDistancia en minutos.
     *               saldoDisponibleLocal disminuye en ( minutos * 80 )
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
	public void agregarLlamadaLargaDistancia(int minutos)
	{
		//Se invoca el m�todo agregarLlamadaLargaDistancia de la clase hereda a trav�s de la palabra reservada "super".
    	//Esta invocaci�n incrementa en 1 numeroDeLlamadas, incrementa numeroDeMinutos en minutos y aumenta costoLlamadas en ( minutos * 380 )
		super.agregarLlamadaLargaDistancia(minutos);
		
		//Modifica el costo total de las llamadas con el valor dado por par�metro (80 pesos).
		modificarCostoLlamada (darCostoLlamadas() - minutos*300 );
		
		//Suma los minutos a celular consumidos. Se modifica el atributo propio de esta clase
		numeroMinutosLargaDistancia += minutos;
		
		//Disminuye el saldo disponible para realizar llamadas locales (costo por minuto: 80 pesos)
		saldoDisponible = saldoDisponible - (minutos * 80);
		
	}
	
	/**
     * Reinicia la l�nea VozIP, dejando todos sus valores en cero.
     */
	public void reiniciar ()
	{
		super.reiniciar();
		saldoDisponible = 100000;
		numeroMinutosLargaDistancia = 0;
		numeroMinutosCelular = 0;
		
	}

}
