import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

//Diese Helper-Klasse implementiert von anderen Klassen benötigte Methoden

public class Helper {
    
	//Generieren von einer zufälligen ID 
	public static String genId(){
        // erzeuge einen zufälligen 64 Zeichen langen ID-String
        String tmp = "";
        for(int i = 0; i < 64; i++){
            // r liegt zwischen 0 und 61 da 0<= Math.random<1
            int r = (int) Math.floor(Math.random() * 62);

            if(r<26){
                // A - Z
                r += 65;
            }
            else if(r<52){
                // a - z
                r += 71;
            }else{
                // 0 - 9
                r -= 4;
            }
            tmp += (char)r;
        }
        return tmp;
    }
    //Padding für bessere Formatierung der Ausgabe 
    public static String padding(String string, Integer count){
	    String s = "";
	    for(int i = 0; i < count; i++){
	        s += string;
        }
        return s;
    }

    //Ausgabe von einer Datei
    public static void printFile(String path){
        try{
            Scanner input = new Scanner(new File(Paths.get("").toAbsolutePath().toString()+"\\"+path));
            while (input.hasNextLine())
            {
                System.out.println(input.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("Die Datei "+path+" existiert nicht...");
        }
    }
    //Anzeigen von einem Bild mittels Brailleschrift
    public static void printImage(String path){
        try {
            BufferedImage img = ImageIO.read(new File(path));

            int newW = 240;
            double scale = img.getWidth()/newW;
            int newH = (int)(img.getHeight()/scale);

            Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
            BufferedImage resized = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resized.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();

            int[][] Braille = {{1,2,4,64},{8,16,32,128}};
            int threshold = 150;

            for (int i = 0; i < resized.getHeight()-4; i+=4) {
                for (int j = 0; j < resized.getWidth()-2; j+=2) {
                    int charBraille = 10495;
                    for(int k = 0; k < 4; k++){
                        for(int m = 0; m < 2; m++){
                            Color pixcol = new Color(resized.getRGB(j+m, i+k));
                            double pixelval = (pixcol.getRed() * 0.30) + (pixcol.getBlue() * 0.59) + (pixcol.getGreen() * 0.11);
                            if(pixelval >= threshold){
                                charBraille -= Braille[m][k];
                            }
                        }
                    }
                    if(charBraille == 10240){
                        System.out.print((char)10244);
                    }else{
                        System.out.print((char)charBraille);
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Die Datei "+path+" konnte nicht geladen werden....");
        }
    }
}
