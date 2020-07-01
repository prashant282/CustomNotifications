package com.example.user.customnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.user.customnotifications.App.CHANNEL_1_ID;
import static com.example.user.customnotifications.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    EditText edit_text_title;
    EditText edit_text_message;
    Button button_channel_1;
    Button button_channel_2;
    NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text_title=findViewById(R.id.edit_text_title);
        edit_text_message=findViewById(R.id.edit_text_message);
        button_channel_1=findViewById(R.id.button_channel_1);
        button_channel_2=findViewById(R.id.button_channel_2);

        notificationManagerCompat=NotificationManagerCompat.from(this);

        button_channel_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edit_text_title.getText().toString();
                String message= edit_text_message.getText().toString();
                Notification notification= new NotificationCompat.Builder(MainActivity.this,CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic_baseline_favorite_24)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();

                notificationManagerCompat.notify(1,notification);
                Toast.makeText(MainActivity.this,"Pop up notification occur",Toast.LENGTH_LONG).show();

            }
        });

        button_channel_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edit_text_title.getText().toString();
                String message= edit_text_message.getText().toString();
                Notification notification= new NotificationCompat.Builder(MainActivity.this,CHANNEL_2_ID)
                        .setSmallIcon(R.drawable.ic_baseline_favorite_border_24)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_LOW)
                        .build();
                Toast.makeText(MainActivity.this,"Silent Notification occur",Toast.LENGTH_LONG).show();

                notificationManagerCompat.notify(2,notification);

            }
        });


    }
}