package com.example.novelokuma.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novelokuma.NovelGoruntuleActivity;
import com.example.novelokuma.R;
import com.example.novelokuma.model.NovelModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {


    List<NovelModel> arrayListNovelAdi; //boş liste olusturduk
    List<NovelModel> arrayListNovelResmiUrl; //boş liste olusturduk
    Context context; //mainactivity'de bizden context isteyeceği için burada olusturduk

    public RecyclerViewAdapter(Context context,List<NovelModel> arrayListNovelAdi, List<NovelModel> arrayListNovelResmiUrl) {
        this.context= context;
        this.arrayListNovelAdi = arrayListNovelAdi;
        this.arrayListNovelResmiUrl = arrayListNovelResmiUrl;
        // RecyclerViewAdapter class'ımızın constructorunu oluşturduk.
    }

    public void setNovelList(List<NovelModel> arrayListNovelAdi,List<NovelModel> arrayListNovelResmiUrl) {
        this.arrayListNovelAdi = arrayListNovelAdi;
        this.arrayListNovelResmiUrl = arrayListNovelResmiUrl;
        notifyDataSetChanged(); // eklenen veriyi ekranda direkt güncelleyip gösterir
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false); // recycler_row'a erişip bunu view ile bağlantıya geçip göstermesi için yazıldı
        return new RecyclerViewHolder(view); // bview nesnesini geriye döndürdük
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
        TextView recyclerTextView = holder.itemView.findViewById(R.id.novelAdiTextView);
        recyclerTextView.setText(arrayListNovelAdi.get(position).novelAdi); // textview nesnesine erişip textine novel adını yerleştirdik


        Picasso.get().load(arrayListNovelResmiUrl.get(position).novelResmi).into((ImageView) holder.itemView.findViewById(R.id.novelResmi));
        // picasso kütüphanemiz ile resimlerimizi yerleştirdik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), NovelGoruntuleActivity.class);
                intent.putExtra("novelAdi",arrayListNovelAdi.get(position).novelAdi);
                intent.putExtra("novelUrl",arrayListNovelResmiUrl.get(position).novelResmi);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {

        if(arrayListNovelAdi != null){
            return arrayListNovelAdi.size();
        }
        return 0;
        // arrayListNovelAdi listesi ne kadar veri döndürüyorsa onun size'ı kadar geriye int değer döndürsün dedik.

    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
