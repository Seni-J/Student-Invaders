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

public class Student extends Actor {
    StudentInvaders game;
    Sprite spritestudent;
    public final static int stateLeft = 0;
    public final static int stateRight = 1;
    public final static int stateDown = 2;

    public int state = stateLeft;
    public boolean wasLastStateLeft = true;

    public Student(){
        this.spritestudent = new Sprite(new Texture("Game/Eleve.png"));
        this.spritestudent.setBounds(spritestudent.getX(),spritestudent.getY(),spritestudent.getWidth()/5,spritestudent.getHeight()/5);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        spritestudent.draw(batch);
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
        spritestudent.setPosition(this.getX(),this.getY());
    }

    /**
     * Méthode pour déplacer un étudiant. Si un étudiant atteint le bord de l'écran (gauche ou droite), il avance en direction du prof et il se dirige à l'autre bord de l'écran.
     */
    public void Move(){
        if (state == stateLeft) {
            this.moveBy(-2f,0);
            if (this.getX() < 10) {
                state = stateDown;
                wasLastStateLeft = true;
            }
        }
        if (state == stateRight) {
            this.moveBy(2f,0);
            if (this.getX() + spritestudent.getWidth() > game.viewport.getScreenWidth()) {
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
