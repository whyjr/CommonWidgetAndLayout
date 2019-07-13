package aoto.com.commonwidgetandlayout.basic_widget.progressBar;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-20 16:15:46
 */
public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {

    int progress = 0;
    int cacheProgress = 0;
    ProgressBar defaultBar1;
    ProgressBar horizonBar1;
    ProgressBar horizonBar2;
    TextView progressText;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    horizonBar1.setProgress(progress);
                    if (progress == 100) {
                        progressText.setText("下载完成");
                    } else {
                        progressText.setText("下载进度 " + progress + "%");
                    }
                    break;
                case 1:
                    horizonBar2.setProgress(progress);

                    if(progress==100){
                        progressText.setText("播放完毕");
                    }
                    else {
                        if(cacheProgress<=100){
                            progressText.setText("播放完成："+progress+"%"+"，缓存完成"+cacheProgress+"%");
                            horizonBar2.setSecondaryProgress(cacheProgress);
                        }
                        else {
                            progressText.setText("播放完成："+progress+"%"+"，缓存结束");
                        }
                    }
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        findView();
    }

    private void findView() {
        defaultBar1 = findViewById(R.id.normal_progress_bar_default);
        horizonBar1 = findViewById(R.id.normal_progress_bar_horizon);
        horizonBar2 = findViewById(R.id.normal_progress_bar_horizon2);

        progressText = findViewById(R.id.progress_text);
        findViewById(R.id.normal_default_bar).setOnClickListener(this);
        findViewById(R.id.normal_horizon_bar1).setOnClickListener(this);
        findViewById(R.id.normal_horizon_bar2).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.normal_default_bar:
                progressText.setVisibility(View.INVISIBLE);
                horizonBar1.setVisibility(View.INVISIBLE);
                horizonBar2.setVisibility(View.INVISIBLE);
                defaultBar1.setVisibility(View.VISIBLE);
                break;
            case R.id.normal_horizon_bar1:
                progress = 0;
                progressText.setVisibility(View.VISIBLE);
                defaultBar1.setVisibility(View.INVISIBLE);
                horizonBar2.setVisibility(View.INVISIBLE);
                horizonBar1.setVisibility(View.VISIBLE);
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        progress += 2;
                        if (progress <= 100) {
                            Message message = Message.obtain();
                            message.what = 0;
                            handler.sendMessage(message);
                        } else {
                            timer.cancel();
                        }
                    }
                }, 0, 200);
                break;
            case R.id.normal_horizon_bar2:
                progressText.setVisibility(View.VISIBLE);
                defaultBar1.setVisibility(View.INVISIBLE);
                horizonBar1.setVisibility(View.INVISIBLE);
                horizonBar2.setVisibility(View.VISIBLE);
                cacheProgress = 0;
                progress = 0;
                final Timer timer1 = new Timer();
                timer1.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        progress += 1;
                        cacheProgress += 2;
                        if (progress <= 100) {
                            Message message = Message.obtain();
                            message.what = 1;
                            handler.sendMessage(message);
                        } else {
                            timer1.cancel();
                        }
                    }
                }, 0, 400);
                break;
        }
    }
}
