package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.PlayStates.MainMenuState;
import com.mygdx.game.States.StateManager;

public class Game extends ApplicationAdapter {

    public static final int WIDTH = 480;
    public static final int HEIGTH = 800;
    public static final String TITLE = "Game Trip";

    private SpriteBatch batch;
    private StateManager gsm;


    @Override
    public void create() {
        batch = new SpriteBatch();
        gsm = new StateManager();

        Gdx.gl.glClearColor(1, 0, 0, 1);

        gsm.push(new MainMenuState(gsm));

    }

    @Override
    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
