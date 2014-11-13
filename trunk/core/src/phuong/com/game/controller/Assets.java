package phuong.com.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	// Load 1 time...
	public static boolean isload = false;
	
	// Texture: Menu Screen, Button, etc...
	public static TextureRegion backgroundMenu;

	// Font
	public static BitmapFont font;

	// Animation
	public static TextureRegion[] exampleTexture;
	public static Animation exampleAnimation;

	// Music and sound
	public static Music backgroundPlayMusic;
	public static Sound buttonClick;

	public static void load() {
		
	/**********************************************************************************************/
		// Texture: Menu Screen, Button, etc...
		backgroundMenu = loadTextureRegion("data/image/texture/backgroundMenu.png");
		
	/**********************************************************************************************/
		// Font
		font = new BitmapFont(Gdx.files.internal("data/uiskin/arial.fnt"),
				Gdx.files.internal("data/uiskin/arial.png"), false);
		
	/**********************************************************************************************/
		// Animation
		exampleTexture = load_arrayTexture("data/image/animation/example", 8);
		exampleAnimation = new Animation(0.1f, false, exampleTexture);
		
	/**********************************************************************************************/
		// Music and sound
		// Music
		backgroundPlayMusic = Gdx.audio.newMusic(Gdx.files
				.internal("data/music/backgroundPlay.wav"));
		backgroundPlayMusic.setLooping(true);
		
	/**********************************************************************************************/
		// Sound
		buttonClick = Gdx.audio.newSound(Gdx.files
				.internal("data/music/buttonClick.wav"));
		
		// make sure load asset 1 time only
		isload = true;
		
	/**********************************************************************************************/
	}
	
	// Load texture
	public static Texture loadTexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}

	// Load texture region
	public static TextureRegion loadTextureRegion(String path) {
		//Texture.setEnforcePotImages(false);
		return new TextureRegion(new Texture(Gdx.files.internal(path)));
	}

	// Load animation from file
	public static TextureRegion[] load_arrayTexture(String str, int count) {
		TextureRegion[] arrayTextureRegion = new TextureRegion[count];
		for (int i = 0; i < count; i++) {
			arrayTextureRegion[i] = loadTextureRegion(str +"/"+ (i + 1) + ".png");
		}
		return arrayTextureRegion;
	}

	public static TextureRegion[] loadArrayTexture(int col, int row,
			String direction) {
		TextureRegion[] textureRegion;

		Texture texture_ball = new Texture(Gdx.files.internal(direction));
		TextureRegion[][] tmp = TextureRegion.split(texture_ball,
				texture_ball.getWidth() / col, texture_ball.getHeight() / row);
		textureRegion = new TextureRegion[col * row];

		int index = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				textureRegion[index++] = tmp[i][j];
			}
		}

		return textureRegion;

	}
	
	// Play Sound
	public static void playSound(Sound sound) {
		if (Setting.soundEnabled) {
			sound.play(1);
		}
	}

	// Play Music
	public static void playMusic(Music music) {
		if (Setting.soundEnabled) {
			music.play();
		}
	}

}
