package zomato.models;

public class MenuItem {
    String code;
    String name;
    int price;

    MenuItem(String code, String name, int price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String c){
        code = c;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int p){
        price = p;
    }


}
