package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Fonts;
import com.mygdx.game.GamITW;
import com.mygdx.game.TextButtons.TbMenu;
import com.mygdx.game.TextButtons.TbsMenu;

/**
 * Created by michelle on 4/20/2016.
 */
public class ScrWin implements Screen {
    GamITW gamITW;
    TbsMenu tbsMenu;
    TbMenu tbContinue;
    Stage stage;
    SpriteBatch batch;
    String sWin;
    BitmapFont font;
    Fonts fonts;
    ScreenITW screenITW;

    public ScrWin(GamITW gamITW, Fonts _fonts) {
        this.gamITW = gamITW;
        fonts = _fonts;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        tbsMenu = new TbsMenu(fonts);
        font = fonts.makeFont(1);
        tbContinue = new TbMenu("Continue", tbsMenu);
        tbContinue.setY(0);
        stage.addActor(tbContinue);
        sWin = "You win!";
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        screenITW = new ScreenITW(gamITW);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        batch.begin();
        stage.act();
        font.draw(batch, sWin, 220, 300);
        batch.end();
        stage.draw();
        if (tbContinue.isPressed()) {
            gamITW.currentState = GamITW.GameState.GAME;
            gamITW.updateState();
        }
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
