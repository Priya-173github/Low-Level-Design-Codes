class Programmer {

    private String name; // by default public

    // Getter method used to get the data
    public String getName() { return name; }

    // Setter method is used to set or modify the data
    public void setName(String n) {
        
        this.name = n;
    }
}

public class encapsulation1 {

    public static void main(String[] args){
        
        Programmer p = new Programmer();
        p.setName("name1");
        // System.err.println(p.name);
        System.out.println("Name: " + p.getName());
    }
}