package com.mygdx.game.Sprites.Runner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Runner {

    private static final int GRAVITY = -15;
    private static final int MOVE = 100;

    private Vector3 pos;
    private Vector3 vel;
    private Rectangle rectangleFlopp;
    private Animation floppAnim;
    private Texture texture;
    private Sound sound;

    public Runner(int x, int y) {

        pos = new Vector3(x, y, 0);
        vel = new Vector3(0, 0, 0);
        texture = new Texture("floppAnimation.png");
        floppAnim = new Animation(new TextureRegion(texture), 3, 0.5f);
        rectangleFlopp = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
        sound = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float dt) {

        floppAnim.update(dt);

        if (pos.y > 0)
            vel.add(0, GRAVITY, 0);

        if (vel.x >= 0)
                vel.add(-5, 0, 0);

        vel.scl(dt);

        pos.add(MOVE * dt + vel.x, vel.y, 0);

        if (pos.y < 0)
            pos.y = 0;

        vel.scl(1 / dt);

        if (pos.y <= 80)
            pos.y = 80;

        rectangleFlopp.setPosition(pos.x, pos.y);
    }

    public Vector3 getPos() {
        return pos;
    }

    public TextureRegion getFlopp() {
        return floppAnim.getFrame();
    }

    public void jump() {

        vel.y = 500;
        vel.x = 200;

        sound.play();
    }

    public Rectangle getRectangleFlopp() {

        return rectangleFlopp;
    }

    public void dispose() {

        texture.dispose();
        sound.dispose();
    }
}
