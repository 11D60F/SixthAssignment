package com.example.sixthassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        RecyclerView messageRecycler = findViewById(R.id.message_recycler);
        MessageAdapter adapter = new MessageAdapter(getMessage());
        messageRecycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new MessageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Message message) {
                Toast.makeText(MainActivity.this, "你点击了" + message.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        messageRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Message> getMessage() {
        List<Message> list = new ArrayList<>();
        Message message1 = new Message();
        Message message2 = new Message();
        Message message3 = new Message();
        message1.setImageId(R.drawable.image1);
        message1.setName("帅哥");
        message1.setContent(getRandomLengthContent(message1.getName()));
        message2.setImageId(R.drawable.image2);
        message2.setName("移动部门招新群");
        message2.setContent(getRandomLengthContent(message2.getName()));
        message3.setImageId(R.drawable.image3);
        message3.setName("3G");
        message3.setContent(getRandomLengthContent(message3.getName()));
        for (int i = 0; i < 15; i++) {
            list.add(message1);
            list.add(message2);
            list.add(message3);
        }
        return list;
    }

    private String getRandomLengthContent(String content) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(content);
        }
        return builder.toString();
    }
}