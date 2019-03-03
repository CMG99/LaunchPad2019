import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingPanel extends AppPanel{

    public ShoppingPanel(){

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
        GridBagConstraints constraint = new GridBagConstraints();

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
                MasterFrame.changePanel("HomePanel");
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
        });
        topPanel.add(backButton,BorderLayout.WEST);

        JLabel logoLabel = new JLabel(getImage("LazyRecycleLogo.png"));
        logoLabel.setPreferredSize(new Dimension(400,50));
        logoLabel.setFont(headingTextFont);
        topPanel.add(logoLabel,BorderLayout.CENTER);

        JLabel productsLabel = new JLabel("Our Products");
        changeConstraintPosition(constraint, 0, 1);
        addToPane(productsLabel, constraint, gridBag, this);

        JPanel binPanel = new JPanel();
        GridBagLayout gridBag2 = new GridBagLayout();
        binPanel.setBorder(border);
        binPanel.setLayout(gridBag2);
        GridBagConstraints constraint2 = new GridBagConstraints();

        JLabel binCostLabel = new JLabel("<html>Bin Separator <br>£4.99</html>");
        changeConstraintPosition(constraint2, 0, 0);
        changeConstraintGridSpan(constraint2,-1 ,2);
        addToPane(binCostLabel, constraint2, gridBag2, binPanel);

        changeConstraintGridSpan(constraint2,-1 ,-1);

        JLabel binQtyLabel = new JLabel("Qty");
        changeConstraintPosition(constraint2, 1, 0);
        addToPane(binQtyLabel, constraint2, gridBag2, binPanel);

        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        changeConstraintPosition(constraint2, 1, 1);
        addToPane(spinner, constraint2, gridBag2, binPanel);

        JLabel image1 = new JLabel(getImage("bin1.JPG"));
        changeConstraintPosition(constraint2, 0, 2);
        addToPane(image1, constraint2, gridBag2, binPanel);

        JLabel image2 = new JLabel(getImage("bin2.JPG"));
        changeConstraintPosition(constraint2, 1, 2);
        addToPane(image2, constraint2, gridBag2, binPanel);


        changeConstraintPosition(constraint, 0, 2);
        addToPane(binPanel, constraint, gridBag, this);


        JPanel tapePanel = new JPanel();
        tapePanel.setBorder(border);
        GridBagLayout gridBag3 = new GridBagLayout();
        tapePanel.setLayout(gridBag3);
        GridBagConstraints constraint3 = new GridBagConstraints();

        JLabel tapeCostLabel = new JLabel("<html>Reflective tape (pack of 3)<br>£14.99</html>");
        changeConstraintPosition(constraint3, 0, 0);
        changeConstraintGridSpan(constraint3,-1 ,2);
        addToPane(tapeCostLabel, constraint3, gridBag3, tapePanel);

        changeConstraintGridSpan(constraint3,-1 ,-1);

        JLabel tapeQtyLabel = new JLabel("Qty");
        changeConstraintPosition(constraint3, 1, 0);
        addToPane(tapeQtyLabel, constraint3, gridBag3, tapePanel);

        JSpinner spinner2 = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        changeConstraintPosition(constraint3, 1, 1);
        addToPane(spinner2, constraint3, gridBag3, tapePanel);

        JLabel image3 = new JLabel(getImage("reflectiveTape1.JPG"));
        changeConstraintPosition(constraint3, 0, 2);
        addToPane(image3, constraint3, gridBag3, tapePanel);

        JLabel image4 = new JLabel(getImage("reflectiveTape2.JPG"));
        changeConstraintPosition(constraint3, 1, 2);
        addToPane(image4, constraint3, gridBag3, tapePanel);

        changeConstraintPosition(constraint, 0, 3);
        addToPane(tapePanel, constraint, gridBag, this);

        JButton cartButton = new JButton(getImage("shoppingBasket.png"));
        cartButton.setPreferredSize(new Dimension(100,100));
        cartButton.setFont(textFont);
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterFrame.appPanels[MasterFrame.indexOf("PaymentPanel",MasterFrame.appPanelsString)] = new PaymentPanel((int) spinner.getValue(),(int) spinner2.getValue());

                MasterFrame.changePanel("PaymentPanel");
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
        });
        topPanel.add(cartButton,BorderLayout.EAST);

        changeConstraintPosition(constraint, 0, 0);
        addToPane(topPanel, constraint, gridBag, this);




    }
}
