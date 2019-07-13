package aoto.com.commonwidgetandlayout.basic_widget.radioButton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-13 20:44:28
 */
public class RadioButtonActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "RadioButtonActivityWhy";
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radioButton1=findViewById(R.id.radio_button1);
        radioButton2=findViewById(R.id.radio_button2);
        radioButton3=findViewById(R.id.radio_button3);

        radioButton1.setOnCheckedChangeListener(this);
        radioButton2.setOnCheckedChangeListener(this);
        radioButton3.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            disableOthers(buttonView.getId());
            Log.e(TAG, "您最喜欢的职业是: "+buttonView.getText().toString() );
            buttonView.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
        else {
            buttonView.setTextColor(Color.BLACK);
        }
    }

    private void disableOthers(int viewId) {
        if(R.id.radio_button1!=viewId&&radioButton1.isChecked()){
            radioButton1.setChecked(false);
        }
        if(R.id.radio_button2!=viewId&&radioButton2.isChecked()){
            radioButton2.setChecked(false);
        }
        if(R.id.radio_button3!=viewId&&radioButton3.isChecked()){
            radioButton3.setChecked(false);
        }
    }
}
