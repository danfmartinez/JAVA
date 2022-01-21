package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PanelExtensiones extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	/**
	 * El comando para el boton avanzar
	 */
	private static final String AVANZAR = "AVANZAR";
	
	/**
	 * El comando para el boton retroceder
	 */
	private static final String RETROCEDER ="RETROCEDER";
	
	/**
	 * El comando para el boton 1
	 */
	private final String OPCION_1="opcion1";
	
	/**
	 * El comando para el boton 2
	 */
	private final String OPCION_2 ="opcion2";
	
	// -----------------------------------------------------------------
    // Atributos 
    // -----------------------------------------------------------------
	
	//Botones para avanzar y retroceder el siguiente paciente
	private JButton btnAvanzar;
	private JButton btnRetroceder;
	
	//Boton para la extension 1
	private JButton butOpcion1;
	//Boton para la extension 2
	private JButton butOpcion2;
	
	/**
	 * Interfaz principal de la aplicacion
	 */
	private InterfazSistemaPacientes principal;
	
	// -----------------------------------------------------------------
	// Metodo Constructor
	// -----------------------------------------------------------------

	public PanelExtensiones(InterfazSistemaPacientes v)
	{
		principal = v;
		
	
		TitledBorder border = BorderFactory.createTitledBorder("Puntos de Extensión");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		//Panel donde se muestra la informacion del paciente 
		JPanel panelExtensiones;
				
		panelExtensiones = new JPanel();
		add(panelExtensiones, BorderLayout.SOUTH );
		
		//Creacion y configuracion de los botones
		btnRetroceder = new JButton("<");
		btnAvanzar = new JButton(">");
		butOpcion1 = new JButton("Opcción 1");
		butOpcion2 = new JButton("Opcción 2");
		
		//Distribucion grafica
		panelExtensiones.setLayout(new FlowLayout());
		panelExtensiones.add(btnRetroceder);
		panelExtensiones.add(butOpcion1);
		panelExtensiones.add(butOpcion2);
		panelExtensiones.add(btnAvanzar);
		
		/**
		 * Con los botones para avanzar y retroceder ya creados
		 * se le asocia los comandos respectivo (Las constantes)
		 */
		btnAvanzar.setActionCommand(AVANZAR);
		btnRetroceder.setActionCommand(RETROCEDER);
		
		/**
		 * Con los botones para opcion1 y opcion2 ya creados
		 * se le asocia los comandos respectivo (Las constantes)
		 */
		butOpcion1.setActionCommand(OPCION_1);
		butOpcion2.setActionCommand(OPCION_2);
		
		//Llamado al metodo addActionListener sobre los botones
		//para indicar que el panel es el encargado de atender el
		//evento que se genere cuando se presiona el boton
		//Note que this en esta caso es el panel mismo
		btnAvanzar.addActionListener(this);
		btnRetroceder.addActionListener(this);
		butOpcion1.addActionListener(this);
		butOpcion2.addActionListener(this);
		
	}
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	
	/**Metodo actionPerformed que se ejecuta cada vez que se
	 * genera un evento como consecuencia de una accion del usuario
	 * @param evento Evento generado
	 */
	public void actionPerformed(ActionEvent evento)
	{
		String comando = evento.getActionCommand();
		if(comando.equals(AVANZAR))
		{
			principal.avanzar();
		}
		else if(comando.equals(RETROCEDER))
		{
			principal.retroceder();
		}
		else if(comando.equals(OPCION_1))
		{
			principal.reqFuncOpcion1();
		}
		else if(comando.equals(OPCION_2))
		{
			principal.reqFuncOpcion2();
		}
	
	}

}
