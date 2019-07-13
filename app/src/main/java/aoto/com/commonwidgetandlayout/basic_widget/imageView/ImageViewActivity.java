package aoto.com.commonwidgetandlayout.basic_widget.imageView;

import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-6-7 17:32:13
 */
public class ImageViewActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "ImageViewActivityWhy";
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView=findViewById(R.id.image_view_test);
        findViewById(R.id.adjust_view_bounds).setOnClickListener(this);
        findViewById(R.id.src).setOnClickListener(this);
        findViewById(R.id.maxWidth_maxHeight).setOnClickListener(this);
        findViewById(R.id.tint).setOnClickListener(this);
        findViewById(R.id.scaleType).setOnClickListener(this);
        findViewById(R.id.cropToPadding).setOnClickListener(this);


    }

    private boolean tag=true;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.adjust_view_bounds:
                Log.e(TAG, "onClick: " );
                if (tag) {
                    imageView.setAdjustViewBounds(true);
//                    imageView.setMaxHeight(200);
//                    imageView.setMaxWidth(200);
                    tag=false;
                }
                else {
                    imageView.setAdjustViewBounds(false);
                    tag=true;
                }
                break;
            case R.id.src:
                if(tag){
                    imageView.setImageDrawable(getDrawable(R.drawable.image_view_test1));
                    tag=false;
                }
                else {
                    imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.image_view_test));
                    tag=true;
                }
                break;
            case R.id.maxWidth_maxHeight:
                if (tag) {
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(200);
                    imageView.setMaxWidth(200);
                    tag=false;
                }
                else {
                    imageView.setAdjustViewBounds(false);
                    tag=true;
                }
                break;
            case R.id.tint:
                if(tag){
                    tag=false;
                    imageView.setImageTintMode(PorterDuff.Mode.DST);
                }
                else {
                    tag=true;
                   // imageView.setImageTintMode(PorterDuff.Mode.OVERLAY);
                }
                break;
            case R.id.scaleType:
                if(tag){
                    tag=false;
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                }
                else {
                    tag=true;
                    imageView.setScaleType(ImageView.ScaleType.FIT_START);
                }
                break;
            case R.id.cropToPadding:
                if(tag){
                    tag=false;
                    imageView.setCropToPadding(true);
                }
                else {
                    tag=true;
                    imageView.setCropToPadding(false);
                }
                break;
        }
    }
}
