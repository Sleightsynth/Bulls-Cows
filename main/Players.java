package main;

import java.util.ArrayList;

public class Players {

    private ArrayList<Player> players;
    private String playerFile;

    public Players()
    {
        this.players = new ArrayList<Player>();
        this.playerFile = "Data\\players.txt";
    }

    public void savePlayers(){}

    public Player findPlayer(Player player){return player;}

    public void addPlayer(Player player)
    {
        this.players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String getPlayerFile() {
        return playerFile;
    }

    public void getAllPlayersBulls(){}
    public void getAllPlayersCows(){}
    public void getAllPlayersSecretCodesAttempted(){}
    public void getAllPlayersSecretCodesDeciphered(){}
}
