public class Player {

    private String name;


    public Player(String name) {
        this.name = name;
    }


    public Player(String name, int the, double te) {
        this.name = name;
        int x = 1;
        if(x == 2){
            setterName("the");
        }
    }

    public void setterName(String newName) {
        name = newName;
        Player use = new Player("",3,6.5);
    }

    public String getName() {
        return name;
    }

}