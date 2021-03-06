package cr.ac.ucenfotec.sistemajudicial.ui;


import javax.swing.JOptionPane;


import java.sql.*;
import java.util.*;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

import cr.ac.ucenfotec.sistemajudicial.datamanagment.Gestor;


public class casoEstadoJuez {
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	//Initialization
	public void open (TreeMap<String,String> Params) {
		try {
			//Initialize shell frame
			ShellFrame = new ShellFrame(210,310,"Caso historial",null);		
			//Content charge
			contentCharge (Params);
			//ShellFrame standby
			ShellFrame.StandBy();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error. GUI initialization failure", "Java Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//content initialization
	public static void contentCharge (TreeMap<String,String> Params) throws SQLException, Exception {
		/** ShellFrame object **/
		Shell shell = ShellFrame.getShell();
		/**===========================================================**
		 * 
		 * Items list - Start
		 * 
		 **===========================================================**/
		Combo combo 			= new Combo(shell, SWT.NONE);
		Label lblDescripcion 	= new Label(shell, SWT.NONE);
		Label lblFecha 			= new Label(shell, SWT.NONE);
		Label lblHistorial 		= new Label(shell, SWT.NONE);
		Label lblIDLabel 		= new Label(shell, SWT.NONE);
		Label lblIDVal 			= new Label(shell, SWT.NONE);
		Label lblHistorial_1 	= new Label(shell, SWT.NONE);
		Button btnNewButton 	= new Button(shell, SWT.NONE);
		/**===========================================================**
		 * Items list - end
		 **===========================================================**/
	    
		/**===========================================================**
		 * 
		 * Retrieve data - start
		 * 
		 **===========================================================**/
		
		/**===========================================================**
		 * Retrieve data - end
		 **===========================================================**/
	  
		combo.setBounds(10, 73, 174, 23);
		String[] estados = (new Gestor()).getEstados(Params.get("ID"));
		combo.setItems(estados);
		combo.select(0);
		
		
		lblDescripcion.setBounds(10, 31, 174, 15);
		lblDescripcion.setText(Params.get("Descripcion"));
		
		lblFecha.setBounds(10, 52, 174, 15);
		lblFecha.setText(Params.get("Fecha"));

		lblHistorial.setBounds(10, 159, 174, 243);
		lblHistorial.setText(Params.get("Historial"));
		
		lblIDLabel.setBounds(10, 10, 55, 15);
		lblIDLabel.setText("ID:");
		
		lblIDVal.setBounds(71, 10, 113, 15);
		lblIDVal.setText(Params.get("ID"));
		
		lblHistorial_1.setBounds(10, 138, 174, 15);
		lblHistorial_1.setText("Historial:");
	    	
		btnNewButton.setBounds(10, 102, 174, 30);
		btnNewButton.setText("Actualizar Estado");
		btnNewButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
			    	case SWT.Selection:
			    		if (combo.getSelectionIndex() != 0) {
			    			String estado 	= combo.getText();
				    		String id		= Params.get("ID");
							try {
								(new Gestor()).updateEstado(id, estado);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "El estado se actualizo correctamente", "Actualizacion de datos", JOptionPane.INFORMATION_MESSAGE);
							shell.close();
			    		} else {
			    			JOptionPane.showMessageDialog(null, "Error. El caso no puede ser movido a este estado", "Actualizacion de datos", JOptionPane.ERROR_MESSAGE);
			    			shell.close();
			    		}
			    		
						break;
				}
			}
		});
	}
	
	
	
}
