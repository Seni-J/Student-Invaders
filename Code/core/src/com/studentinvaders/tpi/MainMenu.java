package com.studentinvaders.tpi;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Senistan.JEGARAJASIN on 15.05.2018.
 */

public class MainMenu implements Screen {

    final StudentInvaders game;
    boolean keyPressed = false;

    Texture bg = new Texture("Menu/bg-school.jpg");

    public MainMenu(final StudentInvaders game) {
        VocProvider.load();
        this.game = game;

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.font;

        Label jouer = new Label("JOUER",labelStyle);
        jouer.setPosition(400,500);

        jouer.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                keyPressed = true;
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        game.stage.addActor(jouer);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(game.stage);
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(bg,0,0,game.viewport.getScreenWidth(),game.viewport.getScreenHeight());
        game.batch.end();

        if(keyPressed == true){
            game.stage.getActors().pop();
            game.gotoSelectScreen();
        }
        game.stage.act();
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

    }
}
