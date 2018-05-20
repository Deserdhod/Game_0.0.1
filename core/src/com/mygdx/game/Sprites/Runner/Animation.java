package com.mygdx.game.Sprites.Runner;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {

    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float curFrameTime;
    private int frameCount;
    private int frame;

    public Animation(TextureRegion regione, int frameCount, float cycleTime){

        frames = new Array<TextureRegion>();

        int frameWidth = regione.getRegionWidth() / frameCount;

        for (int i = 0; i < frameCount; i++) {

            frames.add(new TextureRegion(regione, i * frameWidth, 0, frameWidth, regione.getRegionHeight()));
        }

        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt){

        curFrameTime += dt;

        if (curFrameTime > maxFrameTime){

            frame++;
            curFrameTime = 0;
        }

        if (frame >= frameCount)
            frame = 0;

    }

    public TextureRegion getFrame(){

        return frames.get(frame);
    }

}
