import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class TheFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cards = new CardLayout();	

	public TheFrame(GUIController controller) {
		loadProperties();
	}
	
	private void loadProperties() {
		contentPane = new JPanel(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 744);
		setContentPane(contentPane);
		
	}
	
	public void showPanel(String panelToShow) {
		cards.show(contentPane, panelToShow);
		repaint();
	}
	
	public void addPanel(JPanel panelToAdd, String panelName) {
		contentPane.add(panelToAdd, panelName);
	}

}
