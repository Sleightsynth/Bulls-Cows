package main;

import java.io.*;
import java.util.ArrayList;

public class Players {

    private ArrayList<Player> players;
    private final String playerFile;
    public Players()
    {
        this.playerFile = "Data\\players.ser";
        loadPlayers();
    }

    public void loadPlayers(){
        try {
            FileInputStream fileStream = new FileInputStream(playerFile);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            this.players = (ArrayList<Player>) objectStream.readObject();
            for(Player player : this.players) {
                System.out.println(player.getUsername());
                System.out.println(player.getCodesDeciphered());
            }
            fileStream.close();
            objectStream.close();
        } catch (FileNotFoundException e){
            System.err.println("No file found : No players loaded");
            this.players = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePlayers(){
        for(Player player : this.players) {
            System.out.println(player.getUsername());
            System.out.println(player.getCodesDeciphered());
        }
        try{
            FileOutputStream fileStream = new FileOutputStream(playerFile);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(getPlayers());
            fileStream.close();
            objectStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Player findPlayer(String playerName)
    {
        for (Player p : getPlayers())
            if(p.getUsername().equals(playerName))
                return p;
        Player player = new Player(playerName);
        addPlayer(player);
        return player;
    }


    public void addPlayer(Player player)
    {
        this.players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }

    public String getPlayerFile() {
        return playerFile;
    }

    public void getAllPlayersBulls(){}

    public void getAllPlayersCows(){}

    public void getAllPlayersSecretCodesAttempted(){}

    public void getAllPlayersSecretCodesDeciphered(){}

}
