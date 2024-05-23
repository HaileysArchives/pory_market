package com.example.grocery_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.grocery_app.Adapter.PopularListAdapter;
import com.example.grocery_app.Domain.PopularDomain;
import com.example.grocery_app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;
    private ImageView ivWishlist; // 추가된 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottom_navigation();

        // 위시리스트 버튼에 대한 클릭 리스너를 설정합니다.
        ivWishlist = findViewById(R.id.ivWishlist);
        ivWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // WishListActivity를 시작합니다.
                Intent intent = new Intent(MainActivity.this, WishListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Original Pepero", "Discover", "pic1", 15, 4, 2));
        items.add(new PopularDomain("Kontrabass coffee cold brew", "Discover", "pic2", 10, 4.5, 3));
        items.add(new PopularDomain("Lemon", "Discover", "pic3", 13, 4.2, 5));

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPopular = new PopularListAdapter(this, items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}
