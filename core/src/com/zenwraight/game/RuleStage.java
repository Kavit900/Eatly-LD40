package com.zenwraight.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class RuleStage extends Stage{

    private final GameScreen gameScreen;

    public RuleStage(GameScreen screen) {
        super(new ExtendViewport(Gdx.graphics.getBackBufferWidth()/3, Gdx.graphics.getBackBufferHeight()/3));
        this.gameScreen = screen;

        Label.LabelStyle style = new Label.LabelStyle(Res.font, Color.WHITE);
        Label label = new Label("Rules: ", style);
        label.setPosition(getWidth()/2f - label.getWidth()/2f, getHeight()/2f - label.getHeight()/2f + 55f);
        addActor(label);
        label.setColor(1f, 1f, 1f, 0f);
        label.addAction(Actions.fadeIn(3f));


        Label.LabelStyle styleRules = new Label.LabelStyle(Res.fontRules, Color.WHITE);
        Label l2 = new Label("1. Your Mission is to reach the door", styleRules);
        l2.setPosition(getWidth()/2f - l2.getWidth()/2f, getHeight()/2f - l2.getHeight()/2f + 35f);
        addActor(l2);
        l2.setColor(1f,1f,1f,0f);
        l2.addAction(Actions.fadeIn(3f));

        Label l3 = new Label("2. Use Arrow keys to move around, Space to jump", styleRules);
        l3.setPosition(getWidth()/2f - l3.getWidth()/2f, getHeight()/2f - l3.getHeight()/2f + 15f);
        addActor(l3);
        l3.setColor(1f,1f,1f,0f);
        l3.addAction(Actions.fadeIn(3f));

        Label l4 = new Label("3. Don't overeat, you might get fat", styleRules);
        l4.setPosition(getWidth()/2f - l3.getWidth()/2f, getHeight()/2f - l3.getHeight()/2f);
        addActor(l4);
        l4.setColor(1f,1f,1f,0f);
        l4.addAction(Actions.fadeIn(3f));
    }
}
