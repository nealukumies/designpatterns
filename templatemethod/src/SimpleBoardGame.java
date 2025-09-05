import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SimpleBoardGame extends Game {
    private Player[] players;
    private int numberOfTiles;
    private HashSet<Integer> badTiles;
    private int winner;
    private boolean gameOver;

    public SimpleBoardGame() {
        this.numberOfTiles = 40;
        this.gameOver = false;
    }

    public void initializeGame(int numberOfPlayers) {
        System.out.println("Initializing Simple Board Game");
        initializePlayers(numberOfPlayers);
        initializeBadTiles();
    }

    public void initializePlayers(int numberOfPlayers) {
        this.players = new Player[numberOfPlayers];
        for (int i = 1; i <= numberOfPlayers; i++) {
            String playerName = "Player " + i;
            players[i - 1] = new Player(playerName);
        }
        System.out.println("Players are initialized.");
    }

    public void initializeBadTiles() {
        int numberOfBadTiles = numberOfTiles/3;
        badTiles = new HashSet<>(numberOfBadTiles);
        while (badTiles.size() < numberOfBadTiles) {
            int randomTile = (int)(Math.random() * numberOfTiles + 1);
            if (randomTile == numberOfTiles) {
                randomTile = numberOfTiles - 1; //Don´t make the last tile a bad tile
            }
            badTiles.add(randomTile);
        }
        TreeSet<Integer> sortedBadTiles = new TreeSet<>(badTiles);
        System.out.println("Bad tiles are: " + sortedBadTiles.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public boolean endOfGame() {
        return gameOver;
    }

    public void playSingleTurn(int player) {
        int random = (int) (Math.random() * 6) +1;
        players[player].movePlayer(random);
        if (players[player].getTileNumber() >= numberOfTiles) {
            this.winner = player;
            gameOver = true;
        } else if (isOnBadTile(players[player].getTileNumber())){
            System.out.println("Player " + players[player].getPlayerName() + " landed on a bad tile and moves back 3 tiles.");
            players[player].movePlayer(-3);
        }
    }

    public void displayWinner() {
        System.out.println("Winner is player number " + winner);
        System.out.println("The final results for all players are:");
        for (Player player: players) {
            int tile = player.getTileNumber();
            System.out.println("Player " + player.getPlayerName() + " is on tile " + tile);
        }
    }

    public boolean isOnBadTile(int tile) {
        return badTiles.contains(tile);
    }
}
