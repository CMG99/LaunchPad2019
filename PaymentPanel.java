import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPanel extends AppPanel{
    public PaymentPanel(int amountOfBins, int amountOfTape){

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
        GridBagConstraints constraint = new GridBagConstraints();

        JPanel topPanel = new JPanel();
        topPanel.setBackground(appColour);
        topPanel.setLayout(new BorderLayout());
        topPanel.setSize(500,100);

        JButton backButton = new JButton(getImage("leftBackButton.png"));
        backButton.setPreferredSize(new Dimension(100,100));
        backButton.setFont(textFont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterFrame.changePanel("ShoppingPanel");
                SwingUtilities.updateComponentTreeUI(MasterFrame.masterFrame);
            }
        });
        topPanel.add(backButton,BorderLayout.WEST);

        JLabel logoLabel = new JLabel(getImage("LazyRecycleLogo.png"));
        logoLabel.setPreferredSize(new Dimension(400,50));
        logoLabel.setFont(headingTextFont);
        topPanel.add(logoLabel,BorderLayout.CENTER);

        changeConstraintPosition(constraint, 0, 0);
        addToPane(topPanel, constraint, gridBag, this);

        JLabel shoppingTitleLabel = new JLabel("Shopping Basket");
        shoppingTitleLabel.setFont(headingTextFont);
        changeConstraintPosition(constraint, 0, 1);
        addToPane(shoppingTitleLabel, constraint, gridBag, this);

        JPanel boughtItemsPanel = new JPanel();
        GridBagLayout gridBag2 = new GridBagLayout();
        boughtItemsPanel.setLayout(gridBag2);
        GridBagConstraints constraint2 = new GridBagConstraints();

        JLabel productLabel = new JLabel("Product");
        productLabel.setBorder(border);
        productLabel.setFont(textFont);
        changeConstraintPosition(constraint2, 0, 0);
        addToPane(productLabel, constraint2, gridBag2, boughtItemsPanel);

        JLabel qtyLabel = new JLabel("Qty");
        qtyLabel.setBorder(border);
        qtyLabel.setFont(textFont);
        changeConstraintPosition(constraint2, 1, 0);
        addToPane(qtyLabel, constraint2, gridBag2, boughtItemsPanel);

        JLabel totalLabel = new JLabel("Total");
        totalLabel.setBorder(border);
        totalLabel.setFont(textFont);
        changeConstraintPosition(constraint2, 2, 0);
        addToPane(totalLabel, constraint2, gridBag2, boughtItemsPanel);

        JLabel binProductLabel = new JLabel("Bin Separator");
        binProductLabel.setBorder(border);
        binProductLabel.setFont(textFont);
        changeConstraintPosition(constraint2, 0, 1);
        addToPane(binProductLabel, constraint2, gridBag2, boughtItemsPanel);

        JLabel binQtyLabel = new JLabel(String.valueOf(amountOfBins));
        binQtyLabel.setBorder(border);
        binQtyLabel.setFont(textFont);
        changeConstraintPosition(constraint2, 1, 1);
        addToPane(binQtyLabel, constraint2, gridBag2, boughtItemsPanel);

        JLabel binTotalLabel = new JLabel("£"+String.valueOf(amountOfBins*4.99));
        binTotalLabel.setBorder(border);
        binTotalLabel.setFont(textFont);
        changeConstraintPosition(constraint2, 2, 1);
        addToPane(binTotalLabel, constraint2, gridBag2, boughtItemsPanel);

        JLabel tapeProductLabel = new JLabel("Reflective tape (pack of 3)");
        tapeProductLabel.setBorder(border);
        tapeProductLabel.setFont(textFont);
        changeConstraintPosition(constraint2, 0, 2);
        addToPane(tapeProductLabel, constraint2, gridBag2, boughtItemsPanel);

        JLabel tapeQtyLabel = new JLabel(String.valueOf(amountOfTape));
        tapeQtyLabel.setBorder(border);
        tapeQtyLabel.setFont(textFont);
        changeConstraintPosition(constraint2, 1, 2);
        addToPane(tapeQtyLabel, constraint2, gridBag2, boughtItemsPanel);

        JLabel tapeTotalLabel = new JLabel("£"+String.valueOf(amountOfTape*4.99));
        tapeTotalLabel.setBorder(border);
        tapeTotalLabel.setFont(textFont);
        changeConstraintPosition(constraint2, 2, 2);
        addToPane(tapeTotalLabel, constraint2, gridBag2, boughtItemsPanel);

        changeConstraintPosition(constraint, 0, 2);
        addToPane(boughtItemsPanel, constraint, gridBag, this);

        JLabel addressTitleLabel = new JLabel("Delivery Address");
        addressTitleLabel.setFont(headingTextFont);
        changeConstraintPosition(constraint, 0, 3);
        addToPane(addressTitleLabel, constraint, gridBag, this);


        JPanel  deliveryPanel = new JPanel();
        deliveryPanel.setLayout(new GridLayout(8,2));

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBorder(border);
        nameLabel.setFont(textFont);
        nameLabel.setPreferredSize(new Dimension(150, 30));
        changeConstraintPosition(constraint2, 1, 2);
        deliveryPanel.add(nameLabel);

        JTextArea nameField = new JTextArea();
        nameField.setPreferredSize(new Dimension(200,30));
        nameField.setFont(textFont);
        nameField.setBorder(border);
        deliveryPanel.add(nameField);

        deliveryPanel.add(new JLabel());
        deliveryPanel.add(new JLabel());

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBorder(border);
        addressLabel.setFont(textFont);
        addressLabel.setPreferredSize(new Dimension(150, 30));
        changeConstraintPosition(constraint2, 1, 2);
        deliveryPanel.add(addressLabel);

        JTextArea addressField = new JTextArea();
        addressField.setPreferredSize(new Dimension(200,30));
        addressField.setFont(textFont);
        addressField.setBorder(border);
        deliveryPanel.add(addressField);

        deliveryPanel.add(new JLabel());
        deliveryPanel.add(new JLabel());

        JLabel cityLabel = new JLabel("City");
        cityLabel.setBorder(border);
        cityLabel.setFont(textFont);
        cityLabel.setPreferredSize(new Dimension(150, 30));
        changeConstraintPosition(constraint2, 1, 2);
        deliveryPanel.add(cityLabel);

        JTextArea cityField = new JTextArea();
        cityField.setPreferredSize(new Dimension(200,30));
        cityField.setFont(textFont);
        cityField.setBorder(border);
        deliveryPanel.add(cityField);

        deliveryPanel.add(new JLabel());
        deliveryPanel.add(new JLabel());

        JLabel postcodeLabel = new JLabel("Postcode");
        postcodeLabel.setBorder(border);
        postcodeLabel.setFont(textFont);
        postcodeLabel.setPreferredSize(new Dimension(150, 30));
        changeConstraintPosition(constraint2, 1, 2);
        deliveryPanel.add(postcodeLabel);

        JTextArea postcodeField = new JTextArea();
        postcodeField.setPreferredSize(new Dimension(200,30));
        postcodeField.setFont(textFont);
        postcodeField.setBorder(border);
        deliveryPanel.add(postcodeField);

        changeConstraintPosition(constraint, 0, 4);
        addToPane(deliveryPanel, constraint, gridBag, this);

        JLabel paypal = new JLabel(getImage("paypal.png"));
        changeConstraintPosition(constraint, 0, 5);
        addToPane(paypal, constraint, gridBag, this);


    }
}
