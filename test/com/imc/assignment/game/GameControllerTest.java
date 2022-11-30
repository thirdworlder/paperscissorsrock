package com.imc.assignment.game;

import com.imc.assignment.game.impl.GameObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameControllerTest {

    private GameController gameController;

    @Before
    public void init() {
        gameController = new GameController();
    }

    @Test
    public void testUserWin1() {
        GameObject userMove = GameObject.PAPER;
        GameObject systemMove = GameObject.ROCK;
        assertEquals(gameController.play(userMove, systemMove), 1);
    }

    @Test
    public void testUserWin2() {
        GameObject userMove = GameObject.ROCK;
        GameObject systemMove = GameObject.SCISSORS;
        assertEquals(gameController.play(userMove, systemMove), 1);
    }

    @Test
    public void testUserWin3() {
        GameObject userMove = GameObject.SCISSORS;
        GameObject systemMove = GameObject.PAPER;
        assertEquals(gameController.play(userMove, systemMove), 1);
    }

    @Test
    public void testUserLoss1() {
        GameObject userMove = GameObject.ROCK;
        GameObject systemMove = GameObject.PAPER;
        assertEquals(gameController.play(userMove, systemMove), -1);
    }

    @Test
    public void testUserLoss2() {
        GameObject userMove = GameObject.SCISSORS;
        GameObject systemMove = GameObject.ROCK;
        assertEquals(gameController.play(userMove, systemMove), -1);
    }

    @Test
    public void testUserLoss3() {
        GameObject userMove = GameObject.PAPER;
        GameObject systemMove = GameObject.SCISSORS;
        assertEquals(gameController.play(userMove, systemMove), -1);
    }

    @Test
    public void testDraw1() {
        GameObject userMove = GameObject.ROCK;
        GameObject systemMove = GameObject.ROCK;
        assertEquals(gameController.play(userMove, systemMove), 0);
    }

    @Test
    public void testDraw2() {
        GameObject userMove = GameObject.PAPER;
        GameObject systemMove = GameObject.PAPER;
        assertEquals(gameController.play(userMove, systemMove), 0);
    }

    @Test
    public void testDraw3() {
        GameObject userMove = GameObject.SCISSORS;
        GameObject systemMove = GameObject.SCISSORS;
        assertEquals(gameController.play(userMove, systemMove), 0);
    }

}
