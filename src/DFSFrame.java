import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

public class DFSFrame extends JFrame {

	private JPanel contentPane;
	private JTextField speedTextField = new JTextField();
	private JTextField txtHello = new JTextField();
	private ArrayList listOfStates = new ArrayList(); 
	private JPanel DesignPanel = new JPanel();
	private JPanel ControlPanel = new JPanel();
	private JLabel runTimeLabel = new JLabel("Previous Runtime: ");
	private JButton buttonRun = new JButton("Run Simulation");
	
	private JRadioButton rdbtnNewRadioButton = new JRadioButton("Step-by-step simulation");
	private JLabel lblNewLabel = new JLabel("Simulation Speed (ms)");
	private JLabel stringLabel = new JLabel("String to Validate");
	private JButton buttonLoad = new JButton("Load Automata");
	private JButton buttonChange = new JButton("Change Automata");
	private JButton buttonExit = new JButton("Exit");
	private JLabel stringAcceptedLabel = new JLabel("String Was:");
	private JLabel displayAcceptedLabel = new JLabel("");
	
	/**
	 * Create the frame.
	 */
	
	public DFSFrame() {
		setElementProperties();
		addEventListeners();
		setVisible(true);
	}
	
	public void setElementProperties() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 717);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DesignPanel.setBounds(180, 5, 835, 662);
		contentPane.add(DesignPanel);
		
		ControlPanel.setBounds(5, 5, 165, 662);
		contentPane.add(ControlPanel);
		ControlPanel.setLayout(null);
		
		runTimeLabel.setBounds(6, 11, 149, 22);
		ControlPanel.add(runTimeLabel);
		
		buttonRun.setBounds(10, 442, 145, 53);
		ControlPanel.add(buttonRun);
		
		speedTextField = new JTextField();
		speedTextField.setText("10");
		speedTextField.setBounds(111, 69, 44, 17);
		ControlPanel.add(speedTextField);
		speedTextField.setColumns(10);
		
		rdbtnNewRadioButton.setBounds(6, 38, 149, 23);
		ControlPanel.add(rdbtnNewRadioButton);
		
		lblNewLabel.setBounds(6, 71, 112, 14);
		ControlPanel.add(lblNewLabel);
		
		txtHello.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHello.setBounds(10, 390, 145, 41);
		ControlPanel.add(txtHello);
		txtHello.setColumns(10);
		
		
		stringLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stringLabel.setBounds(10, 365, 145, 14);
		ControlPanel.add(stringLabel);
		
		
		buttonLoad.setBounds(10, 506, 145, 39);
		ControlPanel.add(buttonLoad);
		
		
		buttonChange.setBounds(10, 556, 145, 39);
		ControlPanel.add(buttonChange);
		
		
		buttonExit.setBounds(10, 606, 145, 39);
		ControlPanel.add(buttonExit);
		
		
		stringAcceptedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stringAcceptedLabel.setBounds(8, 107, 149, 39);
		ControlPanel.add(stringAcceptedLabel);
		
		
		displayAcceptedLabel.setEnabled(false);
		displayAcceptedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		displayAcceptedLabel.setBounds(10, 157, 145, 53);
		ControlPanel.add(displayAcceptedLabel);
	}
	
	private void addEventListeners() {
		DesignPanel.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Here");
				int x = e.getX();
				int y = e.getY();
				GUIState guiStateToAdd = new GUIState("Test", x, y);
				DesignPanel.add(guiStateToAdd);
				guiStateToAdd.setVisible(true);
			}
		});
	}
	
	
	private void addState(int x, int y) {
		
	}
}
