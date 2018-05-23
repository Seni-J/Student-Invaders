package com.studentinvaders.tpi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.ArrayList;

/**
 * Created by Senistan.JEGARAJASIN on 23.05.2018.
 */

public class Boxes extends Actor {
    Sprite box;
    Label lblbox;

    public Boxes(){
        box = new Sprite(new Texture("Game/Box.png"));

    }

}
