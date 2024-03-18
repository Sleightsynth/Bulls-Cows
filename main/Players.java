package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;

public class Players {

    private  TopTenList topTen;
    private ArrayList<Player> players;
    private final String playerFile;

    public Players()
    {
        this.playerFile = "Data\\players.ser";
        loadPlayers();
        extractTopTen();
    }

    public void loadPlayers(){
        try {
            FileInputStream fileStream = new FileInputStream(playerFile);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            this.players = (ArrayList<Player>) objectStream.readObject();
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
            if(p.getUsername().equalsIgnoreCase(playerName))
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

    public void extractTopTen(){
        this.topTen = new TopTenList(10);
        for(Player player : this.players)
            this.topTen.add(player);
    }

    public String getLeaderboard(){
        StringBuilder returnString = new StringBuilder();
        Hashtable<String, Integer> topTen = this.topTen.getTopTen();
        int longestName = this.getLongestUsername();
        for(String name : topTen.keySet())
        {
            int score = topTen.get(name);
            StringBuilder nameBuilder = new StringBuilder(name);
            nameBuilder.append(" ".repeat(Math.max(0, longestName - nameBuilder.length() + 1)));
            name = nameBuilder.toString();
            returnString
                    .append(name)
                    .append(" : ")
                    .append(score)
                    .append("\n");
        }
        return returnString.toString();
    }

    public int getLongestUsername(){
        int size = 0;
        for(Player player : this.players)
            if(size < player.getUsername().length())
                size = player.getUsername().length();
        return size;
    }

    //public void setPlayers(ArrayList<Player> players){this.players = players;}

    //public String getPlayerFile() {return playerFile;}

    //public void getAllPlayersBulls(){}

    //public void getAllPlayersCows(){}

    //public void getAllPlayersSecretCodesAttempted(){}

    //public void getAllPlayersSecretCodesDeciphered(){}

}
