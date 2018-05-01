package com.mygdx.game.Sprites.Flopp;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {

    public static final int FLUCT = 130;
    public static final int TUBE_GAP = 100;
    public static final int LOWEST_OPENNING = 120;
    public static final int TUBE_WIDTH = 52;

    private Texture topTube;
    private Texture botTube;
    private Vector2 posTopTube;
    private Vector2 posBotTube;
    private Random random;
    private Rectangle rectangleTopTube;
    private Rectangle rectangleBotTube;

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBotTube() {
        return botTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Tube(float x){

        topTube = new Texture("tubeTop.png");
        botTube = new Texture("tubeBottom.png");

        random = new Random();

        posTopTube = new Vector2(x, random.nextInt(FLUCT) + TUBE_GAP + LOWEST_OPENNING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - botTube.getHeight());

        rectangleTopTube = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        rectangleBotTube = new Rectangle(posBotTube.x, posBotTube.y, botTube.getWidth(), botTube.getHeight());

    }

    public void repos(float x){

        posTopTube.set(x, random.nextInt(FLUCT) + TUBE_GAP + LOWEST_OPENNING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - botTube.getHeight());

        rectangleTopTube.setPosition(posTopTube.x, posTopTube.y);
        rectangleBotTube.setPosition(posBotTube.x, posBotTube.y);
    }

    public boolean collider(Rectangle player){

        return player.overlaps(rectangleTopTube) || player.overlaps(rectangleBotTube);
    }

    public void dispose() {

        topTube.dispose();
        botTube.dispose();
    }
}
