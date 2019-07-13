package aoto.com.commonwidgetandlayout.basic_widget.switchP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-30 19:21:29
 */
public class SwitchActivity extends AppCompatActivity {

    Switch aSwitch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        aSwitch1=findViewById(R.id.switch1);

        //aSwitch1.setSwitchTextAppearance(this, android.R.style.TextAppearance_DeviceDefault_Large);


        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //aSwitch1.setThumbDrawable(getResources().getDrawable(R.drawable.left_angel));
                }
                else {
                    //aSwitch1.setThumbDrawable(getResources().getDrawable(R.drawable.right_angel));
                }
            }
        });
    }
}
