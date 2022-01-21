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

public class MainFrame extends JPanel{
	private JPanel panel = new JPanel();
	private JButton buttonFSM = new JButton("Create FSM");
	private JButton buttonLoad = new JButton("Load FSM");
	private JButton buttonLessons = new JButton("Lessons");
	private GUIController controllerRef;
	private JButton buttonExit = new JButton("Exit");
	JLabel titleLbl = new JLabel("FSMania");
	

	public MainFrame(GUIController controller) {
		loadElementProperties();
		addEventListeners();
		controllerRef = controller;
	}
	
	public void changeScreen(int flag) {
		System.out.println("here");
		if(flag == 1) {
			controllerRef.changeFrame(controllerRef.getSelectionFrame(), this);
		}
		//ADD OTHER OPTIONS
	}
	
	private void loadElementProperties() {
		controllerRef.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		buttonFSM.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonFSM.setBounds(89, 55, 247, 54);
		panel.add(buttonFSM);
		
		buttonLoad.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonLoad.setBounds(89, 164, 247, 54);
		panel.add(buttonLoad);
		
		
		buttonLessons.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonLessons.setBounds(89, 273, 247, 54);
		panel.add(buttonLessons);
		
		buttonExit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		buttonExit.setBounds(89, 382, 247, 54);
		panel.add(buttonExit);
		
		titleLbl.setFont(new Font("Tahoma", Font.PLAIN, 61));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
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
