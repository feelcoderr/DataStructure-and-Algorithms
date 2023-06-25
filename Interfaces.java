public class Interfaces {
    
}

interface Herbivores{
    void eatTrees();
}
interface Carnivores{
    void eatMeet();
}
class Beer implements Herbivores, Carnivores{
    public void eatTrees(){
        System.out.println("Eat trees");
    }
    public void eatMeet(){
        System.out.println("Eat Meet");
    }
}

interface chessPlayer{
    void moves();
}

class Queen implements chessPlayer{
    public void moves(){
        System.out.println("Up, Down, Right, Left, Diagonal");
    }
}
class King implements chessPlayer{
    public void moves(){
        System.out.println("Up, Down, Right, Left by One step");
    }
}