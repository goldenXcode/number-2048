package phuong.com.game.controller;

public class World {

	// World state
	public static enum STATE {
		WORLD_RUNNING,
		WORLD_NEXT_LEVEL,
		WORLD_GAME_OVER
	}
	
	public STATE state;
	
	// Objects, etc...
	public float timePlay = 0f;
	public float timeOver = 0f;
	public int timeRemaining;
	
	public World() {
		// TODO Auto-generated constructor stub
		// create objects, etc...
		
		this.state = STATE.WORLD_RUNNING;
	}
	
	public void update(float deltaTime) {
		// Update every object in the world
		refreshWorld();
		
		// Check condition
		checkLevelEnd();
		checkGameOver();
	}
	
	private void refreshWorld() {
		// TODO Auto-generated method stub
		
		// update objects, ...
	}
	
	private void checkLevelEnd() {
		// TODO Auto-generated method stub
		
		// state = STATE.WORLD_NEXT_LEVEL;
	}

	private void checkGameOver() {
		// TODO Auto-generated method stub
		
		// state = STATE.WORLD_GAME_OVER;
	}
	
	public void dispose() {
		// dispose objects in the world
	}
}
