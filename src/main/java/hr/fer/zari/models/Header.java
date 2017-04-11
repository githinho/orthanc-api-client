package hr.fer.zari.models;

/**
 * Created by eugen on 09/03/2017.
 */
public class Header {

    private String Name;
    private String Type;
    private String Value;

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String getValue() {
        return Value;
    }

    @Override
    public String toString() {
        return "Header{" +
                "Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Value='" + Value + '\'' +
                '}';
    }
}
