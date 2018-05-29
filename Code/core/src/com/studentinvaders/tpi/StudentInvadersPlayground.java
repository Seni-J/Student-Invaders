package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import java.lang.reflect.Array;
import java.text.ParsePosition;
import java.util.ArrayList;

import javax.swing.Box;

/**
 * Created by Senistan.JEGARAJASIN on 15.05.2018.
 */

public class StudentInvadersPlayground extends Actor implements Screen{
    final StudentInvaders game;
    int id;

    ArrayList<TeacherWords> teacherWords;
    ArrayList<Words> studentWords;
    ArrayList<Actor> boxTeachers;
    ArrayList<Actor> boxStudents;

    Texture bg;
    Texture boxTexture;
    Teacher teacher;
    Student student;
    int sendFlight = 0;
    int indexvisible;
    boolean changed = false;

    Rectangle leftSide;
    Rectangle rightSide;


    private ShapeRenderer shapeRenderer;



    public StudentInvadersPlayground(final StudentInvaders game) {
        this.game = game;
        bg = new Texture("Game/bg_game.jpg");
        boxTexture = new Texture("Game/Box.png");
        teacher = new Teacher();
        student = new Student();
        leftSide = new Rectangle();
        rightSide = new Rectangle();
        boxTeachers = new ArrayList<Actor>();
        boxStudents = new ArrayList<Actor>();

        id = SelectLanguages.idVoc;


        shapeRenderer = new ShapeRenderer();

        teacherWords = VocProvider.getTeacherWords();
        studentWords = VocProvider.getWords();


        //Effacer les anciens acteurs (Labels).
        game.stage.getRoot().clearChildren();

        //Mis en place des "boutons" invisibles pour déplacer le prof de gauche à droite.
        teacher.setPosition(500,100);
        leftSide.set(0,teacher.getY(),200,teacher.spriteTeacher.getHeight());
        rightSide.set(game.viewport.getScreenWidth() - 200,teacher.getY(), 200,teacher.spriteTeacher.getHeight());

        // Pour chaque mot du voc sélectionné, on crée des acteurs qu'on ajoute dans notre tableau boxTeacher pour les mots en bas.
        for (TeacherWords word: teacherWords) {
            if(word.vocID == id)
                if(word.type == Words.wordType.Teacher){
                    word.setBounds(word.box.getX(),word.box.getY(),word.box.getWidth(),word.box.getHeight());
                    boxTeachers.add(word);
                    if(boxTeachers.get(boxTeachers.size() - 1).getX() > game.viewport.getScreenWidth()){
                        boxTeachers.get(boxTeachers.size() - 1).setVisible(false);
                    }
                    boxTeachers.get(boxTeachers.size() - 1).setName(word.word);
                    if(boxTeachers.size() < 2){
                        boxTeachers.get(0).setX(25);
                    }
                    if(boxTeachers.size() >= 2) {
                        boxTeachers.get(boxTeachers.size() - 1).setPosition(boxTeachers.get(boxTeachers.size() - 2).getX() + boxTeachers.get(boxTeachers.size() - 2).getWidth() + 50,0);
                    }
                }
        }

        for(Words word: studentWords){
            if(word.vocID == id){
                if(word.type == Words.wordType.Student){
                    boxStudents.add(word);
                }
            }
        }

        Gdx.app.log("Box", studentWords.toString());
        // Ajout d'acteur dans le tableau boxTeachers.
        for(Actor boxTeacher: boxTeachers){
            game.stage.addActor(boxTeacher);
        }

        int x = 500;
        for(Actor boxStudent: boxStudents){
            Table table = new Table();
            table.setFillParent(true);
            table.setPosition(x,700);
            table.add(student,boxStudent);
            game.stage.addActor(table);
            x += 50;
        }

        game.stage.addActor(teacher);
        game.stage.getActors().peek().setName("Prof"); // On set un nom pour le retrouver plus facilement dans la liste des acteurs.
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(bg,0,0, game.viewport.getScreenWidth(),game.viewport.getScreenHeight());
        game.batch.end();

        //Méthode pour bouger le prof.
        MoveTeacher();
        student.Move();
        //Si un avion est envoyé, on ne fait pas de check de mot. Cette condition est surtout là pour que l'avion continue son chemin sans qu'elle s'arrête à cause du input X et Y.
        if(sendFlight == 1){
            SendFlight();
        }else{
            CheckWordTaken();
            UpdatePositionTeacherBox();
        }

        //On regarde si l'avion en papier existe pour pouvoir le lancer. Si il l'existe, on vérifie si il est sorti de l'écran. Sinon, il est prêt à être lancer.
        if(game.stage.getActors().peek().getName().toString().contains(String.valueOf("PaperFlight"))) {
            if(game.stage.getActors().peek().getY() > game.viewport.getScreenHeight()){
                sendFlight = 0;
                teacherWords.get(indexvisible).known = true;
                game.stage.getActors().pop();
                teacher.changeImageback(teacher.spriteTeacher.getX(),teacher.spriteTeacher.getY());
            }else {
                if (Gdx.input.getX() > 0 && Gdx.input.getX() < game.viewport.getScreenWidth() && game.viewport.getScreenHeight() - Gdx.input.getY() > teacher.spriteTeacher.getY() + teacher.spriteTeacher.getHeight() && game.viewport.getScreenHeight() - Gdx.input.getY() < game.viewport.getScreenHeight()) {
                    sendFlight = 1;
                }
            }
        }

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

    public void MoveTeacher(){
        if(leftSide.contains(Gdx.input.getX(),game.viewport.getScreenHeight() - Gdx.input.getY())){
            if(teacher.getX() > 0) {
                teacher.moveBy(-2.5f, 0);
                if(game.stage.getRoot().findActor("PaperFlight") != null && sendFlight == 0){
                    game.stage.getRoot().findActor("PaperFlight").moveBy(-2.5f,0);
                }
            }
        }
        if(rightSide.contains(Gdx.input.getX(), game.viewport.getScreenHeight() - Gdx.input.getY())){
            if(teacher.getX() + teacher.spriteTeacher.getWidth() < game.viewport.getScreenWidth()) {
                teacher.moveBy(2.5f, 0);
                if(game.stage.getRoot().findActor("PaperFlight") != null && sendFlight == 0) {
                    game.stage.getRoot().findActor("PaperFlight").moveBy(2.5f, 0);
                }
            }
        }
    }

    public void SendFlight(){
        game.stage.getRoot().findActor("PaperFlight").moveBy(0,3f);
    }

    public void CheckWordTaken(){
        if(Gdx.input.getX() > 0 && Gdx.input.getX() < game.viewport.getScreenWidth() && game.viewport.getScreenHeight() - Gdx.input.getY() > 0 && game.viewport.getScreenHeight() - Gdx.input.getY() < 100){
            for (Actor box: boxTeachers){
                if(Gdx.input.getX() > box.getX() && Gdx.input.getX() < box.getX() + box.getWidth()){
                    if(teacher.spriteTeacher.getX() + teacher.spriteTeacher.getHeight() > box.getX()
                            && teacher.spriteTeacher.getX() + teacher.spriteTeacher.getHeight() < box.getX() + box.getWidth()) {
                        teacher.changeImage(teacher.spriteTeacher.getX(),teacher.spriteTeacher.getY());
                        for(TeacherWords word: teacherWords){
                            if(!game.stage.getActors().peek().getName().contains(String.valueOf("PaperFlight"))) {
                                if (box.toString().contains(String.valueOf(word.lblbox))) {
                                    CreatePaperFlight(word.idWord);
                                    box.setVisible(false);
                                    indexvisible = box.getZIndex();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void UpdatePositionTeacherBox(){
        float x = 25;

        for(TeacherWords teacherword: teacherWords){
            if(!teacherword.known){
                teacherword.setX(x);
                x += teacherword.getWidth() + 50;
            }else{
                //Si les mots qui sont connus ne sont pas déplacés, cela pose problème car deux blocs sont superposés et l'application prends en compte que l'ancien bloc et le nouveau qui est placé n'est pas pris en compte.
                teacherword.setX(-500);
                teacherword.setTouchable(Touchable.disabled);
                teacherword.setVisible(false);
            }
        }
    }

    public void CreatePaperFlight(int id){
        int paperflightid = id;
        Image PaperFlight = new Image(new SpriteDrawable(new Sprite(new Texture("Game/AvionEnPapier.png"))));

        PaperFlight.setBounds(this.teacher.spriteTeacher.getX() + this.teacher.spriteTeacher.getWidth()/2 - 20,
                this.teacher.spriteTeacher.getY() + this.teacher.spriteTeacher.getHeight()+10, PaperFlight.getWidth()/6,PaperFlight.getHeight()/6);

        game.stage.addActor(PaperFlight);
        game.stage.getActors().peek().setName("PaperFlight");

    }
}
