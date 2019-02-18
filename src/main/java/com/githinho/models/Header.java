package com.githinho.models;

public class Header {

    private String Name;
    private String Type;
    // TODO: problem with Value is it can be a String and or a array of Header
//    private String Value;

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

//    public String getValue() {
//        return Value;
//    }

    @Override
    public String toString() {
        return "Header{" +
                "Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
//                ", Value='" + Value + '\'' +
                '}';
    }
}
