package uniandes.cupi2.simuladorBancario.mundo;

public class Transaccion 
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	/**
	 * Tipo Transaccion
	 */
	public static final int ENTRADA = 0;
	public static final int SALIDA = 1;
	
	/**
	 * Tipo cuenta
	 */
	public static final int AHORROS = 0;
	public static final int CORRIENTE = 1;
	public static final int CDT = 2;
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	/**
	 * Numero de consecutivo de la transaccion
	 */
	private int consecutivo;
	/**
	 * valor de la transaccion
	 */
	private double valor;
	/**
	 * tipo de cuenta
	 */
	private int tipoCuenta;
	/**
	 * tipo de transaccion
	 */
	private int tipoTransaccion;
	/**
	 * Nombre da la transaccion
	 */
	private String nombre;
	
	// -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
	/**
	 * Crea la Transaccion con su numero consecutivo
	 * <b>post: </b> El objeto Transaccion tiene sus datos consecutivo, tipo de transaccion, 
	 * tipo de cuenta y el valor de la transaccion.
	 * @param pConsecutivo - numero de consecutivo
	 * @param pTipoTransaccion - tipo de transaccion - pTipoTransaccion pertenece {ENTRADA, SALIDA}
	 * @param pTipoCuenta - tipo de la cuenta - pTipoCuenta pertenece {AHORROS, CORRIENTE, CDT}
	 * @param pValor - el valor de la transaccion 
	 */
	public Transaccion (int pConsecutivo, int pTipoTransaccion, int pTipoCuenta, double pValor, String pNombre)
	{
		consecutivo = pConsecutivo;
		valor = pValor;
		tipoCuenta = pTipoCuenta;
		tipoTransaccion = pTipoTransaccion;
		nombre = pNombre;
	}
	/**
	 * Retorna el consecutivo de la transaccion
	 * @return
	 */
	public int darConsecutivo()
	{
		return consecutivo;
	}
	/**
	 * Retorna el valor de la transaccion
	 * @return
	 */
	public double darValor()
	{
		return valor;
	}
	/**
	 * Retorna el tipo de transaccion
	 * ENTRADA = 0
	 * SALIDA = 1
	 * @return
	 */
	public int darTipoTransaccion()
	{
		return tipoTransaccion;
	}
	/**
	 * Retorna el tipo de cuenta
	 * AHORROS = 0
	 * CORRIENTE = 1
	 * CDT = 2
	 * @return
	 */
	public int darTipoCuenta()
	{
		return tipoCuenta;
	}
	/**
	 * Retorna el nombre de la transaccion
	 * @return
	 */
	public String darNombre()
	{
		return nombre;
	}
	/**
	 * Retorna la representación en cadena de caracteres un objeto Transaccion.
	 */
	public String toString()
	{
		return consecutivo + "." + " " + nombre;
	}
}
