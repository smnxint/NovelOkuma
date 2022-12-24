package com.example.novelokuma.model;

import com.google.gson.annotations.SerializedName;

public class NovelModel {

    //modelimizi oluşturduk. ad ve resim url den oluşan 2 tane değişken
    // @SerializedName anatasyonun amacı; api'daki değişkenlerin ismi neyse aynısını oraya yazmak
    @SerializedName("novelAdi")
    public String novelAdi;

    @SerializedName("novelResmi")
    public String novelResmi;

    public NovelModel(String novelAdi, String novelResmi) {
        this.novelAdi = novelAdi;
        this.novelResmi = novelResmi;
        // bu class'ın nesnesini oluşturmak için bir constructor oluşturduk
    }

    //novel adı ve novel resmi değişkenlerine erişmek için get set methodlarını oluşturduk

    public String getNovelAdi() {
        return novelAdi;
    }

    public void setNovelAdi(String novelAdi) {
        this.novelAdi = novelAdi;
    }

    public String getNovelResmi() {
        return novelResmi;
    }

    public void setNovelResmi(String novelResmi) {
        this.novelResmi = novelResmi;
    }
}
