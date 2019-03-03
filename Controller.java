import javax.swing.*;

public class Controller {

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                }
                catch (Exception e){System.out.println("failed");}
                JFrame masterFrame = new JFrame("LazyRecycle");
                masterFrame.setSize(550,700);
                masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                masterFrame.setVisible(true);
                new MasterFrame(masterFrame);



            }
        });
    }
}
