

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;



public class StartingPanel extends AppPanel{

    private String[] searchResults =  {"tomato stem","tomato peel","tomato juice","tomato carton",
                                       "aluminium can","aluminium foil",
                                       "charger broken",
                                       "plastic bottle",
                                       "potato peel",
                                       "ripped jeans"};

    public StartingPanel(){
        setLayout(new BorderLayout());
        createTopPanel();
        createMidPanel();
        createBotPanel();
    }

    private void createTopPanel(){
        JPanel topPanel = new JPanel();
        topPanel.setBackground(appColour);
        topPanel.setLayout(new BorderLayout());
        JButton personalDataButton = new JButton(getImage("Settings.png"));
        personalDataButton.setPreferredSize(new Dimension(100,100 ));
        personalDataButton.setFont(textFont);
        personalDataButton.setBackground(appColour);
        personalDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterFrame.changePanel("PersonalDataPanel");
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
        });

        topPanel.add(personalDataButton,BorderLayout.WEST);

        JLabel image = new JLabel(getImage("LazyRecycleLogo.png"));
        topPanel.add(image,BorderLayout.CENTER);

        JButton homeButton = new JButton(getImage("Home.png"));
        homeButton.setPreferredSize(new Dimension(100,100));
        homeButton.setFont(textFont);
        homeButton.setBackground(appColour);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterFrame.changePanel("HomePanel");
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
        });
        topPanel.add(homeButton,BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
    }

    private void createMidPanel(){
        JPanel midPanel = new JPanel();
        midPanel.setBackground(new Color(100,100,100));
        midPanel.setLayout(new GridLayout());
        JLabel cameraLabel = new JLabel("");
        cameraLabel.setPreferredSize(new Dimension(400,400));
        midPanel.add(cameraLabel);

        add(midPanel, BorderLayout.CENTER);
    }

    private void createBotPanel(){
        JPanel botPanel = new JPanel();
        botPanel.setBackground(appColour);
        botPanel.setPreferredSize(new Dimension(500, 150));
        GridBagLayout gridBag = new GridBagLayout();
        botPanel.setLayout(gridBag);
        GridBagConstraints constraint = new GridBagConstraints();

        JLabel botSearchLabel = new JLabel(" Search...");
        botSearchLabel.setPreferredSize(new Dimension(100,50 ));
        botSearchLabel.setFont(textFont);
        botSearchLabel.setOpaque(true);
        botSearchLabel.setBackground(appColour);
        changeConstraintPosition(constraint, 0, 0);
        addToPane(botSearchLabel,constraint,gridBag,botPanel);

        JTextArea botSearchField = new JTextArea();
        botSearchField.setPreferredSize(new Dimension(300,30 ));
        botSearchField.setFont(textFont);
        changeConstraintPosition(constraint, 1, 0);
        addToPane(botSearchField,constraint,gridBag,botPanel);

        JButton botVoiceButton = new JButton(getImage("Microphone.png"));
        botVoiceButton.setPreferredSize(new Dimension(50,50 ));
        botVoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        changeConstraintPosition(constraint, 2, 0);
        addToPane(botVoiceButton,constraint,gridBag,botPanel);

        JComboBox botSearchCombo = new JComboBox();
        changeConstraintPosition(constraint, 0, 1);
        changeConstraintGridSpan(constraint, 2, 0);
        //changeConstraintGridSpan(constraint, 0, 0);
        addToPane(botSearchCombo, constraint, gridBag, botPanel);

        botSearchField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent event) {
                DefaultComboBoxModel model = new DefaultComboBoxModel(getSearchResults(botSearchField.getText()+event.getKeyChar()));
                botSearchCombo.setModel(model);
            }
            public void keyPressed(KeyEvent event){
                if(event.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    DefaultComboBoxModel model = new DefaultComboBoxModel(getSearchResults(botSearchField.getText()));
                    botSearchCombo.setModel(model);
                }
            }
            public void keyReleased(KeyEvent event){

            }
        });

        JButton botSelectButton = new JButton(getImage("Search.png"));
        botSelectButton.setPreferredSize(new Dimension(50,50 ));
        botSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterFrame.appPanels[indexOf("ProductDataPanel",MasterFrame.appPanelsString)] = new ProductDataPanel((String) botSearchCombo.getSelectedItem());
                MasterFrame.changePanel("ProductDataPanel");
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
        });
        changeConstraintPosition(constraint, 2, 1);
        addToPane(botSelectButton,constraint,gridBag,botPanel);

        add(botPanel, BorderLayout.SOUTH);
    }

    private String[] getSearchResults(String currentSearchResult){
        ArrayList<String> returnList = new ArrayList<String>();
        for(String searchResult : searchResults){
            if(searchResult.contains(currentSearchResult)){
                returnList.add(searchResult);
            }
        }
        return (String[]) returnList.toArray(new String[0]);
    }
}
