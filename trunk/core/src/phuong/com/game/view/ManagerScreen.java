package phuong.com.game.view;

import com.badlogic.gdx.Screen;

public class ManagerScreen {

	// Screen Definition
	public static int SCREEN_MENU = 0;
	public static int SCREEN_PLAY = 1;
	//public static int SCREEN_SPLASH = -1;

	private Screen nowScreen;

	public Screen getScreen() {
		if (nowScreen == null) {
			nowScreen = new MenuScreen();
			nowScreen.show();
		}
		return nowScreen;
	}

	public Screen createScreen(int select) {
		switch (select) {
		/*case -1:

			clearNowScreen();
			nowScreen = new SplashScreen();
			nowScreen.show();
			return nowScreen;*/

		case 0:
			clearNowScreen();
			nowScreen = new MenuScreen();
			nowScreen.show();
			return nowScreen;
		case 1:
			clearNowScreen();
			nowScreen = new PlayScreen();
			nowScreen.show();
			return nowScreen;
		}
		return new MenuScreen();
	}

	private void clearNowScreen() {
		if (nowScreen != null)
			nowScreen.dispose();
	}

}
