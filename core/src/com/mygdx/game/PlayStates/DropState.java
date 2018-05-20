package com.mygdx.game.PlayStates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Sprites.Flopp.Drop.Bucket;
import com.mygdx.game.States.State;
import com.mygdx.game.States.StateManager;



public class DropState extends State {

    Bucket bucket;

    public DropState(StateManager gsm) {
        super(gsm);

        bucket = new Bucket(800 / 2 - 64 / 2,20);
    }

    @Override
    protected void handle() {

    }

    @Override
    public void update(float dt) {

        handle();


    }

    @Override
    public void render(SpriteBatch sb) {

    }

    @Override
    public void dispose() {

    }
}
