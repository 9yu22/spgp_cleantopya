package com.example.myapplication.Cleantopya.game;

import com.example.myapplication.R;
import com.example.myapplication.framework.objects.VertScrollBackground;
import com.example.myapplication.framework.scene.Scene;

public class stage2Scene extends Scene {
    public enum Layer {
        bg, icon, bullet, player, ui, controller, COUNT
    }
    public stage2Scene(){
        initLayers(stage2Scene.Layer.COUNT);
        add(stage2Scene.Layer.bg, new VertScrollBackground(R.mipmap.background2, 0));
    }
}
