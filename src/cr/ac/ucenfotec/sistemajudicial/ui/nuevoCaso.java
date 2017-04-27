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

public class nuevoCaso {
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	
	
	private static casosQuerellante casosQuerellante = new casosQuerellante();
	
	
	//Initialization
	public void open (TreeMap<String, String> Params, Shell shell) throws Exception {
		try {
			if (shell != null)
				shell.dispose();
			//Initialize shell frame
			ShellFrame = new ShellFrame(330,260,"Registrar Caso",new GridLayout(1, false));		
			//Content charge
			contentCharge (Params, shell);
			//ShellFrame standby
			ShellFrame.StandBy();
		} catch (Exception e) {
			throw e;//JOptionPane.showMessageDialog(null, "Error. GUI initialization failure", "Java Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//content initialization
	public static void contentCharge (TreeMap<String, String> Params, Shell shellPass) throws SQLException, Exception {


		/** ShellFrame object **/
		Shell shell = ShellFrame.getShell();
		/**===========================================================**
		 * 
		 * Items list - Start
		 * 
		 **===========================================================**/
		new Label(shell, SWT.NONE);
		Label lblDescripcion = new Label(shell, SWT.NONE);
		Text descripcion = new Text(shell, SWT.BORDER);
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
		lblDescripcion.setText("Descripcion");
		
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.heightHint = 107;
		descripcion.setLayoutData(gd_text);
		
		GridData gd_btnRegistrarUsuario = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnRegistrarUsuario.widthHint = 200;
		btnRegistrarUsuario.setLayoutData(gd_btnRegistrarUsuario);
		btnRegistrarUsuario.setText("Registrar caso");
		btnRegistrarUsuario.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
			    	case SWT.Selection:
			    		try {
			    			String descripcionTxt	= descripcion.getText();
			    			if (!descripcionTxt.equals("")) {
			    				TreeMap<String, String> caso = (new Gestor()).crearCaso(descripcionTxt, Integer.parseInt(Params.get("id")));
			    				TreeMap<String, String> querellante = (new Gestor()).querellanteBuscarPorID(Integer.parseInt(caso.get("id_querellante")));
			    				if (shellPass != null)
			    					casosQuerellante.open(querellante, shell);
			    				else
			    					shell.dispose();
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
