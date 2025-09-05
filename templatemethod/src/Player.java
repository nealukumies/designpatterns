public class Player {
    private String playerName;
    private int tileNumber;
    private int score;

    public Player(String playerName){
        this.playerName = playerName;
        this.tileNumber = 0;
    }

    public void movePlayer(int number){
        tileNumber += number;
        if (tileNumber < 0){
            tileNumber = 0;
        }
        System.out.println("Player " + playerName + " moved the tile " + tileNumber + ".");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getTileNumber(){
        return tileNumber;
    }

    public String getPlayerName(){
        return playerName;
    }
}
