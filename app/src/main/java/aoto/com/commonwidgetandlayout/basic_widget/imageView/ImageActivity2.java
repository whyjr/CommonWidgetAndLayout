package aoto.com.commonwidgetandlayout.basic_widget.imageView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-7-3 14:52:14
 */
public class ImageActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image2);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
    }
}
