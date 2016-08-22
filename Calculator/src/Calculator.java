import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{
	
	// name of keys
	public final String[] KEYS = { "7", "8", "9", "/", "sqrt", "4", "5", "6",  
            "*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };
	
	// name of commands
	private final String[] COMMANDS = { "Backspace", "CE", "C" };
	
	// name of M's
	private final String[] M = { " ", "MC", "MR", "MS", "M+" }; 
	
	// buttons of keys on the calculator
	private JButton keys[] = new JButton[KEYS.length];
	
	// buttons of commands on the calculator
	private JButton commands[] = new JButton[COMMANDS.length];
	
	// buttons of M's on the calculator
	private JButton m[] = new JButton[M.length]; 
	
	// text field for visualizing results
	private JTextField resultText = new JTextField("0");
	
	// if it's the first digit
	private boolean firstDigit = true;
	//intermediate result
	private double resultNum = 0.0;
	//current operator
	private String operator = "=";
	//if the operation is valid
	private boolean operateValidFlag = true;
	
	
	/*
	 * constructor
	 */
	public Calculator(){
		super();
		// initial calculator
		init();
		//set background color
		this.setBackground(Color.LIGHT_GRAY);
		//set title
		this.setTitle("Calculator");
		//set location
		this.setLocation(500, 500);
		//CANNOT resize calculator
		this.setResizable(false);
		//make components have proper sizes
		this.pack();		
	}
	
	/*
	 * initial the calculator
	 */
	private void init() {
		// text field - align right
		resultText.setHorizontalAlignment(JTextField.RIGHT);
		// text field - CANNOT edit
		resultText.setEditable(false);
		// text field - set background color
		resultText.setBackground(Color.yellow);
		
		// put all keys into one panel
		JPanel calckeysPanel = new JPanel();
		// 4 rows & 5 columns, horizontal: at least 3 pixels, vertical: at least 3 pixels
		calckeysPanel.setLayout(new GridLayout(4,5,3,3));		
		for(int i = 0; i < KEYS.length;i++){
			keys[i] = new JButton(KEYS[i]);
			calckeysPanel.add(keys[i]);
			keys[i].setForeground(Color.blue);
		}
		
		// operators: red; other keys: blue
		keys[3].setForeground(Color.red);  // "/"
		keys[8].setForeground(Color.red);  // "*"
		keys[13].setForeground(Color.red);  // "-"
		keys[18].setForeground(Color.red);  // "+"
		keys[19].setForeground(Color.red);  // "="
        
        // put all commands into one panel
        JPanel commandsPanel = new JPanel();
        // 1 row & 3 columns ...
        commandsPanel.setLayout(new GridLayout(1,3,3,3));
        for(int i = 0; i < COMMANDS.length;i++){
        	commands[i] = new JButton(COMMANDS[i]);
        	commandsPanel.add(commands[i]);
        	commands[i].setForeground(Color.red);
		}
        
        // put all M's into one panel
        JPanel calmsPanel = new JPanel();
        // 5 rows & 1 column ...
        calmsPanel.setLayout(new GridLayout(5,1,3,3));
        for (int i = 0; i < M.length; i++) {  
            m[i] = new JButton(M[i]);  
            calmsPanel.add(m[i]);  
            m[i].setForeground(Color.red);  
        } 
        
        // create a large panel, put commands' and keys' panels on it
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(3,3));
        panel1.add("North", commandsPanel);  
        panel1.add("West", calckeysPanel);
        
        // create a panel, put text field
        JPanel top = new JPanel();  
        top.setLayout(new BorderLayout());  
        top.add("Center", resultText);
        
        // overall layout
        getContentPane().setLayout(new BorderLayout(3,5));
        getContentPane().add("North", top);  
        getContentPane().add("Center", panel1);  
        getContentPane().add("West", calmsPanel); 
        
        // use the same action listener
        for (int i = 0; i < KEYS.length; i++) {  
            keys[i].addActionListener(this);  
        }  
        for (int i = 0; i < COMMANDS.length; i++) {  
            commands[i].addActionListener(this);  
        }  
        for (int i = 0; i < M.length; i++) {  
            m[i].addActionListener(this);  
        } 
	}

	/*
	 * handle events
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// retrieve event label
		String label = e.getActionCommand();
		if (label.equals(COMMANDS[0])){
			// backspace command
			handleBackspace();
		} else if (label.equals(COMMANDS[1])){
			// CE command
			resultText.setText("0");
			firstDigit = true;
		} else if (label.equals(COMMANDS[2])){
			// C command
			handleC();
		} else if ("0123456789.".indexOf(label) >= 0){
			// digits or dot
			handleDigits(label);
		} else {
			handleOperators(label);
		}
	}
	
	private void handleOperators(String key) {
		
		/* --------------------------------------
		 * -------Missing M operators!!!!!-------
		 * --------------------------------------
		 */
		
		if (operator.equals("=")){
			// the first operator handled is always "=", because it's initialized
			// i.e. the operators working flow: = -> + -> =
			resultNum = getNumberFromText();
		} else if (operator.equals("+")){
			resultNum += getNumberFromText();
		} else if (operator.equals("-")){
			resultNum -= getNumberFromText();
		} else if (operator.equals("*")){
			resultNum *= getNumberFromText();
		} else if (operator.equals("sqrt")){
			resultNum = Math.sqrt(resultNum);
		} else if (operator.equals("%")){
			// divide by 100
			resultNum = resultNum / 100;
		} else if (operator.equals("+/-")){
			// positive/negative
			resultNum = resultNum * (-1);
		} else if (operator.equals("1/x")){
			if (resultNum == 0.0){
				operateValidFlag = false; 
				resultText.setText("1/0 DNE"); 
			} else {
				resultNum = 1 / resultNum;
			}		
		}else if (operator.equals("/")){
			if (getNumberFromText() == 0.0){
				operateValidFlag = false;
				resultText.setText("divisor can't be 0");
			} else {
				resultNum /= getNumberFromText();
			}
		}
		
		if (operateValidFlag) {
			// out print the result
			resultText.setText(String.valueOf(resultNum));
		}
		
		// the current operator that the user acts
		operator = key;
		firstDigit = true;
		operateValidFlag = true;
		
	}

	private double getNumberFromText() {
		double result = 0;
		try {
			result = Double.valueOf(resultText.getText()).doubleValue();
		} catch (NumberFormatException e) {
			// ...
		}
		return result;
	}

	/*
	 * handle C command
	 */
	private void handleC() {
		// initialize the calculator
		resultText.setText("0");
		firstDigit = true;
		operator = "=";
		
	}

	private void handleDigits(String key) {
		if(firstDigit){
			// first digit
			resultText.setText(key);
		}else if(key.equals(".") && resultText.getText().indexOf(".") < 0){
			// no "." in the current text and key is "."
			resultText.setText(resultText.getText()+".");
		}else if(!key.equals(".")){
			// key is any number
			resultText.setText(resultText.getText()+key);
		}
		
		firstDigit = false;
	}

	/*
	 * handle backspace
	 */
	private void handleBackspace() {
		String text = resultText.getText();
		int len = text.length();
		if(len > 0){
			text = text.substring(0, len-1);
			if(text.length() == 0){
				// the original text has only one char
				// set text to 0 after pressing the Backspace button
				// a special case, has the same effect as pressing C command
				resultText.setText("0");
				firstDigit = true;
				operator = "=";
			}else{
				// the original text has more than one char
				// remove the last char after pressing the Backspace button 
				resultText.setText(text);
			}
		}		
	}

	public static void main(String[] args) {
		Calculator calculator1 = new Calculator();  
        calculator1.setVisible(true);  
        calculator1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

}
