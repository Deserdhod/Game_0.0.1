package com.mygdx.game.PlayStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.States.State;
import com.mygdx.game.States.StateManager;

/**
 * Created by bgk_0_000 on 02.05.2018.
 */

public class DropStartMenuState extends State {

    private Texture backGround;

    public DropStartMenuState(StateManager gsm) {
        super(gsm);

        backGround = new Texture("ds.png");
        camera.setToOrtho(false, Game.WIDTH, Game.HEIGTH);

    }


    @Override
    protected void handle() {

        if (Gdx.input.justTouched())
            gsm.push(new DropState(gsm));
    }

    @Override
    public void update(float dt) {
        handle();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(backGround, 0, 0, Game.WIDTH, Game.HEIGTH);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
