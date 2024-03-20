import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class IndianDemocracySurveyGUI extends JFrame implements ActionListener {
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private JLabel questionLabel;
    private ButtonGroup optionsGroup;
    private JButton nextButton;

    public IndianDemocracySurveyGUI() {
        setTitle("Indian Democracy Survey");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        questionLabel = new JLabel();
        optionsGroup = new ButtonGroup();
        nextButton = new JButton("Next");

        // Set up question label
        questionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        // Set up options panel
        JPanel optionsPanel = new JPanel(new GridLayout(0, 1));
        add(optionsPanel, BorderLayout.CENTER);

        // Set up next button
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);

        // Adding questions to the survey
        addQuestion("Question 1: I believe that democracy is thriving in India.", new String[]{"Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree"});
        addQuestion("Question 2: Do you think that Indian elections are free and fair?", new String[]{"Yes", "No"});
        addQuestion("Question 3: How satisfied are you with the functioning of Indian Parliament?", new String[]{"Very Satisfied", "Satisfied", "Neutral", "Dissatisfied", "Very Dissatisfied"});
        addQuestion("Question 4: Do you feel that your voice is heard in the Indian political system?", new String[]{"Yes, always", "Most of the time", "Sometimes", "Rarely", "No, never"});
        addQuestion("Question 5: Is there enough transparency in the decision-making process of Indian government?", new String[]{"Yes", "No", "Not Sure"});
        addQuestion("Question 6: How would you rate the level of corruption in India?", new String[]{"Very High", "High", "Moderate", "Low", "Very Low"});
        addQuestion("Question 7: Do you believe that media in India is free and unbiased?", new String[]{"Yes", "No", "Not Sure"});
        addQuestion("Question 8: Do you think that caste-based discrimination is still prevalent in India?", new String[]{"Yes", "No"});

        // Display the first question
        displayQuestion();
    }

    public void addQuestion(String questionText, String[] options) {
        Question question = new Question(questionText, options);
        questions.add(question);
    }

    public void displayQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText(currentQuestion.getQuestionText());

        // Clear options panel
        optionsGroup.clearSelection();
        optionsGroup = new ButtonGroup();
        JPanel optionsPanel = (JPanel) getContentPane().getComponent(1);
        optionsPanel.removeAll();

        // Add options to the panel
        for (String option : currentQuestion.getOptions()) {
            JRadioButton radioButton = new JRadioButton(option);
            radioButton.setActionCommand(option);
            optionsGroup.add(radioButton);
            optionsPanel.add(radioButton);
        }

        // Enable/disable next button based on question index
        nextButton.setEnabled(currentQuestionIndex < questions.size() - 1);
        revalidate();
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        // Record the answer
        String selectedOption = optionsGroup.getSelection().getActionCommand();
        System.out.println("Answer to question " + (currentQuestionIndex + 1) + ": " + selectedOption);

        // Move to the next question
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            displayQuestion();
        } else {
            // End of survey
            JOptionPane.showMessageDialog(this, "Thank you for completing the Indian Democracy Survey!", "Survey Completed", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the GUI
        }
    }

    public static void main(String[] args) {
        new IndianDemocracySurveyGUI().setVisible(true);
    }
}

class Question {
    private String questionText;
    private String[] options;

    public Question(String questionText, String[] options) {
        this.questionText = questionText;
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }
}
