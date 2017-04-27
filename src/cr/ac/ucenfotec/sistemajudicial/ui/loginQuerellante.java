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

public class loginQuerellante {
	
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	
	
	/**===========================================================**
	 * 
	 * Other forms
	 * 
	 **===========================================================**/
	private static casosQuerellante casosQuerellante = new casosQuerellante();
	private static nuevoQuerellante nuevoQuerellante = new nuevoQuerellante();
	
	//Initialization
	public void open (TreeMap<String,String> Params, Shell shell) {
		try {
			shell.close();
			//Initialize shell frame
			ShellFrame = new ShellFrame(350,200,"Login Querellante",new GridLayout(1, false));		
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
		new Label(shell, SWT.NONE);
		Label lblCdula = new Label(shell, SWT.NONE);
		Text cedula = new Text(shell, SWT.BORDER);
		new Label(shell, SWT.NONE);
		
		Button btnIniciarSesion 	= new Button(shell, SWT.NONE);
		/**===========================================================**
		 * Items list - end
		 **===========================================================**/
		
		lblCdula.setText("C\u00E9dula");
	
		cedula.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		
		GridData gd_btnIniciarSesion = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		
		gd_btnIniciarSesion.widthHint = 200;
		btnIniciarSesion.setLayoutData(gd_btnIniciarSesion);
		btnIniciarSesion.setText("Iniciar sesion");
		btnIniciarSesion.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
			    	case SWT.Selection:
				    		if (!cedula.getText().equals("")) {
								try {
									TreeMap<String,String> querellante = (new Gestor()).loginQuerellante(cedula.getText());
									if (querellante == null) {
										nuevoQuerellante.open(cedula.getText(), shell);
									} else {
										casosQuerellante.open(querellante, shell);									
									}
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage() , "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);
								}
				    		} else {
								JOptionPane.showMessageDialog(null, "Error. Cedula invalida", "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);									
							}
			    		break;
				}
			}
		});
		
	}
}
