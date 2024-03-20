import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TravelManagementSystemGUI extends JFrame implements ActionListener {
    private JLabel titleLabel, packageLabel, dateLabel, passengerLabel;
    private JTextField dateField, passengerField;
    private JButton submitButton;
    private JComboBox<String> packageComboBox;

    public TravelManagementSystemGUI() {
        setTitle("Tourism Package Management System");
        setSize(500, 300);
        setLayout(null);

        titleLabel = new JLabel("Tourism Package Management System");
        titleLabel.setBounds(100, 10, 300, 20);
        add(titleLabel);

        packageLabel = new JLabel("Select Package:");
        packageLabel.setBounds(50, 50, 150, 20);
        add(packageLabel);

        String[] packages = {"Shimla Tour", "Kashmir Tour", "Kolkata Tour", "England Tour", "Thailand Tour", "New York Tour"};
        packageComboBox = new JComboBox<>(packages);
        packageComboBox.setBounds(200, 50, 200, 20);
        add(packageComboBox);

        dateLabel = new JLabel("Enter Date (DD/MM/YY):");
        dateLabel.setBounds(50, 90, 150, 20);
        add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(200, 90, 200, 20);
        add(dateField);

        passengerLabel = new JLabel("Enter Number Of Passengers:");
        passengerLabel.setBounds(50, 130, 200, 20);
        add(passengerLabel);

        passengerField = new JTextField();
        passengerField.setBounds(250, 130, 50, 20);
        add(passengerField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(200, 170, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            int numberOfPassengers = Integer.parseInt(passengerField.getText());
            String selectedPackage = (String) packageComboBox.getSelectedItem();
            String selectedDate = dateField.getText();

            // Call the existing methods with the provided inputs
            TravelManagementSystem.addNode(selectedPackage, "", numberOfPassengers);
            TravelManagementSystem.date = selectedDate;

            TravelManagementSystem.receipt();
            TravelManagementSystem.displayPassengerDetails();
        }
    }

    public static void main(String[] args) {
        new TravelManagementSystemGUI();
    }
}
