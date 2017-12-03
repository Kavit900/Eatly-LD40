package com.zenwraight.game;

import com.badlogic.gdx.Game;

public class Eatly extends Game {

	private GameScreen gameScreen;
	
	@Override
	public void create () {
		Res.load();
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);
	}
}
