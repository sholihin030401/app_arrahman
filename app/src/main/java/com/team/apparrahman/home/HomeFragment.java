package com.team.apparrahman.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.apparrahman.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerViewDivisi;
    List<ItemDivisi> divisiList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewDivisi = view.findViewById(R.id.rv_divisi);
        initDivisi();
        AdapterDivisi adapterDivisi = new AdapterDivisi(divisiList);
        recyclerViewDivisi.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewDivisi.setAdapter(adapterDivisi);

        return view;
    }

    private void initDivisi() {
        divisiList = new ArrayList<>();
        divisiList.add(new ItemDivisi("Presidium","Koordinasi"));
        divisiList.add(new ItemDivisi("Bidang Kaderisasi","Koordinasi"));
        divisiList.add(new ItemDivisi("Bidang Kajian Syiar Islam (KSI)","Koordinasi"));
        divisiList.add(new ItemDivisi("Bidang Kemuslimahan","Koordinasi"));
        divisiList.add(new ItemDivisi("Biro Bimbingan Belajar Qur'an (BBQ)","Koordinasi"));
        divisiList.add(new ItemDivisi("Biro Akademik","Koordinasi"));
        divisiList.add(new ItemDivisi("Biro Dana & Usaha (Danus)","Koordinasi"));
        divisiList.add(new ItemDivisi("Biro Humas & Kemediaan (HDK)","Koordinasi"));
    }
}