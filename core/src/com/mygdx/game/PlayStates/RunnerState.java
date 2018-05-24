package com.mygdx.game.PlayStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Game;
import com.mygdx.game.Sprites.Runner.Runner;
import com.mygdx.game.Sprites.Runner.Soldier;
import com.mygdx.game.States.State;
import com.mygdx.game.States.StateManager;

public class RunnerState extends State {

    private static final int ENEMY_SPASSING = 400;
    private static final int ENEMY_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -30;
    public static final int GROUND = 80;

    boolean coll;
    int a;
    Rectangle rectangle;
    BitmapFont font = new BitmapFont();
    private int score;
    private Runner runner;
    private Texture background;
    private Texture ground;
    private Vector2 groundPos1;
    private Vector2 groundPos2;

    private Array<Soldier> soldiers;

    public RunnerState(StateManager gsm) {

        super(gsm);

        a = 0;
        score = 0;
        coll = false;

        runner = new Runner(80, GROUND);

        rectangle = new Rectangle(runner.getPos().x, 0, runner.getPos().x - 20, Game.HEIGTH / 2);

        camera.setToOrtho(false, Game.WIDTH / 2, Game.HEIGTH / 2);

        background = new Texture("rbg.png");
        ground = new Texture("rground.png");

        groundPos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + ground.getWidth(), GROUND_Y_OFFSET);

        soldiers = new Array<Soldier>();

        for (int i = 0; i < ENEMY_COUNT; i++) {

            soldiers.add(new Soldier(i * (ENEMY_SPASSING + Soldier.ENEMY_WIDTH)));
        }

    }

    @Override
    protected void handle() {

        if (runner.getPos().y == GROUND)
            if (Gdx.input.justTouched())
                runner.jump();

    }

    @Override
    public void update(float dt) {

        handle();

        updateGround();

        runner.update(dt);

        camera.position.x = runner.getPos().x + 80;

        rectangle.setX(runner.getPos().x - 20);
        a = 0;

        for (int i = 0; i < soldiers.size; i++) {

            Soldier soldier = soldiers.get(i);

            soldier.update(dt);

            if (camera.position.x - (camera.viewportWidth / 2) > soldier.getPosEnemy().x + soldier.getEnemy().getWidth()){

                soldier.repos(soldier.getPosEnemy().x + ((ENEMY_SPASSING + Soldier.ENEMY_WIDTH) * ENEMY_COUNT));
            }

            if (soldier.collider(runner.getRectangleFlopp())) {
                score = 0;
                gsm.set(new GameOverState(gsm));
            }
            if ((soldier.collider(rectangle)) && !coll) {
                score++;
                coll = true;
            }
            else if (!soldier.collider(rectangle))
                a++;
        }
        if (a == soldiers.size)
            coll = false;

        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(runner.getFlopp(), runner.getPos().x, runner.getPos().y);

        for (Soldier soldier : soldiers) {

            sb.draw(soldier.getEnem(), soldier.getPosEnemy().x, soldier.getPosEnemy().y);

        }

        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);

        font.draw(sb,"Score " + score,runner.getPos().x + 50 ,Game.HEIGTH / 2);

        sb.end();

    }

    private void updateGround() {

        if (camera.position.x - (camera.viewportWidth / 2) > groundPos1.x + ground.getWidth())
            groundPos1.add(ground.getWidth() * 2, 0);
        if (camera.position.x - (camera.viewportWidth / 2) > groundPos2.x + ground.getWidth())
            groundPos2.add(ground.getWidth() * 2, 0);
    }

    @Override
    public void dispose() {

        background.dispose();
        runner.dispose();
        for (Soldier soldier : soldiers) {
            soldier.dispose();
        }
        ground.dispose();
    }
}
