import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FocusEvent1 extends JFrame 
{
	private JTextField textField1;
    	private JTextField textField2;
    	FocusEvent1() 
	{
        		setTitle("Focus Event Example");
        		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	 	setLayout(new FlowLayout());
        		textField1 = new JTextField(20);
        		textField1.addFocusListener(new FocusListener() 
		{
            		public void focusGained(FocusEvent e) 
			{
                			System.out.println("Text Field 1 has gained focus.");
            		}
            		public void focusLost(FocusEvent e) 
			{
                		System.out.println("Text Field 1 has lost focus.");
            		}
        		});
        		add(textField1);

        		textField2 = new JTextField(20);
        		textField2.addFocusListener(new FocusListener() 
		{
            		public void focusGained(FocusEvent e) 
			{
               		 	System.out.println("Text Field 2 has gained focus.");
            		}
			public void focusLost(FocusEvent e) 
			{
                			System.out.println("Text Field 2 has lost focus.");
            		}
        		});
        		add(textField2);

        		pack();
        		setLocationRelativeTo(null);
    	}
    	public static void main(String[] args) 
	{
        		SwingUtilities.invokeLater(new Runnable() 
		{
            		public void run() 
			{
               			 new FocusEvent1().setVisible(true);
           			 }
        		});
    	}
}