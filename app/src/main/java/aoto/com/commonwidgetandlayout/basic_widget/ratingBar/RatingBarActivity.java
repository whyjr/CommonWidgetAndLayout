package aoto.com.commonwidgetandlayout.basic_widget.ratingBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;

import aoto.com.commonwidgetandlayout.R;

/**
 * @author why
 * @date 2019-5-27 21:19:29
 */
public class RatingBarActivity extends AppCompatActivity {

    private static final String TAG = "RatingBarActivityWhy";
    private RatingBar ratingBar;
    private RatingBar ratingBar1;
    private RatingBar ratingBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        ratingBar=findViewById(R.id.rating_bar);
        ratingBar1=findViewById(R.id.rating_bar1);
        ratingBar2=findViewById(R.id.rating_bar2);
        ratingBar.setStepSize(0.25f);

        Log.e(TAG, "onCreate: "+ratingBar.getNumStars()+"  "+ratingBar.getStepSize()+"  "+ratingBar.getMax() );

    }


    /**
     * 更新Rating
     * @param view
     */
    public void updateRating(View view){
        float curRating=ratingBar.getRating();
        if(++curRating<=ratingBar.getMax()){
            ratingBar.setRating(curRating);
        }
        else {
            ratingBar.setRating(0.0f);
        }
    }

    /**
     * 更新Rating
     * @param view
     */
    public void updateRating1(View view){
        float curRating=ratingBar1.getRating();
        if(++curRating<=ratingBar1.getMax()){
            ratingBar1.setRating(curRating);
        }
        else {
            ratingBar1.setRating(0.0f);
        }
    }

    /**
     * 更新Rating
     * @param view
     */
    public void updateRating2(View view){
        float curRating=ratingBar2.getRating();
        if(++curRating<=ratingBar2.getMax()){
            ratingBar2.setRating(curRating);
        }
        else {
            ratingBar2.setRating(0.0f);
        }
    }
}
