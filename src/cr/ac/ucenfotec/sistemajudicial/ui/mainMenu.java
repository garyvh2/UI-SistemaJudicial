package cr.ac.ucenfotec.sistemajudicial.ui;


import javax.swing.JOptionPane;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class mainMenu {
	private static ShellFrame ShellFrame;
	
	/**===========================================================**
	 * 
	 * Other forms
	 * 
	 **===========================================================**/
	private static loginJuez loginJuez = new loginJuez();
	private static loginQuerellante loginQuerellante = new loginQuerellante();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Initialize shell frame
			ShellFrame = new ShellFrame(360,200,"Menu principal",null);		
			//Content charge
			contentCharge ();
			//ShellFrame standby
			ShellFrame.StandBy();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error. GUI initialization failure", "Java Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//content initialization
	public static void contentCharge () { 
		Shell shell = ShellFrame.getShell();
		
		/**===========================================================**
		 * 
		 * Items list - Start
		 * 
		 **===========================================================**/
		Button btnJuez 			= new Button(shell, SWT.NONE);
		Button btnQuerellante 	= new Button(shell, SWT.NONE);
		/**===========================================================**
		 * Items list - end
		 **===========================================================**/
		btnJuez.setText("Juez");
		btnJuez.setBounds(10, 10, 160, 142);
		btnJuez.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
			    	case SWT.Selection:
			    		loginJuez.open(null, shell);
			    		break;
				}
			}
		});
		
		btnQuerellante.setText("Querellante");
		btnQuerellante.setBounds(174, 10, 160, 142);
		btnQuerellante.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
			    	case SWT.Selection:
			    		loginQuerellante.open(null, shell);
			    		break;
				}
			}
		});
	}
}
