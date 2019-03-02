import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalDataPanel extends AppPanel {

    public PersonalDataPanel(){
        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
        GridBagConstraints constraint = new GridBagConstraints();

        JLabel productLabel = new JLabel("Settings");
        productLabel.setPreferredSize(new Dimension(400,50));
        productLabel.setFont(headingTextFont);
        changeConstraintPosition(constraint, 0, 0);
        addToPane(productLabel, constraint, gridBag, this);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100,30 ));
        backButton.setFont(textFont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterFrame.changePanel("StartingPanel");
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
        });
        changeConstraintPosition(constraint, 1, 0);
        addToPane(backButton, constraint, gridBag, this);



        JLabel image = new JLabel(getImage("UnknownProfile.png"));
        changeConstraintPosition(constraint, 0, 1);
        changeConstraintGridSpan(constraint,2 ,-1 );
        addToPane(image, constraint, gridBag, this);

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout());

        JLabel FirstNameLabel = new JLabel(" First Name");
        FirstNameLabel.setPreferredSize(new Dimension(200,50));
        productLabel.setFont(textFont);
        settingsPanel.add()


    }
}

