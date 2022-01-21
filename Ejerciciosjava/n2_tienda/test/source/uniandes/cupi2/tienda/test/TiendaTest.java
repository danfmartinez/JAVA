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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uniandes.cupi2.tienda.mundo.Producto;
import uniandes.cupi2.tienda.mundo.Tienda;
import uniandes.cupi2.tienda.mundo.Producto.Tipo;

/**
 * Clase usada para verificar que los métodos de la clase Tienda estén correctamente implementados.
 */
public class TiendaTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Tienda tienda;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Crea una tienda con cuatro producto, dos de ellos de DROGUERIA, uno de PAPELERIA y uno de SUPERMERCADO.
     */
    private void setupEscenario1( )
    {
        tienda = new Tienda( );
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * Tienda<br>
     * darProducto1<br>
     * darProducto2<br>
     * darProducto3<br>
     * darProducto4<br>
     * darNombre<br>
     * darDineroEnCaja<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testTienda( )
    {
        setupEscenario1( );

        assertNotNull( "Debería existir el producto 1.", tienda.darProducto1( ) );
        assertNotNull( "Debería existir el producto 2.", tienda.darProducto2( ) );
        assertNotNull( "Debería existir el producto 3.", tienda.darProducto3( ) );
        assertNotNull( "Debería existir el producto 4.", tienda.darProducto4( ) );
        assertEquals( "No debería haber dinero en caja.", 0.0, tienda.darDineroEnCaja( ), 0.0 );
    }

    /**
     * Prueba 2: Verifica el método venderProducto.<br>
     * <b> Métodos a probar: </b> <br>
     * venderProducto<br>
     * darDineroEnCaja<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se venden todas las unidades.<br>
     * 2. Se venden menos unidades porque no hay suficiente en bodega.
     */
    @Test
    public void testVenderProducto( )
    {
        setupEscenario1( );
        assertEquals( "El resultado de la venta no corresponde.", 10, tienda.venderProducto( "Lapiz", 10 ) );
        assertEquals( "El dinero en caja no corresponde", 6380.0, tienda.darDineroEnCaja( ), 0.01 );
        assertEquals( "El resultado de la venta no corresponde.", 8, tienda.venderProducto( "Lapiz", 30 ) );
        assertEquals( "El dinero en caja no corresponde", 11484.0, tienda.darDineroEnCaja( ), 0.01 );
    }

    /**
     * Prueba 3: Verifica el método abastecerProducto.<br>
     * <b> Métodos a probar: </b> <br>
     * abastecerProducto<br>
     * vender<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se puede abastecer.<br>
     * 2. No se puede abastecer.
     */
    @Test
    public void testAbastecerProducto( )
    {
        setupEscenario1( );
        assertFalse( "No debería poder abastecer.", tienda.abastecerProducto( "Lapiz", 10 ) );
        tienda.venderProducto( "Lapiz", 15 );
        assertTrue( "Debería poder abastecer.", tienda.abastecerProducto( "Lapiz", 20 ) );
    }

    /**
     * Prueba 4: Verifica el método darProductoMasVendido.<br>
     * <b> Métodos a probar: </b> <br>
     * darProductoMasVendido<br>
     * venderProducto<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún producto tiene ventas.<br>
     * 2. Todos los productos tienen ventas.
     */
    @Test
    public void testDarProductoMasVendido( )
    {
        setupEscenario1( );
        assertNull( "No debería haber ningún producto con ventas.", tienda.darProductoMasVendido( ) );
        tienda.venderProducto( "Lapiz", 5 );
        tienda.venderProducto( "Pan", 6 );
        tienda.venderProducto( "Aspirina", 15 );
        tienda.venderProducto( "Borrador", 10 );
        assertNotNull( "Debería existir al menos un producto con ventas.", tienda.darProductoMasVendido( ) );
        assertEquals( "El nombre del producto más vendido no corresponde.", "Aspirina", tienda.darProductoMasVendido( ).darNombre( ) );
    }

    /**
     * Prueba 5: Verifica el método darProductoMenosVendido.<br>
     * <b> Métodos a probar: </b> <br>
     * darProductoMenosVendido<br>
     * venderProducto<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún producto tiene ventas.<br>
     * 2. Todos los productos tienen ventas.
     */
    @Test
    public void testDarProductoMenosVendido( )
    {
        setupEscenario1( );
        assertNull( "No debería haber ningún producto con ventas.", tienda.darProductoMenosVendido( ) );
        tienda.venderProducto( "Lapiz", 5 );
        tienda.venderProducto( "Pan", 6 );
        tienda.venderProducto( "Aspirina", 15 );
        tienda.venderProducto( "Borrador", 10 );
        assertNotNull( "Debería existir al menos un producto con ventas.", tienda.darProductoMenosVendido( ) );
        assertEquals( "El nombre del producto menos vendido no corresponde.", "Lapiz", tienda.darProductoMenosVendido( ).darNombre( ) );

    }

    /**
     * Prueba 6: Verifica el método darPromedioVentas.<br>
     * <b> Métodos a probar: </b> <br>
     * darPromedioVentas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún producto tiene ventas.<br>
     * 2. Todos los productos tienen ventas.
     */
    @Test
    public void testDarPromedioVentas( )
    {
        setupEscenario1( );
        assertEquals( "El promedio está mal calculado.", 0.0, tienda.darPromedioVentas( ), 0.01 );
        tienda.venderProducto( "Lapiz", 5 );
        tienda.venderProducto( "Pan", 6 );
        tienda.venderProducto( "Aspirina", 15 );
        tienda.venderProducto( "Borrador", 10 );
        assertEquals( "El promedio está mal calculado.", 232.5, tienda.darPromedioVentas( ), 0.01 );
    }

    /**
     * Prueba 7: Verifica el método cambiarProducto.<br>
     * <b> Métodos a probar: </b> <br>
     * cambiarProducto<br>
     * darProducto<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No se cambia el nombre del producto.<br>
     * 2. Se cambia el nombre del producto y no existe un producto con ese nombre.<br>
     * 3. Existe otro producto con el mismo nombre.<br>
     */
    @Test
    public void testCambiarProducto( )
    {
        setupEscenario1( );

        boolean cambio = tienda.cambiarProducto( "Lapiz", "Lapiz", Tipo.PAPELERIA, 2000, 11, 8, "lapiz.jpg" );
        assertTrue( "Debería haber cambiado el producto.", cambio );
        Producto p = tienda.darProducto( "Lapiz" );
        assertNotNull( "El producto debería existir", p );
        assertEquals( "El valor unitario no es el esperado.", 2000, p.darValorUnitario( ), 0.01 );
        assertEquals( "La cantidad en bodega no es la esperada", 11, p.darCantidadBodega( ) );
        assertEquals( "La cantidad mínima no es la esperada", 8, p.darCantidadMinima( ) );

        cambio = tienda.cambiarProducto( "Lapiz", "Jabón", Tipo.DROGUERIA, 1000, 10, 7, "jabon.jpg" );
        assertTrue( "Debería haber cambiado el producto.", cambio );
        p = tienda.darProducto( "Jabón" );
        assertNotNull( "El producto debería existir", p );
        assertEquals( "El nombre no es el esperado.", "Jabón", p.darNombre( ) );
        assertEquals( "El valor unitario no es el esperado.", 1000, p.darValorUnitario( ), 0.01 );
        assertEquals( "La cantidad en bodega no es la esperada", 10, p.darCantidadBodega( ) );
        assertEquals( "La cantidad mínima no es la esperada", 7, p.darCantidadMinima( ) );

        cambio = tienda.cambiarProducto( "Jabón", "Aspirina", Tipo.DROGUERIA, 1000, 10, 7, "aspirina.jpg" );
        assertFalse( "No debería haber cambiado el producto", cambio );
        p = tienda.darProducto( "Jabón" );
        assertNotNull( "El producto debería existir", p );
    }
}
