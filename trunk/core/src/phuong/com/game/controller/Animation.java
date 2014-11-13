package phuong.com.game.controller;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {

	/*
	 * Quản lí việc sử dụng các Animation, hiệu ứng trong game
	 */

	public static final int ANIMATION_LOOPING = 0;
	public static final int ANIMATION_NONLOOPING = 1;

	final TextureRegion[] keyFrames;
	final float frameDuration;

	public Animation(float frameDuration, boolean flip, TextureRegion... keyFrames) {
		this.frameDuration = frameDuration;
		this.keyFrames = keyFrames;
		if(flip) {
			for (int i = 0; i < this.keyFrames.length; i++) {
				this.keyFrames[i].flip(true, false);
			}
		}
	}

	public TextureRegion getKeyFrame(float stateTime, int mode) {
		int frameNumber = (int) (stateTime / frameDuration);

		if (mode == ANIMATION_NONLOOPING) {
			frameNumber = Math.min(keyFrames.length - 1, frameNumber);
		} else {
			frameNumber = frameNumber % keyFrames.length;
		}
		return keyFrames[frameNumber];
	}

}
