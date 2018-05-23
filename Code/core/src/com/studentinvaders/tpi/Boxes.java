package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.ArrayList;

/**
 * Created by Senistan.JEGARAJASIN on 23.05.2018.
 */

public class Boxes {
    Sprite box;
    Label lblbox;
    BitmapFont font;

    Boxes(String word){
        /*font = new BitmapFont(Gdx.files.internal("Font/KGWTW.fnt"));
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;*/

        this.box = new Sprite(new Texture("Game/Box.png"));
/*
        this.lblbox = new Label(word,labelStyle);
        this.lblbox.setPosition(box.getHeight()/2,box.getWidth()/2);*/
    }


}
