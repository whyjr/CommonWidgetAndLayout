package aoto.com.commonwidgetandlayout.basic_widget.seekBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-24 18:21:07
 */
public class SeekBarActivity extends AppCompatActivity {

    TextView progressResult;
    SeekBar progressSetting;
    SeekBar discreteBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        progressSetting=findViewById(R.id.progress_setting);
        discreteBar=findViewById(R.id.seek_bar_discrete);
        progressResult=findViewById(R.id.progress);

        progressSetting.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               if(progress==0){
                   progressResult.setText("");
               }
               else {
                   progressResult.setText("已调至"+progress+"℃");
               }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        discreteBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
