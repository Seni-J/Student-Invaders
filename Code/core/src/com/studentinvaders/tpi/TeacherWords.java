package com.studentinvaders.tpi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Align;

/**
 * Created by Senistan.JEGARAJASIN on 25.05.2018.
 * @author Seni-J
 * @version 1.0
 */

public class TeacherWords extends Words {

    boolean known;

    /**
     * Constructeur pour chaque mot du prof. La particularité est qu'on rajoute un booléen "known" pour savoir si le mot a été appris ou non.
     *
     * @param vocID = id du vocabulaire
     * @param idWord = id du mot
     * @param word = Mot de l'élève
     */
    public TeacherWords(int vocID, int idWord, String word){
        super(vocID,idWord,word);
        this.known = false;
        this.sprite = new Sprite(new Texture("Game/Box.png"));
        lblbox.setFontScale(.3f);
        lblbox.setBounds(this.sprite.getX(),this.sprite.getY(),this.sprite.getWidth(),this.sprite.getHeight());
        lblbox.setAlignment(Align.center);
    }
}
