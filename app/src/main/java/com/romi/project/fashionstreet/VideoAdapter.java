package com.romi.project.fashionstreet;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    @NonNull
    List<VideosModel> videosModelList;
    Context context;

    public VideoAdapter(@NonNull List<VideosModel> videosModelList, Context context) {
        this.videosModelList = videosModelList;
        this.context = context;
    }

    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.videoitems,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoAdapter.ViewHolder holder, int position) {
VideosModel videosModel=videosModelList.get(position);
try {
    int video = videosModel.getVideourl();
    MediaController mediaController = new MediaController(context);
    mediaController.setAnchorView(holder.videoView);
    String videoPath = "android.resource://" + context.getPackageName() + "/" ;
    Uri uri = Uri.parse(videoPath + video);
    holder.videoView.setVideoURI(uri);
    holder.videoView.setMediaController(mediaController);
    holder.videoView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            holder.videoView.start();
        }
    });

    holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
                      holder.videoView.stopPlayback();

        }
    });
} catch (Exception e)
{
    e.printStackTrace();
    Toast.makeText(context, "Something Error", Toast.LENGTH_SHORT).show();
}
    }

    @Override
    public int getItemCount() {
        return videosModelList.size();
    }


   public class ViewHolder extends RecyclerView.ViewHolder {
        private VideoView videoView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView=itemView.findViewById(R.id.videoview);
        }
    }
}
