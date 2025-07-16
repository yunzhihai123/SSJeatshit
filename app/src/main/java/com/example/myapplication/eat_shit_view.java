package com.example.myapplication;

import android.media.AudioManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.net.Uri;
import android.widget.VideoView;
import android.content.Context;


public class eat_shit_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eat_shit_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        play();

    }

    private void play() {

        AudioManager audioManager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        // 获取媒体音量的最大值
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //将媒体音量设置为最大值
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume,0);


        VideoView videoView = findViewById(R.id.videoView);

        // 1. 使用 setVideoURI() 和正确的资源 URI
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sun));

        // 3. 显式调用 start() 方法开始播放
        videoView.start();
    }
    }



