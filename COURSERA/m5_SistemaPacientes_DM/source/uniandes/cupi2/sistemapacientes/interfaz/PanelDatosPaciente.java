package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PanelDatosPaciente extends JPanel implements ActionListener 
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	/**
	 * El comando para el boton de calcular la edad del paciente
	 */
	private final static String CALCULAR_EDAD = "CALCULAR EDAD" ;
	
	// -----------------------------------------------------------------
    // Atributos 
    // -----------------------------------------------------------------
	
	//Etiqueta y zona de texte para el nombre
	private JLabel labNombre;
	private JTextField txtNombre;
	
	//Etiqueta y zona de texto para el apellido
	private JLabel labApellido;
	private JTextField txtApellido;
	
	//Etiqueta y zona de texto para la fecha de nacimiento
	private JLabel labFNacimiento;
	private JTextField txtFNacimiento;
	
	//Etiqueta y zona de texto para el sexo
	private JLabel labSexo;
	private JTextField txtSexo;
	
	//Etiqueta donde se muestra la imagen
	private JLabel labImagen;
	
	//boton para calcular la edad
	private JButton butEdad;
	
	//Zona de texto donde se muestra la edad
	private JTextField txtEdad;
	
	/**
	 * Interfaz principal de la aplicacion
	 */
	private InterfazSistemaPacientes principal;
	
	// -----------------------------------------------------------------
	// Metodo Constructor
	// -----------------------------------------------------------------
	public PanelDatosPaciente(InterfazSistemaPacientes v)
	{
		principal = v;
		
		setLayout(new BorderLayout() );
		TitledBorder border = BorderFactory.createTitledBorder("Datos del paciente");
		border.setTitleColor (Color.BLUE);
		setBorder(border);
		
		//Panel donde se muestra la foto del paciente
		JPanel panelFoto;
		
		panelFoto = new JPanel();
		add(panelFoto, BorderLayout.EAST );
		
		//Panel donde se muestra la informacion del paciente 
		JPanel panelInformacion;
		
		panelInformacion = new JPanel();
		add(panelInformacion, BorderLayout.CENTER );
		
		//Creacion de todas las etiquetas
		labNombre = new JLabel("Nombre: " );
		labApellido = new JLabel("Apellido: " );
		labSexo = new JLabel ("Sexo: " );
		labFNacimiento = new JLabel("Fecha de Nacimiento: " );
		
		//Creacion y configuracion de la zona de texto para el nombre
		txtNombre = new JTextField(15);
		txtNombre.setEditable(false);
		txtNombre.setBackground(Color.LIGHT_GRAY);	
		txtNombre.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para el apellido
		txtApellido = new JTextField(15);
		txtApellido.setEditable(false);
		txtApellido.setBackground(Color.LIGHT_GRAY);	
		txtApellido.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para el sexo
		txtSexo = new JTextField(2);
		txtSexo.setEditable(false);
		txtSexo.setBackground(Color.LIGHT_GRAY);	
		txtSexo.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para la fecha de nacimiento
		txtFNacimiento = new JTextField(10);
		txtFNacimiento.setEditable(false);
		txtFNacimiento.setBackground(Color.LIGHT_GRAY);	
		txtFNacimiento.setForeground(Color.BLUE);
		
		//Creacion y configuracion del boton y la zona de texto para la edad
		butEdad = new JButton("Calcular Edad");
		txtEdad = new JTextField(10);
		txtEdad.setEditable(false);
		
		//distribucion grafica
		panelInformacion.setLayout(new GridLayout(6,2));
		panelInformacion.add(labNombre);
		panelInformacion.add(txtNombre);
		panelInformacion.add(labApellido);
		panelInformacion.add(txtApellido);
		panelInformacion.add(labSexo);
		panelInformacion.add(txtSexo);
		panelInformacion.add(labFNacimiento);
		panelInformacion.add(txtFNacimiento);
		panelInformacion.add(butEdad);
		panelInformacion.add(txtEdad);
		
		// etiqueta donde muestra la imagen
		labImagen = new JLabel("FOTO");
		panelFoto.add(labImagen);
		
		/**
		 * Con el boton para calcular la edad del paciente ya creado
		 * se le asocia el comando respectivo (la constante)
		 */
		butEdad.setActionCommand( CALCULAR_EDAD );
		
		//Llamado al metodo addActionListener sobre los botones
		//para indicar que el panel es el encargado de atender el
		//evento que se genere cuando se presiona el boton
		//Note que this en esta caso es el panel mismo
		butEdad.addActionListener(this);
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
		if(comando.equals(CALCULAR_EDAD))
		{
			principal.calcularEdad();
		}
	}
	
	/**
	 * Metodo que muestra el valor de la edad
	 * recibido por parametro en el campo de texto
	 * txtEdad
	 * @param pEdad edad del paciente
	 */
	public void mostrarEdad(String pEdad)
	{
		txtEdad.setText(pEdad);
	}
	
	/**
	 * Metodo que devuelve la edad que haya ingresado
	 * el usuario en el campo de texto txtEdad
	 * @return la edad del usuario
	 */
	public String darEdad()
	{
		String rta=txtEdad.getText();
		return rta;
	}
	
	/**
	 * Limpia los campos de texto del panel
	 */
	public void limpiarCampos()
	{
		txtEdad.setText("");
	}
	
	/**
	 * Actualiza los campos del panel con la informacion del paciente
	 * @param pNombre: nombre del paciente
	 * @param pApellido: apellido del paciente
	 * @param pSexo: sexo del paciente
	 * @param pFechaN: fecha de nacimiento
	 * @param pImagen: ruta donde se encuentra la imagen (foto)
	 */
	public void actualizarCampos(String pNombre, String pApellido,
			String pSexo, String pFechaN, String pImagen)
	{
		txtNombre.setText(pNombre);
		txtApellido.setText(pApellido);
		txtSexo.setText(pSexo);
		txtFNacimiento.setText(pFechaN);
		labImagen.setIcon(new ImageIcon(pImagen) );
		txtEdad.setText("");
	}

}
