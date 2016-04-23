package hacksussex.excusegenerator;

import java.awt.*;
import java.awt.Container;
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
		mainframe = new JFrame("#420HackGen");
		JButton generateExcuse = new JButton("Generate");
		JButton quit = new JButton("Quit");
		JRadioButton devMode = new JRadioButton();
		JRadioButton normalMode = new JRadioButton();
		JPanel mainContainer = new JPanel(new BorderLayout());
		JPanel radButtonContainer = new JPanel(new BorderLayout());
		JPanel ioContainer = new JPanel(new BorderLayout());
		JPanel buttonContainer = new JPanel(new FlowLayout());
		
		
		mainframe.setSize(400, 400);
		mainframe.setVisible(true);
	}
	
}
