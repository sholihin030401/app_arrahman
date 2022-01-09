package com.team.apparrahman.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.team.apparrahman.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DetailEventActivity extends AppCompatActivity {

    public static final String EXTRA_EVENT = "extra_event";
    TextView txtitle, txcontent;
    PhotoView imgevent;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        txtitle = findViewById(R.id.title_blog_detail);
        txcontent = findViewById(R.id.desc_blog_detail);
        imgevent = findViewById(R.id.img_blog_detail);
        progressBar = findViewById(R.id.pb_event_detail);

        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            handler.post(() -> {
                EventItem item = getIntent().getParcelableExtra(EXTRA_EVENT);
                txtitle.setText(item.getTitle());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    txcontent.setText(Html.fromHtml(item.getContent(),Html.FROM_HTML_MODE_COMPACT));
                } else {
                    txcontent.setText(Html.fromHtml(item.getContent()));
                }

                Document document = Jsoup.parse(item.getContent());
                Elements elements = document.select("img");
                Glide.with(DetailEventActivity.this).load(elements.get(0).attr("src")).into(imgevent);

                progressBar.setVisibility(View.GONE);
            });
        }).start();
    }
}