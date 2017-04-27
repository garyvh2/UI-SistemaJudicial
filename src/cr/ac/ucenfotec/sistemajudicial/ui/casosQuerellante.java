package cr.ac.ucenfotec.sistemajudicial.ui;



import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import cr.ac.ucenfotec.sistemajudicial.classes.Estado;
import cr.ac.ucenfotec.sistemajudicial.datamanagment.Gestor;


public class casosQuerellante {
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	private static Table table;
	
	private static int id;

	/**===========================================================**
	 * 
	 * Other forms
	 * 
	 **===========================================================**/
	private static casoEstadoQuerellante casoEstadoQuerellante = new casoEstadoQuerellante();
	private static nuevoCaso nuevoCaso = new nuevoCaso();
	
	
	//Initialization
	public void open (TreeMap<String,String> Params, Shell shell) throws Exception {
		try {
			id = Integer.parseInt(Params.get("id"));
			shell.close();
			//Initialize shell frame
			ShellFrame = new ShellFrame(800,600,"Querellantes menu principal",new GridLayout(9, false));		
			//Content charge
			contentCharge (Params);
			//Set Data data 
			setData();
			//ShellFrame standby
			ShellFrame.StandBy();
		} catch (Exception e) {
			throw e; //JOptionPane.showMessageDialog(null, "Error. GUI initialization failure", "Java Error", JOptionPane.ERROR_MESSAGE);
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
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblCedula = new Label(shell, SWT.NONE);
		lblCedula.setText("Cedula");
		new Label(shell, SWT.NONE);
		
		Label lblCed = new Label(shell, SWT.NONE);
		GridData gd_lblCed = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblCed.widthHint = 120;
		lblCed.setLayoutData(gd_lblCed);
		lblCed.setText(Params.get("cedula"));
		new Label(shell, SWT.NONE);
		
		Label lblNombre = new Label(shell, SWT.NONE);
		lblNombre.setText("Nombre:");
		new Label(shell, SWT.NONE);
		
		String nombre = Params.get("nombre") + " " + Params.get("apellidos");
		
		Label lblNombre_1 = new Label(shell, SWT.NONE);
		GridData gd_lblNombre_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNombre_1.widthHint = 256;
		lblNombre_1.setLayoutData(gd_lblNombre_1);
		lblNombre_1.setText(nombre);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		
		GridData gd_btnNewButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 2);
		gd_btnNewButton.heightHint = 40;
		gd_btnNewButton.widthHint = 140;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("Agregar un caso");
		btnNewButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
			    	case SWT.Selection:
			    		try {
			    			nuevoCaso.open(Params, null);
							setData();
			    		} catch (Exception e1) {
			    			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error de registro", JOptionPane.ERROR_MESSAGE);
			    		}
						break;
				}
			}
		});
		
		
		new Label(shell, SWT.NONE);
		
		Label lblTelefono = new Label(shell, SWT.NONE);
		lblTelefono.setText("Telefono");
		new Label(shell, SWT.NONE);
		
		Label lblTel = new Label(shell, SWT.NONE);
		lblTel.setText(Params.get("telefono"));
		new Label(shell, SWT.NONE);
		
		Label lblDireccion = new Label(shell, SWT.NONE);
		lblDireccion.setText("Direccion:");
		new Label(shell, SWT.NONE);
		
		Label lblSala_1 = new Label(shell, SWT.NONE);
		lblSala_1.setText(Params.get("direccion"));
		new Label(shell, SWT.NONE);
		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 9, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
			
	    table.addListener(SWT.Selection, new Listener() {
		    public void handleEvent(Event e) {
		    	String string = "";
		    	TableItem[] selection = table.getSelection();
		    	TreeMap<String,String> tree = new TreeMap<String,String>();
		    	int i;
		    	
		    	
		    	for (i = 0; i < selection.length; i++) {
		    		string = selection[i].getText(0);
		    		tree.put("ID", string);
		    		string = selection[i].getText(1);
		    		tree.put("Descripcion", string);
		    		string = selection[i].getText(2);
		    		tree.put("Estado", string);
		    		string = selection[i].getText(3);
		    		tree.put("Fecha", string);
		    		string = selection[i].getText(5);
		    		tree.put("Historial", string);
		    		
		    		casoEstadoQuerellante.open(tree);
		    		
		    		try {
						setData();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    }
	    
	    });
	    
	    TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn.setWidth(50);
	    tblclmnNewColumn.setText("ID");
	    
	    TableColumn tblclmnNewColumn1 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn1.setWidth(200);
	    tblclmnNewColumn1.setText("Descripcion");
	    
	    TableColumn tblclmnNewColumn2 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn2.setWidth(150);
	    tblclmnNewColumn2.setText("Estado");
	    
	    TableColumn tblclmnNewColumn3 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn3.setWidth(80);
	    tblclmnNewColumn3.setText("Fecha");
	    	    
	    TableColumn tblclmnNewColumn5 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn5.setWidth(140);
	    tblclmnNewColumn5.setText("Juez");
	    
	    TableColumn tblclmnNewColumn6 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn6.setWidth(1000);
	    tblclmnNewColumn6.setText("Historial");
	    
	}
	public static void setData () throws SQLException, Exception {
		Vector<TreeMap<String, String>> casos = (new Gestor()).listarCasosPorQuerellante(id);
		table.removeAll();
		for (TreeMap<String, String> caso : casos) {
		    TableItem item1 = new TableItem(table, SWT.NONE);
		    String estado = "";
		    Estado estadoCaso = Estado.valueOf(caso.get("estado").toUpperCase());
		    if (estadoCaso == Estado.RESUELTO || estadoCaso == Estado.RECHAZADO) {
		    	estado = estadoCaso.val();
		    } else {
		    	estado = "Pendiente de resolucion";
		    }
		    item1.setText(new String[] {caso.get("id"),caso.get("descripcion"),estado,caso.get("fecha"),caso.get("nombreJ"),caso.get("historial")});	    	
	    }
	}
	
}
