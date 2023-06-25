import java.util.*;
public class Inheritance {
    public static void main(String args[]){

    }
}

//Inheritance

class Animals{
    int lags;
    String skinColor;

    public void eats(){
        System.out.println("Eats...");
    }
    public void breath(){
        System.out.println("Breaths...");
    }
}


class Fishes extends Animals{// example of Single inheritance
    int fings;

    public void swims(){
        System.out.println("Swims...");
    }
}

class Birds extends Animals{//Now it become Hierarchial inheritance
    int wings;

    public void flys(){
            System.out.println("Flies....");
    }
}

class petBirds extends Birds{// Now its become example of meltiple inheritance
    public void talk(){
        System.out.println("talks...");
    }
}

/* If we see all classes its an example of hybrid inheritance */


