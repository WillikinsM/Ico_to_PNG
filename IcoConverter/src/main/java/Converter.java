import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import net.sf.image4j.codec.ico.ICODecoder;
import javax.swing.*;

public class Converter {

    public static void main(String[] args) throws IOException {

        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String name = selectedFile.getName().split("\\.")[0];
            List<BufferedImage> images = ICODecoder.read(selectedFile);
            ImageIO.write(images.get(0), "png", new File(name+".png"));
        }

    }
}
