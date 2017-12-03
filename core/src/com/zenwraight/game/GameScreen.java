package com.zenwraight.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {
    private final Eatly game;
    private GameStage gameStage;
    private Gui gui;
    private boolean shouldReset = false;
    private boolean shouldShowCongrats = false;
    private boolean showRuleStage = true;
    private boolean showDiedScreen = false;
    private Stage finalStage;
    private Stage ruleStage;
    private Stage deathStage;

    public GameScreen(Eatly game) {
        this.game = game;
        this.gameStage = new GameStage(this);
        this.gui = new Gui(this);
        this.finalStage = new FinalStage(this);
        this.ruleStage = new RuleStage(this);
        this.deathStage = new DeathStage(this);
    }

    public void reset() {
        shouldReset = true;
    }

    public void resetInternal() {
        shouldReset = false;
        this.gameStage.cleanUp();
        Food.COLLECT_COUNT = 0;
        this.gameStage = new GameStage(this);
        this.gui = new Gui(this);
        showDiedScreen = true;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0f, 0f, 0f, 1.f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            showRuleStage = false;
        }

        if (shouldReset) {
            resetInternal();
        }
        if (showDiedScreen) {
            deathStage.act(delta);
            deathStage.draw();
        } else if (showRuleStage) {
            ruleStage.act(delta);
            ruleStage.draw();
        } else if (!shouldShowCongrats) {
            gameStage.act(delta);
            gameStage.draw();
            gui.act(delta);
            gui.draw();
        } else {
            finalStage.act(delta);
            finalStage.draw();
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

    public GameStage getGameStage() {
        return gameStage;
    }

    public Gui getGui() {
        return gui;
    }

    public void showCongratulations() {
        shouldShowCongrats = true;
    }
}
