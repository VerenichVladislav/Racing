package verenich_vladislav;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }
    Hippodrome(List horses){
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = null;
        Horse horse1 = new Horse("Horse_1", 3,0);
        //Horse horse2 = new Horse("Horse_3", 3,0);
        Horse horse3 = new Horse("Horse_3", 3,0);
        ArrayList <Horse> horses = new ArrayList<>();
        horses.add(horse1);
        //horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();

    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (int i = 0; i < horses.size() ; i++) {
            horses.get(i).move();
        }
    }
    public void print(){
        for (int i = 0; i < horses.size() ; i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        double max = 0;
        Horse horse = null;
        for (int i = 0; i < horses.size() ; i++) {
            if (horses.get(i).getDistance() > max){
                max = horses.get(i).getDistance();
                horse = horses.get(i);
            }
        }

        return horse;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
