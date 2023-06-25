import java.util.*;
public class Patterns {
    public static void Triangal_pattern(int n){
        for(int i=0;i<n;i++){
                //One Line
                for(int j=0;j<i;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
    }
    public static void Inverted_Triangal_pattern(int n){
        for(int i=1; i<=n ; i++){
                //one line
                for(int j=1; j<=n-i+1 ; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
    }
    public static void Character_half_Pyramid(int n){
        //outer Loop
        char ch='A';
        for(int i=1; i<=n ; i++){
            
            //inner loop
            for(int j=1; j<=i ; j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
    public static void Hollow_Ractangle(int n){
        
        //outer Loop
        for(int i=1; i<=n ; i++){
            
            //inner loop
            for(int j=1; j<=n+1 ; j++){
                if((j==1 || j==n+1)||(i==1||i==n)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void Rotated_half_Pyramid(int n){
        
        //outer Loop
        for(int i=1; i<=n ; i++){
            //inner loop
            for(int j=1; j<=n ; j++){
                if(j>n-i){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        
    }
    public static void Inverted_half_Pyramid_with_numbers(int n){
        
        //outer Loop
        for(int i=1; i<=n ; i++){
            //inner loop
            for(int j=1; j<=n-i+1 ; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        
    }
    public static void FLOYD_Half_triangle(int n){
        
        int count=1;
        //outer Loop
        for(int i=1; i<=n ; i++){
            //inner loop
            for(int j=1; j<=i ; j++){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
        
    }
    public static void zero_one_pattern(int n){
        
        //outer Loop
        for(int i=1; i<=n ; i++){
            //inner loop
            for(int j=1; j<=i ; j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        
    }
    public static void butterfly_pattern(int n){
        
        //outer Loop
        for(int i=1; i<=n ; i++){
            //inner loop
            for(int j=1; j<=i ; j++){
                System.out.print("* ");
            }
            for(int j=1;j<=2*(n-i); j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n; i>=1 ; i--){
            //inner loop
            for(int j=1; j<=i ; j++){
                System.out.print("* ");
            }
            for(int j=1;j<=2*(n-i); j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }

    //solid rhombus
    public static void solid_rhombus(int n){
        //outer loop/lines
        for(int i=1; i<=n; i++){
            //inner loop / in one line
            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=n; j++){
                System.out.print("* ");
            }

            System.err.println();

        }
    }

    //Hollow rhombus
    public static void hollow_rhombus(int n){
        //outer loop/lines
        for(int i=1; i<=n; i++){
            //inner loop / in one line
            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=n; j++){
                if(j==1 || i==1 || j==n || i==n ){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
                
            }

            System.err.println();

        }
    }

    //Dimond patterns

    public static void dimond_pattern(int n){
        //outer loop 
        for(int i=1; i<=n; i++){
            //inner loop

            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }

            //stars
            for(int j=1; j<=i+i-1; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
        //Mirror second part

        for(int i=n; i>=1; i--){
            //inner loop

            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }

            //stars
            for(int j=1; j<=i+i-1; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }
    
    //palindromic Pattern

    public static void palindromic_numbers_triangle(int n){
        //outer loop
        for(int i=1; i<=n; i++){
            //inner loop
            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            //number
            for(int j=i; j>=1; j--){
                System.out.print(j+" ");
            }
            for(int j=2; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        //zero_one_pattern(n);
        //butterfly_pattern(n);
        //solid_rhombus(n);
        //hollow_rhombus(n);
        //dimond_pattern(n);
        palindromic_numbers_triangle(n);
    }
}
