package com.romi.project.fashionstreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private VideoView videoView;
    private MediaController mediaController;
    private RecyclerView recyclerView;
    ;
    private VideoAdapter videoAdapter;
    private SwipeRefreshLayout refreshLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        toolbar = findViewById(R.id.videotoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Video");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        videoView = findViewById(R.id.videoview);
        progressBar = findViewById(R.id.videoprogress);
        List<VideosModel> videosModelArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.videorecyclerview);
        videoAdapter = new VideoAdapter(videosModelArrayList, this);
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));
        videosModelArrayList.add(new VideosModel(R.raw.cod));


        recyclerView.setAdapter(videoAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.search,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home : finish();
                return true;
        }
        return false;
    }


}
