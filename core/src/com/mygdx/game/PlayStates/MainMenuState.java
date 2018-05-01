package com.mygdx.game.PlayStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.States.State;
import com.mygdx.game.States.StateManager;

public class MainMenuState extends State {

    private Texture bg;

    public MainMenuState(StateManager gsm) {

        super(gsm);

        camera.setToOrtho(false, Game.WIDTH, Game.HEIGTH);

        bg = new Texture("bg.png");

    }

    @Override
    protected void handle() {

        if (Gdx.input.justTouched()) {
            vector3.x = Gdx.input.getX();
            vector3.y = Gdx.input.getY();
            if (vector3.y >= Game.HEIGTH - 90) {
                if (vector3.x <= Game.WIDTH / 3)
                    gsm.push(new FloppState (gsm));//left

                else if (vector3.x >= Game.WIDTH / 3 * 2)
                    gsm.push(new FloppState (gsm));//right
                else
                    gsm.push(new FloppState (gsm));//centre

               // else if (vector3.x >= Game.WIDTH / 3 * 2)
                    //gsm.push(new FloppState (gsm));//right
             //   else
                   // gsm.push(new /**/ (gsm));//centre

            }
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

        sb.draw(bg, 0, 0, Game.WIDTH, Game.HEIGTH);

        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
    }
}
