package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Fonts;
import com.mygdx.game.GamITW;
import com.mygdx.game.TextButtons.TbMenu;
import com.mygdx.game.TextButtons.TbsMenu;

/**
 * Created by michelle on 4/21/2016.
 */
public class ScrWeapons implements Screen {

    ScrBattle scrBattle;
    GamITW gamITW;
    Fonts fonts;
    TbsMenu tbsMenu;
    String sChoose;
    TbMenu tbBeans, tbKnife, tbShoe, tbBread;
    Stage stage;
    SpriteBatch batch;
    BitmapFont titleFont;
    Texture txShoe, txBeans, txBread, txKnife;

    public ScrWeapons(GamITW gamITW, ScrBattle _scrBattle, Fonts _fonts) {
        this.gamITW = gamITW;
        scrBattle = _scrBattle;
        fonts = _fonts;

    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        tbsMenu = new TbsMenu(fonts);
        tbBeans = new TbMenu("Beans", tbsMenu);
        tbKnife = new TbMenu("Knife", tbsMenu);
        tbShoe = new TbMenu("Shoe", tbsMenu);
        tbBread = new TbMenu("Bread", tbsMenu);
        tbBeans.setBounds(0, 0, 290, 100);
        tbKnife.setBounds(0, 200, 290, 100);
        tbShoe.setBounds(300, 0, 290, 100);
        tbBread.setBounds(300, 200, 290, 100);
        stage.addActor(tbBeans);
        stage.addActor(tbKnife);
        stage.addActor(tbBread);
        stage.addActor(tbShoe);

        txBeans = new Texture(Gdx.files.internal("beans.png"));
        txBread = new Texture(Gdx.files.internal("bread.png"));
        txKnife = new Texture(Gdx.files.internal("knife.png"));
        txShoe = new Texture(Gdx.files.internal("shoe.png"));
        titleFont = fonts.makeFont(1);
        sChoose = "Choose a Weapon";

        tbBeans.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                scrBattle.damage(10);
                scrBattle.weapon(txBeans);
                gamITW.currentState = GamITW.GameState.BATTLE;
                gamITW.updateState();
                return true;
            }
        });
        tbKnife.addListener(new InputListener() {
            //@Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                scrBattle.damage(250);
                scrBattle.weapon(txKnife);
                gamITW.currentState = GamITW.GameState.BATTLE;
                gamITW.updateState();
                return true;
            }
        });
        tbShoe.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                scrBattle.damage(20);
                scrBattle.weapon(txShoe);
                gamITW.currentState = GamITW.GameState.BATTLE;
                gamITW.updateState();
                return true;
            }
        });
        tbBread.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                scrBattle.damage(15);
                scrBattle.weapon(txBread);
                gamITW.currentState = GamITW.GameState.BATTLE;
                gamITW.updateState();
                return true;
            }
        });
        Gdx.input.setInputProcessor(stage);

    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        batch.begin();
        stage.act();
        titleFont.draw(batch, sChoose, 160, 380);
        batch.end();
        stage.draw();
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
