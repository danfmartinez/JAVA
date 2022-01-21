package uniandes.cupi2.avion.mundo;
/**
 * Peliculas del avion
 */
public class Pelicula 
{
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
	/**
     * Genero comedia de las peliculas
     */
	public final static String COMEDIA = "Comedia";
	/**
	 * Genero accion de las peliculas
	 */
	public final static String ACCION = "Acción";
	/**
	 * Genero drama de las peliculas
	 */
	public final static String DRAMA = "Drama";
	/**
	 * Genero infantil de las peliculas
	 */
	public final static String INFANTIL = "Infantil";
	/**
	 * Genero Romance de las peliculas 
	 */
	public final static String ROMANCE = "Romance";
	
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	/**
	 * Nombre de la pelicula
	 */
	private String nombre;
	/**
	 * Genero de la pelicula
	 */
	private String genero;
	/**
	 * Duracion de la pelicula
	 */
	private int duracion;
	/**
	 * Director de la pelicula
	 */
	private String director;
	
	//-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	/**
	 * Crea a las peliculas con su nombre, genero, duracion y director 
	 */
	public Pelicula (String pNombre, String pGenero, int pDuracion, String pDirector )
	{
		nombre = pNombre;
		genero = pGenero;
		duracion = pDuracion;
		director = pDirector;
	}
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
	/**
	 * Retorna el nombre de la pelicula
	 * @return nombre
	 */
	public String darNombre()
	{
		return nombre;
	}
	/**
	 * Retorna el genero de la pelicula
	 * @return genero
	 */
	public String darGenero()
	{
		return genero;
	}
	/**
	 * Retorna la duracion de la pelicula
	 * @return duracion
	 */
	public int darDuracion()
	{
		return duracion;
	}
	/**
	 * Retorna el director de la pelicula
	 * @return director
	 */
	public String darDirector()
	{
		return director;
	}
	/**
	 * Cambia el nombre de la pelicula
	 * @param pNombre - el nuevo nombre 
	 */
	public void cambiarNombre (String pNombre)
	{
		nombre = pNombre;
	}
	/**
	 * Cambia el genero de la pelicula
	 * @param pGenero - el nuevo genero   
	 */
	public void cambiarGenero (String pGenero)
	{
		genero = pGenero;
	}
	/**
	 * Cambia la duracion de la pelicula
	 * @param pDuracion - la nueva duracion
	 */
	public void cambiarDuracion (int pDuracion)
	{
		duracion = pDuracion;
	}
	/**
	 * Cambia el director de la pelicula
	 * @param pDirector - el nuevo director
	 */
	public void cambiarDirector (String pDirector)
	{
		director = pDirector;
	}
	 /**
	  * Retorna una cadena de texto con la información de la película 
	  * siguiendo el siguiente formato:
	  * <nombre> (<genero>). <duracion> minutos - director.
	  * @return La cadena de texto con el formato definido. 
	  */
	public String toString()
	{
		String cadena = nombre + " (" + genero + "). " + duracion + " minutos " + " - " + director;
		
		return cadena;
	}
	
}
 