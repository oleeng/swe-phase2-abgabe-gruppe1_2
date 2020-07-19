import java.util.ArrayList;
import java.util.Arrays;

//Diese Klasse umfasst die Attribute und Funktionalitäten eines virtuellen Rundgangs

public class Rundgang {
    private String id;
    private String audiokommentar;
    private ArrayList<Modellmoebel> moebel = new ArrayList<Modellmoebel>();

    public Rundgang(String audiokommentar){
        this.audiokommentar = audiokommentar;
        this.id = Helper.genId();
    }

    public String getId() {
        return id;
    }

    public void playAudiokommentar(){
        System.out.println("Gebe den Audiokommentar wieder...");
        System.out.println(audiokommentar);
    }

    public void starteRundgang() {
        System.out.println("Starte Rundgang (id: "+id+")...");
    }

    public void addMoebel(Modellmoebel... moebelstueck){
        this.moebel.addAll(Arrays.asList(moebelstueck));
    }
    //Ausgabe der Lister aller in dem Raum virtuell platzierten Möbel
    public void printAllMoebel(){
        System.out.println("In der Immobile befinden sich aktuell folgende Möbel.....");
        for (Modellmoebel m : moebel) {
            m.print();
        }
    }
}
