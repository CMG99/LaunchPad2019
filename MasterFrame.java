import javax.swing.*;
import java.awt.*;

public class MasterFrame {

    public static JFrame masterFrame;

    public static JPanel[] appPanels = {new StartingPanel(), new AppPanel(), new HomePanel(), new PersonalDataPanel(), new ShoppingPanel(), new AppPanel()};
    public static String[] appPanelsString = {"StartingPanel","ProductDataPanel","HomePanel","PersonalDataPanel","ShoppingPanel","PaymentPanel"};

    public MasterFrame(JFrame masterFrame){
        this.masterFrame = masterFrame;
        masterFrame.setLayout(new FlowLayout());
        changePanel("StartingPanel");
    }

    public static void changePanel(String panelName){
        int index = indexOf(panelName, appPanelsString);
        for(int i=0;i<appPanels.length;i++){
            if(i==index){
                System.out.println(appPanelsString[i]+" "+String.valueOf(true));
                masterFrame.add(appPanels[i]);
            }
            else{
                System.out.println(appPanelsString[i]+" "+String.valueOf(false));
                masterFrame.remove(appPanels[i]);
            }
        }
    }

    public static int indexOf(String element, String[] array){
        for(int i=0;i<array.length;i++){
            if(array[i].equals(element)){
                return i;
            }
        }
        return 0;
    }
}
