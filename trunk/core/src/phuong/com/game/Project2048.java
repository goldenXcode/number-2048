package phuong.com.game;

import phuong.com.game.controller.Assets;
import phuong.com.game.controller.Setting;
import phuong.com.game.view.ManagerScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class Project2048 extends Game {

	private static ManagerScreen manager;

	@Override
	public void create() {
		manager = new ManagerScreen();
		if(!Assets.isload)
			Assets.load();
		Setting.load();
		Project2048.getManagerScreen().createScreen(ManagerScreen.SCREEN_PLAY);
		Gdx.input.setCatchBackKey(true);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void render() {
		if (manager.getScreen() != null)
			manager.getScreen().render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
	}

	@Override
	public Screen getScreen() {
		return super.getScreen();
	}

	public static ManagerScreen getManagerScreen() {
		return manager;
	}
}
