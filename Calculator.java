

    import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[2];
    JButton mulButton;
    JButton equButton;
    JPanel panel;  
    double num1=0,num2=0,result=0;    
    char operator; 
    Calculator()
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        
        textfield.setEditable(false); 
        
        mulButton = new JButton("*");
        equButton = new JButton("=");   
        functionButtons[2] = mulButton;       
        //functionButtons[4] = equButton;              
        for(int i=0;i<2;i++)
        {
            functionButtons[i].addActionListener(this);
           
            functionButtons[i].setFocusable(false);
        }
        for(int i=0;i<10;i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
           
            numberButtons[i].setFocusable(false);
        }       
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));        
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);        
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);     
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);       
        panel.add(numberButtons[0]);
        panel.add(equButton);
        frame.add(panel);
        
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
         System.out.println("Welcome to Sample Calculator");
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++)
        {
            if(e.getSource() == numberButtons[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }       
        if(e.getSource() == mulButton)
        {
                num1= Double.parseDouble(textfield.getText());
                operator = '*';
                textfield.setText("");
        }        
        if(e.getSource() == equButton)
        {
            num2= Double.parseDouble(textfield.getText());
            switch(operator)
            {               
                case '*':
                    result = num1 * num2;
                    break;             
            }
            textfield.setText(String.valueOf(result));
            num1= result;
        }           
    }
}


    
    

