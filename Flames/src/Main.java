
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;

	JLabel lblTitle = new JLabel("FLAMES"), 
			lblFname = new JLabel("Lover's Name: "), 
			lblSname = new JLabel("Partner's Name: "),
			lblOutput = new JLabel();
	
	JTextArea txtFname = new JTextArea(), txtSname = new JTextArea();
	
	JButton btnSubmit = new JButton("Calculate");
	
	public Main() {
		
		setSize(new Dimension(400,400));
		setLocationRelativeTo(null);
		setTitle("FLAMES");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lblTitle.setFont(new Font("Mono", Font.PLAIN, 24));
		lblTitle.setBounds(140, 20, 200, 30);
		lblTitle.setForeground(Color.red);
		
		lblFname.setBounds(20, 70, 150, 20);
		lblSname.setBounds(20, 120, 150, 20);
		
		txtFname.setBounds(170, 70, 170, 20);
		txtSname.setBounds(170, 120, 170, 20);
		
		btnSubmit.setBounds(130, 160, 100, 50);
		btnSubmit.setBackground(Color.WHITE);
		
		lblOutput.setBounds(120, 250, 300, 50);
		lblOutput.setFont(new Font("Mono", Font.BOLD, 30));
		lblOutput.setForeground(Color.DARK_GRAY);
		
		//Submit Event
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String fname = txtFname.getText();
					String sname = txtSname.getText();
					
					calculate(fname, sname);
					
				} catch (Exception e2) {
					lblOutput.setForeground(Color.RED);
					lblOutput.setText("Error");
					System.out.println(e2);
				}
				
				
			}
		});
		
		add(lblTitle);
		add(lblFname);
		add(lblSname);
		add(lblOutput);
		
		add(txtFname);
		add(txtSname);
		
		add(btnSubmit);
		
		setVisible(true);
		
	}
	
	
	//Process the value of the two values being inputed by the user
	void calculate(String fname, String sname) {
		
		String removedCommonChars = fname.replaceAll("["+ sname +"]", "");
		removedCommonChars += sname.replaceAll("["+ fname +"]", "");
		
		removedCommonChars = removedCommonChars.replaceAll("\\s+", "");
		
		System.out.println(removedCommonChars);
		
		String result = getFlames(removedCommonChars);
		
		lblOutput.setText(result);
	}
	
	
	
	//Loop through the flames depends on how many characters of the filtered string
	String getFlames(String filteredString) {
		
		char flames[] = { 'f', 'l', 'a', 'm', 'e', 's'};
		
		int length = filteredString.length();
		
		int index = length % flames.length;
		
		char chose = flames[index];
		
		return flamesValue(chose);
	}
	
	//Get the character value and return its full text
	String flamesValue(char chose) {
		
		String res = "";
		
		switch (chose) {
		case 'f':
			res = "Friends";
			break;
		case 'l':
			res = "Lovers";		
			break;
		case 'a':
			res = "Angry";
			break;
		case 'm':
			res = "Mutual";
			break;
		case 'e':
			res = "Enemies";
			break;
		case 's':
			res = "Siblings";
			break;

		default:
			res = "Yati oy";
		}
		
		chose = ' ';
		
		return res;
	}
	
}
