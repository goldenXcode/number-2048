package phuong.com.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class BaseScreen implements Screen {

	public OrthographicCamera camera;
	public SpriteBatch batch;
	public Stage stage;
	public Viewport viewPort;

	@Override
	public void show() {
		batch = new SpriteBatch();
		viewPort = new StretchViewport(800, 480);
		stage = new Stage(viewPort);
		Gdx.input.setInputProcessor(stage);
		Gdx.input.setCatchBackKey(true);
		camera = (OrthographicCamera) stage.getCamera();
	}

	@Override
	public void render(float arg0) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		stage.act(arg0);
		stage.draw();
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resize(int arg0, int arg1) {
		camera.viewportWidth = arg0;
		camera.viewportHeight = arg1;
		//stage.setViewport(arg0, arg1, true);
		stage.getViewport().update(arg0, arg1, false);
	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}

}
