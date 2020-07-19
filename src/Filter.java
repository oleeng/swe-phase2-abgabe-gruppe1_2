
//Diese Klasse repräsentiert ein Filter, das bei der Suche angewendet werden kann, und umfasst entsprechende Attribute 

public class Filter {
    private String name;
    private String value;
    private String method;
    private String type;

    public Filter(String name, String value){
        this.name = name;
        this.value = value;
        this.method = "";
        this.type = "String";
    }

    public Filter(String name, Double value, String method){
        this.name = name;
        this.value = String.valueOf(value);
        this.method = method;
        this.type = "Double";
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public String getMethod() {
        return this.method;
    }

    public String getType() {
        return this.type;
    }
}
