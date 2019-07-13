package aoto.com.commonwidgetandlayout.basic_widget.space;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Space;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-6-1 9:05:33
 */
public class SpaceActivity extends AppCompatActivity {

    Space testSpace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);
        testSpace=findViewById(R.id.space_test_top);
        testSpace.setVisibility(View.VISIBLE);
    }
}
