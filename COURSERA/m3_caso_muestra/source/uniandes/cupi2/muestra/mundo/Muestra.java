/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java,v 1.1 2006/07/31 16:43:19 da-romer Exp $
 * Universidad de los Andes (Bogot? - Colombia)
 * Departamento de Ingenier?a de Sistemas y Computaci?n 
 * Todos los derechos reservados 2005
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n7_muestra
 * Autor: Jorge Villalobos - 05-Sep-2005
 * Autor: Pablo Barvo - 26-Sep-2005
 * Autor: Mario S?nchez - 28-Jun-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.mundo;

/**
 * Esta clase maneja una muestra de valores enteros entre 1 y el l?mite superior. <br>
 * <b>inv: </b> <br>
 * valores != null <br>
 * valores.lenght > 0 <br>
 * valores.lenght >= tamanio <br>
 * tamanio >= 0 <br>
 * limiteSuperior >= 1 <br>
 * todos los valores de la muestra est?n entre 1 y limiteSuperior
 */
public class Muestra
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Valores de la muestra
     */
    private int valores[];

    /**
     * L?mite superior para los valores de la muestra
     */
    private int limiteSuperior;

    /**
     * N?mero de valores en la muestra
     */
    private int tamanio;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva muestra vac?a (sin elementos) con una determinada capacidad y un l?mite superior
     * @param capacidad es la capacidad m?xima de la muestra a crear - capacidad > 0
     * @param limite es el l?mite superior para los valores de la muestra - limite >= 1
     */
    public Muestra( int capacidad, int limite )
    {
        valores = new int[capacidad];
        tamanio = 0;
        limiteSuperior = limite;

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Agrega un dato al final de la muestra. <br>
     * <b>pre:</b> Hay espacio para un elemento adicional en la muestra. <br>
     * <b>post:</b> Se adicion? un elemento en el arreglo y el tama?o aument? en uno.
     * @param valor es el valor que se va a agregar a la muestra - 1 <= valor <= limiteSuperior
     */
    public void agregarDato( int valor )
    {
        valores[ tamanio ] = valor;
        tamanio++;

        verificarInvariante( );
    }

    /**
     * Retorna el valor de la muestra que se encuentra en una posici?n dada
     * @param posicion es la posici?n del elemento que queremos recuperar - 0 <= posicion < tamanio
     * @return El valor de la muestra que est? en la posici?n pedida
     */
    public int darDato( int posicion )
    {
        return valores[ posicion ];
    }

    /**
     * Genera valores aleatorios para llenar la muestra. <br>
     * <b> post:</b> se gener? un n?mero de valores aleatorios igual a la capacidad de la muestra. <br>
     * Todos los valores generados est?n entre 1 y limiteSuperior
     */
    public void generarValores( )
    {
        for( int i = 0; i < valores.length; i++ )
        {
            double aleatorio = Math.random( ) * limiteSuperior;
            valores[ i ] = ( int )aleatorio + 1;
        }
        tamanio = valores.length;
    }

    /**
     * Retorna el n?mero de valores que hay en la muestra
     * @return N?mero de valores presentes en la muestra
     */
    public int darTamanio( )
    {
        return tamanio;
    }

    /**
     * Retorna el n?mero m?ximo de valores que puede haber en la muestra
     * @return Capacidad m?xima
     */
    public int darCapacidad( )
    {
        return valores.length;
    }

    /**
     * Retorna el l?mite superior para los valores de la muestra
     * @return Limite superior de la muestra
     */
    public int darLimiteSuperior( )
    {
        return limiteSuperior;
    }

    /**
     * Retorna el valor m?s grande entre los elementos de la muestra
     * @return M?ximo valor encontrado en la muestra. Si la muestra est? vac?a se retorna 0
     */
    public int darMaximo( )
    {
        int maximo = 0;
        for( int i = 0; i < tamanio; i++ )
        {
            if( valores[ i ] > maximo )
                maximo = valores[ i ];
        }
        return maximo;
    }

    /**
     * Retorna el valor m?s peque?o entre los elementos de la muestra
     * @return M?nimo valor encontrado en la muestra. Si la muestra est? vac?a se retorna 0
     */
    public int darMinimo( )
    {
        if( tamanio == 0 )
            return 0;
        else
        {
            int minimo = valores[ 0 ];
            for( int i = 1; i < tamanio; i++ )
            {
                if( valores[ i ] < minimo )
                    minimo = valores[ i ];
            }
            return minimo;
        }
    }

    /**
     * Retorna el valor promedio entre los elementos de la muestra
     * @return Promedio de los datos de la muestra o cero si no hay ninguno
     */
    public double darPromedio( )
    {
        double promedio = 0;
        if( tamanio != 0 )
        {
            double suma = 0;
            for( int i = 0; i < tamanio; i++ )
            {
                suma += valores[ i ];
            }
            promedio = suma / ( double )tamanio;
        }
        return promedio;
    }

    /**
     * Crea una copia de los valores de la muestra
     * @return Una copia del arreglo con los valores que hay actualmente en la muestra
     */
    public int[] darCopiaValores( )
    {
        int[] copiaValores = new int[tamanio];
        for( int i = 0; i < tamanio; i++ )
        {
            copiaValores[ i ] = valores[ i ];
        }
        return copiaValores;
    }

    /**
     * Algoritmo de Ordenamiento - Selecci?n. <br>
     * Crea una muestra ordenada utilizando el algoritmo de selecci?n, sin modificar la muestra actual
     * @return Retorna un objeto de la clase MuestraOrdenada con los valores ordenados de la muestra
     */
    public MuestraOrdenada ordenarSeleccion( )
    {
        int[] arreglo = darCopiaValores( );
        for( int i = 0; i < tamanio - 1; i++ )
        {
            int menor = arreglo[ i ];
            int cual = i;
            // Busca el m?nimo elemento entre una posici?n i y el final de la lista
            for( int j = i + 1; j < tamanio; j++ )
            {
                if( arreglo[ j ] < menor )
                {
                    menor = arreglo[ j ];
                    cual = j;
                }
            }
            // Intercambia el m?nimo con el elemento de la posici?n i
            int temp = arreglo[ i ];
            arreglo[ i ] = menor;
            arreglo[ cual ] = temp;
        }
        return new MuestraOrdenada( arreglo );
    }

    /**
     * Algoritmo de Ordenamiento - Burbuja. <br>
     * Crea una muestra ordenada utilizando el algoritmo de burbuja, sin modificar la muestra actual
     * @return Retorna un objeto de la clase MuestraOrdenada con los valores ordenados de la muestra
     */
    public MuestraOrdenada ordenarBurbuja( )
    {
        int[] arreglo = darCopiaValores( );
        for( int i = tamanio; i > 0; i-- )
        {
            for( int j = 0; j < i - 1; j++ )
            {
                // Intercambia si est?n en el orden equivocado
                if( arreglo[ j ] > arreglo[ j + 1 ] )
                {
                    int temp = arreglo[ j ];
                    arreglo[ j ] = arreglo[ j + 1 ];
                    arreglo[ j + 1 ] = temp;
                }
            }
        }
        return new MuestraOrdenada( arreglo );
    }

    /**
     * Algoritmo de Ordenamiento - Inserci?n. <br>
     * Crea una muestra ordenada utilizando el algoritmo de inserci?n, sin modificar la muestra actual
     * @return Retorna un objeto de la clase MuestraOrdenada con los valores ordenados de la muestra
     */
    public MuestraOrdenada ordenarInsercion( )
    {
        int[] arreglo = darCopiaValores( );
        for( int i = 1; i < tamanio; i++ )
        {
            for( int j = i; j > 0 && arreglo[ j - 1 ] > arreglo[ j ]; j-- )
            {
                int temp = arreglo[ j ];
                arreglo[ j ] = arreglo[ j - 1 ];
                arreglo[ j - 1 ] = temp;
            }
        }
        return new MuestraOrdenada( arreglo );
    }

    /**
     * Busca un valor utilizando una b?squeda secuencial
     * @param valor es el valor a buscar en el arreglo
     * @return Retorna true si encontr? el valor en la muestra.
     */
    public boolean buscarSecuencial( int valor )
    {
        for( int i = 0; i < tamanio; i++ )
        {
            if( valores[ i ] == valor )
                return true;
        }
        return false;
    }

    /**
     * Cuenta el n?mero de veces que aparece un valor en la muestra
     * @param valor es el valor que se va a buscar en la muestra
     * @return N?mero de ocurrencias
     */
    public int contarOcurrencias( int valor )
    {
        int ocurrencias = 0;
        for( int i = 0; i < tamanio; i++ )
        {
            if( valor == valores[ i ] )
                ocurrencias++;
        }
        return ocurrencias;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv: </b> <br>
     * valores != null <br>
     * valores.lenght > 0 <br>
     * valores.lenght >= tamanio <br>
     * tamanio >= 0 <br>
     * limiteSuperior >= 1 <br>
     * todos los valores de la muestra est?n entre 1 y limiteSuperior
     */
    private void verificarInvariante( )
    {
        assert valores != null : "El arreglo de valores no puede ser null";
        assert valores.length > 0 : "Debe haber por lo menos espacio para un valor";
        assert valores.length >= tamanio : "El n?mero de elementos debe ser inferior a la capacidad del arreglo";
        assert tamanio >= 0 : "Siempre hay cero o m?s elementos en una muestra";
        assert limiteSuperior >= 1 : "El limite superior debe ser mayor a igual a 1";

        for( int i = 0; i < tamanio; i++ )
        {
            assert valores[ i ] > 0 && valores[ i ] <= limiteSuperior : "Los valores deben estar entre 1 y limiteSuperior";
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi?n
    // -----------------------------------------------------------------

    /**
     * M?todo para la extensi?n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "respuesta1";
    }

    /**
     * M?todo para la extensi?n 2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "respuesta2";
    }

    /**
     * M?todo para la extensi?n 3
     * @return respuesta3
     */
    public String metodo3( )
    {
        return "respuesta3";
    }

    /**
     * M?todo para la extensi?n 4
     * @return respuesta4
     */
    public String metodo4( )
    {
        return "respuesta4";
    }
}