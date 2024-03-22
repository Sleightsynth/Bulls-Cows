package main;

import java.util.*;

public class TopTenList {
    public static class Node {
        private Node next;
        private Node prev;
        private final Player data;

        public Node(Player player) {
            this.data = player;
        }

        public Player getData() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrev() {
            return this.prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private int size;
    private final int cap;
    private Node head;

    public String getLeaderboard() {
        StringBuilder returnString = new StringBuilder();
        int longestName = this.getLongestUsername();

        Node current = this.head;

        while(current != null)
        {
            Player currentPlayer = current.getData();
            int score = currentPlayer.getCodesDeciphered();
            StringBuilder nameBuilder = new StringBuilder(currentPlayer.getUsername());
            nameBuilder.append(" ".repeat(Math.max(0, longestName - nameBuilder.length() + 1)));
            String name = nameBuilder.toString();
            returnString
                    .append(name)
                    .append(" : ")
                    .append(score)
                    .append("\n");
            current = current.getNext();
        }
        return returnString.toString();
    }

    public int getLongestUsername(){
        int len = 0;
        Node current = this.head;
        while (current != null){
            if(len < current.getData().getUsername().length())
                len = current.getData().getUsername().length();
            current = current.getNext();
        }
        return len;
    }

    public TopTenList(int cap) {
        this.size = 0;
        this.cap = cap;
    }

    public void add(Player data) {
        if (data == null) return;

        Node node = new Node(data);
        int score = data.getCodesDeciphered();

        Node current = this.head;
        if(current == null)
        {
            this.head = node;
            ++size;
            return;
        }

        if (this.size == this.cap)
        {
            while (current != null) {
                if (current.getData().getCodesDeciphered() < score) {
                    insertNodeBefore(current, node);
                    trimTail();
                    return;
                }
                current = current.getNext();
            }
        }
        else
        {
            while (current.getNext() != null) {
                if (current.getData().getCodesDeciphered() < score) {
                    insertNodeBefore(current, node);
                    return;
                }
                current = current.getNext();
            }
            if(current.getData().getCodesDeciphered() < data.getCodesDeciphered())
                insertNodeBefore(current, node);
            else
                insertNodeAfter(current, node);
        }
    }

    private void insertNodeBefore(Node current, Node node) {
        node.setNext(current);
        if(current.getPrev() != null)
        {
            current.getPrev().setNext(node);
            node.setPrev(current.getPrev());
        }
        else
            this.head = node;
        current.setPrev(node);
        ++this.size;
    }

    private void insertNodeAfter(Node current, Node node) {
        node.setPrev(current);
        current.setNext(node);
        ++this.size;
    }

    private void trimTail(){
        Node current = this.head;
        for(int i = 0; i < this.cap-1; ++i)
        {
            current = current.getNext();
        }
        current.getNext().setPrev(null);
        current.setNext(null);
    }

    public Hashtable<String, Integer> getTopTen(){
        Hashtable<String, Integer> nameAndScore = new Hashtable<>();
        Node current = this.head;
        while(current != null)
        {
            nameAndScore.put(
                    current.getData().getUsername(),
                    current.getData().getCodesDeciphered()
            );
            current = current.getNext();
        }
        return nameAndScore;
    }

}
