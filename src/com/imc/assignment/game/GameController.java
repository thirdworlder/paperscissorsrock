package com.imc.assignment.game;

import com.imc.assignment.game.impl.GameObject;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class GameController {

    private final Map<String, GameObject> moveMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    private Random rand = new Random();

    public GameController() {
        // first char of enum values as map key - user needs to input only first char
        for(GameObject o : GameObject.values())
            moveMap.put(String.valueOf(o.toString().charAt(0)), o);
    }


    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.prepareAndPlay();
    }

    private GameObject getUserMove(char input) {
        return moveMap.get(input);
    }

    private void prepareAndPlay() {
        System.out.println("Number of games to play?");
        Scanner sc = new Scanner(System.in);
        int numGames = sc.nextInt();

        while(numGames > 0){
            System.out.println("R - Rock\nP - Paper\nS - Scissors\nEnter R, P or S:");
            GameObject userMove = getUserMove(sc.next().charAt(0));
            if(userMove ==null)
                System.out.println("Try again with valid input");
            else {
                numGames--;
                play(userMove);
            }
        }
        System.out.println("Game over");
    }

    private void play(GameObject userMove) {
        int randIndex = rand.nextInt(moveMap.size());
        GameObject systemMove = GameObject.values()[randIndex - 1];
        if(systemMove.equals(userMove))
            System.out.println("Draw");
        else if(userMove.defeats(systemMove))
            System.out.println("User wins");
        else
            System.out.println("User loses");

    }
}
