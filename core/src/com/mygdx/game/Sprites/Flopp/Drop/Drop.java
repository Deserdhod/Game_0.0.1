package com.mygdx.game.Sprites.Flopp.Drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


/**
 * Created by bgk_0_000 on 06.05.2018.
 */

public class Drop {

    private Rectangle rectangle;
    private Texture texture;
    private Sound sound;

    public Drop() {

        texture = new Texture("bidon.png");
        sound =  Gdx.audio.newSound(Gdx.files.internal("waterdrop.wav"));

        rectangle = new Rectangle();
        rectangle.width = 64;
        rectangle.height = 64;
    }


    //Что-то ещё должно быть но я хз

    public void dispose(){
        texture.dispose();
        sound.dispose();
    }
}
