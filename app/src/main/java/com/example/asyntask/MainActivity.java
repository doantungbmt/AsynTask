package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textViewInfo;
    private Button buttonStart;
    private Button buttonCancel;

    private MyWorkTask myWorkTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.progressBar = (ProgressBar) this.findViewById(R.id.progressBar);
        this.textViewInfo = (TextView) this.findViewById(R.id.textView_info);
        this.buttonStart = (Button) this.findViewById(R.id.button_start);
        this.buttonCancel = (Button) this.findViewById(R.id.button_cancel);

        this.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWork();
            }
        });
        this.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestCancel();
            }
        });
    }

    private void startWork() {
        this.myWorkTask = new MyWorkTask(this.progressBar,
                this.textViewInfo, this.buttonStart, this.buttonCancel);

        ParamInfo param = new ParamInfo("Param 1", "Param 2");

        this.myWorkTask.execute(param);
    }

    private void requestCancel() {
        if(this.myWorkTask != null)  {
            this.myWorkTask.cancel(true);
        }
    }
}