package phuong.com.game.view;

import phuong.com.game.controller.Assets;
import phuong.com.game.controller.Setting;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MenuScreen extends BaseScreen {

	// Background and button, etc...
	private Image imgBack;

	@Override
	public void render(float delta) {
		super.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void show() {
		super.show();
		
		// Constructor
		imgBack = new Image(Assets.backgroundMenu);
		stage.addActor(imgBack);

		if (Setting.soundEnabled) {
			// Play music and sound
			Assets.backgroundPlayMusic.play();
		} else {
			//Pause music and sound
			Assets.backgroundPlayMusic.pause();
		}

		// Button Event...
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		super.hide();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		super.resume();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

}
