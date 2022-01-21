package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;

import javax.swing.*;

import uniandes.cupi2.sistemapacientes.mundo.Paciente;
import uniandes.cupi2.sistemapacientes.mundo.SistemaPacientes;

public class InterfazSistemaPacientes extends JFrame 
{
	//---------------------------------------------------------
	//Main
	//---------------------------------------------------------
	
	/**
	 * Este metodo ejecuta la aplicacion, creando una nueva interfaz e inicializandola
	 * @param args Los argumentos no son utilizados
	 */
	public static void main(String[] args) 
	{
		InterfazSistemaPacientes interfaz = new InterfazSistemaPacientes();
		interfaz.setVisible(true);
	}
	
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
	
	/**
	 * Clase principal del mundo
	 */
	private SistemaPacientes sistemaPacientes;
	
	/**
	 * Es el panel que contiene los datos del paciente
	 */
	private PanelDatosPaciente panelDatosPaciente;
	
	/**
	 * Es el panel que contiene los elementos para realizar consultas sobre paciente
	 */
	private PanelDatosMuestra panelDatosMuestra;
	
	/**
	 * Es el panel que contiene los elementos para ejecutar las extensiones y la navegacion
	 */
	private PanelExtensiones panelExtensiones;
	
	//-----------------------------------------------------------------
    // Metodo Constructor
    //-----------------------------------------------------------------
	
	/**
	 * Construye una nueva interfaz inicializada con los
	 * datos del sistema de pacientes.
	 */
	public InterfazSistemaPacientes ()
	{
		setTitle( "Sistema de Pacientes" );
		setSize( 700, 450);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout (new BorderLayout() );
		
		//Crea la clase principal
		sistemaPacientes = new SistemaPacientes();
		
		//Crea el panel de datos de la muestra
		panelDatosPaciente = new PanelDatosPaciente(this);
		panelDatosMuestra = new PanelDatosMuestra(this);
		panelExtensiones = new PanelExtensiones(this);
		
		//organizar el panel principal
		add(panelDatosPaciente, BorderLayout.NORTH);
		add(panelDatosMuestra, BorderLayout.CENTER);
		add(panelExtensiones, BorderLayout.SOUTH);
	}
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	
	/**
	 * Actualiza la informacion del paciente dad por parametro.
	 * @param pPaciente Paciente del cual se mostraron los datos.
	 */
	public void actualizarInfoPaciente( Paciente pPaciente)
	{
		String nombre = pPaciente.darNombre();
		String apellido = pPaciente.darApellido();
		
		String sexo = "F";
		int iSexo = pPaciente.darSexo();
		if(iSexo == 2)
			sexo = "M";
		
		String fechaTomaMuestra = pPaciente.darFechaTomaMuestra();
		String fechaN = pPaciente.darFechaNacimiento();
		String imagen = pPaciente.darImagen();
		double volumenMuestra = pPaciente.darVolumenMuestra();
		double volumenEritrocitos = pPaciente.darVolumenEritrocitos();
		int conteoLeucocitos = pPaciente.darConteoLeucocitos();
		int conteoPlaquetas = pPaciente.darConteoPlaquetas();
		boolean enAyunas = pPaciente.darEnAyunas();
		
		panelDatosPaciente.actualizarCampos(nombre, apellido, sexo, fechaN, imagen);
		panelDatosMuestra.actualizarCampos(fechaTomaMuestra, enAyunas, volumenMuestra, 
				                           volumenEritrocitos, conteoLeucocitos, 
				                           conteoPlaquetas);
		panelDatosMuestra.limpiarCampos();	
	}
	
	/**
	 * Avanza al siguiente paciente y actualiza la informacion de la interfaz
	 */
	public void avanzar()
	{
		Paciente actual = sistemaPacientes.darPacienteSiguiente();
		actualizarInfoPaciente(actual);
	}
	
	/**
	 * Retrocede una posicion en la lista de pacientes y actualiza la informacion de la interfaz
	 */
	public void retroceder()
	{
		Paciente actual = sistemaPacientes.darPacienteAnterior();
		actualizarInfoPaciente(actual);
	}
	
	/**
	 * Calcula y muestra la edad del paciente
	 */
	public void calcularEdad()
	{
		int edad = sistemaPacientes.darPacienteActual().darEdad();
		panelDatosPaciente.mostrarEdad("" + edad);
	}
	
	/**
	 * Calcula y muestra el valor de hematocrito del paciente.
	 */
	public void calcularHematocrito()
	{
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();
		
		if(pVolumenMuestra.trim().equals("") || pVolumenEritrocitos.trim().equals("") )
		{
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.",
					"Calcular Hematocrito", JOptionPane.ERROR_MESSAGE );
		}
		else if(pVolumenMuestra.trim().matches("[0123456789.]*") && 
				pVolumenEritrocitos.trim().matches("[0123456789.]*") )
		{
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim() );
			double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim() );
			
			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
			
			double hematocrito = sistemaPacientes.darPacienteActual().calcularHematocrito();
			hematocrito = Math.round(hematocrito * 100.0) / 100.0;
			panelDatosMuestra.mostrarHematocrito("" + hematocrito);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.",
					"Calcular Hematocrito", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Calcula y muestra el valor de leucocitos del paciente.
	 */
	public void calcularLeucocitos()
	{
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		String pConteoLeucocitos = panelDatosMuestra.darConteoLeucocitos();
		
		if(pVolumenMuestra.trim().equals("") || pConteoLeucocitos.trim().equals("") )
		{
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.",
					"Calcular Leucocitos", JOptionPane.ERROR_MESSAGE );
		}
		else if(pVolumenMuestra.trim().matches("[0123456789.]*") && 
				pConteoLeucocitos.trim().matches("[0123456789.]*") )
		{
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim() );
			int conteoLeucocitos = Integer.parseInt(pConteoLeucocitos.trim() );
			
			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarConteoLeucocitos(conteoLeucocitos);
			
			double leucocitos = sistemaPacientes.darPacienteActual().calcularLeucocitos();
			leucocitos = Math.round(leucocitos * 100.0) / 100.0;
			panelDatosMuestra.mostrarLeucocito("" + leucocitos);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.",
					"Calcular Leucocitos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Muestra un mensaje indicando la muestra esta en ayunas o no
	 * dependiendo de la seleccion o deseleccion que haya hecho el 
	 * usuario en el panel de los datos de la muestra
	 */
	public void cambiarEnAyunas()
	{
		if(panelDatosMuestra.estaEnAyunas())
		{
			JOptionPane.showMessageDialog(this, "En ayunas", "Estado", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "No en ayunas", "Estado", JOptionPane.INFORMATION_MESSAGE);		
		}
	}
	
	/**
	 * Metodo para la extension 1
	 */
	public void reqFuncOpcion1()
	{
		String resultado = sistemaPacientes.metodo1();
		JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Metodo para la extension 2
	 */
	public void reqFuncOpcion2()
	{
		String resultado = sistemaPacientes.metodo2();
		JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	


}
