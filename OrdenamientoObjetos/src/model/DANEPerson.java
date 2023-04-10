package model;

public class DANEPerson implements Comparable<DANEPerson>{
    private int natID;
    private String name;
    private String lastname;
    private int age;

    public DANEPerson(int natID, String name, String lastname, int age) {
        this.natID = natID;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public int getNatID() {
        return natID;
    }

    public void setNatID(int natID) {
        this.natID = natID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(DANEPerson o) {
        //this comparado con o
        //return this.natID - o.natID;
        int criteria1 = this.lastname.compareTo(o.lastname);
        if(criteria1 == 0){
            int criteria2 = this.name.compareTo(o.name);
            return criteria2;
        }else{
            return criteria1;
        }
    }
}
