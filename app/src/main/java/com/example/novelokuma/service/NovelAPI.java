package com.example.novelokuma.service;

import com.example.novelokuma.model.NovelModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NovelAPI {
    //linkimizin slug kısmını get anatasyonun içine yazdık ve getData isminde verileri liste şeklinde çekmesi için bir method oluşturduk
    @GET("a73b705584f84f85c23f")
    Call<List<NovelModel>> getData();
    //https://api.npoint.io/a73b705584f84f85c23f api link
}
