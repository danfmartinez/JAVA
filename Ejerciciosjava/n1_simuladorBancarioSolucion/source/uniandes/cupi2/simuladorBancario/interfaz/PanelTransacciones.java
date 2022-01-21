package uniandes.cupi2.simuladorBancario.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.simuladorBancario.mundo.Transaccion;

@SuppressWarnings("serial")
public class PanelTransacciones extends JPanel implements ListSelectionListener 
{
	// -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

	/**
     * Ventana principal de la tienda de libros.
     */
	private InterfazSimulador principal;
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	/**
	 * La lista de transacciones
	 */
	private JList transacciones;
	/**
     * Scroll que contiene la lista de transacciones.
     */
	private JScrollPane scroll;
	
	private JLabel lblConsecutivo;
	private JLabel lblTipo;
	private JLabel lblCuenta;
	private JLabel lblValor;
	
	private JTextField txtConsecutivo;
	private JTextField txtTipo;
	private JTextField txtCuenta;
	private JTextField txtValor;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public PanelTransacciones(InterfazSimulador pPrincipal)
	{
		principal = pPrincipal;
		
		JPanel panelDetalles = new JPanel();
		panelDetalles.setBorder(new TitledBorder("Detalles"));
		panelDetalles.setLayout( new BorderLayout( ) );
		
		setLayout( new BorderLayout( ) );
		
		transacciones = new JList( );
        transacciones.addListSelectionListener( this );
        scroll = new JScrollPane( );
        setBorder( new TitledBorder( "Historial de transacciones" ) );
        scroll.setViewportView( transacciones );
        scroll.setVerticalScrollBarPolicy( javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );

		add(scroll, BorderLayout.WEST);
		add(panelDetalles, BorderLayout.CENTER);
		
		JPanel informacion = new JPanel( );
        informacion.setLayout( new GridLayout(4, 2));
        panelDetalles.add( informacion, BorderLayout.CENTER);
		
        lblConsecutivo = new JLabel("Consecutivo: ");
        informacion.add(lblConsecutivo);
        txtConsecutivo = new JTextField(12);
        txtConsecutivo.setEditable( false );
        informacion.add( txtConsecutivo );
        
        lblTipo = new JLabel("Tipo: ");
        informacion.add(lblTipo);
        txtTipo = new JTextField(12);
        txtTipo.setEditable(false);
        informacion.add(txtTipo);
        
        lblCuenta = new JLabel("Cuenta: ");
        informacion.add(lblCuenta);
        txtCuenta = new JTextField(12);
        txtCuenta.setEditable(false);
        informacion.add(txtCuenta);
        
        lblValor = new JLabel("Valor: ");
        informacion.add(lblValor);
        txtValor = new JTextField(12);
        txtValor.setEditable(false);
        informacion.add(txtValor);
		
	}
	
	// -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

	@Override
	public void valueChanged(ListSelectionEvent arg0) 
	{
		// TODO Auto-generated method stub
		if (transacciones.getSelectedValue() != null)
		{
			Transaccion pTransaccion = (Transaccion) transacciones.getSelectedValue();
			NumberFormat formatter = NumberFormat.getNumberInstance( );
			
			String consecutivoString = formatter.format(pTransaccion.darConsecutivo());
			txtConsecutivo.setText(consecutivoString);
			
			if (pTransaccion.darTipoTransaccion() == 0)
			{
				txtTipo.setText("ENTRADA");
			}
			if (pTransaccion.darTipoTransaccion() == 1)
			{
				txtTipo.setText("SALIDA");
			}
			if (pTransaccion.darTipoCuenta() == 0)
			{
				txtCuenta.setText("AHORROS");
			}
			if (pTransaccion.darTipoCuenta() == 1)
			{
				txtCuenta.setText("CORRIENTE");
			}
			if (pTransaccion.darTipoCuenta() == 2)
			{
				txtCuenta.setText("CDT");
			}
			
			String valorString = formatter.format(pTransaccion.darValor());
			txtValor.setText("$" + valorString);
		}
		else
		{
			txtConsecutivo.setText("");
			txtTipo.setText("");
			txtCuenta.setText("");
			txtValor.setText("");
		}
		
	}
	
	public void refrescar(ArrayList<Transaccion> pTransacciones)
	{
		transacciones.setListData( pTransacciones.toArray( ));
	}
}
