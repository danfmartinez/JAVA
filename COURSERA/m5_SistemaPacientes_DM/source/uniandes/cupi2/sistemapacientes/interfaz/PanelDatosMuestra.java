package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PanelDatosMuestra extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	/**
	 * El comando para la opcion en ayunas
	 */
	private final static String AYUNAS = "En ayunas";
	
	/**
	 * El comando para el boton de calcular el hematocrito
	 */
	private final static String CALCULAR_HEMATOCRITO = "CALCULAR HEMATOCRITO";
	
	/**
	 * EL comando para el boton de calcular los leucocitos
	 */
	private final static String CALCULAR_LEUCOCITOS = "CALCULAR LEUCOCITOS";
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	//Etiqueta y zona de texto para la fecha de toma de la muestra
	private JLabel labFTomaMuestra;
	private JTextField txtFTomaMuestra;
	
	//Etiqueta y zona de texto para el volumen de la muestra
	private JLabel labVolumenMuestra;
	private JTextField txtVolumenMuestra;
	
	//Etiqueta y zona de texto para el volumend de eritrocitos
	private JLabel labVolumenEritrocitos;
	private JTextField txtVolumenEritrocitos;
	
	//Etiqueta y zona de texto para el conteo de laucocitos
	private JLabel labConteoLeucocitos;
	private JTextField txtConteoLeucocitos;
	
	//Etiqueta y zona de texto para el conteo de plaquetas
	private JLabel labConteoPlaquetas;
	private JTextField txtConteoPlaquetas;
	
	//Caja de chequeo si la muestra se tomo en ayunas
	private JCheckBox cbAyunas;
	
	//boton para el calculo de hematocrito
	private JButton butHematocrito;
	
	//texto para el calculo de hematocrito
	private JTextField txtHematocrito;
	
	//boton para el calculo de Leucocitos
	private JButton butLeucocitos;
		
	//texto para el calculo de Leucocitos
	private JTextField txtLeucocitos;
	
	/**
	 * Interfaz principal de la aplicacion
	 */
	private InterfazSistemaPacientes principal;
	
	// -----------------------------------------------------------------
	// Metodo Constructor
	// -----------------------------------------------------------------

	public PanelDatosMuestra(InterfazSistemaPacientes v )
	{
		principal = v ;
		
		TitledBorder border = BorderFactory.createTitledBorder("Información muestra");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		//Panel donde se muestra la informacion de la muestra 
		JPanel panelMuestra ;
				
		panelMuestra= new JPanel();
		add(panelMuestra, BorderLayout.CENTER );
				
		//Creacion de todas las etiquetas
		labFTomaMuestra = new JLabel("Fecha Toma Muestra: " );
		labVolumenMuestra = new JLabel("Volumen Muestra: " );
		labVolumenEritrocitos = new JLabel ("Volumen Eritrocitos: " );
		labConteoLeucocitos = new JLabel("Conteo Leucocitos: " );
		labConteoPlaquetas = new JLabel("Conteo Plaquetas: ");
				
		//Creacion y configuracion de la zona de texto para la fecha de la toma
		txtFTomaMuestra = new JTextField(15);
		txtFTomaMuestra.setEditable(false);
		txtFTomaMuestra.setBackground(Color.LIGHT_GRAY);	
		txtFTomaMuestra.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para el volumen de la muestra
		txtVolumenMuestra = new JTextField(15);
		txtVolumenMuestra.setEditable(true);
		txtVolumenMuestra.setBackground(Color.WHITE);	
		txtVolumenMuestra.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para el volumen de eritrocitos
		txtVolumenEritrocitos = new JTextField(15);
		txtVolumenEritrocitos.setEditable(true);
		txtVolumenEritrocitos.setBackground(Color.WHITE);	
		txtVolumenEritrocitos.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para el conteo de leucocitos
		txtConteoLeucocitos = new JTextField(15);
		txtConteoLeucocitos.setEditable(true);
		txtConteoLeucocitos.setBackground(Color.WHITE);	
		txtConteoLeucocitos.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para la fecha de la toma
		txtConteoPlaquetas = new JTextField(15);
		txtConteoPlaquetas.setEditable(true);
		txtConteoPlaquetas.setBackground(Color.WHITE);	
		txtConteoPlaquetas.setForeground(Color.BLUE);
		
		//Creacion y configuracion del caja de chequeo para ayunas
		cbAyunas = new JCheckBox("Ayunas");
		
		//Creacion y configuracion del boton y la zona de texto para hematocrito
		butHematocrito = new JButton("Calcular Hematocrito");
		txtHematocrito = new JTextField(10);
		txtHematocrito.setEditable(false);
		
		//Creacion y configuracion del boton y la zona de texto para la edad
		butLeucocitos = new JButton("Calcular Leucocitos");
		txtLeucocitos = new JTextField(10);
		txtLeucocitos.setEditable(false);
		
		//distribucion grafica
		panelMuestra.setLayout(new GridLayout(6,4));
		panelMuestra.add(labFTomaMuestra);
		panelMuestra.add(txtFTomaMuestra);
		panelMuestra.add(new JLabel(""));
		panelMuestra.add(cbAyunas);
		panelMuestra.add(labVolumenMuestra);
		panelMuestra.add(txtVolumenMuestra);
		panelMuestra.add(new JLabel(""));
		panelMuestra.add(new JLabel(""));
		panelMuestra.add(labVolumenEritrocitos);
		panelMuestra.add(txtVolumenEritrocitos);
		panelMuestra.add(butHematocrito);
		panelMuestra.add(txtHematocrito);
		panelMuestra.add(labConteoLeucocitos);
		panelMuestra.add(txtConteoLeucocitos);
		panelMuestra.add(butLeucocitos);
		panelMuestra.add(txtLeucocitos);
		panelMuestra.add(labConteoPlaquetas);
		panelMuestra.add(txtConteoPlaquetas);
		panelMuestra.add(new JLabel(""));
		panelMuestra.add(new JLabel(""));
		panelMuestra.add(new JLabel(""));
		panelMuestra.add(new JLabel(""));
		panelMuestra.add(new JLabel(""));
		panelMuestra.add(new JLabel(""));
		
		/**
		 * Con el boton para calcular el valor del hematocrito ya creado
		 * se le acocia el comando respectivo (la constante)
		 */
		butHematocrito.setText("Calcular Hematocrito");
		butHematocrito.setActionCommand(CALCULAR_HEMATOCRITO);
		
		/**
		 * Con el boton para calcular el valor del leucocitos ya creado
		 * se le acocia el comando respectivo (la constante)
		 */
		butLeucocitos.setText("Calcular Leucocitos");
		butLeucocitos.setActionCommand(CALCULAR_LEUCOCITOS);
		
		/**
		 * COn el boton de chequeo para indicar si la muestra
		 * esta en ayunas ya creado, se le asocia el comando respectivo
		 * (la constante)
		 */
		cbAyunas.setActionCommand(AYUNAS);
		
		//Llamado al metodo addActionListener sobre los botones
		//para indicar que el panel es el encargado de atender el
		//evento que se genere cuando se presiona el boton
		//Note que this en esta caso es el panel mismo
		butHematocrito.addActionListener(this);
		butLeucocitos.addActionListener(this);
		cbAyunas.addActionListener(this);
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
		if(comando.equals(CALCULAR_HEMATOCRITO))
		{
			principal.calcularHematocrito();
		}
		else if (comando.equals(CALCULAR_LEUCOCITOS))
		{
			principal.calcularLeucocitos();
		}
		else if (comando.equals(AYUNAS))
		{
			principal.cambiarEnAyunas();
		}
	}
	
	/**Metodo que muestra el valor de hematocrito
	 * recibido por paremetro en el campo de texto
	 * txtHematocrito
	 * @param pHematocrito Cantidad hematocrito
	 */
	public void mostrarHematocrito(String pHematocrito)
	{
		txtHematocrito.setText(pHematocrito);
	}
	
	/**
	 * Metodo que muestra el valor de leucocito
	 * recibido por parametro en el campo de texto
	 * txtLeucocitos
	 * @param pLeucocito Cantidad leucocito
	 */
	public void mostrarLeucocito(String pLeucocito)
	{
		txtLeucocitos.setText(pLeucocito);
	}
	
	/**
	 * Metodo que muestra el valor de "en ayunas"
	 * de acuerdo al recibido por parametro
	 * en la caja de chequeo cbAyunas
	 * @param pEnAyunas Indica true o false si la muestra es en ayunas o no
	 */
	public void mostrarAyunas(boolean pEnAyunas)
	{
		cbAyunas.setSelected(pEnAyunas);
	}
	
	/**
	 * Metodo que devuelve el volumen de la muestra que haya ingresado
	 * el usuario en el campo de texto txtVolumenMuestra
	 * @return el volumen de la muestra
	 */
	public String darVolumenMuestra()
	{
		String rta=txtVolumenMuestra.getText();
		return rta;
	}
	
	/**
	 * Metodo que devuelve el conteo de leucocitos que haya ingresado
	 * el usuario en el campo de texto txtConteoLeucocitos
	 * @return el conteo de leucocitos
	 */
	public String darConteoLeucocitos()
	{
		String rta=txtConteoLeucocitos.getText();
		return rta;
	}
	
	/**
	 * Metodo que devuelve el volumen de eritrocitos que haya ingresado
	 * el usuario en el campo de texto txtVolumenEritrocitos
	 * @return el volumen de eritrocitos
	 */
	public String darVolumenEritrocitos()
	{
		String rta=txtVolumenEritrocitos.getText();
		return rta;
	}
	
	/**
	 * Metodo que devuelve el conteo de plaquetas que haya ingresado
	 * el usuario en el campo de texto txtConteoPlaquetas
	 * @return el conteo de plaquetas
	 */
	public String darConteoPlaquetas()
	{
		String rta=txtConteoPlaquetas.getText();
		return rta;
	}
	
	/**
	 * Metodo que devuelve el valor (True/False que indica seleccionada/no selecionada)
	 * de la caja de chequeo cbAyunas
	 * @return true o false
	 */
	public boolean estaEnAyunas()
	{
		return cbAyunas.isSelected();
	}
	
	/**
	 * Limpia los campos de texto del panel 
	 */
	public void limpiarCampos()
	{
		txtHematocrito.setText("");
		txtLeucocitos.setText("");
	}
	
	/**
	 * Actualiza los campos del panel con la informacion que entra como parametro
	 * @param pFechaMuestra: fecha de toma de la muestra
	 * @param pEnAyunas: indica si la muestra es en ayunas o no
	 * @param pVolumenMuestra: volumen de la muestra
	 * @param pVolumenEritrocitos: volumen de eritrocitos
	 * @param pConteoLeucocitos: conteo de leucocitos
	 * @param pConteoPlaquetas conteo de plaquetas
	 */
	public void actualizarCampos(String pFechaMuestra, boolean pEnAyunas,
			double pVolumenMuestra, double pVolumenEritrocitos,
			int pConteoLeucocitos, int pConteoPlaquetas)
	{
		txtFTomaMuestra.setText(pFechaMuestra);
		txtVolumenMuestra.setText(pVolumenMuestra +"");
		txtVolumenEritrocitos.setText(pVolumenEritrocitos +"");
		txtConteoLeucocitos.setText(pConteoLeucocitos + "");
		txtConteoPlaquetas.setText(pConteoPlaquetas + "");
		cbAyunas.setSelected(pEnAyunas);
	}
	
	
	
	
}
