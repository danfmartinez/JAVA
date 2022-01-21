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
package uniandes.cupi2.tienda.mundo;

import uniandes.cupi2.tienda.mundo.Producto.Tipo;

/**
 * Tienda que maneja 4 productos.
 */
public class Tienda
{
	//---------------------
	// Constantes
	//---------------------
	public final static int TOTALPRODUCTOS = 4;
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Producto 1 de la tienda.
     */
    private Producto producto1;

    /**
     * Producto 2 de la tienda.
     */
    private Producto producto2;

    /**
     * Producto 3 de la tienda.
     */
    private Producto producto3;

    /**
     * Producto 4 de la tienda.
     */
    private Producto producto4;

    /**
     * Dinero total recibido por las ventas.
     */
    private double dineroEnCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la tienda con sus 4 productos. <br>
     * <b> post: </b> El dinero en caja fue inicializado en 0.<br>
     * Los 4 productos fueron inicializados con los siguientes valores: <br>
     * Producto 1 - Tipo: PAPELERIA, Nombre: Lápiz, Valor unitario: 550.0, Cantidad en bodega: 18, Cantidad mínima: 5, Imagen: lapiz.png. <br>
     * Producto 2 - Tipo: DROGUERIA, Nombre: Aspirina, Valor unitario: 109.5, Cantidad en bodega: 25, Cantidad mínima: 8, Imagen: aspirina.png. <br>
     * Producto 3 - Tipo: PAPELERIA, Nombre: Borrador, Valor unitario: 207.3, Cantidad en bodega: 30, Cantidad mínima: 10, Imagen: borrador.png. <br>
     * Producto 4 - Tipo: SUPERMERCADO, Nombre: Pan, Valor unitario: 150.0, Cantidad en bodega: 15, Cantidad mínima: 20, Imagen: pan.png. <br>
     * 
     */
    public Tienda( )
    {
        producto1 = new Producto( Tipo.PAPELERIA, "Lapiz", 550.0, 18, 5, "lapiz.png" );
        producto2 = new Producto( Tipo.DROGUERIA, "Aspirina", 109.5, 25, 8, "aspirina.png" );
        producto3 = new Producto( Tipo.PAPELERIA, "Borrador", 207.3, 30, 10, "borrador.png" );
        producto4 = new Producto( Tipo.SUPERMERCADO, "Pan", 150.0, 15, 20, "pan.png" );

        dineroEnCaja = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el producto 1.
     * @return Producto 1 de la tienda.
     */
    public Producto darProducto1( )
    {
        return producto1;
    }

    /**
     * Retorna el producto 2.
     * @return Producto 2 de la tienda.
     */
    public Producto darProducto2( )
    {
        return producto2;
    }

    /**
     * Retorna el producto 3.
     * @return Producto 3 de la tienda.
     */
    public Producto darProducto3( )
    {
        return producto3;
    }

    /**
     * Retorna el producto 4.
     * @return Producto 4 de la tienda.
     */
    public Producto darProducto4( )
    {
        return producto4;
    }

    /**
     * Retorna el dinero en caja.
     * @return Dinero en caja.
     */
    public double darDineroEnCaja( )
    {
        return dineroEnCaja;
    }

    /**
     * Retorna el producto con el nombre dado por parámetro.
     * @param pNombre Nombre del producto buscado. pNombre != null && pNombre != "".
     * @return Producto con el nombre dado por parámetro, null si no lo encuentra.
     */
    public Producto darProducto( String pNombre )
    {
        Producto buscado = null;

        if( producto1.darNombre( ).equals( pNombre ) )
        {
            buscado = producto1;
        }
        else if( producto2.darNombre( ).equals( pNombre ) )
        {
            buscado = producto2;
        }
        else if( producto3.darNombre( ).equals( pNombre ) )
        {
            buscado = producto3;
        }
        else if( producto4.darNombre( ).equals( pNombre ) )
        {
            buscado = producto4;
        }

        return buscado;

    }

    /**
     * Retorna el promedio de las ventas.
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
    public double darPromedioVentas( )
    {
        double respuesta = 0.0;
        double totalUnidadesVendidas = producto1.darCantidadUnidadesVendidas( ) + producto2.darCantidadUnidadesVendidas( ) + producto3.darCantidadUnidadesVendidas( ) + producto4.darCantidadUnidadesVendidas( );
        if( totalUnidadesVendidas > 0 )
        {
            respuesta = dineroEnCaja / totalUnidadesVendidas;
        }
        return respuesta;
    }

    /**
     * Retorna el producto con más unidades vendidas.
     * @return Producto con más unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto darProductoMasVendido()
    {
    	int Ventas[];
    	Ventas = new int[TOTALPRODUCTOS];
    	Ventas[0] = producto1.darCantidadUnidadesVendidas( );
    	Ventas[1] = producto2.darCantidadUnidadesVendidas( );
    	Ventas[2] = producto3.darCantidadUnidadesVendidas( );
    	Ventas[3] = producto4.darCantidadUnidadesVendidas( );
        
        Producto ArregloProductos[];
        ArregloProductos = new Producto[TOTALPRODUCTOS];
        ArregloProductos[0] = producto1;
        ArregloProductos[1] = producto2;
        ArregloProductos[2] = producto3;
        ArregloProductos[3] = producto4;
        
        Producto masVendido = null;
        int mayorCantidad = 0;
        for(int iterador=0;iterador<TOTALPRODUCTOS;iterador++)
        {
        	if(Ventas[iterador]>mayorCantidad)
        	{
        		mayorCantidad = Ventas[iterador];
        		masVendido = ArregloProductos[iterador];
        	}
        }
        return masVendido;
    }
    /**
    public Producto darProductoMasVendido()
    {
    	int Ventas[];
    	Ventas = new int[TOTALPRODUCTOS];
    	Ventas[0] = producto1.darCantidadUnidadesVendidas( );
    	Ventas[1] = producto2.darCantidadUnidadesVendidas( );
    	Ventas[2] = producto3.darCantidadUnidadesVendidas( );
    	Ventas[3] = producto4.darCantidadUnidadesVendidas( );
        
        Producto ArregloProductos[];
        ArregloProductos = new Producto[TOTALPRODUCTOS];
        ArregloProductos[0] = producto1;
        ArregloProductos[1] = producto2;
        ArregloProductos[2] = producto3;
        ArregloProductos[3] = producto4;
        
        Producto masVendido = null;
        int mayorCantidad = 0;
        int indice = 0;

        while ( indice < TOTALPRODUCTOS )
        {
        	if(Ventas[indice]>mayorCantidad)
        	{
        		mayorCantidad=Ventas[indice];
        		masVendido = ArregloProductos[indice];
        	}	
        	indice = indice + 1;
        }
        
        return masVendido;
    }
    /**
    public Producto darProductoMasVendido( )
    {
        int venta1 = producto1.darCantidadUnidadesVendidas( );
        int venta2 = producto2.darCantidadUnidadesVendidas( );
        int venta3 = producto3.darCantidadUnidadesVendidas( );
        int venta4 = producto4.darCantidadUnidadesVendidas( );

        Producto masVendido = null;
        int mayorCantidad = 0;

        if( venta1 > mayorCantidad )
        {
            masVendido = producto1;
            mayorCantidad = venta1;
        }
        if( venta2 > mayorCantidad )
        {
            masVendido = producto2;
            mayorCantidad = venta2;
        }
        if( venta3 > mayorCantidad )
        {
            masVendido = producto3;
            mayorCantidad = venta3;
        }
        if( venta4 > mayorCantidad )
        {
            masVendido = producto4;
        }

        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     * @return Producto con menos unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto darProductoMenosVendido( )
    {
        int venta1 = producto1.darCantidadUnidadesVendidas( );
        int venta2 = producto2.darCantidadUnidadesVendidas( );
        int venta3 = producto3.darCantidadUnidadesVendidas( );
        int venta4 = producto4.darCantidadUnidadesVendidas( );

        Producto menosVendido = null;

        if( venta1 > 0 || venta2 > 0 || venta3 > 0 || venta4 > 0 )
        {
            if( venta1 <= venta2 && venta1 <= venta3 && venta1 <= venta4 )
            {
                menosVendido = producto1;
            }
            else if( venta2 <= venta1 && venta2 <= venta3 && venta2 <= venta4 )
            {
                menosVendido = producto2;
            }
            else if( venta3 <= venta2 && venta3 <= venta1 && venta3 <= venta4 )
            {
                menosVendido = producto3;
            }
            else
            {
                menosVendido = producto4;
            }
        }

        return menosVendido;
    }

    /**
     * Vende una cantidad de unidades de producto de la tienda, dado su nombre por parámetro. <br>
     * <b>post: </b> Disminuyó la cantidad de unidades del producto dado y se actualizó el dinero de la caja.
     * @param pNombreProducto Nombre del producto a vender. npNombreProducto != null && pNombreProducto != "".
     * @param pCantidad Cantidad de unidades del producto a vender. pCantidad > 0.
     * @return Cantidad que fue efectivamente vendida.
     */
    public int venderProducto( String pNombreProducto, int pCantidad )
    {
        int cantidadVendida = 0;
        Producto producto = darProducto( pNombreProducto );
        cantidadVendida = producto.vender( pCantidad );
        dineroEnCaja += cantidadVendida * producto.calcularPrecioFinal( );

        return cantidadVendida;
    }

    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas. <br>
     * <b>post: </b> Aumentó la cantidad de unidades en bodega del producto dado.
     * @param pNombreProducto Nombre del producto a abastecer. pNombreProducto != null && pNombreProducto != "".
     * @param pCantidad La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso contrario.
     */
    public boolean abastecerProducto( String pNombreProducto, int pCantidad )
    {
        boolean abastece = false;
        Producto producto = darProducto( pNombreProducto );

        if( producto.puedeAbastecer( ) )
        {
            producto.abastecer( pCantidad );
            abastece = true;
        }

        return abastece;
    }

    /**
     * Cambia el producto que tiene el nombre actual con los nuevos valores dados por parámetro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y cantidad mínima fueron cambiados con los valores dados por parámetro.
     * @param pNombreActual Nombre actual del producto. pNombreActual != null && pNombreActual != "".
     * @param pNombreNuevo Nuevo nombre del producto. pNombreNuevo != null && pNombreNuevo != "".
     * @param pTipo Tipo del producto. pTipo != null.
     * @param pValorUnitario Valor unitario del producto
     * @param pCantidadBodega Cantidad en bodega del producto. pCantidadBodega >= 0.
     * @param pCantidadMinima Cantidad mínima en bodega para hacer un pedido del producto. pCantidadMinima > 0.
     * @param pRutaImagen Ruta de la imagen del producto. pRutaImagen != null && pRutaImagen != "".
     * @return Retorna true si cambió la información del producto, false si ya existía un producto diferente con el nuevo nombre.
     */
    public boolean cambiarProducto( String pNombreActual, String pNombreNuevo, Tipo pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen )
    {
        boolean cambio = false;
        if( pNombreActual.equals( pNombreNuevo ) || darProducto( pNombreNuevo ) == null )
        {

            if( producto1.darNombre( ).equals( pNombreActual ) )
            {
                producto1 = new Producto( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen );
            }
            else if( producto2.darNombre( ).equals( pNombreActual ) )
            {
                producto2 = new Producto( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen );
            }
            else if( producto3.darNombre( ).equals( pNombreActual ) )
            {
                producto3 = new Producto( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen );
            }
            else if( producto4.darNombre( ).equals( pNombreActual ) )
            {
                producto4 = new Producto( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen );
            }
            cambio = true;
        }
        return cambio;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}