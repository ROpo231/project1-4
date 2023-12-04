import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Game {

    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private int random;
    private ArrayList<String> wordList;
    private boolean gameOver;
    private Scanner scan;
    private String word;
    private String guessWord;
    private String letterList;
    private int lives;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        scan = new Scanner(System.in);
        wordList = new ArrayList<String>();
        currentPlayer = null;
        gameOver = false;
        word = giveWord();
        guessWord = "";
        lives = 6;
        letterList = "";
        for(int i = 0; i < word.length(); i++) {
            guessWord += "_";
        }
    }

    public void playRound() {
        chooseStartingPlayer();
        while (!gameOver) {
            printGameState();
        }
        if(lives == 0){
            System.out.println("You ran out of lives! \n");
        }else {
            System.out.println(currentPlayer.getName() + " has won!");
        }
    }

    private void printGameState() {
        System.out.println("--------------------------------------");
        if(currentPlayer == p1){
            currentPlayer = p2;
        } else {
            currentPlayer = p1;
        }
        System.out.println("Letters guessed: " + letterList);
        System.out.println("Lives: " + lives);
        System.out.println("Current player: " + currentPlayer.getName());
        System.out.println(guessWord);
        System.out.println("--------------------------------------");
        guess();
    }


    public void resetGame() {
        gameOver = false;
        currentPlayer = null;
        int x = 1;
        if(x == 3) {
            resetGame(2);
        }
    }

    public void resetGame(int the) {
        gameOver = false;
        currentPlayer = null;
        int thes =the;
        for(int i = 0; i==1; i++){
            for(int s = 0; s==1; s++){
                int x = 2;
            }
        }
    }

    private void chooseStartingPlayer() {
        if (getRandom() == 1) {
            currentPlayer = p1;
        } else {
            currentPlayer = p2;
        }
    }

    /*
    This method deals with collecting of the user input for the guess either for the letter in the word or
    the guess for the entire word
     */

    private void guess() {
        String option = "";
        while (!option.equals("w") && !option.equals("l")) {
            System.out.print("Would you like to guess a letter or guess the word? (l/w) ");
            option = scan.nextLine().toLowerCase();
        }
        // checks if the letter is in the word which needs to be guessed
        if (option.equals("l")) {
            System.out.print("What letter would you like to guess? ");
            String letter = scan.nextLine().toLowerCase();
            while (letterList.contains(letter)) {
                System.out.print("You've already guessed that letter. Please guess a different letter: ");
                letter = scan.nextLine().toLowerCase();
            }
            if (word.contains(letter)) {
                StringBuilder newGuessWord = new StringBuilder(guessWord);
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter.charAt(0)) {
                        newGuessWord.setCharAt(i, letter.charAt(0));
                    }
                }
                guessWord = newGuessWord.toString();
                System.out.println("Correct guess! The word so far: " + guessWord);
                letterList += letter;
                if(guessWord.equals(word)){
                    gameOver = true;
                }
            } else {
                System.out.println(letter + " is not in the word.");
                letterList += letter;
                lives--;
            }
        // checks if the user word is the word need to be guessed
        } else if (option.equals("w")) {
            System.out.print("Type your guess: ");
            String wordGuess = scan.nextLine().toLowerCase();
            if (wordGuess.equals(word)) {
                System.out.println("You guessed the word!");
                gameOver = true;
            } else {
                System.out.println("You did not guess the word.");
                lives--;
            }
        }

        if (lives == 0) {
            gameOver = true;
            System.out.println("You lost, the word was " + word);
        }
    }
    /*
    The segment below reads the words.txt file and puts it into a arrayList. Then from there the
    program will return a random item in the Arraylist which will be the word the user will have to guess
     */

    public String giveWord() {
        try{
            //reads the file
            BufferedReader reader = new BufferedReader(new FileReader(("src/words.txt")));
            String line;
            //adds the lines in the file to a list will stop once there is no more lines meaning result will be null
            while((line = reader.readLine()) != null){
                wordList.add(line);
            }

            double wordSize = wordList.size();
            random = (int)(Math.random() * wordSize);
            reader.close();



        //what happens if the code in the try get an error
        }catch(IOException e){
            e.printStackTrace();
        }
        // returns a word from the ArrayList
        return wordList.get(random);
    }

    private int getRandom(){

        int randNum = (int) (Math.random() * 2) + 1;
        randNum = Math.abs(randNum);
        return randNum;
    }
}

