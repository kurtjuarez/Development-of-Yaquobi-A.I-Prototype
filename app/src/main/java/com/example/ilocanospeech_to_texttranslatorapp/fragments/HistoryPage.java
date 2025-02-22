package com.example.ilocanospeech_to_texttranslatorapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ilocanospeech_to_texttranslatorapp.R;
import com.example.ilocanospeech_to_texttranslatorapp.adapter.RecyclerAdapter;
import com.example.ilocanospeech_to_texttranslatorapp.model.RecyclerModel;

import java.util.ArrayList;
import java.util.List;

// The Fragment of HistoryPage
public class HistoryPage extends Fragment {
    private RecyclerView recyclerView;
    private List<RecyclerModel> recyclerModels = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_page, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_name);

        // Dummy contents of the RecyclerView items
        recyclerModels.add(new RecyclerModel("12-12-12", "12:12:12", "Inputted text here.", "Translated text here."));
        recyclerModels.add(new RecyclerModel("12-12-12", "13:13:13", "Inputted text here.", "Translated text here."));
        recyclerModels.add(new RecyclerModel("12-12-12", "14:14:14", "Inputted text here.", "Translated text here."));

        recyclerAdapter = new RecyclerAdapter(getContext(), recyclerModels);

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}