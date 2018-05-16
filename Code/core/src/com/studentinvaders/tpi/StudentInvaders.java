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

public class StudentInvaders extends Game {
	Stage stage;
	public SpriteBatch batch;
	public BitmapFont font;

	static public ScreenViewport viewport;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("Font/KGWTW.fnt"));

		viewport = new ScreenViewport();
		stage = new Stage(viewport);

		this.setScreen(new MainMenu(this));
	}

	public void gotoMenuScreen(){
		SelectLanguages selectScreen = new SelectLanguages(this);
		setScreen(selectScreen);
	}
	public void gotoGameScreen(){
		StudentInvadersPlayground selectScreen = new StudentInvadersPlayground(this);
		setScreen(selectScreen);
	}


	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
	}
}
