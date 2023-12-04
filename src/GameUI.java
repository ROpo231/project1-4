import java.util.Scanner;

public class GameUI {

    private Game game;
    private Scanner scan;

    public GameUI() {
        game = null;
        scan = new Scanner(System.in);
    }
    public void start(){
        setup();
        mainMenu();
    }
    public GameUI(int the) {
        game = null;
        scan = new Scanner(System.in);
        int wthe = the;
        GameUI haha = new GameUI(7);
    }


    private void setup() {
        System.out.println("Hangman time");
        System.out.print("Enter player 1's name: ");
        String p1Name = scan.nextLine();
        System.out.print("Enter player 2's name: ");
        String p2Name = scan.nextLine();

        Player p1 = new Player(p1Name);
        Player p2 = new Player(p2Name);
        game = new Game(p1, p2);






    }

    private void mainMenu() {
        game.resetGame();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("GAME HAS STARTED!");
        game.playRound();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Hangman time over");
    }
}
