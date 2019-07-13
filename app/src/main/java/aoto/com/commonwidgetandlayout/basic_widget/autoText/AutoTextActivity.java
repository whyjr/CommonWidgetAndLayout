package aoto.com.commonwidgetandlayout.basic_widget.autoText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

import aoto.com.commonwidgetandlayout.R;
import aoto.com.commonwidgetandlayout.basic_widget.checkedTextView.MyAdaptor;

/**
 * @author why
 * @date 2019-6-5 10:07:09
 */
public class AutoTextActivity extends AppCompatActivity {

    private static final String TAG = "AutoTextActivityWhy";
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    private String content="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_text);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView=findViewById(R.id.multiAutoCompleteTextView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                getResources().getStringArray(R.array.country_array));

//        ArrayList<String> nameList=new ArrayList();
//        nameList.add("苹果");
//        nameList.add("香蕉");
//        nameList.add("菠萝");
//        nameList.add("西瓜");
//        nameList.add("火龙果");
//
//        MyAdaptor adaptor1=new MyAdaptor(this,R.layout.list_item,nameList);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setDropDownHorizontalOffset(50);
        autoCompleteTextView.setDropDownVerticalOffset(50);
  //      autoCompleteTextView.setDropDownBackgroundResource(R.drawable.ic_launcher_background);

//        autoCompleteTextView.setDropDownHeight(300);
//        autoCompleteTextView.setDropDownWidth(200);
        //autoCompleteTextView.setThreshold(1);//设置最少检索字符个数，默认是2
        //textView.setCompletionHint("kkk");//最优推荐选项
        //textView.setDropDownWidth(250);//设置下拉框宽度
        //textView.setDropDownHeight(400);//设置下拉框高度
        //textView.setDropDownBackgroundResource(R.color.dsb_ripple_color_pressed);//设置下拉框背景
        //textView.setDropDownVerticalOffset(0);//设置下拉框垂直方向边距，类比TextView中的verticalOffset属性
        //textView.setDropDownHorizontalOffset(0);//设置下拉框水平方向边距，类比TextView中的horizontalOffset属性
        //textView.setDropDownAnchor();

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.
                R.layout.simple_dropdown_item_1line,
                getResources().getStringArray(R.array.time_array));
        multiAutoCompleteTextView.setAdapter(adapter1);
        //multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextView.setTokenizer(new SelfTokenizer());

      multiAutoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
          @Override
          public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
              content=multiAutoCompleteTextView.getText().toString();
              multiAutoCompleteTextView.setText(content.substring(0,content.lastIndexOf("-")));
              multiAutoCompleteTextView.setSelection(content.length()-1);
              return false;
          }
      });
    }
}
