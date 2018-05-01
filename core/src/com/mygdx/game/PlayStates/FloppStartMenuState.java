package com.mygdx.game.PlayStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.States.State;
import com.mygdx.game.States.StateManager;

/**
 * Created by bgk_0_000 on 01.05.2018.
 */

public class FloppStartMenuState extends State {
    private Texture backGround;
    private Texture playButton;

    public FloppStartMenuState(StateManager gsm) {

        super(gsm);

        camera.setToOrtho(false, Game.WIDTH,Game.HEIGTH);

        backGround = new Texture("backGround.png");
        playButton = new Texture("playbutton.png");
    }

    @Override
    protected void handle() {

        if (Gdx.input.justTouched()) {

            gsm.push(new FloppState(gsm));
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

 sb.draw(backGround,0,0,Game.WIDTH,Game.HEIGTH);
sb.draw(playButton,camera.position.x - playButton.getWidth() / 2, camera.position.y);
        sb.end();

    }

    @Override
    public void dispose() {

        backGround.dispose();
        playButton.dispose();
    }
}
