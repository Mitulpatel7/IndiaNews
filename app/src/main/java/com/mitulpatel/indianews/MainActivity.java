package com.mitulpatel.indianews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<News> newsListArray;
    RecyclerView recyclerView;
    Context context;
    RVadapter rVadapter;

    String API_KEY = "=56ef971a17cd43658259adb65d6f10c6";
    String BASE_URL = "https://newsapi.org/v2/top-headlines?country=in&apiKey=56ef971a17cd43658259adb65d6f10c6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsListArray = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rVadapter =new RVadapter(this,newsListArray);
        recyclerView.setAdapter(rVadapter);

        fetchdata();
    }

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(context, "Image Not Found", Toast.LENGTH_SHORT).show();
        }
    };


    private void fetchdata() {

        StringRequest request = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JsonObject object = new JsonObject();
                    JsonArray jsonArray = object.getAsJsonArray("articles");
                    int length = jsonArray.size();
                    for (int i = 0; i < length; i++) {
                        JsonObject object1 = jsonArray.getAsJsonObject();

                        Log.i("key",object1.toString());

                        String title = object1.get("title").toString();

                        String imgURL = object1.get("urlToImage").toString();

                        Log.i("title",title.toString());
                        Log.i("title",imgURL.toString());

                        newsListArray.add(new News(title, imgURL));

                    }

                    rVadapter.notifyDataSetChanged();
                } catch (Exception e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        },errorListener){
                @Override
            public Map<String,String> getHeaders() throws AuthFailureError{
                        Map<String,String> map = new HashMap<>();
                        map.put("key",BASE_URL);
                        return map;
                }
        };


        context = getApplicationContext();
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);

    }


}