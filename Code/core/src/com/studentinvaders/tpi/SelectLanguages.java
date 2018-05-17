package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

import javax.xml.soap.Text;

/**
 * Created by Senistan.JEGARAJASIN on 15.05.2018.
 */

public class SelectLanguages implements Screen {
    final StudentInvaders game;
    Texture bg;
    Sprite prof;
    Sprite eleve;

    Group grpVoc;

    ArrayList<String> langues;
    ArrayList<Vocabulary> vocabulaires;
    int ylang = 450;
    int yvoc = 450;
    int i = 1;


    int proflangue;
    int elevelangue;
    boolean once = true;

    final Label choixLangues;

    Rectangle profRect;
    Rectangle eleveRect;

    private ShapeRenderer shapeRenderer;

    public SelectLanguages(final StudentInvaders game){
        this.game = game;
        langues = VocProvider.getLanguages();
        vocabulaires = VocProvider.getVocs();
        grpVoc = new Group();

        bg = new Texture("Select/bg-couloirs.png");
        prof = new Sprite(new Texture("Select/Prof.png"));
        eleve = new Sprite(new Texture("Select/Eleve.png"));

        prof.setBounds(200,400,prof.getWidth()/6,prof.getHeight()/6);
        eleve.setBounds(200,100,eleve.getWidth()/6,eleve.getHeight()/6);

        profRect = new Rectangle(prof.getX(),prof.getY(),prof.getWidth(),prof.getHeight());
        eleveRect = new Rectangle(eleve.getX(),eleve.getY(),eleve.getWidth(),eleve.getHeight());

        shapeRenderer = new ShapeRenderer();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.font;

        choixLangues = new Label("Choix des langues\n" +
                "Glissez une langue ci-dessous vers le personnage voulu.",labelStyle);
        choixLangues.setFontScale(.3f);
        choixLangues.setAlignment(Align.center);
        choixLangues.setBounds(150,600,choixLangues.getMinWidth(),choixLangues.getMinHeight());
        game.stage.addActor(choixLangues);


        for (String langue: langues) {
            final Label lbllangue = new Label(langue,labelStyle);
            lbllangue.setFontScale(.3f);
            lbllangue.setPosition(400,ylang);
            lbllangue.setSize(lbllangue.getMinWidth(),lbllangue.getMinHeight());

            lbllangue.addListener(new DragListener() {
                public void drag(InputEvent event, float x, float y, int pointer) {
                    lbllangue.moveBy(x - lbllangue.getWidth()/2, y - lbllangue.getHeight()/2);
                }
            });
            ylang -= 100;
            game.stage.addActor(lbllangue);
            game.stage.getActors().peek().setName(langue);
        }

        /*for (Vocabulary vocabulaire : vocabulaires) {
                final Label lblvocabulaire = new Label(vocabulaire.vocName, labelStyle);
                lblvocabulaire.setFontScale(.3f);
                lblvocabulaire.setPosition(800, yvoc);
                lblvocabulaire.setSize(lblvocabulaire.getMinWidth(), lblvocabulaire.getMinHeight());
                yvoc -= 50;
                grpVoc.addActor(lblvocabulaire);
        }
        grpVoc.setName("Vocabulaires");
        game.stage.addActor(grpVoc);*/
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(game.stage);
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(bg,0,0, game.viewport.getScreenWidth(),game.viewport.getScreenHeight());
        eleve.draw(game.batch);
        prof.draw(game.batch);
        game.batch.end();

        checkIfCollide();


        /*
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(profRect.x,profRect.y,profRect.width,profRect.height);
        shapeRenderer.rect(game.stage.getActors().get(1).getX(),game.stage.getActors().get(1).getY(),game.stage.getActors().get(1).getWidth(),game.stage.getActors().get(1).getHeight());
        shapeRenderer.rect(game.stage.getActors().get(2).getX(),game.stage.getActors().get(2).getY(),game.stage.getActors().get(2).getWidth(),game.stage.getActors().get(2).getHeight());
        shapeRenderer.end();*/


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

    public void checkIfCollide() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = game.font;
        Label langueChoisiProf = new Label("Langue choisie pour le prof:", labelStyle);
        langueChoisiProf.setFontScale(.3f);
        langueChoisiProf.setPosition(0, 50);
        langueChoisiProf.setSize(langueChoisiProf.getMinWidth(), langueChoisiProf.getMinHeight());
        Label langueChoisiEleve = new Label("Langue choisie pour l'élève:", labelStyle);
        langueChoisiEleve.setFontScale(.3f);
        langueChoisiEleve.setPosition(0, 10);
        langueChoisiEleve.setSize(langueChoisiEleve.getMinWidth(), langueChoisiEleve.getMinHeight());

        // Fix issue when
        if(once == true){
            if (game.stage.getActors().get(game.stage.getActors().size - 2).toString().contains(String.valueOf(langues.get(langues.size() - 1)))) {
                game.stage.addActor(langueChoisiProf);
                game.stage.addActor(langueChoisiEleve);
            }
            once = false;
        }


        if(game.stage.getActors().peek().toString().contains(String.valueOf("JOUER"))){
            if(proflangue == 0 || elevelangue == 0){
                game.stage.getActors().pop();
            }
        }

        //Check si il y a une collision entre le prof et la langue ou l'élève et la langue.
        for(String langue : langues){
            i = 1 + langues.indexOf(langue);
            Rectangle langueRect = new Rectangle(game.stage.getActors().get(i).getX(),game.stage.getActors().get(i).getY(),
                    game.stage.getActors().get(i).getWidth(),game.stage.getActors().get(i).getHeight());

            if(langueRect.overlaps(profRect)) {
                proflangue = i;
                if (!game.stage.getActors().peek().toString().contains(String.valueOf("JOUER"))) {
                    langueChoisiProf.setText("Langue choisie pour le prof: " + langue);
                    if (!game.stage.getActors().get(game.stage.getActors().size - 1).toString().contains(String.valueOf(langueChoisiProf))) {
                        game.stage.getActors().get(game.stage.getActors().size - 1).remove();
                        game.stage.addActor(langueChoisiProf);
                        game.stage.getActors().swap(game.stage.getActors().size - 1, game.stage.getActors().size - 1);
                    }
                }
            }

            if(langueRect.overlaps(eleveRect)) {
                elevelangue = i;
                if (!game.stage.getActors().peek().toString().contains(String.valueOf("JOUER"))) {
                    langueChoisiEleve.setText("Langue choisie pour l'élève: " + langue);
                    if (!game.stage.getActors().peek().toString().contains(String.valueOf(langueChoisiEleve))) {
                        game.stage.getActors().pop();
                        game.stage.addActor(langueChoisiEleve);
                    }
                }
            }
        }

        for (Vocabulary vocabulaire : vocabulaires) {
            if(vocabulaire.langeleve == elevelangue && vocabulaire.langprof == proflangue){
                /*****/
            }
        }


        if (proflangue != 0 && elevelangue != 0 && elevelangue != proflangue) {
            Label jouer = new Label("JOUER", labelStyle);
            jouer.setPosition(800, 0);

            Label lblvocs = new Label("Vocabulaires", labelStyle);
            lblvocs.setFontScale(.2f);
            lblvocs.setPosition(800, 480);
            //game.stage.addActor(lblvocs);


            jouer.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    game.gotoGameScreen();
                    return super.touchDown(event, x, y, pointer, button);
                }
            });

            if (!game.stage.getActors().peek().toString().contains(String.valueOf("JOUER"))) {
                game.stage.addActor(jouer);
            }
        }

/*
        if(!profRect.overlaps(frenchRect) && !profRect.overlaps(englishRect) && !profRect.overlaps(germanRect) && !profRect.overlaps(italianRect)){
            proflangue = 0;
            game.stage.getActors().get(game.stage.getActors().size - 2).remove();
            game.stage.addActor(langueChoisiProf);
            game.stage.getActors().swap(game.stage.getActors().size - 2, game.stage.getActors().size - 1);
        }

        if(!eleveRect.overlaps(frenchRect) && !eleveRect.overlaps(englishRect) && !eleveRect.overlaps(germanRect) && !eleveRect.overlaps(italianRect)){
            if(elevelangue != 0) {
                elevelangue = 0;
                game.stage.getActors().pop();
                game.stage.addActor(langueChoisiEleve);
            }
        }
*/
    }

}
