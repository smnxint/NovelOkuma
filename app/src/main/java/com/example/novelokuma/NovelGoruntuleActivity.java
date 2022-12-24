package com.example.novelokuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.novelokuma.databinding.ActivityNovelGoruntuleBinding;
import com.squareup.picasso.Picasso;

public class NovelGoruntuleActivity extends AppCompatActivity {


    private ActivityNovelGoruntuleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNovelGoruntuleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent= getIntent();
        String novelAdi= intent.getStringExtra("novelAdi");
        String novelUrl= intent.getStringExtra("novelUrl");
        binding.novelAdiTextViewIki.setText(novelAdi);
        Picasso.get().load(novelUrl).into(binding.novelKapakResmi);
    }
}