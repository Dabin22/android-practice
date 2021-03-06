package com.jaemin.android.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAnimationActivity extends AppCompatActivity {
    /*
        1. 리사이클러뷰를 현재 액티비티의 메인레이아웃에 만든다
        2. 리사이클러뷰에 들어갈 아이템레이아웃을 만든다
        3. Adapter를 만든다
        4. 리사이클러뷰에 아답터를 세팅한다
        5. 리사이클러뷰에 레이아웃매니저를 지정한다

      */
    // 전역으로 설정, 하지만 이렇게 해두면 버튼이 클릭될 때 마다 100개씩 만들어져서 계속 쌓이기 때문에 null로 해두고 onCreate 안에서 new를 해준다
    // public static ArrayList<RecyclerData> datas = new ArrayList<>();
    public static ArrayList<RecyclerData> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_animation);

        datas = new ArrayList<>();// onCreate가 호출될 때 마다 다시 new로 생성한다

        // ArrayList<RecyclerData> datas = new ArrayList<>();
        for (int i=0; i<100; i++) {
            RecyclerData data = new RecyclerData();
            data.title = (i+1) + ". Make You Feel My Love";
            data.name = "adele";
            data.image = R.mipmap.adele;

            datas.add(data);
        }

        RecyclerView listView = (RecyclerView) findViewById(R.id.recyclerView_anim);
        RecyclerAnimationAdapter adapter = new RecyclerAnimationAdapter(datas, R.layout.recycler_animation_item, this);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
    }
}
