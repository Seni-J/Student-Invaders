package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Senistan.JEGARAJASIN on 15.05.2018.
 */

public class StudentInvadersPlayground extends Actor implements Screen{
    final StudentInvaders game;

    static Array<Sprite> boxes;
    Texture bg;
    Texture boxTexture;
    Teacher teacher;

    boolean removeFirst = true;



    public StudentInvadersPlayground(final StudentInvaders game) {
        this.game = game;
        bg = new Texture("Game/bg_game.jpg");
        boxTexture = new Texture("Game/Box.png");
        teacher = new Teacher();

        boxes = new Array<Sprite>();


        //Effacer les anciens acteurs (Labels).
        game.stage.getRoot().clearChildren();

        teacher.setPosition(500,150);

        for(int i=0; i< 4;i++) {
            boxes.insert(i, new Sprite(boxTexture));
            if(i != 0) {
                boxes.get(i).setPosition(boxes.get(i-1).getX() + boxes.get(i - 1).getWidth() + 50,boxes.get(i).getY());
            }
        }

        teacher.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        game.stage.addActor(teacher);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(bg,0,0, game.viewport.getScreenWidth(),game.viewport.getScreenHeight());
        //teacher.Move(0.2f,0.2f);
        game.batch.end();

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
