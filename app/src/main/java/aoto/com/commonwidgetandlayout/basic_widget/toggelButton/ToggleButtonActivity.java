package aoto.com.commonwidgetandlayout.basic_widget.toggelButton;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-7 20:22:25
 */
public class ToggleButtonActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    TransitionDrawable drawable;
    ImageView lightImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggel_button);
        toggleButton = findViewById(R.id.toggle_button);

        lightImage = findViewById(R.id.light_view);
        drawable = (TransitionDrawable) lightImage.getDrawable();
        //设置状态变化监听
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    drawable.reverseTransition(1500);
                } else {
                    drawable.reverseTransition(500);
                }
            }
        });
    }
}
