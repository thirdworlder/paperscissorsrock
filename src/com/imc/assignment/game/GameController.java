package com.imc.assignment.game;

import com.imc.assignment.game.impl.GameObject;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class GameController {

    // make easy for user to play the game - user needs to input only first char to make a move
    private final Map<String, GameObject> moveMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    private final Random rand = new Random();

    public GameController() {
        // first char of enum values as map key
        for(GameObject o : GameObject.values())
            moveMap.put(String.valueOf(o.toString().charAt(0)), o);
    }


    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.prepareAndPlay();
    }

    // translates input char to a move
    // Example: r to ROCK
    // Eaxmple: P to PAPER
    private GameObject getUserMove(char input) {
        return moveMap.get(String.valueOf(input));
    }

    private void prepareAndPlay() {
        System.out.println("Number of games to play?");
        Scanner sc = new Scanner(System.in);
        int numGames = sc.nextInt();

        while(numGames > 0){
            System.out.println("New game\nR - Rock\nP - Paper\nS - Scissors\nEnter R, P or S:");
            GameObject userMove = getUserMove(sc.next().charAt(0));
            if(userMove ==null)
                System.out.println("Try again with valid input");
            else {
                numGames--;
                int randIndex = rand.nextInt(moveMap.size());
                GameObject systemMove = GameObject.values()[randIndex];
                int result = play(userMove, systemMove);
                printResults(result, userMove, systemMove);
            }
        }
        System.out.println("All games over");
    }

    public int play(GameObject userMove, GameObject systemMove) {
        int returnValue = Integer.MIN_VALUE;
        if(systemMove.equals(userMove))
            returnValue = 0;
        else if(userMove.defeats(systemMove))
            returnValue = 1;
        else
            returnValue = -1;
        return returnValue;
    }

    private void printResults(int result, GameObject userMove, GameObject systemMove) {
        System.out.println("User move: " + userMove);
        System.out.println("System move: " + systemMove);
        if(result == 0)
            System.out.println("Draw");
        else if(result == 1)
            System.out.println("User wins");
        else if(result == -1)
            System.out.println("User loses");
        else
            System.out.println("Bad result");

        System.out.println("--- game over ---\n");
    }
}
