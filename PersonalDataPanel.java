import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalDataPanel extends AppPanel {

    public PersonalDataPanel(){
        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
        GridBagConstraints constraint = new GridBagConstraints();
        changeConstraintPadding(constraint, 5,10);

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500,100));
        topPanel.setBackground(appColour);
        topPanel.setLayout(new BorderLayout());



        JLabel image = new JLabel(getImage("LazyRecycleLogo.png"));
        topPanel.add(image,BorderLayout.CENTER);

        JButton backButton = new JButton(getImage("rightBackArrow.png"));
        backButton.setPreferredSize(new Dimension(100,30 ));
        backButton.setFont(textFont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterFrame.changePanel("StartingPanel");
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
        });
        topPanel.add(backButton,BorderLayout.EAST);

        changeConstraintPosition(constraint, 0, 0);
        addToPane(topPanel, constraint, gridBag, this);

        JLabel ProfileImage = new JLabel(getImage("UnknownProfile.png"));
        changeConstraintPosition(constraint, 0, 1);
        changeConstraintGridSpan(constraint,2 ,-1 );
        addToPane(ProfileImage, constraint, gridBag, this);

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(10,2));

        settingsPanel.add(new JLabel());
        settingsPanel.add(new JLabel());

        JLabel firstNameLabel = new JLabel(" First Name");
        firstNameLabel.setBorder(border);
        firstNameLabel.setPreferredSize(new Dimension(200,30));
        firstNameLabel.setFont(textFont);
        firstNameLabel.setBackground(whiteColour);
        firstNameLabel.setOpaque(true);
        settingsPanel.add(firstNameLabel);

        JTextArea firstNameField = new JTextArea();
        firstNameField.setPreferredSize(new Dimension(200,30));
        firstNameField.setFont(textFont);
        firstNameField.setBorder(border);
        settingsPanel.add(firstNameField);

        settingsPanel.add(new JLabel());
        settingsPanel.add(new JLabel());

        JLabel phoneNumberLabel = new JLabel(" Phone Number");
        phoneNumberLabel.setBorder(border);
        phoneNumberLabel.setPreferredSize(new Dimension(200,30));
        phoneNumberLabel.setFont(textFont);
        phoneNumberLabel.setBackground(whiteColour);
        phoneNumberLabel.setOpaque(true);
        settingsPanel.add(phoneNumberLabel);


        JTextArea phoneNumberField = new JTextArea();
        phoneNumberField.setBorder(border);
        phoneNumberField.setPreferredSize(new Dimension(200,30));
        phoneNumberField.setFont(textFont);
        settingsPanel.add(phoneNumberField);

        settingsPanel.add(new JLabel());
        settingsPanel.add(new JLabel());

        JLabel universityEmailLabel = new JLabel(" University Email");
        universityEmailLabel.setBorder(border);
        universityEmailLabel.setPreferredSize(new Dimension(200,30));
        universityEmailLabel.setFont(textFont);
        universityEmailLabel.setBackground(whiteColour);
        universityEmailLabel.setOpaque(true);
        settingsPanel.add(universityEmailLabel);

        JTextArea universityField = new JTextArea();
        universityField.setBorder(border);
        universityField.setPreferredSize(new Dimension(200,30));
        universityField.setFont(textFont);
        settingsPanel.add(universityField);

        settingsPanel.add(new JLabel());
        settingsPanel.add(new JLabel());

        JLabel postCodeLabel = new JLabel(" Post Code");
        postCodeLabel.setBorder(border);
        postCodeLabel.setPreferredSize(new Dimension(200,30));
        postCodeLabel.setFont(textFont);
        postCodeLabel.setBackground(whiteColour);
        postCodeLabel.setOpaque(true);
        settingsPanel.add(postCodeLabel);

        JTextArea postCodeField = new JTextArea();
        postCodeField.setBorder(border);
        postCodeField.setPreferredSize(new Dimension(200,30));
        postCodeField.setFont(textFont);
        settingsPanel.add(postCodeField);

        settingsPanel.add(new JLabel());
        settingsPanel.add(new JLabel());

        JButton saveButton = new JButton(getImage("saveButton.png"));
        saveButton.setPreferredSize(new Dimension(100,30));
        saveButton.setFont(textFont);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        settingsPanel.add(new JLabel());
        settingsPanel.add(saveButton);



        changeConstraintPosition(constraint, 0, 2);
        addToPane(settingsPanel, constraint, gridBag, this);
    }
}

