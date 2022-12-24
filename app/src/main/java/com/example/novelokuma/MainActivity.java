package com.example.novelokuma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.novelokuma.adapter.RecyclerViewAdapter;
import com.example.novelokuma.client.ApiClient;
import com.example.novelokuma.databinding.ActivityMainBinding;
import com.example.novelokuma.model.NovelModel;
import com.example.novelokuma.service.NovelAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //NovelAPI apiService = ApiClient.getClient().create(NovelAPI.class); // apiclient class'ında yazdığımız kodları burada kullanmak için oluşturulan nesne
    private ActivityMainBinding binding; //binding ile verilere erişmek için burada nesnesini oluşturdum
    List<NovelModel> novelList; //boş bir novel adı listesi oluşturduk
    List<NovelModel> novelUrlList; // boş bir novel resim url list oluşturduk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        // 34-35-36 ıncı satırlar bindingi kullanmak için yazıldı.

        RecyclerView recyclerView =binding.recyclerView; //recycler view nesnesine eriştik
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // itemleri alt alta görmek istediğimiz için linearlayout kullandık
        recyclerView.setLayoutManager(layoutManager);


        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getApplicationContext(),novelList,novelUrlList); //adapter nesnesi oluşturup içine listelerimizi verdik
        recyclerView.setAdapter(recyclerAdapter);


        NovelAPI apiService = ApiClient.getClient().create(NovelAPI.class); //verileri çekmek için yazmış olduğumuz sınıfın nesnesini oluşturduk

        Call<List<NovelModel>> call = apiService.getData(); // verileri çekme methodunu çağırdık



        call.enqueue(new Callback<List<NovelModel>>() { //sırasıyla yap dedik. başarılı olursa onresponse başarısız olursa onfailure çalışacak
            @Override
            public void onResponse(Call<List<NovelModel>> call, Response<List<NovelModel>> response) {
                //verileri başarılı olarak çektiğinde çalışan method
                novelList = response.body(); //novelAdıList verilerini çektik. bunu yazmasaydık veriler null olarak dönecekti
                novelUrlList = response.body(); //novelUrlList verilerini çektik. bunu yazmasaydık veriler null olarak dönecekti
                Log.d("TAG","Response = "+novelList);
                System.out.println("novel url list");
                System.out.println(novelUrlList);
                System.out.println("novel adı list");
                System.out.println(novelList);
                System.out.println("adapter");
                recyclerAdapter.setNovelList(novelList,novelUrlList); // adaptörümüze listelerimizi verdik çünkü ekranda görmek için
            }

            @Override
            public void onFailure(Call<List<NovelModel>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
                //verileri çekemezse çalışacak olan method
            }
        });

    }
}