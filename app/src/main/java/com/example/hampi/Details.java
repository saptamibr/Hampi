package com.example.hampi;

public class Details {

    private int nameId;
    private int imgId;

    public Details(int n,int id){
        nameId = n;
        imgId = id;
    }

    public int getName(){
        return nameId;
    }

    public int getImgId(){
        return imgId;
    }

}
