package aoto.com.commonwidgetandlayout.basic_widget.checkedTextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-14 10:07:30
 */
public class CTextViewActivity extends AppCompatActivity {

    private static final String TAG = "CTextViewActivityWhy";
    CheckedTextView textView;
    ListView listView;
    TextView chooseResult;
    MyAdaptor adaptor;
    //  MyAdaptorTest adaptor;
    ArrayList<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctext_view);
        chooseResult = findViewById(R.id.choose_result);
        listView = findViewById(R.id.name_list_view);
        nameList.add("苹果");
        nameList.add("香蕉");
        nameList.add("菠萝");
        nameList.add("西瓜");
        nameList.add("火龙果");
        adaptor = new MyAdaptor(this, R.layout.list_item, nameList);
        listView.setAdapter(adaptor);

    }

    public void confirm(View view) {
        if (adaptor.getList().size() != 0) {
            chooseResult.setText(adaptor.getList().toString());
        } else {
            chooseResult.setText("");
        }
    }
}
