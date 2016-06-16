package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.Fonts;
import com.mygdx.game.GamITW;
import com.mygdx.game.StageActors.StgIntoTheWoods;
import com.mygdx.game.TextButtons.TbMenu;
import com.mygdx.game.TextButtons.TbsMenu;

/**
 * Created by Luke on 2016-04-07.
 */
public class ScrIntoTheWoods implements Screen {
    StgIntoTheWoods stgIntoTheWoods;
    com.mygdx.game.GamITW gamITW;
    TbMenu button;
    TbsMenu tbsMenu;
    Fonts fonts;

    public ScrIntoTheWoods(GamITW gamITW, Fonts _fonts) {
        this.gamITW = gamITW;
        fonts = _fonts;
    }

    @Override
    public void show() {
        tbsMenu = new TbsMenu(fonts);
        Music Music;
//        Music= Gdx.audio.newMusic(Gdx.files.internal("IntoTheWoods(Prologue).mp3"));
        stgIntoTheWoods = new StgIntoTheWoods();
        Gdx.input.setInputProcessor(stgIntoTheWoods);
        button = new TbMenu("Battle", tbsMenu);
        button.setBounds(350, 0, 300, 100);
        button.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gamITW.currentState = GamITW.GameState.WEAPONS;
                gamITW.updateState();
                return true;
            }
        });
        stgIntoTheWoods.addActor(button);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stgIntoTheWoods.act();
        stgIntoTheWoods.draw();
//        com.badlogic.gdx.audio.Music.isLooping();
//        com.badlogic.gdx.audio.Music.play();


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
