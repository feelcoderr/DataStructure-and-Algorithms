public class OOPs {
    public static void main(String args[]){
        int marks[]= {98,89,100};
    student s1= new student("Yogesh",509,marks); //created student object called s1
    student s2= new student(s1);
    s1.marks[1]=90;
    // s1.setName("Yogesh");
    // s1.setIdNum(045);
    System.out.println(s1.getName());
    System.out.println(s1.getIdNum());
    s1.getMarks();
    System.out.println(s2.getName());
    System.out.println(s2.getIdNum());
    s2.getMarks();
    
    }
}

class student{
    String name;
    int idNum;
    int marks[]= new int [3];

    //Constructors

    student(){  //Non-parameterized consructor or default constructor
        System.out.println("constructor called ...");
    }
    student(String name, int idNum, int marks[]){  //parameterized constructor
        this.name=name;
        this.idNum=idNum;
        this.marks= marks;
        System.out.println("second constructor called ...");
    }
    //Copy constructor (Shallow copy)
    // student(student s1){  
    //     name=s1.name;
    //     idNum=s1.idNum;
    //     marks=s1.marks;
    //     System.out.println("copy constructor called ...");
    // }
    //copy constructor (Deep copy)
    student(student s1){  
        name=s1.name;
        idNum=s1.idNum;
        for(int i=0; i<marks.length; i++){
            this.marks[i]= s1.marks[i];
        }
        System.out.println("copy constructor called ...");
    }

    //Setters
     
    void setName(String newName){
        name= newName;
    }
    void setIdNum(int  newIdNum){
        idNum= newIdNum;
    }
    
    //Getters
    
    String getName(){
        return this.name;
    }
    int getIdNum(){
        return this.idNum;
    }
    void getMarks(){
        for(int i=0; i<marks.length; i++){
            System.out.print(this.marks[i]);
        }
        System.out.println();
        return;
    }
    
}