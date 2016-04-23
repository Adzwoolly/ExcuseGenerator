package hacksussex.excusegenerator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** GUI for the Excuse Generator.
 * 
 * @author JRIngram
 * @version 23/04/2016
 *
 */

public class GUI {
	private static JFrame mainframe;
	
	
	public static void main(String args[]){
		//Construct components
		mainframe = new JFrame("Excuse Generator");
		JButton generateButton = new JButton("Generate");
		JButton quitButton = new JButton("Quit");
		JRadioButton devMode = new JRadioButton("Developer Mode");
		JRadioButton normalMode = new JRadioButton("Normal Mode");
		JLabel radButtonLabel = new JLabel("Choose the 'excuse mode':");
		JLabel inputLabel = new JLabel("Enter what you need an excuse for!:");
		JLabel outputLabel = new JLabel("And your excuse is!:");
		TextArea input = new TextArea(5, 1);
		TextArea output = new TextArea(5, 1);
		JPanel modeContainer = new JPanel(new BorderLayout());
		JPanel radButtonContainer = new JPanel(new FlowLayout());
		JPanel ioContainer = new JPanel(new BorderLayout());
		JPanel inputContainer = new JPanel(new BorderLayout());
		JPanel outputContainer = new JPanel(new BorderLayout());
		JPanel buttonContainer = new JPanel(new FlowLayout());
		ButtonGroup modeButtons = new ButtonGroup();
		
		output.setEditable(false);
		
		//Adds the radio to the button group
		modeButtons.add(devMode);
		modeButtons.add(normalMode);
		normalMode.setSelected(true);
		
		/*Add components to radButtonContainer, add radButtonContainer to modeContainer
		 * then add mode container to the mainframe.
		 */
		radButtonContainer.add(normalMode);
		radButtonContainer.add(devMode);
		modeContainer.add(radButtonLabel, BorderLayout.NORTH);
		modeContainer.add(radButtonContainer, BorderLayout.SOUTH);
		mainframe.add(modeContainer, BorderLayout.NORTH);
		
		/* Adds two text areas and JLabels to two containers, 
		 * then adds these to ioContainer, 
		 * and then adds the ioContainer to mainframe. 
		 */
		inputContainer.add(inputLabel, BorderLayout.NORTH);
		inputContainer.add(input, BorderLayout.SOUTH);
		outputContainer.add(outputLabel, BorderLayout.NORTH);
		outputContainer.add(output, BorderLayout.SOUTH);
		ioContainer.add(inputContainer, BorderLayout.NORTH);
		ioContainer.add(outputContainer, BorderLayout.CENTER);
		mainframe.add(ioContainer, BorderLayout.CENTER);
		
		/*Adds the quit and generate button to the button container,
		 * then adds these to the mainframe.
		 */
		buttonContainer.add(generateButton);
		buttonContainer.add(quitButton);
		mainframe.add(buttonContainer, BorderLayout.SOUTH);
		
		
		mainframe.pack();
		mainframe.setVisible(true);
	}
	
}
