import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AppPanel extends JPanel {

    protected Font textFont = new Font("Arial",Font.PLAIN,20);
    protected Font headingTextFont = new Font("Arial",Font.PLAIN,45);
    protected Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
    protected Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
    protected Color appColour = new Color(126,217,87);
    protected Color whiteColour = new Color(255,255,255);

    protected String imagePath = System.getProperty("user.dir")+"\\images";
    static protected String productInfoPath = System.getProperty("user.dir")+"\\ProductInformations";

    public AppPanel(){

    }

    protected int indexOf(String element, String[] array){
        for(int i=0;i<array.length;i++){
            if(array[i].equals(element)){
                return i;
            }
        }
        return 0;
    }

    protected void changeConstraintPosition(GridBagConstraints constraint, int column, int row){
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = column;
        constraint.gridy = row;
    }

    protected void changeConstraintPadding(GridBagConstraints constraint, int paddingX, int paddingY){
        Insets currentInsects = new Insets(paddingY,paddingX,paddingY,paddingX);
        constraint.insets = currentInsects;
    }

    protected void changeConstraintGridSpan(GridBagConstraints constraint, int xSpan, int ySpan){
        constraint.gridwidth = xSpan;
        constraint.gridheight = ySpan;
    }

    protected void addToPane(JComponent component,GridBagConstraints constraint,GridBagLayout gridBag, Container pane){
        gridBag.setConstraints(component,constraint);
        pane.add(component);
    }

    protected static String getContents(String file, String dropDownBox){
        String currentString = "";
        FileReader reader;
        BufferedReader fileReader;
        try {
            reader = new FileReader(productInfoPath+"\\"+file);
            fileReader = new BufferedReader(reader);
        }
        catch(IOException e) {
            System.out.println("ERROR");
            return "";
        }
        boolean startRecordingData = false;
        try {
            for (String line = fileReader.readLine(); line!=null;line = fileReader.readLine()){
                if(line.equals("NEW DROPDOWN BOX "+dropDownBox)){
                    startRecordingData = true;
                    continue;
                }
                if(startRecordingData){
                    if(line.contains("NEW DROPDOWN BOX")){
                        break;
                    }
                    currentString+=line+"\n";
                }

            }
        }
        catch(IOException e){ }
        System.out.println("text: ");
        System.out.println(currentString);
        return currentString;
    }

    protected ImageIcon getImage(String name){
        try {
            return new ImageIcon(ImageIO.read(new File(imagePath+"\\"+name)));
        }
        catch (IOException ex) {
            try {
                new ImageIcon(ImageIO.read(new File(imagePath + "\\ImageNotFound.png")));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
