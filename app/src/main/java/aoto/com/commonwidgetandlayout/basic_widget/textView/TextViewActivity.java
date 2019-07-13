package aoto.com.commonwidgetandlayout.basic_widget.textView;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-6-1 11:18:17
 */
public class TextViewActivity extends AppCompatActivity {

    boolean isOver=false;
    private static final String TAG = "TextViewActivityWhy";
    TextView textView;
    private float percent=0.0f;

    // @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        //textView.setPadding();
        //textView = findViewById(R.id.textView_test1);
        //textView.setSingleLine();
        //textView.setEllipsize();
       // percent=textView.getLineSpacingMultiplier();
    }

//    public void showText(View view) {
//        if (!isOver) {
//            final Timer timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    percent += 0.05f;
//                    if (percent <= 1) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                textView.setLineSpacing(0, percent);
//                            }
//                        });
//                    } else {
//                        isOver=true;
//                        percent=0;
//                        timer.cancel();
//                    }
//                }
//            }, 100, 50);
//        }
//        else {
//            isOver=false;
//            textView.setLineSpacing(0,0);
//        }
//    }
}
