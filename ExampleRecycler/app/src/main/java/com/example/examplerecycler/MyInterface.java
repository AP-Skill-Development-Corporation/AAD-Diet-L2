package com.example.examplerecycler;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyInterface {
    @GET("top-headlines?sources=google-news&apiKey=01ff052b0bae41d68947bd7b88e600d5")
    Call<String> value();
}
