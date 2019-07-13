package aoto.com.commonwidgetandlayout.basic_widget.checkedTextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-14 15:05:23
 */
public class CTextViewTestActivity extends AppCompatActivity {

    private static final String TAG = "CTextViewActivityWhy";
    CheckedTextView textView;
    ListView listView;
    TextView chooseResult;
    MyAdaptorTest adaptor;
    List<String> record = new ArrayList();
    ArrayList<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checked_text_view_test);
        chooseResult = findViewById(R.id.choose_result);
        listView = findViewById(R.id.name_list_view);
        nameList.add("苹果");
        nameList.add("香蕉");
        nameList.add("菠萝");
        nameList.add("西瓜");
        nameList.add("火龙果");
        adaptor = new MyAdaptorTest(this, 0, nameList);
        listView.setAdapter(adaptor);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chooseResult.setText(nameList.get(position));//单选显示
                //多选显示
//                if (record.contains(nameList.get(position))) {
//                    record.remove(nameList.get(position));
//                } else {
//                    record.add(nameList.get(position));
//                }
//
//                if (record.size() == 0) {
//                    chooseResult.setText("");
//                } else {
//                    chooseResult.setText(record.toString());
//                }
            }
        });
    }
}
