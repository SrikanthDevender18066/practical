import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
class SelectionEvent1 extends JFrame 
{
	private JTable table;
    	public SelectionEvent1() 
	{
		setTitle("Table Selection Event ");
        		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		setLayout(new BorderLayout());
        		String[][] data = { {"alandi", "kadam", "18"},{"karishma", "chaursiya", "18"},{"nupur", "kakade", "19"},
		  		{"sanika", "ture", "20"},{"drishti", "gupta", "19"},{"amruta", "satpute", "20"}};
        		String[] columnNames = {"First Name", "Last Name", "Age"};
        		
		table = new JTable(data, columnNames);
        		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        		table.getSelectionModel().addListSelectionListener(new ListSelectionListener()
 		{
            		public void valueChanged(ListSelectionEvent e) 
			{
               			 if (!e.getValueIsAdjusting()) 
				{
                   				int selectedRow = table.getSelectedRow();
                    				if (selectedRow != -1) 
					{ 
                       		 			String firstName = (String) table.getValueAt(selectedRow, 0);
                        				String lastName = (String) table.getValueAt(selectedRow, 1);
                        				String age = (String) table.getValueAt(selectedRow, 2);
                        				System.out.println("Selected Row: " + firstName + " " + lastName + 						", Age: " + age);
                    				}
                			}
            		}
        		});
        		JScrollPane scrollPane = new JScrollPane(table);
        		add(scrollPane, BorderLayout.CENTER);
        		pack();	
		setLocationRelativeTo(null);
    	}
    	public static void main(String[] args) 
	{
        		SwingUtilities.invokeLater(new Runnable() 
		{	
			public void run() {
                			new SelectionEvent1().setVisible(true);
            		}
        		});
   	 }
}