import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class FSMSelectionFrame extends JFrame {

	private JPanel contentPane;
	
	public FSMSelectionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton buttonDFS = new JButton("DFS (Wrap Text)");
		buttonDFS.setBounds(13, 11, 164, 356);
		panel.add(buttonDFS);
		
		JButton buttonNFS = new JButton("NFS (Wrap)");
		buttonNFS.setBounds(190, 11, 164, 356);
		panel.add(buttonNFS);
		
		JButton buttonFST = new JButton("FST (Wrap)");
		buttonFST.setBounds(367, 11, 164, 356);
		panel.add(buttonFST);
		
		JButton buttonPDA = new JButton("PDA (Wrap)");
		buttonPDA.setBounds(544, 11, 164, 356);
		panel.add(buttonPDA);
	}

}
