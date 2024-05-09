package com.example.myapplication.Cleantopya.game;

import com.example.myapplication.R;
import com.example.myapplication.framework.objects.VertScrollBackground;
import com.example.myapplication.framework.scene.Scene;

public class stage2Scene extends Scene {
    TouchButton redButton;
    TouchButton yellowButton;
    TouchButton blueButton;
    public enum Layer {
        bg, icon, bullet, player, ui, controller, COUNT
    }
    public stage2Scene(){
        initLayers(stage2Scene.Layer.COUNT);
        add(stage2Scene.Layer.bg, new VertScrollBackground(R.mipmap.background2, 0));

        this.redButton = new TouchButton(R.mipmap.red, 0, 14);
        float yellowX = 3.5f;
        this.yellowButton = new TouchButton(R.mipmap.yellow, yellowX, 14);
        this.blueButton = new TouchButton(R.mipmap.blue, 7, 14);

        add(stage1Scene.Layer.icon, redButton);
        add(stage1Scene.Layer.icon, blueButton);
        add(stage1Scene.Layer.icon, yellowButton);
    }
}
