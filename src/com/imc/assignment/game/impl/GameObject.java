package com.imc.assignment.game.impl;

import com.imc.assignment.game.IGameObject;

public enum GameObject implements IGameObject {

    PAPER {
        @Override
        public boolean defeats(IGameObject otherGameObject) {
            return otherGameObject == ROCK;
        }
    },
    SCISSORS {
        @Override
        public boolean defeats(IGameObject otherGameObject) {
            return otherGameObject == PAPER;
        }
    },
    ROCK {
        @Override
        public boolean defeats(IGameObject otherGameObject) {
            return otherGameObject == SCISSORS;
        }
    }
}
