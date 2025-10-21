package com.example;

public class Department{
    private static int idCounter = 1;

    private final int id;
    private final String name;

    public Department(String name){
        this.id = idCounter++;
        this.name = name;
    }

    public int getId(){ return id;}
    public String getName(){ return name;}

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Department that = (Department) other;
        return name.equals(that.name);
    }

    @Override
    public int hashCode(){ return name.hashCode();}

    @Override
    public String toString(){
        return "Department{id=}"+id+", name='"+name+"'}";
    }
}