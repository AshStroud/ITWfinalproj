package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.Screens.ScrBattle;
import com.mygdx.game.Screens.ScrLose;
import com.mygdx.game.Screens.ScrMain;
import com.mygdx.game.Screens.ScrWeapons;
import com.mygdx.game.Screens.ScrWin;
import com.mygdx.game.Screens.ScreenITW;
import com.mygdx.game.StageActors.Dialog;
import com.mygdx.game.StageActors.HealthBar;
import com.mygdx.game.TextButtons.TbsDialog;
import com.mygdx.game.TextButtons.TbsMenu;

public class GamITW extends Game {
	ScrMain scrMain;
	ScrBattle scrBattle;
	ScrWin scrWin;
	ScrWeapons scrWeapons;
	ScrLose scrLose;
	HealthBar healthBar;
	Fonts fonts;
	Dialog dialog;
	TbsMenu tbsMenu;
	TbsDialog tbsDialog;
	ScreenITW screenITW;
	public enum GameState {
		MENU, GAME, BATTLE, WIN, WEAPONS,LOSE
	}
	public GameState currentState;
	public void updateState(){
		if(currentState==GameState.MENU){
			setScreen(scrMain);
		}else if(currentState==GameState.GAME) {
			setScreen(screenITW);
		}
		else if(currentState==GameState.BATTLE){
			setScreen(scrBattle);
		}
		else if(currentState==GameState.WEAPONS){
			setScreen(scrWeapons);
		}
		else if(currentState==GameState.WIN){
			setScreen(scrWin);
		}
		else if(currentState==GameState.LOSE){
			setScreen(scrLose);
		}


	}

	@Override
	public void create () {
		scrMain = new ScrMain(this,fonts);
		screenITW= new ScreenITW(this);
		scrBattle = new ScrBattle(this, healthBar, fonts, dialog);
		scrWin = new ScrWin(this, fonts);
		scrWeapons = new ScrWeapons(this, scrBattle, fonts);
		scrLose = new ScrLose(this, fonts);
		tbsDialog = new TbsDialog(fonts);
		tbsMenu = new TbsMenu(fonts);
		dialog = new Dialog(scrBattle);
		currentState = GameState.MENU; //Set the current state to the main menu, and update it.
		updateState();

	}

	@Override
	public void render () {
		super.render();
	}

}