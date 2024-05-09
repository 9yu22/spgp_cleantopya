package com.example.myapplication.Cleantopya.game;

import android.content.Context;
import android.widget.VideoView;

import com.example.myapplication.R;

public class StartVideo extends VideoView {

    public StartVideo(Context context) {
        super(context);
        // 비디오 파일을 로드
        setVideoPath("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
    }
}
