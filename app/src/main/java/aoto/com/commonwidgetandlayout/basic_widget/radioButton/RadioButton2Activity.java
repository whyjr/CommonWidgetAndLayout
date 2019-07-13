package aoto.com.commonwidgetandlayout.basic_widget.radioButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-13 21:43:42
 */
public class RadioButton2Activity extends AppCompatActivity {

    private static final String TAG = "RadioButton2ActivityWhy";
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button2);
        radioGroup=findViewById(R.id.job_list);
        radioButton1=findViewById(R.id.radio_button1);
        radioButton2=findViewById(R.id.radio_button2);
        radioButton3=findViewById(R.id.radio_button3);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getYourFavorite(checkedId);
            }
        });
    }

    /**
     * 根据ID,执行相应的逻辑
     * @param buttonId
     */
    private void getYourFavorite(int buttonId){
        switch (buttonId){
            case R.id.radio_button1:
                if(radioButton1.isChecked()) {
                    Log.e(TAG, "你最爱的职业是: " + radioButton1.getText().toString());
                }
                break;
            case R.id.radio_button2:
                if(radioButton2.isChecked()) {
                    Log.e(TAG, "你最爱的职业是: " + radioButton2.getText().toString());
                }
                break;
            case R.id.radio_button3:
                if(radioButton3.isChecked()) {
                    Log.e(TAG, "你最爱的职业是: " + radioButton3.getText().toString());
                }
                break;
        }
    }

    /**
     * 清除选型
     * @param view
     */
    public void clearAll(View view){
      radioGroup.clearCheck();
    }
}
