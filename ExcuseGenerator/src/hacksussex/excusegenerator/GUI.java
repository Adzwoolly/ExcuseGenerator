package hacksussex.excusegenerator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** GUI for the Excuse Generator.
 * 
 * TODO: Add quit system, call generate excuse on generate.
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
		
		//Set properties of classes within the GUI
		mainframe.setPreferredSize(new Dimension(600, 350));
		mainframe.setMinimumSize(new Dimension());
		devMode.setEnabled(false);
		devMode.setToolTipText("Runs the program in 'Developer Mode'");
		normalMode.setToolTipText("Runs the program in 'Normal Mode'");
		input.setText("Why isn't there already an excuse already?");
		output.setEditable(false);
		output.setText("I haven't made an excuse yet because my cat ate it...");
		quitButton.setToolTipText("Exits the program");
		generateButton.setToolTipText("Generates an excuse");
		
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
		
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				exitProgram();
			}
		});
		
		generateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				output.setText(generateExcuse(input.getText()));
			}
		});
		
		mainframe.pack();
		mainframe.setVisible(true);
	}
	
	/**Shows a dialog box which prompts the user on confirming their exit of the program.
	 * 
	 */
	private static void exitProgram(){
		int answer = JOptionPane.showConfirmDialog(mainframe, 
				"Are you sure you'd like to exit?",
				"Exit?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
				);
		if(answer == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	private static String generateExcuse(String problem){
		System.out.println(problem);
		Backend bk = new Backend();
		return bk.getExcuse(problem);
	}
	
	
}
