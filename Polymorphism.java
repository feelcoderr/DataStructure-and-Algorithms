
public class Polymorphism {
    
    public static void main(String args[]){
        // Calculator calc= new Calculator();
        // calc.sum(3,4);
        // calc.sum(3,4,5);
        // calc.sum((float)3.5,(float)6.9);

        Deer d= new Deer();
        d.eats();
    }
}
//example of OverRiding
class Animal{
    void eats(){
        System.out.println("eat anything");
    }
}
class Deer extends Animal{
    void eats(){
        System.out.println("eat grass");
    }
}
//example of Overloading (static)
class Calculator{
    public static int sum(int a, int b){
        return a+b;
    }
    public static int sum(int a, int b, int c){// it is Overloading ( static )
        return a+b+c;
    }
    public static float sum(float a, float b){
        return a+b;
    }
}
