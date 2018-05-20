package com.mygdx.game.Sprites.Flopp.Drop;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Drop  {

    private Rectangle rec;
    private Texture drop;

    public Drop(){
        rec = new Rectangle();
        drop = new Texture("droplet.png");
    }

    


    public void dispose(){
        drop.dispose();
    }
}
