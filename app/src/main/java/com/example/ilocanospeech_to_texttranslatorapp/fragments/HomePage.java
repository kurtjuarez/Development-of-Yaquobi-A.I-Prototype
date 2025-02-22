package com.example.ilocanospeech_to_texttranslatorapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.ilocanospeech_to_texttranslatorapp.MainActivity;
import com.example.ilocanospeech_to_texttranslatorapp.R;

// The Fragment for HomePage
public class HomePage extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_home_page, container, false);

        return view;
    }
}