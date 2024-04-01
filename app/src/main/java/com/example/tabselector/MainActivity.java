package com.example.tabselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edta, edtb;
    Button btncong;
    TabHost mytabs;
    // khai báo list
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvet();

        // commit vỡn có thay đồi ở git không
    }

    private void addEvet() {
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a + b;
                mylist.add(a + " + " + b + " = " + c);// thêm dữ liệu vào mảng
                myadapter.notifyDataSetChanged(); // cập nhật lại adapter
                Toast.makeText(MainActivity.this, "Kết quả là : " + c, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addControl() {
        // ánh xạ id
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        btncong = findViewById(R.id.btncong);

        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>(); // tạo mảng
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

        // tanhost
        mytabs = findViewById(R.id.mytab);
        mytabs.setup();
        // khai báo cáo tabs con
        TabHost.TabSpec spec1, spec2;

        // ứng với mỗi spec, có 4 công việc
        //tab1
        spec1 = mytabs.newTabSpec("t1");// tạo mới
        spec1.setContent(R.id.tab1); // tham chiếu
        spec1.setIndicator("",getResources().getDrawable(R.drawable.ic_launcher_background));// có icon thì thiết lập //
        mytabs.addTab(spec1);// thêm vào tab chính


        //tab2
        spec2 = mytabs.newTabSpec("t2");// tạo mới
        spec2.setContent(R.id.tab2); // tham chiếu
        spec2.setIndicator("",getResources().getDrawable(R.drawable.ic_launcher_foreground));//có icon thì thiết lập //
        mytabs.addTab(spec2);// thêm vào tab chính

    }
}