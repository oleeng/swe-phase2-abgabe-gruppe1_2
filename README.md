# Softwareimplementierung für Softwareengineering
Dies ist die Softwareimplementierung der zweiten Phase für den Kurs 'Software Engineering'. Ziel ist es die Gundfunktionen einer Immobilienseite umzusetzen. Dazu gehört unteranderem das einfügen und löschen von Inseraten sowie das Filtern.

## Installation
Das Programm kann ausgeführt werden indem das git-repository gecloned wird und die Java Dateien lokal kompiliert und ausgeführt werden. Es gibt zurzeit keine executable oder sonstige vorkompilierte Dateien.

>**Achtung: Die  korrekte Ausführung wurde nur für Windows getestet. Auf Linux oder MacOS Sytemen kann es Probleme aufgrund anderer Konventionen für Pfadnamen beim Lesen von Dateien wie Bildern geben!**

## Benutzung
Nach dem Ausführen des Programms laufen einige Demo-Befehle ab, die die Grundfunktionen der Software zeigen. Danach hat man als Benutzer die Möglichkeit über die Konsole selbst mit der Software zu interagieren und zum Beispiel Suchanfragen und vieles mehr durchzuführen.

## Beispielausgaben
Hier werden Schreenshots von Beispielkonsolenausgaben eingefügt.

## Dokumentation

### class Helper
*public class Helper*

Diese Klasse stellt einige Hilfsfunktionen für andere Klassen bereit.

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*static String*|*genId()*|Diese Funktion gibt einen 64-Zeichen langen pseudozufälligen String (nicht kryptographisch sicher), der von anderen Klassen für die Erzeugung einer eindeutigen ID genutzt wird, zurück.|
|*static String*|*padding(String string, Integer count)*|Wiederholt den String *string* *count*-mal und gibt ihn zurück. Diese Funktion wird von anderen Funktionen zur Erzeugung von padding genutzt.|
|*static void*|*printFile(String path)*|Gibt den Inhalt der in *path* übergebenen Datei in der Konsole aus. Wenn die Datei nicht existiert, wird eine entsprechende Nachricht auf der Konsole ausgegeben ohne eine Exception zu werfen oder das Programm zu beenden.|
|*static void*|*printImage(String path)*|Konvertiert die in *path* angegebene Bilddatei in ASCII-Art und gibt sie anschließend auf der Konsole aus. Wenn die Datei nicht geöffnet werden kann wird eine entsprechende Nachricht in der Konsole ausgegeben ohne eine Exception zu werfen oder das Programm zu beenden.<br>**Achtung: Die Konsole muss dafür unicode bzw. UTF-8 unterstützen**|

### class Bild
*public class Bild*

Diese Klasse stellt ein Bild dar und kann unteranderem der Klasse [*Inserat*](#class-inserat) hinzugefügt werden. Sie nutzt Funktionen der Klasse [*Helper*](#class-helper)

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Bild(String beschreibung, String path)*|Erzeugt eine neue [*Bild*](#class-bild) Instanz mit der in *pfad* angegebenen Datei und der Beschreibung aus *beschreibung*. Falls die Datei nicht existiert oder nicht vom Typ *.png* oder *.jpg* ist, wird eine *FileNotFoundException* ausgeworfen.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*String*|*getId()*|Gibt die 64-Zeichen lange ID des [*Bildes*](#class-bild) zurück|
|*String*|*getBeschreibung()*|Gibt die Beschreibung des [*Bildes*](#class-bild) zurück|
|*String*|*getDateiformat()*|Gibt da Dateiformat des [*Bildes*](#class-bild) zurück|
|*String*|*getPath()*|Gibt den absoluten Pfad des [*Bildes*](#class-bild) zurück|
|*Integer*|*getDateigroesse()*|Gibt die Dateigröße des [*Bildes*](#class-bild) in Byte zurück|
|*void*|*print()*|Gibt alle wichtigen Informationen zu dem [*Bild*](#class-bild) in der Konsole aus|
|*void*|*anzeigen()*|Konvertiert das Bild in ASCII-Art und gibt es auf der Konsole aus. Diese Funktion nutzt die Funktion *printImage(String path)* der Klasse [*Helper*](#class-helper)<br>**Achtung: Die Konsole muss dafür unicode bzw. UTF-8 unterstützen**|

### class Eigenschaft
*public class Eigenschaft*

Diese Klasse stellt eine Eigenschaft dar, die einem [*Inserat*](#class-inserat) hinzugefügt werden kann.

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Eigenschaft(String name, String value)*|Erzeugt eine neue [*Eigenschaft*](#class-eigenschaft) Instanz mit dem Namen *name* und dem Stringwert *value*|
|*Eigenschaft(String name, Double value)*|Erzeugt eine neue [*Eigenschaft*](#class-eigenschaft) Instanz mit dem Namen *name* und dem Doublewert *value*|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*String*|*getName()*|Gibt den Namen der [*Eigenschaft*](#class-eigenschaft) zurück.|
|*String*|*getValue()*|Gibt den Wert der [*Eigenschaft*](#class-eigenschaft) zurück. Doublewerte werden hier als String zurückgegeben|
|*String*|*getType()*|Gibt den Typ der [*Eigenschaft*](#class-eigenschaft) zurück, also ob es sich bei dem gespeicherten Wert um eine *"String"* oder *"Double"* handelt|

### class Filter
*public class Filter*

Diese Klasse stellt einen Filter, der dafür genutzt werden kann alle [*Inserate*](#class-inserat) eines [*InseratContainers*](#class-inseratcontainer) nach bestimmten Kriterien zu durchsuchen.

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Filter(String name, String value)*|Erzeugt eine neue [*Filter*](#class-filter) Instanz mit dem Namen *name* und dem Stringwert *value*|
|*Filter(String name, Double value, String method)*|Erzeugt eine neue [*Filter*](#class-filter) Instanz mit dem Namen *name* und dem Doublewert *value*. Beim Typ kann mit *"min"* oder *"max"* angegeben werden ob es sich um eine obere oder untere Grenze handelt.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*String*|*getName()*|Gibt den Namen des [*Filters*](#class-filter) zurück.|
|*String*|*getValue()*|Gibt den Wert des [*Filters*](#class-filter) zurück. Doublewerte werden hier als String zurückgegeben|
|*String*|*getMethod()*|Gibt die Filtermethode des [*Filters*](#class-filter) zurück. Bei einem Textfilter wird als Methode ein leerer String zurückgegeben.|
|*String*|*getType()*|Gibt den Typ des [*Filters*](#class-filter) zurück, also ob es sich bei dem gespeicherten Wert um eine *"String"* oder *"Double"* handelt|

### interface InseratComposite
*public interface InseratComposite*

Diese Klasse ist das Interface, welches von den Klassen [*Inserat*](#class-inserat) und [*InseratContainer*](#class-inseratcontainer) als Teil des *Composite*-Musters implementiert wird.

#### Methoden
|Modifier and Type|Methode|
|:---|:---|
|*void*|*print()*|
|*void*|*print(Integer level)*|
|*Double*|*getPreis()*|

### class Inserat
*public class Inserat implements InseratComposite*

Diese Klasse repräsentiert ein Inserat und nutzt unteranderem Funktionen der Klasse [*Helper*](#class-helper).

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Inserat(String beschreibung, Standort standort, Double preis, String immobielenart, String wohnart)*|Erzeugt eine neue [*Inserat*](#class-inserat) Instanz mit der Beschreibung *beschreibung*, dem in *standort* übergebenen [*Standort*](#class-standort), dem Preis *preis*, der Immobilienart *immobilienart*, welche angibt, ob es sich um ein "Haus", "Wohnung" oder "Bungalow" hadelt, und der Wohnart *wohnart*, welche angibt, ob es sich um ein "wohnen" oder "kaufen" Objekt handelt.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*static HashMap<String,String>*|*getErlaubteEigenschaften()*|Diese Funktion gibt eine Hashmap aller erlaubten [*Eigenschaften*](#class-eigenschaft) zurück. Dabei ist der Key der Name der [*Eigenschaft*](#class-eigenschaft) und der Wert der jeweilige Typ, also "String" oder "Double".|
|*void*|*add([*Rundgang*](#class-rundgang) rundgang)*|Fügt dem [*Inserat*](#class-inserat) den in *rundgang* übergebenen [*Rundgang*](#class-rundgang) hinzu.|
|*void*|*removeRundgang()*|Entfernt den [*Rundgang*](#class-rundgang) des [*Inserat*](#class-inserat).|
|*void*|*add([*Bild*](#class-bild) ... bilder)*|Fügt dem [*Inserat*](#class-inserat) alle in *bilder* übergebenen [*Bilder*](#class-bild) hinzu.|
|*void*|*remove([*Bild*](#class-bild)... bilder)*|Entfernt alle in *bilder* übergebenen [*Bilder*](#class-bild) dem [*Inserat*](#class-inserat).|
|*void*|*add([*Eigenschaft*](#class-eigenschaft)... eigenschaften)*|Fügt dem [*Inserat*](#class-inserat) alle in *eigenschaften* übergebenen [*Eigenschaften*](#class-eigenschaft) hinzu.|
|*void*|*remove(String... names)*|Entfernt alle in [*Eigenschaften*](#class-eigenschaft) mit mit den Namen *names* dem [*Inserat*](#class-inserat).|
|*String*|*getId()*|Gibt die 64-Zeichen lange ID des [*Inserats*](#class-inserat) zurück|
|*String*|*getBeschreibung()*|Gibt die Beschreibung des [*Inserats*](#class-inserat) zurück|
|*[*Standort*](#class-standort)*|*getStandort()*|Gibt den [*Standort*](#class-standort) des [*Inserats*](#class-inserat) zurück|
|*void*|*starteRundgang()*|Startet den [*Rundgang*](#class-Rundgang) des [*Inserats*](#class-inserat).|
|*[*Rundgang*](#class-Rundgang)*|*getRundgang()*|Gibt den [*Rundgang*](#class-Rundgang) des [*Inserats*](#class-inserat) zurück.|
|*void*|*printBilder()*|Ruft für jedes [*Bild*](#class-bild) des [*Inserats*](#class-inserat) die *print()* Funktion auf.|
|*void*|*zeigeBilder()*|Ruft für jedes [*Bild*](#class-bild) des [*Inserats*](#class-inserat) die *anzeigen()* Funktion auf.|
|*String*|*getEigenschaft(String name)*|Gibt den Wert der [*Eigenschaft*](#class-eigenschaft) mit dem Namen *name* des [*Inserats*](#class-inserat) zurück. Falls das [*Inserat*](#class-inserat) diese [*Eigenschaft*](#class-eigenschaft) nicht besitzt wird *null* zurückgegeben.|
|*void*|*printEigenschaften()*|Gibt alle [*Eigenschaften*](#class-eigenschaft) des [*Inserats*](#class-inserat) in der Konsole aus.|
|*void*|*print()*|Dies ist eine Funktion des implementierten Interfaces [*InseratComposite*](#interface-inseratcomposite). Sie gibt für das [*Inserat*](#class-inserat) die ID und die Beschreibung in der Konsole aus.|
|*void*|*print(Integer level)*|Dies ist eine Funktion des implementierten Interfaces [*InseratComposite*](#interface-inseratcomposite). Sie gibt für das [*Inserat*](#class-inserat) die ID und die Beschreibung in der Konsole aus, jedoch mit einem padding entsprechned dem in *level* übergebenen Wert.|
|*Double*|*getPreis()*|Dies ist eine Funktion des implementierten Interfaces [*InseratComposite*](#interface-inseratcomposite). Sie gibt den Preis des [*Inserats*](#class-inserat) zurück.

### class InseratContainer
*public class Inserat implements InseratComposite*

Diese Klasse stellt einen Container bereit, dem beliebig viele [*InseratComposites*](#interface-inseratcomposite), also [*Inserate*](#class-inserat) und [*InseratContainer*](#class-inseratcontainer), hinzugefügt werden können. Sie nutzt auch einige Funktionen der Klasse [*Helper*](#class-helper).

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*InseratContainer(String name)*|Erzeugt eine neue [*InseratContainer*](#class-inseratcontainer) Instanz mit dem Namen *name*.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*void*|*add([*InseratComposite*](#interface-inseratcomposite)... inserate)*|Fügt dem [*InseratContainer*](#class-inseratcontainer) alle in *inserate* übergebenen [*InseratComposite*](#interface-inseratcomposite) hinzu.|
|*void*|*add(ArrayList<[*InseratComposite*](#interface-inseratcomposite)> inserate)*|Fügt dem [*InseratContainer*](#class-inseratcontainer) alle in *inserate* übergebenen [*InseratComposite*](#interface-inseratcomposite) hinzu.|
|*void*|*remove([*InseratComposite*](#interface-inseratcomposite)... inserate)*|Entfernt dem [*InseratContainer*](#class-inseratcontainer) das in *inserat* übergebene [*InseratComposite*](#interface-inseratcomposite), wenn es exsistiert.|
|*[*InseratComposite*](#interface-inseratcomposite)*|*get(Integer number)*|Gibt das [*InseratComposite*](#interface-inseratcomposite) mit dem Index *number* zurück oder *null* wenn *number* außerhalb des Indexbereiches liegt.
|*void*|*print()*|Dies ist eine Funktion des implementierten Interfaces [*InseratComposite*](#interface-inseratcomposite). Sie gibt alle im [*InseratContainer*](#class-inseratcontainer) enthaltenen [*InseratComposite*](#interface-inseratcomposite) auf der Konsole aus.|
|*void*|*print(Integer level)*|Dies ist eine Funktion des implementierten Interfaces [*InseratComposite*](#interface-inseratcomposite). Sie gibt alle im [*InseratContainer*](#class-inseratcontainer) enthaltenen [*InseratComposite*](#interface-inseratcomposite) auf der Konsole aus, jedoch mit einem padding entsprechned dem in *level* übergebenen Wert.|
|*[*InseratContainer*](#class-inseratcontainer)*|*suche([*Filter*](#class-filter)... filter)*|Durchsucht alle im [*InseratContainer*](#class-inseratcontainer) enthaltenen [*InseratComposite*](#interface-inseratcomposite) nach den [*Inseraten*](#class-inserat), die alle in *filter* übergebenen [*Filter*](#class-filter) erfüllen. Bei fehlerhaften oder ungültigen [*Filtern*](#class-filter) wird eine entsprechende Nachricht in der Konsole ausgegeben und der Filtervorgang abgebrochen.|
|*Double*|*getPreis()*|Dies ist eine Funktion des implementierten Interfaces [*InseratComposite*](#interface-inseratcomposite). Sie gibt den Gesamtpreis aller im [*InseratContainer*](#class-inseratcontainer) enthaltenen [*InseratComposite*](#interface-inseratcomposite) zurück.|

### class Modellmoebel
*public class Modellmoebel*

Diese Klasse stellt ein Möbelstück dar, welches einem [*Rundgang*](#class-rundgang) hinzugefügt werden kann. Sie nutzt einige Funktionen der Klasse [*Helper*](#class-helper).

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Modellmoebel(String beschreibung, String groesse)*|Erzeugt eine neue [*Modellmoebel*](#class-modellmoebel) Instanz mit der Beschreibung *beschreibung* und den Maßen *groesse*.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*void*|*print()*|Diese Funktion gibt die Id, die Beschreibung und die Maße des [*Modellmoebel*](#class-modellmoebel) in der Konsole aus.|
|*String*|*getId()*|Gibt die 64-Zeichen lange ID des [*Modellmoebel*](#class-modellmoebel) zurück.|
|*String*|*getBeschreibung()*|Gibt die Beschreibung des [*Modellmoebel*](#class-modellmoebel) zurück.|
|*String*|*getGroesse()*|Gibt die Maße des [*Modellmoebel*](#class-modellmoebel) zurück.|

### class Rundgang
*public class Rundgang*

Diese Klasse stellt einen Rundgang dar, der unteranderem einem [*Inserat*](#class-inserat) hinzugefügt werden kann. Sie nutzt Funktionen der Klasse [*Helper*](#class-helper)

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Rundgang(String audiokommentar)*|Erzeugt eine neue [*Rundgang*](#class-rundgang) Instanz mit dem Audiokommentar *audiokommentar*.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*String*|*getId()*|Gibt die 64-Zeichen lange ID des [*Modellmoebel*](#class-modellmoebel) zurück.|
|*void*|*starteRundgang()*|Startet den [*Rundgang*](#class-rundgang).|
|*void*|*playAudiokommentar()*|Spielt den Audiokommentar des [*Rundgang*](#class-rundgang) ab.|
|*void*|*addMoebel([*Modellmoebel*](#class-modellmoebel)... moebel)*|Fügt dem [*Rundgang*](#class-rundgang) alle in *moebel* enthaltenen [*Modellmoebel*](#class-modellmoebel) hinzu.|
|*void*|*printMoebel()*|Gibt alle im [*Rundgang*](#class-rundgang) enthaltenen [*Modellmoebel*](#class-modellmoebel) in der Konsole aus.|

### class Standort
*public class Standort*

Diese Klasse repräsentiert einen Standort.

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Standort(String land, String bundesland, String stadt, String plz, String strasse)*|Erzeugt eine neue [*Standort*](#class-standort) Instanz mit den übergebenen Parametern.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*String*|*getLand()*|Gibt das Land des [*Standorts*](#class-standort) zurück.|
|*String*|*getBundesland()*|Gibt das Bundesland des [*Standorts*](#class-standort) zurück.|
|*String*|*getStadt()*|Gibt die Stadt des [*Standorts*](#class-standort) zurück.|
|*String*|*getPLZ()*|Gibt die PLZ des [*Standorts*](#class-standort) zurück.|
|*String*|*getStrasse()*|Gibt die Straße des [*Standorts*](#class-standort) zurück.|
|*void*|*printKarte(Integer zoom)*|Ruft von der [*here-API*](https://developer.here.com/) einen Kartenausschnitt von dem [*Standort*](#class-standort) unter Beachtung des in *zoom* angegeben Zoomfaktors ab, konvertiert ihn in ASCII-Art und gibt ihn anschließend auf der Konsole aus. Der Zoomfaktor darf zwischen 0 und 20 liegen, es wird jedoch ein Wert von 14 oder 15 empfohlen.<br>**Achtung: Die Konsole muss dafür unicode bzw. UTF-8 unterstützen**|

