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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con la imagen de la aplicación.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{

    // ------------------------------------------------------------
    // Atributos de interfaz
    // ------------------------------------------------------------

    /**
     * Etiqueta con la imagen de título de la tienda de juegos de celular.
     */
    private JLabel lblImagen;

    // ------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------

    /**
     * Constructor del panel de la imagen de la tienda.
     */
    public PanelImagen( )
    {
        setLayout( new BorderLayout( ) );

        ImageIcon icono = new ImageIcon( "./data/imagenes/Encabezado.png" );
        lblImagen = new JLabel( "" );

        lblImagen.setIcon( icono );
        lblImagen.setBorder( new TitledBorder( "" ) );
        add( lblImagen, BorderLayout.CENTER );

    }
}