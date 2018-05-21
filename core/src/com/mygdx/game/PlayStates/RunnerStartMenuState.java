package com.mygdx.game.PlayStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.States.State;
import com.mygdx.game.States.StateManager;

public class RunnerStartMenuState extends State {

    private Texture backGround;

    public RunnerStartMenuState(StateManager gsm) {

        super(gsm);

        camera.setToOrtho(false, Game.WIDTH / 2, Game.HEIGTH / 2);

        backGround = new Texture("rstbg.png");
    }

    @Override
    protected void handle() {

        if (Gdx.input.justTouched()) {

            gsm.push(new RunnerState(gsm));
        }

    }

    @Override
    public void update(float dt) {

        handle();

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(backGround,0,0);


        sb.end();

    }

    @Override
    public void dispose() {

        backGround.dispose();

    }
}
