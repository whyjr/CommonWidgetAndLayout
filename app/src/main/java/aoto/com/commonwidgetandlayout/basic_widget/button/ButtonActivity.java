package aoto.com.commonwidgetandlayout.basic_widget.button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Toast;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-7 17:11:09
 */
public class ButtonActivity extends AppCompatActivity {

    private Button btn1;
    private RotateAnimation rotateAnimation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        //findViewById(R.id.btn1).setOnClickListener(this);
        //findViewById(R.id.btn2).setOnClickListener(this);

        btn1=findViewById(R.id.btn1);
        rotateAnimation1=new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation1.setDuration(2000);
        btn1.setAnimation(rotateAnimation1);

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ButtonActivity.this,"你点击了btn1",Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    /**
     * 通过Button的 android:onClick属性定义点击事件
     * @param view
     */
    public void btn1Click(View view){
        Toast.makeText(this,"你点击了btn1",Toast.LENGTH_SHORT).show();
        btn1.startAnimation(rotateAnimation1);
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn1:
//                btn1.setAnimation(rotateAnimation1);
//                Toast.makeText(this,"你点击了btn1",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.btn2:
//                Toast.makeText(this,"你点击了btn2",Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }
}
