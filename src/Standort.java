import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// Diese Klasse umfasst die Attribute und Funktionalitäten eines Standorts 

public class Standort {
    private String land;
    private String bundesland;
    private String stadt;
    private String plz;
    private String strasse;

    public Standort(String land, String bundesland, String stadt, String plz, String strasse){
        this.land = land;
        this.bundesland = bundesland;
        this.stadt = stadt;
        this.plz = plz;
        this.strasse = strasse;
    }

    public String getLand() {
        return land;
    }

    public String getBundesland() {
        return bundesland;
    }

    public String getStadt() {
        return stadt;
    }

    public String getPLZ() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void printKarte(int zoom){
        //Ideales zoom level ist 14 or 15
        if(zoom < 0 || zoom > 20){
            System.out.println("Invalid zoom: "+zoom+" (value must be between 0 and 20)");
        }
        URL url = null;
        try {
        	// URL für den API-endpoint
            String tmp = "https://image.maps.ls.hereapi.com/mia/1.6/mapview?apiKey=4t-sIBgXFePm5Azm8eAj1GxpbfvTMyRsnicw61CI1W8&co="+URLEncoder.encode(land, "UTF-8")+"&ci="+URLEncoder.encode(stadt, "UTF-8")+"&f=0&h=120&i=0&s="+URLEncoder.encode(strasse, "UTF-8")+"&nocmp=1&nocp=1&nodot=1&w=240&z="+zoom+"&zi="+URLEncoder.encode(plz, "UTF-8")+"&style=dreamworks";
            url = new URL(tmp);
            BufferedImage img = ImageIO.read(url);
            
            // Generieren des Karte-Bilds aus originalem Bild mit dem Brailleschrift
            int centerX = img.getWidth()/2;
            centerX -= (centerX%2);
            int centerY = img.getHeight()/2;
            centerY -= centerY%4;

            String[] str = {"#5A3194", "#CE5AE6", "#FF943A", "#FF523A", "#6B5AE6", "#000000"};

            int[][] Braille = {{1,2,4,64},{8,16,32,128}};

            for (int i = 0; i < img.getHeight()-4; i=i+4) {
                for (int j = 0; j < img.getWidth()-2; j=j+2) {
                    if(i == centerY && j == centerX){
                        System.out.print("@");
                        continue;
                    }
                    int charBraille = 10240;
                    for(int k = 0; k < 4; k++){
                        for(int m = 0; m < 2; m++){
                            Color pixcol = new Color(img.getRGB(j+m, i+k));
                            String c = "#"+Integer.toHexString(pixcol.getRGB()).substring(2).toUpperCase();
                            if(Arrays.asList(str).contains(c)){
                                charBraille += Braille[m][k];
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
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL Format..."+url);
        } catch (IOException e) {
            System.out.println("Can't read file..."+url);
        }
    }
}
