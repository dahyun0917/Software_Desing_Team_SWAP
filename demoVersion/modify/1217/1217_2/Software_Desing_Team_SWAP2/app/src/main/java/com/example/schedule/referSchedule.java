package com.example.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class referSchedule<calendarView> extends AppCompatActivity {

    public String date = new String();

        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_refer_schedule);
            findViewById(R.id.backButton).setOnClickListener(onClickListener);
            EditText dateText = findViewById(R.id.textDateRefer);
            Intent getInfo = getIntent();
            date = getInfo.getStringExtra("Date");
            dateText.setText(date);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.backButton:
                    gotoMainActivity();
                    break;
            }
        }
    };

    private void gotoMainActivity(){
        Intent intent = new Intent(this, busSchedule.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
