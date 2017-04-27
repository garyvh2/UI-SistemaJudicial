package cr.ac.ucenfotec.sistemajudicial.ui;


import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public class ShellFrame 	{
	private 	int 	WIDTH;
	private 	int 	HEIGHT;
	private 	Shell 	shell;
	private 	Display display;
	
	//Constructor
	public ShellFrame(int WIDTH, int HEIGHT, String title, Layout layout) {
		super();
		this.WIDTH 		= WIDTH;
		this.HEIGHT 	= HEIGHT;
		this.shell 		= new Shell();
		this.display 	= Display.getDefault();
		
		
		//Set Size and title
		shell.setSize(WIDTH,HEIGHT);
		shell.setText(title);
		shell.setLayout(layout);

	    

		
	}
	//Getters & Setters	
	public Shell 	getShell	() {
		return shell;
	}
	public Display 	getDisplay	() {
		return display;
	}
	public int 		getWidth 	() {
		return WIDTH;
	}
	public int 		getHeight 	() {
		return HEIGHT;
	}

	//Methods
	public void ShellResize (int WIDTH, int HEIGHT) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		shell.setSize(WIDTH,HEIGHT);
	}
	
	
	//
	public void StandBy () {
		
		//Open shell and set layout
		shell.open();
		shell.layout();
		//Get Monitor
		Monitor primary = display.getPrimaryMonitor();
		//get bounds
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    //Get middle center
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    //Set location middle center
	    shell.setLocation(x, y);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
