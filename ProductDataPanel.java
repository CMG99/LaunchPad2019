import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class ProductDataPanel extends AppPanel {

    private Object[][] productDetails = {{1,"Tomato-carton.jpg","Recycle",getContents("tomato-carton.txt","Recycle")},
                                         {2,"Charger-broken.png","Recycle",getContents("charger-broken.txt","Recycle"),
                                                                 "Donate",getContents("charger-broken.txt", "Donate")},
                                         {2,"plasticBottle.jpg","Recycle",getContents("plasticBottle.txt","Recycle"),
                                                                "DIY",getContents("plasticBottle.txt", "DIY")},
                                         {3,"Potato-peel.jpg","Recycle",getContents("potato-peel.txt","Recycle"),
                                                              "Recipe",getContents("potato-peel.txt", "Recipe"),
                                                              "Compost",getContents("potato-peel.txt", "Compost")}};
    private Object[] currentDetails;
    private ArrayList<Boolean> dropDownStates = new ArrayList<>();
    private String[] productDetailsString = {"tomato carton","charger broken","plastic bottle","potato peel"};
    private JPanel dropDownPanelMaster = new JPanel();
    private boolean hasHyperlink = false;
    private String hyperlink;

    public ProductDataPanel(String product){
        int index = indexOf(product,productDetailsString);
        currentDetails = productDetails[index];
        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
        GridBagConstraints constraint = new GridBagConstraints();

        GridBagLayout gridBag2 = new GridBagLayout();
        dropDownPanelMaster.setLayout(gridBag2);
        GridBagConstraints constraint2 = new GridBagConstraints();

        changeConstraintPadding(constraint, 2,2 );
        changeConstraintPadding(constraint2, 2,2 );

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

        JLabel productLabel = new JLabel(product);
        productLabel.setPreferredSize(new Dimension(400,50));
        productLabel.setFont(headingTextFont);
        changeConstraintPosition(constraint, 0, 0);
        addToPane(productLabel, constraint, gridBag, this);

        JLabel image = new JLabel(getImage((String)currentDetails[1]));
        changeConstraintPosition(constraint, 0, 1);
        changeConstraintGridSpan(constraint,2 ,-1 );
        addToPane(image, constraint, gridBag, this);

        for(int i=0;i<(int) currentDetails[0];i++){
            dropDownStates.add(false);
        }
        for(int i=0;i<(int) productDetails[index][0];i++){
            createDropDown((String) productDetails[index][2*(i+1)], (String) productDetails[index][2*(i+1)+1], i,constraint2,gridBag2);
        }

        changeConstraintPosition(constraint, 0, 2);
        addToPane(dropDownPanelMaster, constraint, gridBag, this);
    }

    private void createDropDown(String name, String contents, int index,GridBagConstraints constraint2, GridBagLayout gridBag2){
        JPanel dropDownPanel = new JPanel();
        GridBagLayout gridBag = new GridBagLayout();
        dropDownPanel.setLayout(gridBag);
        GridBagConstraints constraint = new GridBagConstraints();
        JLabel dropDownName = new JLabel(name);
        dropDownName.setFont(textFont);
        dropDownName.setBackground(new Color(50,50,50));
        dropDownName.setPreferredSize(new Dimension(500,30));
        dropDownName.setBorder(border);
        DefaultStyledDocument currentContents = new DefaultStyledDocument();

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
        dropDownName.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if((boolean) dropDownStates.get(index)){
                    System.out.println("close");
                    dropDownPanel.remove(dropDownContents);
                    dropDownStates.set(index,false);
                }
                else{
                    System.out.println("open");
                    changeConstraintPosition(constraint, 0, 1);
                    addToPane(dropDownContents, constraint, gridBag, dropDownPanel);
                    dropDownStates.set(index,true);
                }
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
            public void mousePressed(MouseEvent e) {
            }
            public void mouseReleased(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {

            }
        });
        changeConstraintPosition(constraint, 0, 0);
        addToPane(dropDownName, constraint, gridBag, dropDownPanel);

        changeConstraintPosition(constraint2, 0, index);
        addToPane(dropDownPanel, constraint2, gridBag2, dropDownPanelMaster);
    }

}
