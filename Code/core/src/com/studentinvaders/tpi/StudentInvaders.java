package com.studentinvaders.tpi;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import sun.applet.Main;


/**
 * Classe permettant de changer de scène. Contient aussi la police d'écriture.
 * @author Seni-J
 * @version 1.0
 */
public class StudentInvaders extends Game {
	Stage stage;
	public SpriteBatch batch;
	public BitmapFont font;
	public BitmapFont gameoverfont;

	static public ScreenViewport viewport;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("Font/KGWTW.fnt"));
		gameoverfont = new BitmapFont(Gdx.files.internal("Font/Chalk.fnt"));

		viewport = new ScreenViewport();
		stage = new Stage(viewport);

		this.setScreen(new MainMenu(this));
	}

	public void gotoSelectScreen(){
		SelectLanguages selectScreen = new SelectLanguages(this);
		setScreen(selectScreen);
	}
	public void gotoGameScreen(){
		StudentInvadersPlayground gameScreen = new StudentInvadersPlayground(this);
		setScreen(gameScreen);
	}

	public void gotoMainScreen(){
		MainMenu mainMenuScreen = new MainMenu(this);
		setScreen(mainMenuScreen);
	}
	public void gotoGameOverScreen(){
		GameOver gameOverScreen = new GameOver(this);
		setScreen(gameOverScreen);
	}


	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
	}
}
