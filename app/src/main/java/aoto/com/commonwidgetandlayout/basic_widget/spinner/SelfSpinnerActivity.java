package aoto.com.commonwidgetandlayout.basic_widget.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import java.util.ArrayList;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-18 14:50:52
 */
public class SelfSpinnerActivity extends AppCompatActivity {
    private static final String TAG = "SelfSpinnerActivityWhy";
    private ArrayList<String> list = null;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_spinner);
        spinner = findViewById(R.id.spinner_year);
        initListData();
        spinner.setAdapter(new MySpinnerAdaptor(this, list));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.e(TAG, "onItemSelected: before" + position);
                view.findViewById(R.id.item_icon_1).setVisibility(View.INVISIBLE);
                view.findViewById(R.id.item_info_1).setVisibility(View.INVISIBLE);
                Log.e(TAG, "onItemSelected: after" + position);

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.findViewById(R.id.result_info).setVisibility(View.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.e(TAG, "onNothingSelected: ");
            }
        });

    }

    private void initListData() {
        list = new ArrayList<>();
        list.add("1990");
        list.add("1991");
        list.add("1992");
        list.add("1993");
        list.add("1994");
        list.add("1995");
    }
}
