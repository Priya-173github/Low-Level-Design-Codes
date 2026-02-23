package zomato.models;

public class User {
    
    private int userId;
    private String name;
    private String address;
    private Cart cart;

    public User(int userId, String name, String address){
        this.userId = userId;
        this.name = name;
        this.address = address;
        cart = new Cart();
    }

    public String getname(){
        return name;
    }

    public void setname(String n){
        name = n;
    }

    public String getAddress(){
        return address;
    }

    public void setaddress(String a){
        address = a;
    }

    public Cart getcart(){
        return cart;
    }
}
