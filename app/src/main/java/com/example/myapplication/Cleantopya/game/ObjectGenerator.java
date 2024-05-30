package com.example.myapplication.Cleantopya.game;

import android.graphics.Canvas;

import com.example.myapplication.framework.interfaces.IGameObject;
import com.example.myapplication.framework.scene.Scene;

public class ObjectGenerator implements IGameObject {
    private static final String TAG = ObjectGenerator.class.getSimpleName();
    public static final float GEN_INTERVAL = 5.0f;
    private float furnitureGenerateTime = 0;
    @Override
    public void update(float elapsedSeconds) {
        furnitureGenerateTime -= elapsedSeconds*5;
        if (furnitureGenerateTime < 0) {
            generate();
            furnitureGenerateTime = GEN_INTERVAL;
        }
    }

    private void generate() {
        Scene scene = Scene.top();
        if (scene == null) return;

        scene.add(stage2Scene.Layer.enemy, HomeObjectsLine.get());
    }

    @Override
    public void draw(Canvas canvas) {

    }


}