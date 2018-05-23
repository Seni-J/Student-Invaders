package com.studentinvaders.tpi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.ArrayList;

/**
 * Created by Senistan.JEGARAJASIN on 23.05.2018.
 */

public class Words {
    int vocID;
    int idWord;
    String wordTeacher;
    String wordPupil;

    Words(int vocID, int idWord, String wordTeacher, String wordPupil){
        this.vocID = vocID;
        this.idWord = idWord;
        this.wordTeacher = wordTeacher;
        this.wordPupil = wordPupil;
    }
}
