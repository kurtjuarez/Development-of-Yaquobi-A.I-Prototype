package com.example.ilocanospeech_to_texttranslatorapp.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ilocanospeech_to_texttranslatorapp.R;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class HomePage extends Fragment {

    // TensorFlow Whisper Model variables
    private static final String TAG = "HomePage";
    private static final String DEFAULT_MODEL_TO_USE = "whisper-tiny.tflite";
    private static final String ENGLISH_ONLY_MODEL_EXTENSION = ".en.tflite";
    private static final String ENGLISH_ONLY_VOCAB_FILE = "filters_vocab_en.bin";
    private static final String MULTILINGUAL_VOCAB_FILE = "filters_vocab_multilingual.bin";
    private static final String[] EXTENSIONS_TO_COPY = {"tflite", "bin", "wav", "pcm"};
    // Speech-to-Text variables
    private ImageView micBut;

    // Text-to-Text variables
    private EditText editTextIn;
    private TextView engT, iloT;
    private String api = "";
    private Translator translator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        // Initialize UI components
        editTextIn = view.findViewById(R.id.editTextInput);
        engT = view.findViewById(R.id.eng_text);
        iloT = view.findViewById(R.id.ilo_text);

        // Set up translation model (English to Ilocano)
        TranslatorOptions options = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.TAGALOG)
                .build();

        translator = Translation.getClient(options);

        translator.downloadModelIfNeeded()
                .addOnSuccessListener(unused -> {
                    // Enable input translation after model download
                    editTextIn.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            engT.setText(s.toString()); // Set input text as English text
                            translateText(s.toString());
                        }

                        @Override
                        public void afterTextChanged(Editable s) {}
                    });
                })
                .addOnFailureListener(e -> iloT.setText("Error downloading translation model"));

        return view;
    }

    // Translate input text
    private void translateText(String input) {
        if (input.isEmpty()) {
            iloT.setText("");
            engT.setTextColor(getResources().getColor(R.color.black)); // Ensure default color
            iloT.setTextColor(getResources().getColor(R.color.black));
            return;
        }
        engT.setTextColor(getResources().getColor(R.color.black)); // Change font color to black
        translator.translate(input)
                .addOnSuccessListener(translatedText -> {
                    iloT.setText(translatedText);
                    iloT.setTextColor(getResources().getColor(R.color.black)); // Change font color to black
                })
                .addOnFailureListener(e -> iloT.setText("Translation error"));
        translator.translate(input)
                .addOnSuccessListener(translatedText -> iloT.setText(translatedText)) // Set Ilocano text
                .addOnFailureListener(e -> iloT.setText("Translation error"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (translator != null) {
            translator.close(); // Clean up translator instance
        }
    }
}
