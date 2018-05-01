package com.mygdx.game.PlayStates;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.States.State;
import com.mygdx.game.States.StateManager;

public class MainMenuState extends State {

    private Texture bg;

    public MainMenuState(StateManager gsm) {

        super(gsm);

        camera.setToOrtho(false, Game.WIDTH / 2, Game.HEIGTH / 2);

        bg = new Texture("bg.png");

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


        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(bg, 0, 0, 0, 0, 240, 400, 1, 1, 0, 0, 0, bg.getWidth(), bg.getHeight(), false, false);

        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
    }
}
