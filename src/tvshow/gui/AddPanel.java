package tvshow.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tvshow.controler.Listener;

public class AddPanel extends JPanel{

	private final JButton addButton;
	private final JTextField nextSeriesNameTextField;
	
	public AddPanel(Listener listener){
		this.setBackground(Color.red);
		this.setLayout(new FlowLayout());
		
		//init components
		this.addButton = new JButton("add");
		this.nextSeriesNameTextField = new JTextField(20);
		
		addButton.setSize(100,25);
		addButton.setLocation(350,20);
		
		nextSeriesNameTextField.setSize(100,25);
		nextSeriesNameTextField.setLocation(100,20);
		
		//add Actionlistener
		this.addButton.addActionListener(listener);
		this.nextSeriesNameTextField.addActionListener(listener);
		
		//setActionCommand
		this.addButton.setActionCommand(Listener.ADDSERIES);
		this.nextSeriesNameTextField.setActionCommand(Listener.ADDSERIES);
		
		//add Components
		this.add(this.nextSeriesNameTextField);
		this.add(this.addButton);
		
	}
	
	public String getCurrentName(){
		return this.nextSeriesNameTextField.getText();
	}
	
	public void cleanTextField(){
		this.nextSeriesNameTextField.setText("");
	}
	
}
