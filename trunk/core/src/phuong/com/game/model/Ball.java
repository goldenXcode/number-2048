package phuong.com.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool.Poolable;

public class Ball implements Poolable {

	public Vector2 position;
	public boolean alive;
	public Vector2 oriPosition;
	
	public Ball() {
		// TODO Auto-generated constructor stub
		position = new Vector2();
		oriPosition = new Vector2();
		alive = false;
	}
	
	public void init(float x, float y) {
		// TODO Auto-generated method stub
		this.position.set(x, y);
		this.oriPosition.set(x, y);
		alive = true;
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		position.set(0, 0);
		alive = false;
	}
	
	public void update(float delta) {
		// TODO Auto-generated method stub
		position.add(1*60*delta, 1*60*delta);
		position.x += 10;
		if(position.x >= 400) {
			alive = false;
		}
	}

}
