/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot? - Colombia)
 * Departamento de Ingenier?a de Sistemas y Computaci?n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.simuladorBancario.mundo;

import java.util.ArrayList;

/**
 * Clase que representa el simulador bancario para las tres cuentas de un cliente.
 */
public class SimuladorBancario
{
	
	public static final double INVERSION_MAXIMO = 100000000;
	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	//TODO: 1 Crear atributo
    private double interesGenerado;
	
    /**
     * C?dula del cliente.
     */
    private String cedula;

    /**
     * Nombre del cliente.
     */
    private String nombre;

    /**
     * Mes actual.
     */
    private int mesActual;

    /**
     * Cuenta corriente del cliente.
     */
    private CuentaCorriente corriente;

    /**
     * Cuenta de ahorros del cliente.
     */
    private CuentaAhorros ahorros;

    /**
     * CDT del cliente.
     */
    private CDT inversion;
    /**
     * Coleccion de transacciones
     */
    private ArrayList<Transaccion> transacciones ;
    /**
     * consecutivo actual de las transacciones
     */
    private int consecutivoActual;
    
    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Inicializa el simulador con la informaci?n del cliente. <br>
     * <b>post: </b> El mes fue inicializado en 1, y las tres cuentas (CDT, corriente y de ahorros) fueron inicializadas como vac?as. <br>
     * @param pCedula C?dula del nuevo cliente. pCedula != null && pCedula != "".
     * @param pNombre Nombre del nuevo cliente. pNombre != null && pNombre != "".
     */
    public SimuladorBancario( String pCedula, String pNombre )
    {
        // Inicializa los atributos personales del cliente
        nombre = pNombre;
        cedula = pCedula;
        // Inicializa el mes en el 1
        mesActual = 1;
        // Inicializa las tres cuentas en vac?o
        corriente = new CuentaCorriente( );
        ahorros = new CuentaAhorros( );
        inversion = new CDT( );
        // Inicializa las transacciones y el consecutivo en 1
        transacciones = new ArrayList<Transaccion>();
        consecutivoActual = 1;
    }

    /**
     * Retorna el nombre del cliente.
     * @return Nombre del cliente.
     */
    public String darNombre( )
    {
        return nombre;
    }
    
    public double darInteresGenerado() {
    	return interesGenerado + ahorros.darInteresGenerado();
    }

    /**
     * Retorna la c?dula del cliente.
     * @return C?dula del cliente.
     */
    public String darCedula( )
    {
        return cedula;
    }

    /**
     * Retorna la cuenta corriente del cliente.
     * @return Cuenta corriente del cliente.
     */
    public CuentaCorriente darCuentaCorriente( )
    {
        return corriente;
    }

    /**
     * Retorna el CDT del cliente.
     * @return CDT del cliente.
     */
    public CDT darCDT( )
    {
        return inversion;
    }

    /**
	 * Retorna la cuenta de ahorros del cliente.
	 * @return Cuenta de ahorros del cliente.
	 */
	public CuentaAhorros darCuentaAhorros( )
	{
	    return ahorros;
	}

	/**
     * Retorna el mes en el que se encuentra la simulaci?n.
     * @return Mes actual.
     */
    public int darMesActual( )
    {
        return mesActual;
    }
    /**
     * Retorna las coleccion de transacciones
     * @return transacciones
     */
    public ArrayList<Transaccion> darTransacciones()
    {
    	return transacciones;
    }
    /**
     * Retorna el consecutivo en el que se encuentra las transacciones
     * @return consecutivo actual
     */
    public int darConsecutivoActual()
    {
    	return consecutivoActual;
    }

    /**
     * Calcula el saldo total de las cuentas del cliente.
     * @return Saldo total de las cuentas del cliente.
     */
    public double calcularSaldoTotal( )
    {
        return corriente.darSaldo( ) + ahorros.darSaldo( ) + inversion.calcularValorPresente( mesActual );
    }

    /**
     * Invierte un monto de dinero en un CDT. <br>
     * <b>post: </b> Invirti? un monto de dinero en un CDT.
     * @param pMonto Monto de dinero a invertir en un CDT. pMonto > 0.
     * @param pInteresMensual Inter?s del CDT elegido por el cliente.
     * @throws Exception 
     */
    public void invertirCDT( double pMonto, String pInteresMensual ) throws Exception
    {
    	try{
    		String pInteresM = pInteresMensual.replaceAll(",", ".") ;
    		double pInteres = Double.parseDouble(pInteresM) / 100.0;
		    inversion.invertir( pMonto, pInteres, mesActual );
		    verificarInvariante();
		    
    	} catch (Exception e)
    	{
    		System.out.println("ERROR: EL VALOR INGRESADO DEBE SER NUM?RICO");
    	}
    	// Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
	    Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.ENTRADA, Transaccion.CDT, pMonto,"Apertura CDT");
	    transacciones.add(nueva);
	    consecutivoActual += 1;
    }

    /**
     * Consigna un monto de dinero en la cuenta corriente. <br>
     * <b>post: </b> Consign? un monto de dinero en la cuenta corriente.
     * @param pMonto Monto de dinero a consignar en la cuenta. pMonto > 0.
     */
    public void consignarCuentaCorriente( double pMonto )
    {
        corriente.consignarMonto( pMonto );
        // Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
        Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.ENTRADA, Transaccion.CORRIENTE, pMonto,"Consignacion Corriente");
        transacciones.add(nueva);
        consecutivoActual += 1; 
    }

    /**
     * Consigna un monto de dinero en la cuenta de ahorros. <br>
     * * <b>post: </b> Consign? un monto de dinero en la cuenta de ahorros.
     * @param pMonto Monto de dinero a consignar en la cuenta. pMonto > 0.
     */
    public void consignarCuentaAhorros( double pMonto )
    {
    	verificarInvariante();
    	ahorros.consignarMonto( pMonto );
    	// Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
    	Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.ENTRADA, Transaccion.AHORROS, pMonto,"Consignacion Ahorros");
    	transacciones.add(nueva);
    	consecutivoActual += 1;	
    }

    /**
     * Retira un monto de dinero de la cuenta corriente. <br>
     * <b>pre: </b> La cuenta corriente ha sido inicializada
     * <b>post: </b> Si hay saldo suficiente, entonces este se redujo en el monto especificado.
     * @param pMonto Monto de dinero a retirar de la cuenta. pMonto > 0.
     */
    public void retirarCuentaCorriente( double pMonto )
    {
        corriente.retirarMonto( pMonto );
        // Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
        Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.SALIDA, Transaccion.CORRIENTE, pMonto, "Retiro Corriente");
        transacciones.add(nueva);
        consecutivoActual += 1;
    }

    /**
     * Retira un monto de dinero de la cuenta de ahorros. <br>
     * <b>post: </b> Se redujo el saldo de la cuenta en el monto especificado.
     * @param pMonto Monto de dinero a retirar de la cuenta. pMonto > 0.
     */
    public void retirarCuentaAhorros( double pMonto )
    {
        ahorros.retirarMonto( pMonto );
        // Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
        Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.SALIDA, Transaccion.AHORROS, pMonto, "Retiro Ahorros");
        transacciones.add(nueva);
        consecutivoActual += 1;
    }
    

    /**
     * Avanza en un mes la simulaci?n. <br>
     * <b>post: </b> Se avanz? el mes de la simulaci?n en 1. Se actualiz? el saldo de la cuenta de ahorros.
     */
    public void avanzarMesSimulacion( )
    {
        double interesAhorros = ahorros.darIngresoInteres();
        double interesCDT = inversion.darInteresMes();
        if (inversion.calcularValorPresente(mesActual) == 0)
        {
        	// Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
        	Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.ENTRADA, Transaccion.AHORROS, interesAhorros,"Interes Ahorros");
            transacciones.add(nueva);
            consecutivoActual += 1;
        }
        if(ahorros.darSaldo() == 0 ) 
        {
        	 // Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
        	 Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.ENTRADA, Transaccion.CDT, interesCDT,"Interes CDT");
             transacciones.add(nueva);
             consecutivoActual += 1;
        }
        if (ahorros.darSaldo() > 0 && inversion.calcularValorPresente(mesActual) > 0)
        {
        	// Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
        	Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.ENTRADA, Transaccion.AHORROS, interesAhorros, "Interes Ahorros");
            transacciones.add(nueva);
        	Transaccion nueva2 = new Transaccion(consecutivoActual + 1, Transaccion.ENTRADA, Transaccion.CDT, interesCDT, "Interes CDT");
            transacciones.add(nueva2);
            consecutivoActual += 2;
        }
        
        mesActual += 1;
        ahorros.actualizarSaldoPorPasoMes( );
    }

    /**
     * Cierra el CDT, pasando el saldo a la cuenta corriente. <br>
     * <b>pre: </b> La cuenta corriente y el CDT han sido inicializados. <br>
     * <b>post: </b> El CDT qued? cerrado y con valores en 0, y la cuenta corriente aument? su saldo en el valor del cierre del CDT.
     */
    public void cerrarCDT( )
    {
    	//TODO: 8 agregar el interes generado por el cdt al total de la simulacion
        interesGenerado += inversion.darInteresGenerado(mesActual);
        double valorCierreCDT = inversion.cerrar( mesActual );
        corriente.consignarMonto( valorCierreCDT );
        verificarInvariante();
        // Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
        Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.SALIDA, Transaccion.CDT, valorCierreCDT,"Cierre CDT");
        transacciones.add(nueva);
        Transaccion nueva2 = new Transaccion(consecutivoActual + 1, Transaccion.ENTRADA, Transaccion.CORRIENTE, valorCierreCDT,"Consignacion Corriente");
        transacciones.add(nueva2);
        consecutivoActual += 2; 
    }
    
    /**
     * Retrira el saldo total la cuenta de ahorros, pasandolo a la cuenta corriente. <br>
     * <b>pre: </b> La cuenta corriente y el la cuenta de ahorros han sido inicializados. <br>
     * <b>post: </b> La cuenta de ahorros queda vacia ( con valores en 0 ), y la cuenta corriente aument? su saldo en el valor del saldo total que tenia la cuenta de ahorros.
     */
    public void pasarAhorrosToCorriente()
    {
    	double cantidad = ahorros.darSaldo();
    	ahorros.cerrarCuenta();
    	corriente.consignarMonto(cantidad);
    	// Crea una nueva transaccion con consecutivo, tipo transaccion, tipo cuenta y valor
    	Transaccion nueva = new Transaccion(consecutivoActual, Transaccion.SALIDA, Transaccion.AHORROS, cantidad,"Retiro Ahorros");
    	transacciones.add(nueva);
    	Transaccion nueva2 = new Transaccion(consecutivoActual + 1, Transaccion.ENTRADA, Transaccion.CORRIENTE, cantidad,"Consignacion Corriente");
    	transacciones.add(nueva2);
    	consecutivoActual += 2;	
    }

    /**
     * Avanza la simulci?n un numero de meses dado por par?metro.
     * @param pMeses numero de meses a avanzar
     * <b>post: </b> Se avanzaron los meses de la simulaci?n. Se actualizaron los saldos.
     */
    public void metodo1( int pMeses )
    {
    	for (int i = 0; i < pMeses; i++)
    	{
    		avanzarMesSimulacion();
    		verificarInvariante();
    	}
    }

    /**
     * Reinicia la simulaci?n.
     * @return interes total generado por la simulaci?n.
     */
    public double metodo2( )
    {	
    	cerrarCDT();
    	corriente.cerrarCuenta();
    	double respuesta = interesGenerado + ahorros.darInteresGenerado();
    	ahorros.cerrarCuenta();
    	interesGenerado = 0;
    	mesActual = 1;
    	// Reinicia las transacciones y consecutivo 
    	consecutivoActual = 1;
    	transacciones.clear();
        
    	return respuesta;
    }
    
    /**
     *  Retorna el consecutivo asociado a la transacci?n de mayor valor para un tipo(entrada/salida) 
     *  y una cuenta(ahorros/corriente/cdt) dados por par?metro.
     * @param pTipo - tipo(entrada/salida)
     * @param pCuenta - cuenta(ahorros/corriente/cdt)
     * @return consecutivo
     */
	public int metodo3(int pTipo, int pCuenta) 
	{
		double mayorValor = 0.0;
		int consecutivoMayorValor = 0;
		for (int i = 0; i < transacciones.size() ; i++)
		{
			Transaccion actual = transacciones.get(i);
			if (actual.darTipoTransaccion() == pTipo && actual.darTipoCuenta() == pCuenta)
			{
				if (mayorValor < actual.darValor())
				{
					mayorValor = actual.darValor();
					consecutivoMayorValor = actual.darConsecutivo();
				}
			}
		}
		return consecutivoMayorValor;
	}
	
	private void verificarInvariante()
	{
		assert interesGenerado >= 0: "Los intereses no pueden ser menores a 0";
		assert mesActual >= 1: "Los meses no pueden ser menores a 0";
		
		assert ahorros != null: "La cuenta de ahorros no puede ser null";
		assert corriente != null: "La cuenta corriente no puede ser null";
		assert inversion != null: "El CDT no puede ser null";
		
		assert (inversion.calcularValorPresente(mesActual) + ahorros.darSaldo() <= INVERSION_MAXIMO): "ERROR: SE SUPER? EL MONTO M?XIMO DE INVERSI?N"; 
	}
	
}