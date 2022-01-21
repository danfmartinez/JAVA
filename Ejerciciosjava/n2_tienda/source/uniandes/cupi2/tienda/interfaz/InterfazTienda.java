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
package uniandes.cupi2.tienda.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.tienda.mundo.Producto.Tipo;
import uniandes.cupi2.tienda.mundo.Tienda;

/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazTienda extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Tienda tienda;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen del título.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel para mostrar la información del producto1.
     */
    private PanelProducto panelProducto1;

    /**
     * Panel para mostrar la información del producto2.
     */
    private PanelProducto panelProducto2;

    /**
     * Panel para mostrar la información del producto3.
     */
    private PanelProducto panelProducto3;

    /**
     * Panel para mostrar la información del producto.
     */
    private PanelProducto panelProducto4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal de la aplicación.
     */
    public InterfazTienda( )
    {
        setTitle( "Tienda Cupi2" );
        setSize( 800, 720 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        tienda = new Tienda( );

        setLayout( new BorderLayout( ) );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );

        JPanel panelCentro = new JPanel( );
        panelCentro.setLayout( new GridLayout( 2, 2 ) );

        panelProducto1 = new PanelProducto( this );
        panelCentro.add( panelProducto1 );
        panelProducto2 = new PanelProducto( this );
        panelCentro.add( panelProducto2 );
        panelProducto3 = new PanelProducto( this );
        panelCentro.add( panelProducto3 );
        panelProducto4 = new PanelProducto( this );
        panelCentro.add( panelProducto4 );

        add( panelCentro, BorderLayout.CENTER );

        setLocationRelativeTo( null );
        setResizable( false );

        actualizar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información de los paneles.
     */
    private void actualizar( )
    {
        panelProducto1.actualizarInfo( tienda.darProducto1( ) );
        panelProducto2.actualizarInfo( tienda.darProducto2( ) );
        panelProducto3.actualizarInfo( tienda.darProducto3( ) );
        panelProducto4.actualizarInfo( tienda.darProducto4( ) );
    }

    /**
     * Vende una cantidad de unidades del producto con el nombre dado por parámetro.
     * @param pNombreProducto Nombre del producto. pNombreProducto != null && pNombreProducto != "".
     */
    public void venderProducto( String pNombreProducto )
    {
        String pCant = JOptionPane.showInputDialog( this, "Cantidad de unidades a vender:", "Vender producto", JOptionPane.INFORMATION_MESSAGE );
        if( pCant != null )
        {
            try
            {
                int cantidad = Integer.parseInt( pCant );
                if( cantidad > 0 )
                {
                    int venta = tienda.venderProducto( pNombreProducto, cantidad );
                    if( venta > 0 )
                    {
                        JOptionPane.showMessageDialog( this, "Fueron vendidas " + venta + " unidades.", "Vender producto", JOptionPane.INFORMATION_MESSAGE );
                        actualizar( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El producto no tiene unidades para realizar la venta.", "Vender producto", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cantidad ingresada debe ser mayor a cero.", "Vender producto", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor numérico.", "Vender producto", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Abastece una cantidad de unidades del producto con el nombre dado por parámetro.
     * @param pNombreProducto Nombre del producto. pNombreProducto != null && pNombreProducto != "".
     */
    public void abastecerUnidades( String pNombreProducto )
    {
        String pCant = JOptionPane.showInputDialog( this, "Cantidad de unidades para abstecer:", "Abastecer producto", JOptionPane.INFORMATION_MESSAGE );
        if( pCant != null )
        {
            try
            {
                int cantidad = Integer.parseInt( pCant );
                if( cantidad > 0 )
                {
                    boolean abastecio = tienda.abastecerProducto( pNombreProducto, cantidad );
                    actualizar( );
                    if( abastecio )
                    {
                        JOptionPane.showMessageDialog( this, "Se abasteció la tienda.", "Abastecer producto", JOptionPane.INFORMATION_MESSAGE );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "No se pudo abastecer la tienda.", "Abastecer producto", JOptionPane.ERROR_MESSAGE );

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cantidad ingresada debe ser mayor a cero.", "Abastecer producto", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor numérico.", "Abastecer producto", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Cambia el producto con el nombre actual con los valores dados por parámetro.
     * @param pNombreActual Nombre actual del producto. pNombreActual != null && pNombreActual != "".
     * @param pNombreNuevo Nuevo nombre del producto. pNombreNuevo != null && pNombreNuevo != "".
     * @param pTipo Tipo del producto. pTipo != null.
     * @param pValorUnitario valor unitario del producto. pValorUnitario >= 0.
     * @param pCantidadBodega Cantidad en bodega del producto. pCantidadBodega >= 0.
     * @param pCantidadMinima Cantidad mínima del producto. pCantidadMinima >= 0.
     * @param pRutaImagen Ruta de la imagen del producto. pRutaImagen != null && pRutaImagen != "".
     */
    public void cambiarProducto( String pNombreActual, String pNombreNuevo, Tipo pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen )
    {
        boolean cambio = tienda.cambiarProducto( pNombreActual, pNombreNuevo, pTipo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen );
        if( !cambio )
        {
            JOptionPane.showMessageDialog( this, "Ya existe un producto con el nombre " + pNombreNuevo + ".", "Cambiar producto", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            actualizar( );
        }
    }

    /**
     * Muestra el producto más vendido.
     */
    public void mostrarMasVendido( )
    {
        if( tienda.darProductoMasVendido( ) != null )
        {
            JOptionPane.showMessageDialog( this, "El producto más vendido es: " + tienda.darProductoMasVendido( ).darNombre( ) + " con un numero de: " + tienda.darProductoMasVendido( ).darCantidadUnidadesVendidas( )+ " unidades vendidas", "Producto más vendido", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Ningún produto tiene unidades vendidas.", "Producto más vendido", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra el producto menos vendido.
     */
    public void mostrarMenosVendido( )
    {
        if( tienda.darProductoMenosVendido( ) != null )
        {
            JOptionPane.showMessageDialog( this, "El producto menos vendido es: " + tienda.darProductoMenosVendido( ).darNombre( ), "Producto menos vendido", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Ningún produto tiene unidades vendidas.", "Producto menos vendido", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra el dialogo para seleccionar la cantidad de juegos para consultar una venta por volumen.
     * @param pNombreProducto Nombre del producto. pNombreProducto != null && pNombreProducto != "".
     */
    public void mostrarDialogoCambiarProducto( String pNombreProducto )
    {
        DialogoCambiarProducto dialogo = new DialogoCambiarProducto( this, pNombreProducto );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el total de dinero en caja de la tienda.
     */
    public void mostrarDineroEnCaja( )
    {
        JOptionPane.showMessageDialog( this, "En caja hay: " + tienda.darDineroEnCaja( ) + " $.", "Dinero en caja", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Muestra el promedio de dinero en caja.
     */
    public void mostrarPromedioVentas( )
    {
        JOptionPane.showMessageDialog( this, "El promedio de ventas es: " + tienda.darPromedioVentas( ), "Promedio ventas", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = tienda.metodo1( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = tienda.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 2", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazTienda interfaz = new InterfazTienda( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

}