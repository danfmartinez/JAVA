/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: TareaOrdenarInsercion.java,v 1.5 2006/08/02 19:57:57 da-romer Exp $
 * Universidad de los Andes (Bogot? - Colombia)
 * Departamento de Ingenier?a de Sistemas y Computaci?n 
 * Licenciado bajo el esquema Academic Free License versi?n 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Mario S?nchez - 2/07/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.interfaz;

import uniandes.cupi2.muestra.mundo.Muestra;
import uniandes.cupi2.muestra.mundo.MuestraOrdenada;

/**
 * Esta tarea se usa para ordenar una muestra usando el algoritmo de Inserci?n
 */
public class TareaOrdenarInsercion extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La muestra que ser? ordenada
     */
    private Muestra muestra;

    /**
     * Es una referencia a la ventana principal de la interfaz, donde se tendr? que registrar el tiempo que tom? el ordenamiento
     */
    private InterfazMuestra principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la tarea, con una referencia a la ventana donde debe publicarse el tiempo
     * @param laMuestra es la muestra que ser? ordenada
     * @param ventanaPrincipal es la ventana principal donde se informar? el tiempo que tom? el ordenamiento
     */
    public TareaOrdenarInsercion( Muestra laMuestra, InterfazMuestra ventanaPrincipal )
    {
        muestra = laMuestra;
        principal = ventanaPrincipal;
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta el ordenamiento y reporta el tiempo que tom?
     */
    public void run( )
    {
        long tiempoTotal = 0;
        long t1 = System.currentTimeMillis( );

        MuestraOrdenada muestraOrdenada = muestra.ordenarInsercion( );

        long t2 = System.currentTimeMillis( );
        tiempoTotal += ( t2 - t1 );

        principal.registrarTiempoOrdenamientoInsercion( tiempoTotal );
        principal.cambiarMuestraOrdenada( muestraOrdenada );

    }
}
