package com.mygdx.game.Sprites.Runner;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.PlayStates.RunnerState;

import java.util.Random;

public class Soldier {

    public static final int ENEMY_WIDTH = 48;

    private Texture enemy;
    private Vector2 posEnemy;
    private Random random;
    private Animation enemAnim;
    private Rectangle rectangleEnemy;


    public Texture getEnemy() {
        return enemy;
    }


    public Vector2 getPosEnemy() {
        return posEnemy;
    }

    public Soldier(float x){

        enemy = new Texture("Bigbadgif.png");

        random = new Random();

        posEnemy = new Vector2(x, RunnerState.GROUND);

        enemAnim = new Animation(new TextureRegion(enemy), 3, 0.5f);

        rectangleEnemy = new Rectangle(posEnemy.x, posEnemy.y, enemy.getWidth() / 3, enemy.getHeight());

    }

    public void repos(float x){

        posEnemy.set(x, RunnerState.GROUND);

        rectangleEnemy.setPosition(posEnemy.x, posEnemy.y);
    }

    public void update(float dt) {
        enemAnim.update(dt);
    }

    public TextureRegion getEnem() {
        return enemAnim.getFrame();
    }

    public boolean collider(Rectangle player){

        return player.overlaps(rectangleEnemy);
    }

    public void dispose() {

        enemy.dispose();
    }
}
