package com.team.apparrahman.event;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.team.apparrahman.R;

import java.util.ArrayList;

public class EventFragment extends Fragment {

    private EventAdapter eventAdapter;
    RecyclerView recyclerView;
    Handler handler = new Handler();

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        recyclerView = view.findViewById(R.id.rv_event);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        eventAdapter = new EventAdapter();
        eventAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(eventAdapter);
        ProgressBar progressBar = view.findViewById(R.id.pb_event);
        progressBar.setVisibility(View.VISIBLE);

        EventModel eventModel = new ViewModelProvider(this).get(EventModel.class);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            handler.post(() -> {
                eventModel.getLiveEvent().observe(getViewLifecycleOwner(),getEventBlog);
                eventModel.setEvent("extra_event");
                progressBar.setVisibility(View.GONE);
            });
        }).start();


        return view;

    }

    private Observer<ArrayList<EventItem>> getEventBlog = eventItems -> {
        if (eventItems != null){
            eventAdapter.EventAdapter(eventItems);
        }
    };
}