/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_tienda
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.tienda.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uniandes.cupi2.tienda.mundo.Producto;
import uniandes.cupi2.tienda.mundo.Producto.Tipo;

/**
 * Clase usada para verificar que los métodos de la clase Producto estén correctamente implementados.
 */
public class ProductoTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Producto producto;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo producto sin unidades vendidas.
     */
    private void setupEscenario1( )
    {
        producto = new Producto( Tipo.DROGUERIA, "pastilla", 1000.0, 50, 25, "pastilla.jpg" );
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * Producto<br>
     * darTipo<br>
     * darNombre<br>
     * darvalorUnitario<br>
     * darCantidadBodega<br>
     * darCantidadMinima<br>
     * darCantidadVendidad<br>
     * darRutaImagen<br>
     * calcularPrecioFinal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testProducto( )
    {
        setupEscenario1( );
        System.out.println( "Precio con iva: " + producto.calcularPrecioFinal( ) );
        assertEquals( "El nombre no corresponde.", "pastilla", producto.darNombre( ) );
        assertTrue( "El tipo no corresponde.", Tipo.DROGUERIA == producto.darTipo( ) );
        assertEquals( "El valor unitario no corresponde.", 1000.0, producto.darValorUnitario( ), 0.01 );
        assertEquals( "La cantidad mínima no corresponde.", 25, producto.darCantidadMinima( ) );
        assertEquals( "La cantidad en bodega no corresponde.", 50, producto.darCantidadBodega( ) );
        assertEquals( "La ruta de la imagen no corresponde.", "pastilla.jpg", producto.darRutaImagen( ) );
        assertEquals( "La cantidad de vendidas no corresponde.", 0, producto.darCantidadUnidadesVendidas( ) );
        assertEquals( "El precio final no corresponde.", 1120.0, producto.calcularPrecioFinal( ), 0.01 );
    }

    /**
     * Prueba 2: Verifica el método vender.<br>
     * <b> Métodos a probar: </b> <br>
     * vender<br>
     * darCantidadBodega<br>
     * darCantidadVendidas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Logra vender todas las unidades. <br>
     * 2. No logra vender todas las unidades.
     */
    @Test
    public void testVender( )
    {
        setupEscenario1( );
        assertEquals( "Debería realizar la venta de 10.", 10, producto.vender( 10 ) );
        assertEquals( "La cantidad en bodega no corresponde.", 40, producto.darCantidadBodega( ) );
        assertEquals( "La cantidad de vendidas no corresponde.", 10, producto.darCantidadUnidadesVendidas( ) );
        assertEquals( "Debería realizar la venta de 40.", 40, producto.vender( 50 ) );
        assertEquals( "La cantidad en bodega no corresponde.", 0, producto.darCantidadBodega( ) );
        assertEquals( "La cantidad de vendidas no corresponde.", 50, producto.darCantidadUnidadesVendidas( ) );
    }

    /**
     * Prueba 3: Verifica el método abastecer.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadBodega<br>
     * abastecer<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Logra abastecer las unidades.
     */
    @Test
    public void testAbastecer( )
    {
        setupEscenario1( );
        producto.abastecer( 10 );
        assertEquals( "Debería aumentar la cantidad en bodega.", 60, producto.darCantidadBodega( ) );
    }
}