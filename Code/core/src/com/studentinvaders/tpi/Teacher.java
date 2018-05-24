package com.studentinvaders.tpi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Senistan.JEGARAJASIN on 18.05.2018.
 */

public class Teacher extends Actor{
    Sprite spriteTeacher;


    public Teacher(){
        this.spriteTeacher = new Sprite(new Texture("Game/Prof.png"));
        this.spriteTeacher.setBounds(0,0,spriteTeacher.getWidth()/6,spriteTeacher.getHeight()/6);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        spriteTeacher.draw(batch);
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
        spriteTeacher.setPosition(this.getX(),this.getY());
    }

    public void changeImage(float x,float y) {
        this.spriteTeacher = new Sprite(new Texture("Game/ProfRetourne.png"));
        this.spriteTeacher.setBounds(x,y,spriteTeacher.getWidth()/6,spriteTeacher.getHeight()/6);
    }
    public void changeImageback(float x,float y) {
        this.spriteTeacher = new Sprite(new Texture("Game/Prof.png"));
        this.spriteTeacher.setBounds(x,y,spriteTeacher.getWidth()/6,spriteTeacher.getHeight()/6);
    }

}
