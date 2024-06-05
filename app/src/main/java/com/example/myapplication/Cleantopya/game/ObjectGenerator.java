package com.example.myapplication.Cleantopya.game;

import android.graphics.Canvas;

import com.example.myapplication.framework.interfaces.IGameObject;
import com.example.myapplication.framework.scene.Scene;

import java.util.LinkedList;
import java.util.Queue;

public class ObjectGenerator implements IGameObject {
    Queue<HomeObjectsLine> Lines = new LinkedList<>();
    private static final String TAG = ObjectGenerator.class.getSimpleName();
    public static final float GEN_INTERVAL = 5.0f;
    private float furnitureGenerateTime = 0;
    @Override
    public void update(float elapsedSeconds) {
        furnitureGenerateTime -= elapsedSeconds*5;
        if (furnitureGenerateTime < 0) {
            if(Lines.size()<6) {
                generate();
            }
            furnitureGenerateTime = GEN_INTERVAL;
        }
        int idx = 0;
        for(HomeObjectsLine line: Lines){
            line.update(elapsedSeconds, idx++);
        }
    }

    private void generate() {
        Scene scene = Scene.top();
        if (scene == null) return;

        HomeObjectsLine line = HomeObjectsLine.get();
        scene.add(stage2Scene.Layer.enemy, line);

        Lines.add(line);
    }

    @Override
    public void draw(Canvas canvas) {

    }

    public void lineRemove(int index){
        if(Lines.isEmpty())
            return;
        HomeObjectsLine line = Lines.peek();
        line.Remove(index);
        if(line.isEmptyLine()){
            Lines.remove();
            Scene.top().remove(stage2Scene.Layer.enemy, line);
        }
    }

}