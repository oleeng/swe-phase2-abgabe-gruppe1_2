
//Diese Klasse repräsentiert eine Eigenschaft des Inserates und umfasst entsprechende Attribute 

public class Eigenschaft {
    private String name;
    private String value;
    private String type;

    public Eigenschaft(String name, String value){
        this.name = name;
        this.value = value;
        this.type = "String";
    }

    public Eigenschaft(String name, Double value){
        this.name = name;
        this.value = String.valueOf(value);
        this.type = "Double";
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
}
