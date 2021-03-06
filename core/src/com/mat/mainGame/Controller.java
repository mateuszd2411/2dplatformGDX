package com.mat.mainGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mat.mainGame.Screens.BasicDialog;
import com.mat.mainGame.Sprites.Player;

public class Controller {
    Viewport viewport;
    Stage stage;
    boolean bombPress,upPressed, firePress, leftPressed, rightPressed;
    OrthographicCamera cam;

    public Controller(){
        cam = new OrthographicCamera();
        viewport = new FitViewport(800, 480, cam);
        stage = new Stage(viewport, MainGame.batch);

        basicDialogShow();

        stage.addListener(new InputListener(){

            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch(keycode){
                    case Input.Keys.UP:
                        upPressed = true;
                        break;
                    case Input.Keys.DOWN:
                        firePress = true;
                        break;
                    case Input.Keys.B:
                        bombPress = true;
                        break;
                    case Input.Keys.LEFT:
                        leftPressed = true;
                        break;
                    case Input.Keys.RIGHT:
                        rightPressed = true;
                        break;
                }
                return true;
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                switch(keycode){
                    case Input.Keys.UP:
                        upPressed = false;
                        break;
                    case Input.Keys.DOWN:
                        firePress = false;
                        break;
                    case Input.Keys.B:
                        bombPress = false;
                        break;
                    case Input.Keys.LEFT:
                        leftPressed = false;
                        break;
                    case Input.Keys.RIGHT:
                        rightPressed = false;
                        break;
                }
                return true;
            }
        });

        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        Image upImg = new Image(new Texture("flatDark25.png"));
        upImg.setSize(90, 110);
        upImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
            }
        });

        ///fire IMG
        Image downImg = new Image(new Texture("flatDark26.png"));
        downImg.setSize(90, 90);
        downImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                firePress = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                firePress = false;
            }
        });
        //fire IMG

        ///bomb IMG
        Image bombImg = new Image(new Texture("bomb.png"));
        bombImg.setSize(90, 90);
        bombImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                bombPress = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                bombPress = false;
            }
        });
        //bomb IMG

        Image rightImg = new Image(new Texture("flatDark24.png"));
        rightImg.setSize(110, 60);
        rightImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = false;
            }
        });

        Image leftImg = new Image(new Texture("flatDark23.png"));
        leftImg.setSize(110, 60);
        leftImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = false;
            }
        });

        ///bobm IMG
        table.add();
        table.add(bombImg).padBottom(500).size(bombImg.getWidth(), bombImg.getHeight());
        ///bobm IMG

        table.add();
        table.pad(15, 1, 50, 15);
        table.add(downImg).padLeft(-90).padBottom(250).size(downImg.getWidth(), downImg.getHeight());
        table.pad(15, 1, 50, 15);
        table.add(leftImg).padRight(50).padLeft(-50).size(leftImg.getWidth(), leftImg.getHeight());
        table.pad(15, 1, 50, 15);
        table.add(rightImg).size(rightImg.getWidth(), rightImg.getHeight());

        table.add().pad(15, 15, 50, 340);
        table.left().padBottom(80).add(upImg).size(upImg.getWidth(), upImg.getHeight());
        table.add();
        table.row().pad(15, 15, 15, 15);

        table.add();

        table.row().padBottom(15);
        table.add();
        table.add();

        stage.addActor(table);
    }

    private void basicDialogShow() {
        System.out.println(Player.b2body.getPosition());

            BasicDialog basicDialog = new BasicDialog();
            stage.addActor(basicDialog);
            basicDialog.initContent("Start game ");
    }

    public void draw(){
        stage.draw();
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isFirePress() {
        return firePress;
    }

    //bomb
    public boolean isBombPress() {
        return bombPress;
    }
    //bomb

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void resize(int width, int height){
        viewport.update(width, height);
    }
}
