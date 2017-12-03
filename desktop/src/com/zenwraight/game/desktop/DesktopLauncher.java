package com.zenwraight.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.zenwraight.game.Eatly;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Eatly";
		config.width = 1080;
		config.height = 720;
		new LwjglApplication(new Eatly(), config);
	}
}
