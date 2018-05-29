package com.studentinvaders.tpi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Senistan.JEGARAJASIN on 24.05.2018.
 * @author Seni-J
 * @version 1.0
 */

public class StudentWords extends Words {
    StudentInvaders game;

    public final static int stateLeft = 0;
    public final static int stateRight = 1;
    public final static int stateDown = 2;

    public int state = stateLeft;
    public boolean wasLastStateLeft = true;

    public StudentWords(int vocID, int idWord, String word,wordType type){
        super(vocID,idWord,word,type);
    }


    /**
     * Méthode pour déplacer un étudiant. Si un étudiant atteint le bord de l'écran (gauche ou droite), il avance en direction du prof et il se dirige à l'autre bord de l'écran.
     */
    public void Move(float delta){
        if (state == stateLeft) {
            this.moveBy(-2f,0);
            if (this.getX() < 10) {
                state = stateDown;
                wasLastStateLeft = true;
            }
        }
        if (state == stateRight) {
            this.moveBy(2f,0);
            if (this.getX() + Words.student.getWidth() > game.viewport.getScreenWidth()) {
                state = stateDown;
                wasLastStateLeft = false;
            }
        }
        if (state == stateDown) {
            this.setPosition(this.getX(),this.getY() - 50);
            if (wasLastStateLeft)
                state = stateRight;
            else
                state = stateLeft;
            }
        }
    }
