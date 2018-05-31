package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Senistan.JEGARAJASIN on 30.05.2018.
 */

public class GameOver implements Screen {
    StudentInvaders game;
    Texture bg;
    boolean keyPressed = false;

    public GameOver(StudentInvaders game) {
        this.game = game;
        bg = new Texture("GameOver.jpg");
        game.stage.getRoot().clearChildren();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.gameoverfont;

        Label gameOver = new Label("GAME OVER",labelStyle);
        gameOver.setPosition(game.viewport.getScreenWidth()/5 + 100,game.viewport.getScreenHeight()/2);

        Label rejouer = new Label("Retour au menu",labelStyle);
        rejouer.setPosition(game.viewport.getScreenWidth()/5 + 100,game.viewport.getScreenHeight()/2 - 200);

        rejouer.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                keyPressed = true;
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        game.stage.addActor(gameOver);
        game.stage.addActor(rejouer);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(bg,0,0,game.viewport.getScreenWidth(),game.viewport.getScreenHeight());
        game.batch.end();

        if(keyPressed){
            game.stage.clear();
            game.gotoMainScreen();
        }

        game.stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.stage.dispose();
    }
}
