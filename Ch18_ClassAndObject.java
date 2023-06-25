import java.util.*;
public class Ch18_ClassAndObject {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
    int R1= sc.nextInt();
    int I1= sc.nextInt();
    int R2= sc.nextInt();
    int I2= sc.nextInt();

    Complex c1= new Complex(R1, I1, R2, I2);
    c1.sum();
    c1.product();
    c1.difference();
    }  
}
class Complex{
    int R1,R2,I1,I2;
    Complex(int R1,int I1,int R2,int I2){
        this.R1=R1;
        this.I1=I1;
        this.R2=R2;
        this.I2=I2;
    }
    void sum(){
        System.out.println(R1+R2 + " +j " +(I1+I2));
    }
    void product(){
        System.out.println(R1*R2 + " +j " +I1*I2);
    }
    void difference(){
        System.out.println((R1-R2) + " +j " +(I1-I2));
    }
}
