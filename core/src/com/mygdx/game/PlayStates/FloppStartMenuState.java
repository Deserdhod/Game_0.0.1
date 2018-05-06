package com.mygdx.game.PlayStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
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
    private Music music;

    public FloppStartMenuState(StateManager gsm) {

        super(gsm);

        camera.setToOrtho(false, Game.WIDTH, Game.HEIGTH);
       // music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
       // music.setLooping(true);
       // music.setVolume(0.1f);
      //  music.play();             //я чет хз на счёт музыки мб в другом скрине её сделать
        backGround = new Texture("backGround.png");
        playButton = new Texture("playbutton.png");
    }

    @Override
    protected void handle() {

        if (Gdx.input.justTouched()) {

            gsm.push(new FloppState(gsm));

           // music.stop();
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

        sb.draw(backGround, 0, 0, Game.WIDTH, Game.HEIGTH);
        sb.draw(playButton, camera.position.x - playButton.getWidth() / 2, camera.position.y);
        sb.end();

    }

    @Override
    public void dispose() {

        music.dispose();
        backGround.dispose();
        playButton.dispose();
    }
}
