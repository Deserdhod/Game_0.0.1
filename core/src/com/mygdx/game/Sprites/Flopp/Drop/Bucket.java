package com.mygdx.game.Sprites.Flopp.Drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


/**
 * Created by bgk_0_000 on 06.05.2018.
 */

public class Bucket {

    private Rectangle buc;
    private Texture texture;
    private Sound sound;
    //private Vector3 pos;

    public Bucket(int x, int y) {

        texture = new Texture("bidon.png");
        sound =  Gdx.audio.newSound(Gdx.files.internal("waterdrop.wav"));

        buc = new Rectangle();
        buc.width = 64;
        buc.height = 64;
        buc.x = x;
        buc.y = y;
        //pos = new Vector3(x,y,0);
    }

    public void move(int x){ //
        //this.pos.x = x;
    }

    //Что-то ещё должно быть но я хз

    public void dispose(){
        texture.dispose();
        sound.dispose();
    }
}
