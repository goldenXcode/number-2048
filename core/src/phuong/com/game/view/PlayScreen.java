package phuong.com.game.view;

import phuong.com.game.controller.Assets;
import phuong.com.game.controller.Setting;
import phuong.com.game.controller.World;
import phuong.com.game.model.Ball;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class PlayScreen extends BaseScreen {

	// Game state
	public enum STATE {
		GAME_READY, GAME_RUNNING, GAME_PAUSE, GAME_LEVEL_END, GAME_OVER
	}

	private STATE state;
	
	// Button, etc...
	
	// World
	public World world;
	
	private final Array<Ball> activeBall = new Array<Ball>();
	private final Pool<Ball> ballPool = new Pool<Ball>() {

		@Override
		protected Ball newObject() {
			// TODO Auto-generated method stub
			return new Ball();
		}
		
	};
	
	@Override
	public void show() {
		super.show();
		
		// Play Music and Sound
		if (Setting.soundEnabled) {
			// Play music and sound
			Assets.backgroundPlayMusic.play();
		} else {
			//Pause music and sound
			Assets.backgroundPlayMusic.pause();
		}
		
		// Constructor for button, etc...
		
		// Event
		
		// State
		state = STATE.GAME_READY;
		
		// World
		world = new World();
		
		Ball ball = ballPool.obtain();
		ball.init(2, 2);
		activeBall.add(ball);
		Ball ball2 = ballPool.obtain();
		ball2.init(200, 200);
		activeBall.add(ball2);
		Ball ball3 = ballPool.obtain();
		ball3.init(100, 400);
		activeBall.add(ball3);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		update(delta);
		draw(delta);
	}

	private void update(float deltaTime) {
		if (deltaTime > 0.1f)
			deltaTime = 0.1f;
		switch (state) {
		case GAME_READY:
			updateReady(deltaTime);
			break;

		case GAME_RUNNING:
			updateRunning(deltaTime);
			break;

		case GAME_PAUSE:
			updatePause(deltaTime);
			break;

		case GAME_LEVEL_END:
			updateLevelEnd(deltaTime);
			break;

		case GAME_OVER:
			updateGameOver(deltaTime);
			break;

		default:
			break;
		}
	}

	// Game Ready
	private void updateReady(float deltaTime) {
		// TODO Auto-generated method stub
		if(Gdx.input.justTouched())
			state = STATE.GAME_RUNNING;
	}

	// Game Running
	private void updateRunning(float deltaTime) {
		// TODO Auto-generated method stub
		// Update time play
		world.timePlay += deltaTime;
		
		System.gc();
		ApplicationType apptype = Gdx.app.getType();
		if (apptype == ApplicationType.Android
				|| apptype == ApplicationType.Desktop)
			world.update(deltaTime);

		// Update Money, etc...
		Ball ball;
        int len = activeBall.size;
        for (int i = len; --i >= 0;) {
            ball = activeBall.get(i);
            ball.update(deltaTime);
            if (ball.alive == false) {
            	Vector2 pos = ball.oriPosition;
            	System.out.println(pos.x+", "+pos.y);
                activeBall.removeIndex(i);
                ballPool.free(ball);
                Ball newBall = ballPool.obtain();
        		newBall.init(pos.x, pos.y);
        		activeBall.add(newBall);
            }
        }
		
		// If Level End
		if (world.state == World.STATE.WORLD_NEXT_LEVEL) {
			state = STATE.GAME_LEVEL_END;
			
			// Next Level
			
			System.gc();
			world.dispose();
		}

		// If Game Over
		if (world.state == World.STATE.WORLD_GAME_OVER) {
			state = STATE.GAME_OVER;
			
			// End Game
			
			System.gc();
			world.dispose();
		}

	}

	// Game Pause
	private void updatePause(float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	// Game Level End
	private void updateLevelEnd(float deltaTime) {
		// TODO Auto-generated method stub
		
		// Win, next level
		
	}

	// Game Over
	private void updateGameOver(float deltaTime) {
		// TODO Auto-generated method stub
		
		System.gc();
		// Game over
	}
	
	// Draw Objects
	private void draw(float deltaTime) {
		// TODO Auto-generated method stub
		batch.begin();
		for (Ball ball : activeBall) {
			batch.draw(Assets.backgroundMenu, ball.position.x, ball.position.y, 100, 100);
		}
		switch (state) {
		case GAME_READY:
			presentReady();
			break;
		case GAME_RUNNING:
			presentRunning();
			break;
		case GAME_PAUSE:
			presentPaused();
			break;
		case GAME_LEVEL_END:
			presentLevelEnd();
			break;
		case GAME_OVER:
			presentGameOver();
			break;
		default:
			break;
		}
		batch.end();
	}

	// Draw Game Ready
	private void presentReady() {
		// TODO Auto-generated method stub
		Assets.font.draw(batch, "READY", 800 / 2 - 40, 480 / 2 + 25);
	}

	// Draw Game Running
	private void presentRunning() {
		// TODO Auto-generated method stub
		//Assets.font.draw(batch, "RUNNING", 800 / 2 - 40, 480 / 2 + 25);
		// Used memory
		long freeMemory = Runtime.getRuntime().maxMemory()
				- Runtime.getRuntime().freeMemory();
		Assets.font.draw(batch, String.valueOf(freeMemory), 800 / 2 - 50, 480 / 2 + 25);
	}

	// Draw Game Pause
	private void presentPaused() {
		// TODO Auto-generated method stub
		Assets.font.draw(batch, "PAUSE", 800 / 2 - 40, 480 / 2 + 25);
	}

	// Draw Game Level End
	private void presentLevelEnd() {
		// TODO Auto-generated method stub
		Assets.font.draw(batch, "LEVEL COMPLETED...", 800 / 2 - 100,
				480 / 2 + 25);
	}

	// Draw Game Over
	private void presentGameOver() {
		// TODO Auto-generated method stub
		Assets.font.draw(batch, "GAME OVER", 800 / 2 - 70, 480 / 2 + 25);
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
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
		if(state == STATE.GAME_RUNNING)
			state = STATE.GAME_PAUSE;
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
		world.dispose();
	}

}
