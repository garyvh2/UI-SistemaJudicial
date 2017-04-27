package cr.ac.ucenfotec.sistemajudicial.ui;


import javax.swing.JOptionPane;


import java.sql.*;
import java.util.*;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

import cr.ac.ucenfotec.sistemajudicial.datamanagment.Gestor;


public class casoEstadoQuerellante {
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	//Initialization
	public void open (TreeMap<String,String> Params) {
		try {
			//Initialize shell frame
			ShellFrame = new ShellFrame(210,270,"Caso historial",null);		
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
		Label lblEstado		 	= new Label(shell, SWT.NONE);
		Label lblDescripcion 	= new Label(shell, SWT.NONE);
		Label lblFecha 			= new Label(shell, SWT.NONE);
		Label lblHistorial 		= new Label(shell, SWT.NONE);
		Label lblIDLabel 		= new Label(shell, SWT.NONE);
		Label lblIDVal 			= new Label(shell, SWT.NONE);
		Label lblHistorial_1 	= new Label(shell, SWT.NONE);
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
	  
		lblEstado.setBounds(10, 73, 174, 15);
		TreeMap<String, String> caso = (new Gestor()).casoBuscarPorID(Integer.parseInt(Params.get("ID")));
		lblEstado.setText(caso.get("estado"));
		
		lblDescripcion.setBounds(10, 31, 174, 15);
		lblDescripcion.setText(Params.get("Descripcion"));
		
		lblFecha.setBounds(10, 52, 174, 15);
		lblFecha.setText(Params.get("Fecha"));

		lblHistorial.setBounds(10, 115, 174, 220);
		lblHistorial.setText(Params.get("Historial"));
		
		lblIDLabel.setBounds(10, 10, 55, 15);
		lblIDLabel.setText("ID:");
		
		lblIDVal.setBounds(71, 10, 113, 15);
		lblIDVal.setText(Params.get("ID"));
		
		lblHistorial_1.setBounds(10, 94, 174, 15);
		lblHistorial_1.setText("Historial:");
	    	
		
	}
	
	
	
}
