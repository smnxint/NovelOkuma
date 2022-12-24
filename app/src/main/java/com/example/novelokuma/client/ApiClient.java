package com.example.novelokuma.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String BASE_URL ="https://api.npoint.io/"; // api'mızın ana kısmının linkini base_url değişkenine atadık
    private static Retrofit retrofit; // retrofit nesnesi oluşturduk
    public static Retrofit getClient(){ //getClient adında bir method oluşturduk
        if(retrofit == null){ // eğer retrofit nesnemiz boş ise bir retrofit builder nesnesi oluştursun dedik
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // api'mızın ana kısmının linkini verdik
                    .addConverterFactory(GsonConverterFactory.create()) // verileri json a çevirmek için yazıldı
                    .build(); // ve inşa ettik
        }
        return retrofit; // geriye retrofit nesnesini döndürdük
    }

}
