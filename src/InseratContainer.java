import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// Diese Klasse ist ein Composite - Inserat-Container, das zu Speicherung von 
// Inseraten und Implementierung der Funktionen zu ihrer Steuerung benutzt wird

public class InseratContainer implements InseratComposite {
    private String name;
    private ArrayList<InseratComposite> inserateComposite = new ArrayList<>();

    private HashMap<String, String> erlaubteFilter = new HashMap<>();

    public InseratContainer(String name){
        this.name = name;
        erlaubteFilter = Inserat.getErlaubteEigenschaften();
    }

    public void add(InseratComposite... inserate){
        this.inserateComposite.addAll(Arrays.asList(inserate));
    }

    public void add(ArrayList<InseratComposite> inserate){
        this.inserateComposite.addAll(inserate);
    }

    public void remove(InseratComposite... inserate){
        for(InseratComposite i:inserate){
            removeIntern(i);
        }
    }

    private boolean removeIntern(InseratComposite inserat){
        boolean found = false;
        if(!inserateComposite.remove(inserat)){
            // Inserat konnte in der Liste nicht gefunden werden
            for(InseratComposite i: inserateComposite){
                if(i instanceof InseratContainer){
                    if(((InseratContainer) i).removeIntern(inserat)){
                        found = true;
                        break;
                    }
                }
            }
        }else{
            // Inserat konnte gelöscht werden
            found = true;
        }
        return found;
    }

    public InseratComposite get(Integer number){
        number --;
        if(number < inserateComposite.size() && number >= 0){
            return inserateComposite.get(number);
        }else{
            System.out.println("Indexnumber ist außerhalb des erlaubten Bereichs!");
            return null;
        }
    }

    @Override
    public void print(){
        print(0);
    }

    @Override
    public void print(Integer level) {
        System.out.println(Helper.padding("-", level)+"Inseratcontainer: "+this.name);
        Integer count = 1;
        for (InseratComposite inserat: inserateComposite){
            if(this.name.equals("Suchergebnisse")){
                System.out.println(Helper.padding(" ", level+1)+"Suchergebnis #"+count);
                count++;
            }
            inserat.print(level+1);
        }
    }

    //Suche der Inseraten unter Berücksichtigung der Filter
    public InseratContainer suche(Filter... filter){
        ArrayList<InseratComposite> ergebnisse = sucheIntern(filter);
        if(ergebnisse == null){
            return null;
        }else{
            InseratContainer tmp = new InseratContainer("Suchergebnisse");
            tmp.add(ergebnisse);
            return tmp;
        }
    }

    private ArrayList<InseratComposite> sucheIntern(Filter... filter){
        ArrayList<InseratComposite> ergebnisse = new ArrayList<>();

        for (InseratComposite inserat: inserateComposite){
            if(inserat instanceof InseratContainer){
                // Inserat ist kein Inserat sondern ein Container
                ArrayList<InseratComposite> tmp = ((InseratContainer) inserat).sucheIntern(filter);
                if(tmp == null){
                    return null;
                }
                ergebnisse.addAll(tmp);
            }else{
                // Inserat ist ein einzelnes Inserat
                Inserat i = (Inserat) inserat;
                boolean erfuelltFilter = true;
                int status;

                for (Filter f: filter){
                    if(erlaubteFilter.get(f.getName()) != null){
                        if(erlaubteFilter.get(f.getName()).equals(f.getType())){
                            if(f.getType().equals("String")){
                                status = stringFilter(i.getEigenschaft(f.getName()), f);
                            }else{
                                status = zahlFilter(Double.parseDouble(i.getEigenschaft(f.getName())), f);
                            }
                        }else{
                            System.out.println("Invalid Filtertyp: "+f.getType());
                            status = -1;
                        }
                    }else{
                        System.out.println("Invalid Filtername: "+f.getName());
                        status = -1;
                    }
                    if(status == 0){
                        erfuelltFilter = false;
                        break;
                    }else if(status == -1){
                        return null;
                    }
                }

                if(erfuelltFilter){
                    ergebnisse.add(inserat);
                }
            }
        }
        return ergebnisse;
    }

    //Filterung basierend auf der Anwesenheit der Eigentschaften
    private int stringFilter(String a, Filter f){
        if(a.equals(f.getValue())){
            return 1;
        }
        return 0;
    }

    //Filterung mit Angabe von min/max Grenze der Eigentschaft
    private int zahlFilter(Double a, Filter f){
        if(a == null){
            return 0;
        }else{
            if(f.getMethod().equals("min")){
                if(a < Double.parseDouble(f.getValue())){
                    return 0;
                }
            }else if(f.getMethod().equals("max")){
                if(a > Double.parseDouble(f.getValue())){
                    return 0;
                }
            }else{
                System.out.println("Invalid Filtermethod: "+f.getType());
                return -1;
            }
        }
        return 1;
    }

    //Delegieren der Methode von Preisermittlung an Inserat und Summieren der Preise aller Inserate
    @Override
    public Double getPreis() {
        Double gesamtpreis = 0.0;
        for(InseratComposite i: inserateComposite){
            gesamtpreis += i.getPreis();
        }
        return gesamtpreis;
    }
}
