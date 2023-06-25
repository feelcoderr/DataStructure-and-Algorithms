public class SuperStatic {
    public static void main(String argu[]){
        Horses h= new Horses();
        //Animal a= new Animal();
        System.out.println(h.color);
    }
}

class Animal{
    String color;
    Animal(){
        System.out.println("Animal constructor called");
    }
    
}

class Horses extends Animal{
    Horses(){
        System.out.println("Hores constructor called");
        color= "brown";// it will change properties of immediate parant class 
    }
    
     
}