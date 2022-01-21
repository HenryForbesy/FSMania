import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class FSMSelectionPanel extends JPanel {
	
	public FSMSelectionPanel(GUIController controller) {
		if(controller != null) {
		}
		loadElements(controller);
		
	}
	
	private void loadElements(GUIController controller) {
		this.setBounds(0, 0, 872, 744);
		this.setLayout(null);
		
		JButton buttonDFS = new JButton("DFS (Wrap Text)");
		buttonDFS.setBounds(13, 11, 164, 356);
		this.add(buttonDFS);
		
		JButton buttonNFS = new JButton("NFS (Wrap)");
		buttonNFS.setBounds(190, 11, 164, 356);
		this.add(buttonNFS);
		
		JButton buttonFST = new JButton("FST (Wrap)");
		buttonFST.setBounds(367, 11, 164, 356);
		this.add(buttonFST);
		
		JButton buttonPDA = new JButton("PDA (Wrap)");
		buttonPDA.setBounds(544, 11, 164, 356);
		this.add(buttonPDA);
		
		if(controller != null) {
			
		}
	}

}
