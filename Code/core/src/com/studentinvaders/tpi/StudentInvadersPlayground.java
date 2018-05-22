package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
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

    Rectangle leftSide;
    Rectangle rightSide;

    boolean removeFirst = true;

    private ShapeRenderer shapeRenderer;



    public StudentInvadersPlayground(final StudentInvaders game) {
        this.game = game;
        bg = new Texture("Game/bg_game.jpg");
        boxTexture = new Texture("Game/Box.png");
        teacher = new Teacher();
        leftSide = new Rectangle();
        rightSide = new Rectangle();

        boxes = new Array<Sprite>();

        shapeRenderer = new ShapeRenderer();


        //Effacer les anciens acteurs (Labels).
        game.stage.getRoot().clearChildren();

        //Mis en place des "boutons" pour déplacer le prof de gauche à droite.
        teacher.setPosition(500,100);
        leftSide.set(0,teacher.getY(),200,teacher.spriteTeacher.getHeight());
        rightSide.set(game.viewport.getScreenWidth() - 200,teacher.getY(), 200,teacher.spriteTeacher.getHeight());

        //Création des boxes pour les mots
        for(int i=0; i< 4;i++) {
            boxes.insert(i, new Sprite(boxTexture));
            if(i != 0) {
                boxes.get(i).setPosition(boxes.get(i-1).getX() + boxes.get(i - 1).getWidth() + 50,boxes.get(i).getY());
            }else{
                boxes.get(i).setPosition(30,boxes.get(i).getY());
            }
            Gdx.app.log("Perimeters", Float.toString(boxes.get(i).getBoundingRectangle().perimeter()));
        }
        game.stage.addActor(teacher);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(bg,0,0, game.viewport.getScreenWidth(),game.viewport.getScreenHeight());
        for (Sprite box:boxes) {
            game.batch.draw(box,box.getX(),box.getY());
        }
        game.batch.end();

        MoveTeacher();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.line(boxes.get(1).getX(),150,boxes.get(1).getWidth(),150);
        shapeRenderer.rect(rightSide.x,rightSide.y,rightSide.width,rightSide.height);
        shapeRenderer.circle(Gdx.input.getX(),game.viewport.getScreenHeight() - Gdx.input.getY(),30);
        shapeRenderer.end();

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

    public void MoveTeacher(){
        if(leftSide.contains(Gdx.input.getX(),game.viewport.getScreenHeight() - Gdx.input.getY())){
            if(teacher.getX() > 0) {
                teacher.moveBy(-2.5f, 0);
            }
        }
        if(rightSide.contains(Gdx.input.getX(), game.viewport.getScreenHeight() - Gdx.input.getY())){
            if(teacher.getX() < 1180) {
                teacher.moveBy(2.5f, 0);
            }
        }
    }

    public void  WriteWords(){

    }

    public void CreatePaperFlight(){

    }
}
