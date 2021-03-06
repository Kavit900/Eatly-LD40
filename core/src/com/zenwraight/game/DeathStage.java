package com.zenwraight.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class DeathStage extends Stage {

    private final GameScreen gameScreen;

    public DeathStage(GameScreen screen) {
        super(new ExtendViewport(Gdx.graphics.getBackBufferWidth() / 3, Gdx.graphics.getBackBufferHeight() / 3));
        this.gameScreen = screen;

        Label.LabelStyle style = new Label.LabelStyle(Res.font, Color.WHITE);
        Label label = new Label("Sorry You couldn't make it", style);
        label.setPosition(getWidth() / 2f - label.getWidth() / 2f, getHeight() / 2f - label.getHeight() / 2f + 35f);
        addActor(label);
        label.setColor(1f, 1f, 1f, 0f);
        label.addAction(Actions.fadeIn(3f));

        Label l2 = new Label("Restart the Game again!", style);
        l2.setPosition(getWidth() / 2f - l2.getWidth() / 2f, getHeight() / 2f - label.getHeight() / 2f);
        addActor(l2);
        l2.setColor(1f, 1f, 1f, 0f);
        l2.addAction(Actions.sequence(Actions.delay(2f), Actions.fadeIn(3f)));
    }
}
