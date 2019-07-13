package aoto.com.commonwidgetandlayout.basic_widget.ImageButton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-7-4 11:42:48
 */
public class ImageButtonActivity extends AppCompatActivity {

    boolean isOpen=true;
    ImageButton imageButton;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button);
        imageButton=findViewById(R.id.test_image_button);
        textView=findViewById(R.id.opener_label);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    imageButton.setImageResource(R.drawable.image_button_test_stop);
                    isOpen=false;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("状态：关");
                            textView.setTextColor(Color.RED);
                        }
                    });
                }
                else {
                    imageButton.setImageResource(R.drawable.image_button_test_start);
                    isOpen=true;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("状态：开");
                            textView.setTextColor(Color.BLACK);
                        }
                    });
                }
            }
        });
    }
}
