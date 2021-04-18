package grayscale;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GrayScale {
 BufferedImage image;
 int width;
 int height;

 public GrayScale() {

 try {
 //odczyt obrazu z pliku
 File input = new File("zdj1.jpg");
 image = ImageIO.read(input);
 width = image.getWidth();
 height = image.getHeight();

 //odczyt pixeli obrazu w dwóch pętlach po kolumnach i wierszach
 for(int i=0; i<height; i++){
 for(int j=0; j<width; j++){

 //odczyt składowych koloru RGB
 Color c = new Color(image.getRGB(j, i));
 int red = (int)(c.getRed());
 int green = (int)(c.getGreen());
 int blue = (int)(c.getBlue());

 int x, y, z;


 x = 0;
 y = 0;
 z = 0;

// przyciemnienie obrazu
if ( i>=0 && i<=670 && j>=900 && j<=300 ) 
 {
     
 x = 150; //czerwony
 y = -50; // zielony
 z = -10; //niebieski
 
 }

//rozjasnienie obrazu
 if ( i>=0 && i<=763 && j>=450 && j<=900 )
 {
     
 x = 50;
 y = 50;
 z = 50;

 }

// negatyw
 if ( i>=0 && i<=670 && j>=0 && j<=300 )
 {
     
 x = 0;
 y = -30;
 z = 60;
 }


 if (red + x>=0 && red + x <=255) red = red + x;
 else red = red;

 if (green + y>=0 && green + y <=255) green = green + y;
 else green = green;

 if (blue + z>=0 && blue + z <=255) blue = blue + z;
 else blue = blue;


 Color newColor = new Color(red, green,blue);
 image.setRGB(j,i,newColor.getRGB());

 } //koniec dwóch pętli po kolumnach i wierszach obrazu
 }
 //zapis do pliku zmodyfikowanego obrazu
 File ouptut = new File("transformacja.jpg");
 ImageIO.write(image, "jpg", ouptut);

 } catch (IOException e) {}
 }

 static public void main(String args[]) throws Exception
 {
 GrayScale obj = new GrayScale();
 }
}
