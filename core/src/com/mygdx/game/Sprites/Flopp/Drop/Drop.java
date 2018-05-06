package com.mygdx.game.Sprites.Flopp.Drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;


/**
 * Created by bgk_0_000 on 06.05.2018.
 */

public class Drop {

    private Texture texture;
    private Sound sound;

    public Drop() {
        texture = new Texture("bidon.png");
        sound =  Gdx.audio.newSound(Gdx.files.internal("waterdrop.wav"));
    }

    //Что-то ещё должно быть но я хз

    public void dispose(){
        texture.dispose();
        sound.dispose();
    }
}
