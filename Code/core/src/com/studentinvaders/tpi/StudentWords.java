package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
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
    public final static int stateangry = 3;
    public final static int statepause = 4;

    public int state = stateLeft;
    public boolean wasLastStateLeft = true;

    float linearSpeed = 150f;
    float timer = 2f;


    /**
     * Constructeur pour chaque mot d'élève.
     *
     * @param vocID = id du vocabulaire
     * @param idWord = id du mot
     * @param word = Mot de l'élève
     * @param type = Le type pour le mot (Prof ou élève). Un seul type possible dans ce cas, l'élève.
     */
    public StudentWords(int vocID, int idWord, String word,wordType type){
        super(vocID,idWord,word,type);
    }


    /**
     * Méthode pour déplacer un étudiant. Si un étudiant atteint le bord de l'écran (gauche ou droite), il avance en direction du prof et il se dirige à l'autre bord de l'écran.
     */
    public void Move(float delta) {
        if (state == stateLeft) {
            this.moveBy(-2f, 0);
            if (this.getX() < 50) {
                state = stateDown;
                wasLastStateLeft = true;
            }
        }
        if (state == stateRight) {
            this.moveBy(2f, 0);
            if (this.getX() + Words.student.getWidth() > game.viewport.getScreenWidth() - 50) {
                state = stateDown;
                wasLastStateLeft = false;
            }
        }
        if (state == stateDown) {
            if (this.getX() > 1 && wasLastStateLeft) {
                moveBy(-2f, -1f);
            } else if (this.getX() + Words.student.getWidth() < game.viewport.getScreenWidth() && !wasLastStateLeft) {
                moveBy(2f, -1f);
            } else {
                if (wasLastStateLeft)
                    state = stateRight;
                else
                    state = stateLeft;
            }
        }
        if (state == statepause) {
            Vector2 speed = new Vector2();
            Vector2 deltaVector = new Vector2(0, game.viewport.getScreenHeight());
            Vector2 studentVector = new Vector2(this.getX(), this.getY());
            deltaVector.sub(studentVector);
            float dt = deltaVector.len();

            speed.x = linearSpeed / dt * deltaVector.x;
            speed.y = linearSpeed / dt * deltaVector.y;

            moveBy(speed.x * delta, speed.y * delta);
        }

        if (state == stateangry) {
           if(timer > 0) {
                moveBy(0, -1f);
                timer -= delta;
            }else {
               if (wasLastStateLeft) {
                   angry = false;
                   timer = 2f;
                   state = stateRight;
               } else {
                   angry = false;
                   timer = 2f;
                   state = stateLeft;
               }
           }
        }
    }
}

