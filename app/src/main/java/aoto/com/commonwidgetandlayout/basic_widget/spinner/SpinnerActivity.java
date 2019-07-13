package aoto.com.commonwidgetandlayout.basic_widget.spinner;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-14 19:48:02
 */
public class SpinnerActivity extends AppCompatActivity {

    private static final String TAG = "SpinnerActivityWhy";
    private ArrayList<String> list = null;
    Spinner yearSpinner;
    ArrayAdapter<String> adapter;
    int maxYear=1995;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: " + this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initListData();

        yearSpinner = findViewById(R.id.spinner_year);
        //获取适配器
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        //设置样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        yearSpinner.setAdapter(adapter);
    }


    private void initListData() {
        list = new ArrayList<>();
        list.add("年");
        list.add("1990");
        list.add("1991");
        list.add("1992");
        list.add("1993");
        list.add("1994");
        list.add("1995");
    }


    public void addData(View view){
       list.add(String.valueOf(++maxYear));
    }

    public void deleteData(View view){
      list.remove(String.valueOf(maxYear--));
    }
}
