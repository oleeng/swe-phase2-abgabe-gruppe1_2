import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
    	
    	//Erzeugen von einem Container für verschiedene Arten von Immobilien und Oberklassen jeder Art
    	
        InseratContainer Container = new InseratContainer("Container");
        InseratContainer OberklasseHaus = new InseratContainer("Häuser");
        InseratContainer OberklasseWohnung = new InseratContainer("Wohnungen");
        InseratContainer OberklasseBungalow = new InseratContainer("Bungalows");

        Container.add(OberklasseHaus, OberklasseWohnung, OberklasseBungalow);

        System.out.println("Füge zwei Inserate von jedem Typ hinzu...");

        Inserat wohnung1 = new Inserat("Helle Wohnung in Berlin", new Standort("Deutschland", "Berlin", "Berlin", "10179", "Stallschreiberstraße 27"), 1799.0, "Wohnung", "mieten");
        wohnung1.add(
                new Eigenschaft("Größe", 95.8),
                new Eigenschaft("Zimmerzahl", 4.0),
                new Eigenschaft("Baujahr", 1982.0),
                new Eigenschaft("Einbauküche", "ja"),
                new Eigenschaft("Haustiere", "nein"),
                new Eigenschaft("Garten", "nein"),
                new Eigenschaft("Etage", 3.0)
        );

        Inserat wohnung2 = new Inserat("Große Wohnung in der  Bochumer Innenstadt", new Standort("Deutschland", "Nordrhein-Westfalen", "Bochum", "44787", "Malteserstraße 47"), 900.0, "Wohnung", "mieten");
        wohnung2.add(
                new Eigenschaft("Größe", 106.0),
                new Eigenschaft("Zimmerzahl", 4.5),
                new Eigenschaft("Baujahr", 1967.0),
                new Eigenschaft("Einbauküche", "nein"),
                new Eigenschaft("Haustiere", "nein"),
                new Eigenschaft("Garten", "nein"),
                new Eigenschaft("Etage", 1.0)
        );

        Inserat haus1 = new Inserat("Doppelhaushälfte mit großem Garten in Altenbochum", new Standort("Deutschland", "Nordrhein-Westfalen", "Bochum", "44803", "Klausengrund 5"), 389000.0, "Haus", "kaufen");
        haus1.add(
                new Eigenschaft("Größe", 652.0),
                new Eigenschaft("Zimmerzahl", 4.5),
                new Eigenschaft("Baujahr", 1993.0),
                new Eigenschaft("Einbauküche", "nein"),
                new Eigenschaft("Haustiere", "ja"),
                new Eigenschaft("Garten", "ja")
        );

        Inserat haus2 = new Inserat("Das versteckte Paradies im Vrings-Veedl", new Standort("Deutschland", "Nordrhein-Westfalen", "Köln", "50676", "Georgsplatz 8"), 2200.0, "Haus", "mieten");
        haus2.add(
                new Eigenschaft("Größe", 155.0),
                new Eigenschaft("Zimmerzahl", 4.0),
                new Eigenschaft("Baujahr", 2005.0),
                new Eigenschaft("Einbauküche", "ja"),
                new Eigenschaft("Haustiere", "ja"),
                new Eigenschaft("Garten", "nein")
        );

        Inserat bungalow1 = new Inserat("Bungalow im Harz", new Standort("Deutschland", "Niedersachsen", "Braunlage", "38700", "Am Bodefall 4"), 980.0, "Bungalow", "mieten");
        bungalow1.add(
                new Eigenschaft("Größe", 130.0),
                new Eigenschaft("Zimmerzahl", 4.0),
                new Eigenschaft("Baujahr", 1925.0),
                new Eigenschaft("Einbauküche", "nein"),
                new Eigenschaft("Haustiere", "ja"),
                new Eigenschaft("Garten", "ja")
        );

        Inserat bungalow2 = new Inserat("Schöner Reihenhaus-Bungalow in Playa de Muro in Strandnähe!", new Standort("Spanien", "Mallorca", "Alcudia", "07400", "Carrer de Minerva 11"), 515000.0, "Bungalow", "kaufen");
        bungalow2.add(
                new Eigenschaft("Größe", 325.0),
                new Eigenschaft("Zimmerzahl", 4.0),
                new Eigenschaft("Baujahr", 2010.0),
                new Eigenschaft("Einbauküche", "ja"),
                new Eigenschaft("Haustiere", "ja"),
                new Eigenschaft("Garten", "ja")
        );

        OberklasseWohnung.add(wohnung1, wohnung2);
        OberklasseHaus.add(haus1, haus2);
        OberklasseBungalow.add(bungalow1, bungalow2);

        Container.print();        //Ausgabe der Liste von allen Inseraten

        System.out.println("Lösche ein Inserate von jedem Typ...");

        Container.remove(wohnung1, haus2, bungalow1);

        Container.print();

        System.out.println("Füge vier Inserate hinzu...");

        Inserat wohnung3 = new Inserat("Haus in idyllische und ruhige Lage in Farmsen- Berne", new Standort("Deutschland", "Hamburg", "Hamburg", "22459", "Barenkrug 30"), 238000.0, "Wohnung", "kaufen");
        wohnung3.add(
                new Eigenschaft("Größe", 40.0),
                new Eigenschaft("Zimmerzahl", 2.0),
                new Eigenschaft("Baujahr", 2018.0),
                new Eigenschaft("Einbauküche", "nein"),
                new Eigenschaft("Haustiere", "nein"),
                new Eigenschaft("Garten", "nein"),
                new Eigenschaft("Etage", 5.0)
        );

        Inserat haus3 = new Inserat("Provisionsfreies Reihenhaus in Adlershof", new Standort("Deutschland", "Berlin", "Berlin", "12489", "Moissistraße 9"), 619000.0, "Haus", "kaufen");
        haus3.add(
                new Eigenschaft("Größe", 135.7),
                new Eigenschaft("Zimmerzahl", 4.0),
                new Eigenschaft("Baujahr", 1947.0),
                new Eigenschaft("Einbauküche", "ja"),
                new Eigenschaft("Haustiere", "ja"),
                new Eigenschaft("Garten", "nein")
        );

        Inserat bungalow3 = new Inserat("Modernisiertes Ferienhaus in Norddeich", new Standort("Deutschland", "Niedersachsen", "Norden", "26506", "Fledderweg 6"), 259500.0, "Bungalow", "kaufen");
        bungalow3.add(
                new Eigenschaft("Größe", 170.0),
                new Eigenschaft("Zimmerzahl", 4.0),
                new Eigenschaft("Baujahr", 2000.0),
                new Eigenschaft("Einbauküche", "nein"),
                new Eigenschaft("Haustiere", "ja"),
                new Eigenschaft("Garten", "ja")
        );

        Inserat bungalow4 = new Inserat("Beach House - Erfüllen Sie sich den Traum von einem eigenen Ferienhaus in den Niederlanden", new Standort("Niederlande", "Gelderland", "Olburgen", "7225", "Pipeluurseweg 8"), 99500.0, "Bungalow", "kaufen");
        bungalow4.add(
                new Eigenschaft("Größe", 250.0),
                new Eigenschaft("Zimmerzahl", 3.0),
                new Eigenschaft("Baujahr", 2019.0),
                new Eigenschaft("Einbauküche", "ja"),
                new Eigenschaft("Haustiere", "ja"),
                new Eigenschaft("Garten", "ja")
        );

        OberklasseWohnung.add(wohnung3);
        OberklasseHaus.add(haus3);
        OberklasseBungalow.add(bungalow3, bungalow4);

        Container.print();

        System.out.println("Gesamtpreis: "+Container.getPreis()+"€");    //Summe der Mietpreise aller Immobilien

        System.out.println("Filter nach Stadt...");

        Container.remove(wohnung1, wohnung2, wohnung3, haus1, haus2, haus3, bungalow1, bungalow2, bungalow3, bungalow4);   //Reinigung der Liste von Inseraten um FIlterfunktion zu zeigen
        
        //Einfügen von 3 Inseraten der Art "Wohnung" in Berlin, Bochum und Köln
        
        Inserat filterTest1 = new Inserat("Testinserat 1 (in Berlin)", new Standort("Deutschland", "Berlin", "Berlin", "12489", "Moissistraße  9"), 999.0, "Wohnung", "mieten");
        Inserat filterTest2 = new Inserat("Testinserat 2 (in Berlin)", new Standort("Deutschland", "Berlin", "Berlin", "12489", "Moissistraße  9"), 999.0, "Wohnung", "mieten");
        Inserat filterTest3 = new Inserat("Testinserat 3 (in Berlin)", new Standort("Deutschland", "Berlin", "Berlin", "12489", "Moissistraße  9"), 999.0, "Wohnung", "mieten");

        Inserat filterTest4 = new Inserat("Testinserat 4 (in Bochum)", new Standort("Deutschland", "Nordrhein-Westfalen", "Bochum", "44787", "Klausengrund 5"), 999.0, "Wohnung", "mieten");
        Inserat filterTest5 = new Inserat("Testinserat 5 (in Bochum)", new Standort("Deutschland", "Nordrhein-Westfalen", "Bochum", "44787", "Klausengrund 5"), 999.0, "Wohnung", "mieten");
        Inserat filterTest6 = new Inserat("Testinserat 6 (in Bochum)", new Standort("Deutschland", "Nordrhein-Westfalen", "Bochum", "44787", "Klausengrund 5"), 999.0, "Wohnung", "mieten");

        Inserat filterTest7 = new Inserat("Testinserat 7 (in Köln)", new Standort("Deutschland", "Nordrhein-Westfalen", "Köln", "50676", "Georgsplatz 8"), 999.0, "Wohnung", "mieten");
        Inserat filterTest8 = new Inserat("Testinserat 8 (in Köln)", new Standort("Deutschland", "Nordrhein-Westfalen", "Köln", "50676", "Georgsplatz 8"), 999.0, "Wohnung", "mieten");
        Inserat filterTest9 = new Inserat("Testinserat 9 (in Köln)", new Standort("Deutschland", "Nordrhein-Westfalen", "Köln", "50676", "Georgsplatz 8"), 999.0, "Wohnung", "mieten");

        OberklasseWohnung.add(filterTest1, filterTest2, filterTest3, filterTest4, filterTest5, filterTest6, filterTest7, filterTest8, filterTest9);

        Container.print();

        InseratContainer suchergebnisse = null;

        System.out.println("Filtern nach Berlin...");
        
        suchergebnisse = Container.suche(
                new Filter("Stadt", "Berlin")       
        );
        suchergebnisse.print();

        System.out.println("Filtern nach Bochum...");

        suchergebnisse = Container.suche(
                new Filter("Stadt", "Bochum")
        );
        suchergebnisse.print();

        System.out.println("Filtern nach Köln...");

        suchergebnisse = Container.suche(
                new Filter("Stadt", "Köln")
        );
        suchergebnisse.print();

        System.out.println("Weitere Funktinen...");

        Container.remove(filterTest1, filterTest2, filterTest3, filterTest4, filterTest5, filterTest6, filterTest7, filterTest8, filterTest9);
        
        //Hier werden extra Funktionalitäten demonstriert, die in der Phase 1 als zentrale Ideen erarbeitet wurden
        
        try{
            //Einfügen von Bildern zu dem Inserat, indem der Pfad zu dem File angegeben und Fehlerfall behandelt werden
            bungalow2.add(
                    new Bild("RUB Logo", "img\\rub.png"),
                    new Bild("GitHub Logo", "img\\git.jpg")     
            );
        }catch (FileNotFoundException e){
            System.out.println("Mindestens eins der Bilder wurde nicht gefunden");
        }

        //Erzeugen von einem virtuellen Rundgang mit dem Beispiel-Audiokommentar
        
        Rundgang rundgang1 = new Rundgang("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        //Einfügen von den Möbel-Modellen zu dem Rundgang
        rundgang1.addMoebel(
                new Modellmoebel("Ein Stuhl", "50cm x 50cm x 150cm"),
                new Modellmoebel("Ein Tisch", "200cm x 100cm x 80cm")
        );

        bungalow2.add(rundgang1);

        OberklasseHaus.add(haus1, haus2, haus3);
        OberklasseWohnung.add(wohnung1, wohnung2, wohnung3);
        OberklasseBungalow.add(bungalow1, bungalow2, bungalow3, bungalow4);

        //Beispiel einer realen Suche in der Anwendung anhand Filter 
        
        suchergebnisse = Container.suche(
                new Filter("Stadt", "Alcudia"),
                new Filter("Größe", 80.0, "min"),
                new Filter("Größe", 500.0, "max"),
                new Filter("Zimmerzahl", 2.0, "min"),
                new Filter("Preis", 1000000.0, "max"),
                new Filter("Haustiere", "ja"),
                new Filter("Baujahr", 2000.0, "min"),
                new Filter("Typ", "Bungalow"),
                new Filter("Garten", "ja")
        );

        //Ausgabe der Suchergebnisse oder ihre Abwesenheit
        if(suchergebnisse == null){
            System.out.println("Fehlerhafte Filter");
            System.out.println("Siehe Konsolenausgabe für Gründe");
        }else{
            suchergebnisse.print();
        }

        System.out.println("Einige Funktionen für das erste Suchergebnis...");

        InseratComposite t = suchergebnisse.get(1);
        if(t != null){
            Inserat i = (Inserat)t;
            //Ausgabe der Informationen über Inserat
            i.printEigenschaften();
            //Anzeigen des Standorts des Inserates auf der Karte
            i.getStandort().printKarte(14);
            //Anzeigen der Bilder von dem Inserat
            i.zeigeBilder();
            //Benutzen der Funktion von dem virtuellen Rundgang
            i.starteRundgang();
            //Abspielen der Audiokommentaren bei dem Rundgang
            i.getRundgang().playAudiokommentar();
            //Ausgabe der Lister aller in dem Raum virtuell platzierten Möbel
            i.getRundgang().printAllMoebel();
        }
    }
}