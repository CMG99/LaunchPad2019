import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingPanel extends AppPanel{

    public ShoppingPanel(){
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500,100));
        topPanel.setBackground(appColour);
        topPanel.setLayout(new BorderLayout());

        JButton backButton = new JButton(getImage("leftBackButton.png"));
        backButton.setPreferredSize(new Dimension(100,100));
        backButton.setFont(textFont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterFrame.changePanel("StartingPanel");
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
        });
        topPanel.add(backButton,BorderLayout.WEST);

        JLabel logoLabel = new JLabel(getImage("LazyRecycleLogo.png"));
        logoLabel.setPreferredSize(new Dimension(400,50));
        logoLabel.setFont(headingTextFont);
        topPanel.add(logoLabel,BorderLayout.CENTER);
    }
}
