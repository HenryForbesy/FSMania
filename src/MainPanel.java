import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.ModuleLayer.Controller;
import java.awt.Rectangle;

public class MainPanel extends JPanel{
	private JPanel panel = new JPanel();
	private JButton buttonFSM = new JButton("Create FSM");
	private JButton buttonLoad = new JButton("Load FSM");
	private JButton buttonLessons = new JButton("Lessons");
	private JButton buttonExit = new JButton("Exit");
	private GUIController controllerRef;
	JLabel titleLbl = new JLabel("FSMania");
	

	public MainPanel(GUIController controller, int frameWidth, int frameHeight) {
		setLayout(null);
		controllerRef = controller;
		loadElementProperties(frameWidth, frameHeight);
		addEventListeners();		
	}
	
	private void changeScreen(int flag) {
		if(flag == 1) {
			controllerRef.changePanel("selectionPanel");
		}
		//ADD OTHER OPTIONS
	}
	
	private void loadElementProperties(int frameWidth, int frameHeight) {
		setBounds(0, 0, 872, 744);
		
		buttonFSM.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(buttonFSM);
		
		buttonLoad.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(buttonLoad);
		
		add(titleLbl);
		
		buttonLessons.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(buttonLessons);
		
		buttonExit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(buttonExit);
		
		titleLbl.setFont(new Font("Tahoma", Font.PLAIN, 61));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		setBounds(0, 0, frameWidth, frameHeight);
			
		buttonFSM.setBounds(frameWidth / 4, 55, frameWidth / 2, 54);
		buttonLoad.setBounds(frameWidth / 4, 164, frameWidth / 2, 54);
		buttonLessons.setBounds(frameWidth / 4, 273, frameWidth / 2, 54);
		buttonExit.setBounds(frameWidth / 4, 382, frameWidth / 2, 54);
	}
	
	private void addEventListeners() {
		
		buttonFSM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("buttonFSM pressed");
				changeScreen(1);
			}
		});
		
		
		buttonLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeScreen(2);
			}
		});
		
		buttonLessons.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeScreen(3);
			}
		});
		
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeScreen(4);
			}
		});
	}
	
	
	
}
