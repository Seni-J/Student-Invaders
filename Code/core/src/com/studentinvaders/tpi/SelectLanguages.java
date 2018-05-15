package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import javax.xml.soap.Text;

/**
 * Created by Senistan.JEGARAJASIN on 15.05.2018.
 */

public class SelectLanguages implements Screen {
    final StudentInvaders game;
    Texture bg;
    Texture prof;
    Texture eleve;

    public SelectLanguages(final StudentInvaders game){
        this.game = game;

        bg = new Texture("Select/bg-couloirs.png");
        prof = new Texture("Select/Prof.png");
        eleve = new Texture("Select/Eleve.png");

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.font;

        Label choixLangues = new Label("Choix des langues\n" +
                "Glissez une langue si dessous vers le personnage voulu.",labelStyle);
        choixLangues.setFontScale(.3f);
        choixLangues.setPosition(400,500);
        Label french = new Label("Français",labelStyle);
        french.setFontScale(.3f);
        french.setPosition(500,400);
        Label english = new Label("Anglais",labelStyle);
        english.setFontScale(.3f);
        english.setPosition(500,300);
        Label german = new Label("Allemand",labelStyle);
        german.setFontScale(.3f);
        german.setPosition(500,200);
        Label italian = new Label("Italien",labelStyle);
        italian.setFontScale(.3f);
        italian.setPosition(500,100);
        


        game.stage.addActor(choixLangues);
        game.stage.addActor(french);
        game.stage.addActor(english);
        game.stage.addActor(german);
        game.stage.addActor(italian);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(game.stage);
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(bg,0,0, game.viewport.getScreenWidth(),game.viewport.getScreenHeight());
        game.batch.draw(prof,180,400,prof.getWidth()/6,prof.getHeight()/6);
        game.batch.draw(eleve,200,100,eleve.getWidth()/6,eleve.getHeight()/6);
        game.batch.end();

        game.stage.draw();



    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
