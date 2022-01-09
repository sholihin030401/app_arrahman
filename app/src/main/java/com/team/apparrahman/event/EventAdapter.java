package com.team.apparrahman.event;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.team.apparrahman.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder> {

    private ArrayList<EventItem> eventItems = new ArrayList<>();

    public void EventAdapter(ArrayList<EventItem> eventItem) {
        eventItems.clear();
        eventItems.addAll(eventItem);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventAdapter.EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvevent_item,parent,false);

        return new EventHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.EventHolder holder, int position) {
        holder.bind(eventItems.get(position));
    }

    @Override
    public int getItemCount() {
        return eventItems.size();
    }

    public class EventHolder extends RecyclerView.ViewHolder {

        TextView titles, labels;
        ImageView imageViews;

        public EventHolder(@NonNull View itemView) {
            super(itemView);

            titles = itemView.findViewById(R.id.title_blog);
            labels = itemView.findViewById(R.id.label_blog);
            imageViews = itemView.findViewById(R.id.img_blog);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                EventItem items = eventItems.get(position);
                items.setTitle(items.getTitle());

                Intent events = new Intent(itemView.getContext(),DetailEventActivity.class);
                events.putExtra(DetailEventActivity.EXTRA_EVENT,items);
                itemView.getContext().startActivity(events);
            });
        }

        void bind(EventItem item){
            titles.setText(item.getTitle());
            //error
            Document document = Jsoup.parse(item.getContent());
            Elements elements = document.select("img");
            Glide.with(itemView.getContext()).load(elements.get(0).attr("src")).into(imageViews);
        }
    }
}
