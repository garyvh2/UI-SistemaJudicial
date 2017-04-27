package cr.ac.ucenfotec.sistemajudicial.ui;

import java.sql.SQLException;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import cr.ac.ucenfotec.sistemajudicial.datamanagment.Gestor;

public class nuevoQuerellante {
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	
	
	private static nuevoCaso nuevoCaso = new nuevoCaso();
	
	
	//Initialization
	public void open (String Params, Shell shell) {
		try {
			shell.dispose();
			//Initialize shell frame
			ShellFrame = new ShellFrame(330,350,"Registrar Querellante",new GridLayout(1, false));		
			//Content charge
			contentCharge (Params);
			//ShellFrame standby
			ShellFrame.StandBy();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error. GUI initialization failure", "Java Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//content initialization
	public static void contentCharge (String Params) throws SQLException, Exception {


		/** ShellFrame object **/
		Shell shell = ShellFrame.getShell();
		/**===========================================================**
		 * 
		 * Items list - Start
		 * 
		 **===========================================================**/
		new Label(shell, SWT.NONE);
		Label lblCdula = new Label(shell, SWT.NONE);
		Text cedula = new Text(shell, SWT.BORDER);
		Label lblNombre = new Label(shell, SWT.NONE);
		Text nombre = new Text(shell, SWT.BORDER);
		Label lblApellidos = new Label(shell, SWT.NONE);
		Text apellidos = new Text(shell, SWT.BORDER);
		Label lblTelfono = new Label(shell, SWT.NONE);
		Text telefono = new Text(shell, SWT.BORDER);
		Label lblDireccin = new Label(shell, SWT.NONE);
		Text direccion = new Text(shell, SWT.BORDER);
		new Label(shell, SWT.NONE);
		Button btnRegistrarUsuario = new Button(shell, SWT.NONE);
		
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
		lblCdula.setText("C\u00E9dula");
		
		cedula.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cedula.setText(Params);
		
		lblNombre.setText("Nombre");
		
		nombre.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblApellidos.setText("Apellidos");
		
		apellidos.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblTelfono.setText("Tel\u00E9fono");
		
		telefono.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblDireccin.setText("Direcci\u00F3n");
		
		direccion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		GridData gd_btnRegistrarUsuario = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnRegistrarUsuario.widthHint = 200;
		btnRegistrarUsuario.setLayoutData(gd_btnRegistrarUsuario);
		btnRegistrarUsuario.setText("Registrar usuario");
		btnRegistrarUsuario.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
			    	case SWT.Selection:
			    		try {
			    			String cedulaTxt	= cedula.getText();
			    			String nombreTxt	= nombre.getText();
			    			String apellidosTxt	= apellidos.getText();
			    			String telefonoTxt	= telefono.getText();
			    			String direccionTxt	= direccion.getText();
			    			if (!cedulaTxt.equals("") 
			    			&&	!nombreTxt.equals("")
			    			&&	!apellidosTxt.equals("")
			    			&&	!telefonoTxt.equals("")
			    			&&	!direccionTxt.equals("")) {
			    				TreeMap<String, String> querellante = (new Gestor()).crearQuerellante(cedulaTxt, nombreTxt, apellidosTxt, telefonoTxt, direccionTxt);
			    				nuevoCaso.open(querellante, shell);
			    			} else {
			    				throw new Exception ("Error. No puede dejar espacios en blanco");
			    			}
			    		} catch (Exception e1) {
			    			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error de registro", JOptionPane.ERROR_MESSAGE);
			    		}
						break;
				}
			}
		});
	}
}
