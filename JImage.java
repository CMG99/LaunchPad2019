import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JImage extends AppPanel {

    private BufferedImage image;

    public JImage(String name) {

    }
    public BufferedImage getImage(){
        return image;
    }


}