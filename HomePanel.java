import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class HomePanel extends AppPanel{

    private String[][] homePageDetails = {{"Recycle",getContents("homePage.txt", "Recycle")},
                                          {"Donate",getContents("homePage.txt", "Donate")},
                                          {"DIY",getContents("homePage.txt", "DIY")},
                                          {"Recipe",getContents("homePage.txt", "Recipe")}};

    private boolean hasHyperlink = false;
    private String hyperlink;

    private JPanel dropDownPanelMaster = new JPanel();

    public HomePanel(){
        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
        GridBagConstraints constraint = new GridBagConstraints();

        GridBagLayout gridBag2 = new GridBagLayout();
        dropDownPanelMaster.setLayout(gridBag2);
        GridBagConstraints constraint2 = new GridBagConstraints();

        changeConstraintPadding(constraint, 2,2 );
        changeConstraintPadding(constraint2, 2,2 );

        for(int i=0;i<homePageDetails.length;i++){
            if(i==0){
                createDropDown(homePageDetails[i][0], homePageDetails[i][1], i, 0, 0, constraint2,gridBag2 );
            }
            else if(i==1){
                createDropDown(homePageDetails[i][0], homePageDetails[i][1], i, 1, 0, constraint2,gridBag2 );
            }
            else if(i==2){
                createDropDown(homePageDetails[i][0], homePageDetails[i][1], i, 0, 1, constraint2,gridBag2 );
            }
            else {
                createDropDown(homePageDetails[i][0], homePageDetails[i][1], i, 1, 1, constraint2,gridBag2 );
            }
        }


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
        changeConstraintPosition(constraint, 0, 0);
        addToPane(backButton, constraint, gridBag, this);


        JLabel titleLabel = new JLabel("WTF is this app ?");
        titleLabel.setPreferredSize(new Dimension(400,50));
        titleLabel.setFont(headingTextFont);

        changeConstraintPosition(constraint, 1, 0);
        addToPane(titleLabel, constraint, gridBag, this);

        changeConstraintPosition(constraint, 0, 1);
        changeConstraintGridSpan(constraint,0,-1 );
        addToPane(dropDownPanelMaster, constraint, gridBag, this);


        JLabel image = new JLabel(getImage("SocialMedias.png"));
        changeConstraintPosition(constraint, 0, 2);
        addToPane(image, constraint, gridBag, this);


    }

    private void createDropDown(String name, String contents, int index, int x, int y, GridBagConstraints constraint2, GridBagLayout gridBag2){
        JPanel dropDownPanel = new JPanel();
        GridBagLayout gridBag = new GridBagLayout();
        dropDownPanel.setLayout(gridBag);
        GridBagConstraints constraint = new GridBagConstraints();
        JLabel dropDownName = new JLabel(name);
        dropDownName.setFont(textFont);
        dropDownName.setBackground(new Color(50,50,50));
        dropDownName.setPreferredSize(new Dimension(200,30));
        dropDownName.setBorder(border);
        changeConstraintPosition(constraint, 0, 0);
        addToPane(dropDownName, constraint, gridBag, dropDownPanel);

        JTextPane dropDownContents = new JTextPane();
        dropDownContents.setBorder(border);
        dropDownContents.setText(contents);
        dropDownContents.setEditable(false);
        for(String line : contents.split("\n")){
            if(line.contains("http")){
                hasHyperlink = true;
                hyperlink = line;
            }
        }
        if(hasHyperlink){
            dropDownContents.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    try {
                        Desktop.getDesktop().browse(new URI(hyperlink));
                    }
                    catch (URISyntaxException e){}
                    catch(IOException e2){}
                }
                public void mousePressed(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
            });
        }

        changeConstraintPosition(constraint, 0, 1);
        addToPane(dropDownContents, constraint, gridBag, dropDownPanel);

        changeConstraintPosition(constraint2, x, y);
        addToPane(dropDownPanel, constraint2, gridBag2, dropDownPanelMaster);
    }
}
