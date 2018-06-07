package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;

/**
 * Created by Senistan.JEGARAJASIN on 23.05.2018.
 */

public class Words extends Group{

    public enum wordType{
        Teacher,
        Student
    }

    int vocID;
    int idWord;
    protected Sprite sprite;
    Label lblbox;
    BitmapFont font;
    String word;
    wordType type;
    boolean angry = false;

    public Words(int vocID, int idWord, String word){
        this.vocID = vocID;
        this.idWord = idWord;
        this.word = word;

        font = new BitmapFont(Gdx.files.internal("Font/KGWTW.fnt"));
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;

        lblbox = new Label(word,labelStyle);
        addActor(new Image(new SpriteDrawable(sprite)));
        addActor(lblbox);
    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public int getIdWord() {
        return idWord;
    }

    @Override
    public float getHeight() {
        return super.getHeight();
    }

    @Override
    public float getWidth() {
        return super.getWidth();
    }
}
