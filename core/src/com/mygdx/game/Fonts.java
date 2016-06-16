package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by michelle on 5/11/2016.
 */
public class Fonts extends ApplicationAdapter {

    public static BitmapFont makeFont(int nChoose) {
        FileHandle fontFile = Gdx.files.internal("Woods.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FileHandle dialogFontFile = Gdx.files.internal("DialogFont.ttf");
        FreeTypeFontGenerator generator1 = new FreeTypeFontGenerator(dialogFontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter1 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = Color.BLACK;
        if (nChoose == 2) {
            parameter.size = 18;
            parameter.borderColor = Color.WHITE;
            parameter.borderWidth = 3;
            BitmapFont textFont = generator.generateFont(parameter);
            generator.dispose();
            return textFont;
        } else if (nChoose == 1) {
            parameter.size = 30;
            BitmapFont textFont = generator.generateFont(parameter);
            generator.dispose();
            return textFont;
        } else if (nChoose == 3) {
            parameter1.color = Color.WHITE;
            parameter1.size = 29;
            BitmapFont textFont = generator1.generateFont(parameter1);
            generator1.dispose();
            return textFont;
        } else if (nChoose == 4) {
            parameter.size = 29;
            parameter.color = Color.WHITE;
            BitmapFont textFont = generator.generateFont(parameter);
            generator.dispose();
            return textFont;
        } else {
            parameter.size = 18;
            BitmapFont textFont = generator.generateFont(parameter);
            generator.dispose();
            return textFont;
        }

    }
}