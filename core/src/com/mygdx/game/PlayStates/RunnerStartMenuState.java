package com.mygdx.game.PlayStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.States.State;
import com.mygdx.game.States.StateManager;

public class RunnerStartMenuState extends State {

    private Texture backGround;
    private Texture playButton;

    public RunnerStartMenuState(StateManager gsm) {

        super(gsm);

        camera.setToOrtho(false, Game.WIDTH / 2, Game.HEIGTH / 2);

        backGround = new Texture("backGround.png");
        playButton = new Texture("playbutton.png");
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
        sb.draw(playButton,camera.position.x - playButton.getWidth() / 2, camera.position.y);

        sb.end();

    }

    @Override
    public void dispose() {

        backGround.dispose();
        playButton.dispose();
    }
}
