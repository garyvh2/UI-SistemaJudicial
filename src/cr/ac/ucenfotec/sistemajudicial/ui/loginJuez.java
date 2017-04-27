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

public class loginJuez {
	
	
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	
	
	/**===========================================================**
	 * 
	 * Other forms
	 * 
	 **===========================================================**/
	private static casosJuez casosJuez = new casosJuez();
	
	
	//Initialization
	public void open (TreeMap<String,String> Params, Shell shell) {
		try {
			shell.close();
			//Initialize shell frame
			ShellFrame = new ShellFrame(350,200,"Login Juez",new GridLayout(1, false));		
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
		Label lblNombreDeUsuario 	= new Label(shell, SWT.NONE);
		Text userName 				= new Text(shell, SWT.BORDER);;
		Label lblContrasea 			= new Label(shell, SWT.NONE);
		Text password 				= new Text(shell, SWT.PASSWORD | SWT.BORDER);
		Button btnIniciarSesion 	= new Button(shell, SWT.NONE);
		/**===========================================================**
		 * Items list - end
		 **===========================================================**/
		lblNombreDeUsuario.setText("Nombre de usuario");
		lblContrasea.setText("Contrase\u00F1a");
		
		userName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		password.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		new Label(shell, SWT.NONE);
		
		
		
		GridData gd_btnIniciarSesion = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		
		gd_btnIniciarSesion.widthHint = 200;
		btnIniciarSesion.setLayoutData(gd_btnIniciarSesion);
		btnIniciarSesion.setText("Iniciar sesion");
		btnIniciarSesion.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
			    	case SWT.Selection:
						try {
							TreeMap<String, String> data = (new Gestor()).loginJuez(userName.getText(), password.getText());
							casosJuez.open(data, shell);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage() , "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);
						}
			    		break;
				}
			}
		});
		
	}
	
}
