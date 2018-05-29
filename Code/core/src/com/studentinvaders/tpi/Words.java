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
    Sprite box;
    Label lblbox;
    BitmapFont font;
    String word;
    wordType type;

    public Words(int vocID, int idWord, String word,wordType type){
        this.vocID = vocID;
        this.idWord = idWord;
        this.word = word;
        this.type = type;

        font = new BitmapFont(Gdx.files.internal("Font/KGWTW.fnt"));
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;

        //Switch pour différencier les mots si ils sont pour le prof ou pour l'élève.
        switch (type){
            case Teacher:
                this.box = new Sprite(new Texture("Game/Box.png"));
                lblbox = new Label(word,labelStyle);
                lblbox.setFontScale(.3f);
                lblbox.setBounds(this.box.getX(),this.box.getY(),this.box.getWidth(),this.box.getHeight());
                lblbox.setAlignment(Align.center);
                addActor(new Image(new SpriteDrawable(box)));
                addActor(lblbox);
                break;
            case Student:
                lblbox = new Label(word,labelStyle);
                lblbox.setFontScale(.19f);
                lblbox.setAlignment(Align.center);
                addActor(lblbox);
                break;
        }
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
