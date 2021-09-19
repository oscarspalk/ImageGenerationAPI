package me.olle.imagegeneration;
import org.springframework.http.MediaType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageGeneration {
    private BufferedImage generatedImage;
    private Graphics2D g2d;
    private Font font;
    private Rectangle drawingRect;
    public ImageGeneration(int width, int height){
        this.generatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.g2d =  generatedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void setPixel(int x, int y, Color color){
        generatedImage.setRGB(x, y, color.getRGB());
    }

    public void drawLine(int startX, int startY, int endX, int endY, int strokeW,  Color color){
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(strokeW));
        g2d.drawLine(startX, startY, endX, endY);
    }

    public void drawImage(BufferedImage image){
        g2d.drawImage(image, 0,0, null);
        g2d.dispose();
    }



    public void drawFilledRect(int x, int y, int X, int Y, Color color){
        g2d.setColor(color);
        g2d.fillRect(x,y,X,Y);
    }

    public void drawString(String text, int x, int y, Color color, int fontSize) {
        g2d.setFont(new Font("SansSerif", Font.PLAIN, fontSize));
        g2d.setColor(color);
        g2d.drawString(text, x, y);
    }



    public void drawCenteredString(String string, int fontSize, Color color){
        g2d.setFont(new Font("SansSerif", Font.PLAIN, fontSize));
        int stringWid = g2d.getFontMetrics().stringWidth(string);
        FontMetrics fm = g2d.getFontMetrics();
        int xPos = generatedImage.getWidth() / 2 - stringWid/2;
        int yPos =(generatedImage.getHeight() + fm.getAscent() - fm.getDescent())/2;
        drawString(string, xPos, yPos, color, fontSize);

    }


    public byte[] buildImage(String format)  {
        if(format == MediaType.IMAGE_JPEG_VALUE || format == MediaType.IMAGE_PNG_VALUE){
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(generatedImage, format == MediaType.IMAGE_PNG_VALUE ? "png" : "jpg", baos);
                byte[] bytes = baos.toByteArray();
                return bytes;
            }
            catch (IOException ioException){
                System.out.println(ioException);
            }

        }
        return new byte[0];
    }

}