package com.mygdx.game.PlayStates;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Game;
import com.mygdx.game.Sprites.Flopp.Flopp;
import com.mygdx.game.Sprites.Flopp.Tube;
import com.mygdx.game.States.State;
import com.mygdx.game.States.StateManager;

public class FloppState extends State {

    private static final int TUBE_SPASSING = 125;
    private static final int TUBE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -30;

    private Flopp flopp;
    private Texture background;
    private Texture ground;
    private Vector2 groundPos1;
    private Vector2 groundPos2;
    private Array<Tube> tubes;

    public FloppState(StateManager gsm) {
        super(gsm);

        flopp = new Flopp(50, 300);

        camera.setToOrtho(false, Game.WIDTH, Game.HEIGTH );

        background = new Texture("backGround.png");
        ground = new Texture("ground.png");

        groundPos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + ground.getWidth(), GROUND_Y_OFFSET);

        tubes = new Array<Tube>();

        for (int i = 0; i < TUBE_COUNT; i++) {

            tubes.add(new Tube(i * (TUBE_SPASSING + Tube.TUBE_WIDTH)));
        }
    }

    @Override
    protected void handle() {

        if (Gdx.input.justTouched())
            flopp.jump();

    }
    @Override
    public void update(float dt) {

        handle();

        updateGround();

        flopp.update(dt);

        camera.position.x = flopp.getPos().x + 80;

        for (int i = 0; i < tubes.size; i++) {

            Tube tube = tubes.get(i);

            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){

                tube.repos(tube.getPosTopTube().x + ((TUBE_SPASSING + Tube.TUBE_WIDTH) * TUBE_COUNT));
            }

            if (tube.collider(flopp.getRectangleFlopp()))
                gsm.set(new GameOverState(gsm));
        }

        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(flopp.getFlopp(),flopp.getPos().x,flopp.getPos().y);

        for (Tube tube : tubes) {

            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y); // Если что, то tube.getPosTopTube().x поменять на tube.getPosBotTube().x
            sb.draw(tube.getBotTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);

        }

        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);

        sb.end();

    }

    private void updateGround(){

        if (camera.position.x - (camera.viewportWidth / 2) > groundPos1.x + ground.getWidth())
            groundPos1.add(ground.getWidth() * 2, 0);
        if (camera.position.x - (camera.viewportWidth / 2) > groundPos2.x + ground.getWidth())
            groundPos2.add(ground.getWidth() * 2, 0);
    }

    @Override
    public void dispose() {

        background.dispose();
        flopp.dispose();
        for (Tube tube : tubes){
            tube.dispose();
        }
        ground.dispose();
    }
}

