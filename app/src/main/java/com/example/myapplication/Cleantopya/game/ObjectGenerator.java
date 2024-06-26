package com.example.myapplication.Cleantopya.game;

import static com.example.myapplication.Cleantopya.app.CleantopyaActivity.getContext;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.Log;

import com.example.myapplication.Cleantopya.app.ScoreActivity;
import com.example.myapplication.framework.interfaces.IGameObject;
import com.example.myapplication.framework.objects.Score;
import com.example.myapplication.framework.scene.Scene;

import java.util.LinkedList;
import java.util.Queue;

public class ObjectGenerator implements IGameObject {
    Queue<HomeObjectsLine> Lines = new LinkedList<>();
    private static final String TAG = ObjectGenerator.class.getSimpleName();
    public static final float GEN_INTERVAL = 5.0f;
    private float furnitureGenerateTime = 0;
    private int gameend = 29; //총 30줄
    @Override
    public void update(float elapsedSeconds) {
        furnitureGenerateTime -= elapsedSeconds*25;
        if (furnitureGenerateTime < 0) {
            if(Lines.size()<6 && !(gameend<0)) {
                generate();
                gameend--;
                //Log.d("gameend", "gameend: " + gameend);
            }
            if(gameend == -1 && Lines.isEmpty()){
                Log.d("clear", "clear");
                method();

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

    public boolean lineRemove(int index){
        if(Lines.isEmpty()){
            return false;
        }

        HomeObjectsLine line = Lines.peek();
        if(!line.Remove(index))
            return false;
        if(line.isEmptyLine()){
            Lines.remove();
            Scene.top().remove(stage2Scene.Layer.enemy, line);
        }
        return true;
    }

    public void method() {
        Context context = getContext();

        stage1Scene Stage1Scene = stage1Scene.getInstance();
        int stage1score = Stage1Scene.getStage1score();
        stage2Scene Stage2Scene = stage2Scene.getInstance();
        int stage2score = Stage2Scene.getStage2score();
        //Log.d("stage1Score", "stage1score: " + stage1score);
        Intent intent = new Intent(context, ScoreActivity.class);
        intent.putExtra("STAGE_1_SCORE", stage1score);
        intent.putExtra("STAGE_2_SCORE", stage2score);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // 플래그 추가
        context.startActivity(intent);

    }


}