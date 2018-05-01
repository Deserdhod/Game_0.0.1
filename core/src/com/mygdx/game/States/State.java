package com.mygdx.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 vector3;
    protected StateManager gsm;

    public State(StateManager gsm) {

        this.gsm = gsm;
        camera = new OrthographicCamera();
        vector3 = new Vector3();

    }

    protected abstract void handle();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
