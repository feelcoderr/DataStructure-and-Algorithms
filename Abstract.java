
public class Abstract {
    public static void main(String args[]){
    //can not create object of abstract classes
    Horse h= new Horse();
    h.eats();
    h.walks();
    System.out.println(h.color);
    Chicken c= new Chicken();
    c.eats();
    c.walks();
    c.changeColor("black");
    System.out.println(c.color);
    }
}

abstract class Animal{
    String color;
    Animal(){
        color="brown";
    }
    public void eats(){
        System.out.println("Eats");
    }
    abstract void walks();
}

class Horse extends Animal{
    void walks(){
        System.out.println("Walks on 4 legs");
    }
    void changeColor(String color){
        this.color= color;
    }
}

class Chicken extends Animal{
    void walks(){
        System.out.println("Walks on 2 legs");
    }
    void changeColor(String color){
        this.color= color;
    }
}