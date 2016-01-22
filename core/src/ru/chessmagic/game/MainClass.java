package ru.chessmagic.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture texPawnW;
	Texture texGrass;
	Texture texSelGrid;
	GameFigure gf;

	int mouseX = 0;
	int mouseY = 0;
	int mouseCellX;
	int mouseCellY;

	@Override
	public void create () {
		batch = new SpriteBatch();
		texPawnW = new Texture("pawnw.png");
		texGrass = new Texture("board.png");
		texSelGrid = new Texture("select.png");
		gf = new GameFigure(1, 1);
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0.4f, 0.4f, 1.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();


		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if((i+j) % 2 == 0) {
					batch.draw(texGrass, i * 60, j * 60, 0, 0, 60, 60);
				} else {
					batch.draw(texGrass, i * 60, j * 60, 60, 0, 60, 60);
				}

			}
			
		}
		batch.draw(texPawnW, gf.getX() * 60, gf.getY() * 60);
		batch.draw(texSelGrid, mouseCellX * 60, mouseCellY * 60);
		batch.end();
	}

	public void update() {
		mouseX = -30 + Gdx.input.getX();
		mouseY = 570 - Gdx.input.getY();

		mouseCellX = mouseX / 60;
		mouseCellY = mouseY / 60;

		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			gf.changeCoords(mouseCellX, mouseCellY);
		}
	}
}
