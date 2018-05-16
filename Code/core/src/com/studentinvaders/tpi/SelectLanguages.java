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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Align;

import javax.xml.soap.Text;

/**
 * Created by Senistan.JEGARAJASIN on 15.05.2018.
 */

public class SelectLanguages implements Screen {
    final StudentInvaders game;
    Texture bg;
    Sprite prof;
    Sprite eleve;
    Actor check;
    int proflangue;
    int elevelangue;
    boolean once = true;

    final Label choixLangues;
    final Label french;
    final Label english;
    final Label german;
    final Label italian;


    Rectangle profRect;
    Rectangle eleveRect;
    Rectangle frenchRect;
    Rectangle englishRect;
    Rectangle germanRect;
    Rectangle italianRect;


    private ShapeRenderer shapeRenderer;

    public SelectLanguages(final StudentInvaders game){
        this.game = game;

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

        french = new Label("Français",labelStyle);
        french.setFontScale(.3f);
        french.setPosition(400,450);
        french.setSize(french.getMinWidth(),french.getMinHeight());
        frenchRect = new Rectangle(french.getX(),french.getY(),french.getMinWidth(),french.getMinHeight());

        english = new Label("Anglais",labelStyle);
        english.setFontScale(.3f);
        english.setPosition(400,350);
        english.setSize(english.getMinWidth(),english.getMinHeight());
        englishRect = new Rectangle(english.getX(),english.getY(),english.getMinWidth(),english.getMinHeight());

        german = new Label("Allemand",labelStyle);
        german.setFontScale(.3f);
        german.setPosition(400,250);
        german.setSize(german.getMinWidth(),german.getMinHeight());
        germanRect = new Rectangle(german.getX(),german.getY(),german.getMinWidth(),german.getMinHeight());

        italian = new Label("Italien",labelStyle);
        italian.setFontScale(.3f);
        italian.setPosition(400,150);
        italian.setSize(italian.getMinWidth(),italian.getMinHeight());
        italianRect = new Rectangle(italian.getX(),italian.getY(),italian.getMinWidth(),italian.getMinHeight());

        french.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                french.moveBy(x - french.getWidth()/2, y - french.getHeight()/2);
            }
        });

        english.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                english.moveBy(x - english.getWidth()/2, y - english.getHeight()/2);
            }
        });

        german.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                german.moveBy(x - german.getWidth()/2, y - german.getHeight()/2);
            }
        });

        italian.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                italian.moveBy(x - italian.getWidth()/2, y - italian.getHeight()/2);
            }
        });


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
        eleve.draw(game.batch);
        prof.draw(game.batch);
        game.batch.end();

        updateRect();
        checkIfCollide();


        if(game.stage.getActors().size > 10){
            Gdx.app.log("Array Actors", game.stage.getActors().toString());
        }


        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(profRect.x,profRect.y,profRect.width,profRect.height);
        shapeRenderer.rect(frenchRect.x,frenchRect.y,frenchRect.width,frenchRect.height);
        shapeRenderer.end();


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

    public void updateRect(){
        frenchRect.set(french.getX(),french.getY(),french.getMinWidth(),french.getMinHeight());
        englishRect.set(english.getX(),english.getY(),english.getMinWidth(),english.getMinHeight());
        germanRect.set(german.getX(),german.getY(),german.getMinWidth(),german.getMinHeight());
        italianRect.set(italian.getX(),italian.getY(),italian.getMinWidth(),italian.getMinHeight());
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

        //Label pour voir quelles langues ont été choisies. Mais vu que le langage Italien peut être choisi en dernier pour l'élève, cela pose quelques problèmes d'ou le boolean.
        if(once == true){
            if (game.stage.getActors().peek().toString().contains(String.valueOf("Italien"))) {
                game.stage.addActor(langueChoisiProf);
                game.stage.addActor(langueChoisiEleve);
            }
            once = false;
        }


        if (proflangue != 0 && elevelangue != 0 && elevelangue != proflangue) {
            Label jouer = new Label("JOUER", labelStyle);
            jouer.setPosition(800, 0);

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

        if (!game.stage.getActors().peek().toString().contains(String.valueOf("JOUER"))) {
            if (profRect.overlaps(frenchRect)) {
                langueChoisiProf.setText("Langue choisie pour le prof: Français.");
                if (!game.stage.getActors().get(game.stage.getActors().size - 2).toString().contains(String.valueOf(langueChoisiProf))) {
                    game.stage.getActors().get(game.stage.getActors().size - 2).remove();
                    game.stage.addActor(langueChoisiProf);
                    game.stage.getActors().swap(game.stage.getActors().size - 2, game.stage.getActors().size - 1);
                    proflangue = 1;
                }
            } else if (profRect.overlaps(englishRect)) {
                langueChoisiProf.setText("Langue choisie pour le prof: Anglais.");
                if (!game.stage.getActors().get(game.stage.getActors().size - 2).toString().contains(String.valueOf(langueChoisiProf))) {
                    game.stage.getActors().get(game.stage.getActors().size - 2).remove();
                    game.stage.addActor(langueChoisiProf);
                    game.stage.getActors().swap(game.stage.getActors().size - 2, game.stage.getActors().size - 1);
                    proflangue = 2;
                }
            } else if (profRect.overlaps(germanRect)) {
                langueChoisiProf.setText("Langue choisie pour le prof: Allemand.");
                if (!game.stage.getActors().get(game.stage.getActors().size - 2).toString().contains(String.valueOf(langueChoisiProf))) {
                    game.stage.getActors().get(game.stage.getActors().size - 2).remove();
                    game.stage.addActor(langueChoisiProf);
                    game.stage.getActors().swap(game.stage.getActors().size - 2, game.stage.getActors().size - 1);
                    proflangue = 3;
                }
            } else if (profRect.overlaps(italianRect)) {
                langueChoisiProf.setText("Langue choisie pour le prof: Italien.");
                if (!game.stage.getActors().get(game.stage.getActors().size - 2).toString().contains(String.valueOf(langueChoisiProf))) {
                    game.stage.getActors().get(game.stage.getActors().size - 2).remove();
                    game.stage.addActor(langueChoisiProf);
                    game.stage.getActors().swap(game.stage.getActors().size - 2, game.stage.getActors().size - 1);
                    proflangue = 4;
                }
            }

            if (eleveRect.overlaps(frenchRect)) {
                langueChoisiEleve.setText("Langue choisie pour l'élève: Français.");
                if (!game.stage.getActors().peek().toString().contains(String.valueOf(langueChoisiEleve))) {
                    game.stage.getActors().pop();
                    game.stage.addActor(langueChoisiEleve);
                    elevelangue = 1;
                }
            } else if (eleveRect.overlaps(englishRect)) {
                langueChoisiEleve.setText("Langue choisie pour l'élève: Anglais.");
                if (!game.stage.getActors().peek().toString().contains(String.valueOf(langueChoisiEleve))) {
                    game.stage.getActors().pop();
                    game.stage.addActor(langueChoisiEleve);
                    elevelangue = 2;
                }
            } else if (eleveRect.overlaps(germanRect)) {
                langueChoisiEleve.setText("Langue choisie pour l'élève: Allemand.");
                if (!game.stage.getActors().peek().toString().contains(String.valueOf(langueChoisiEleve))) {
                    game.stage.getActors().pop();
                    game.stage.addActor(langueChoisiEleve);
                    elevelangue = 3;
                }
            } else if (eleveRect.overlaps(italianRect)) {
                langueChoisiEleve.setText("Langue choisie pour l'élève: Italien.");
                if (!game.stage.getActors().peek().toString().contains(String.valueOf(langueChoisiEleve))) {
                    game.stage.getActors().pop();
                    game.stage.addActor(langueChoisiEleve);
                    elevelangue = 4;
                }
            }
        }
    }
}
