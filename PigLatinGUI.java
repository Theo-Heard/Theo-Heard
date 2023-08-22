package myGui;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PigLatinGUI {
	private static JFrame myFrame;
	private static JPanel myPanel, ioPanel, inputPanel, outputPanel, buttonPanel;
	private static JTextArea inputArea, outputArea;
	private static JButton convertButton;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	public static void main(String[] args) {
		myFrame = new JFrame();
		myFrame.setTitle("Pig Latin Converter");
		
		myPanel = new JPanel();
		myPanel.setLayout(new GridLayout(2, 1));
		
		ioPanel = new JPanel();
		ioPanel.setLayout(new FlowLayout());
		
		
		inputPanel = new JPanel();
		inputArea = new JTextArea(10, 20);
		inputArea.setLineWrap(true);
		inputPanel.add(inputArea);
		
		outputPanel = new JPanel();
		outputArea = new JTextArea(10, 20);
		outputArea.setLineWrap(true);
		outputArea.setEditable(false);
		outputPanel.add(outputArea);
		
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		convertButton = new JButton("Convert to Pig Latin");
		buttonPanel.add(convertButton);
		
		convertButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(inputArea.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter a string to convert.");
				else
					outputArea.setText(getPigLatin(inputArea.getText().trim()));
			}
		});
		
		ioPanel.add(inputPanel);
		ioPanel.add(outputPanel);
		
		myPanel.add(ioPanel);
		myPanel.add(buttonPanel);
		
		myFrame.add(myPanel);
		myFrame.setSize(WIDTH, HEIGHT);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}
	
	public static String getPigLatin(String input)
	{
		String pigLSentence = "";
		String punct = "";
		
		String[] words = input.split(" ");
		
		for (String word : words)
		{
			if(!Character.isLetter(word.charAt(word.length() - 1)))
			{
				punct = word.charAt(word.length() - 1) + "";
				word = word.replace(word.charAt(word.length() - 1) + "", "");
			}
			if (Character.isLetter(word.charAt(0)))
			{
				if(isVowel(word.charAt(0)))
				{
					word = word + "way";
				}
				else
					word = word.substring(1) + word.charAt(0) + "ay";
			}
			else if (Character.isDigit(word.charAt(0)))
				word = word.substring(1) + word.charAt(0) + "ay";
			
			pigLSentence += word + " ";
		}
		pigLSentence = pigLSentence.trim() + punct;
		return pigLSentence;	
	}
	
	public static boolean isVowel(char lttr)
	{
		if(lttr == 'a' || lttr == 'A' || lttr == 'e' || lttr == 'E' || lttr == 'i' || lttr == 'I' || lttr == 'o' || lttr == 'O' || lttr == 'u' || lttr == 'U')
			return true;
		else
			return false;
	}
}









