package aoto.com.commonwidgetandlayout.basic_widget.editText;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-6-3 19:14:44
 */
public class EditTextActivity extends AppCompatActivity {

    EditText userNameView;
    EditText userPsdView;
    TextView userNameTip;
    TextView userPsdTip;

    boolean userNameTrigger = false;
    boolean userPsdTrigger = false;

    boolean userNameLegal=false;
    boolean userPsdLegal=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        userNameView = findViewById(R.id.editText);
        userPsdView = findViewById(R.id.editText1);
        userNameTip = findViewById(R.id.userName_edit_tip);
        userPsdTip = findViewById(R.id.userPsd_edit_tip);


        userNameView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && userNameTrigger) {
                    userNameLegal=checkString(userNameView.getText().toString());
                    if (userNameLegal) {
                        userNameTip.setText("用户名合法");
                        userNameTip.setTextColor(Color.GREEN);
                        userNameTip.setVisibility(View.VISIBLE);
                    } else {
                        userNameTip.setTextColor(Color.RED);
                        userNameTip.setText("密码只能由文本字符，数字组成");
                        userNameTip.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        userNameView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                userNameTrigger = true;
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    userPsdView.requestFocus();
                }
                return false;
            }
        });


        userPsdView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && userPsdTrigger == true) {
                    userPsdLegal=checkString(userPsdView.getText().toString());
                    if (userPsdLegal) {
                        userPsdTip.setText("密码合法");
                        userPsdTip.setTextColor(Color.GREEN);
                        userPsdTip.setVisibility(View.VISIBLE);
                        if(userNameLegal&&userPsdLegal){
                            Toast.makeText(EditTextActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        userPsdTip.setTextColor(Color.RED);
                        userPsdTip.setText("密码只能由文本字符，数字组成");
                        userPsdTip.setVisibility(View.VISIBLE);
                    }
                } else {
                    userPsdTrigger = true;
                }
                return false;
            }
        });

//        text.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                text1.setText("keyCode:"+keyCode+"v=text:"+(v==text));
//                return false;
//            }
//        });

//        text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//              text.setText("是否有焦点："+hasFocus);
//            }
//        });
    }

    private boolean checkString(String string) {
        for (char c : string.toCharArray()) {
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        return true;
    }
}
