package phuong.com.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import phuong.com.game.Project2048;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Project 2048";
		config.useGL30 = false;
		config.width = 800;
		config.height = 480;
		config.resizable = false;
		new LwjglApplication(new Project2048(), config);
	}
}
