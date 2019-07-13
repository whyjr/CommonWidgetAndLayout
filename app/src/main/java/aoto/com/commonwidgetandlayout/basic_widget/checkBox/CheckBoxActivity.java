package aoto.com.commonwidgetandlayout.basic_widget.checkBox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-8 16:59:39
 */
public class CheckBoxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "CheckBoxActivityWhy";
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        checkBox1=findViewById(R.id.check_box1);
        checkBox2=findViewById(R.id.check_box2);
        checkBox3=findViewById(R.id.check_box3);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            Log.e(TAG, "已经添加爱好:" + buttonView.getText().toString());
        }
        else {
            Log.e(TAG, "已经移除爱好: " + buttonView.getText().toString());
        }
    }
}
