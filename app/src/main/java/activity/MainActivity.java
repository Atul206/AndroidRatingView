package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.roadster.sakhala.ratingview.R;

import customview.OnRatingChangeListener;
import customview.Rating;
import customview.RatingView;

public class MainActivity extends AppCompatActivity implements OnRatingChangeListener {

    RatingView ratingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingView = (RatingView) findViewById(R.id.rating_view);
        ratingView.setClickMode(false);
        ratingView.setOnRatingChangeListener(this);
        ratingView.setRating(2.1f);
        Log.d("Rating",""+ratingView.getRating());
        ratingView.setVisiblity(View.VISIBLE);
    }


    @Override
    public void onRatingChange(float rate) {
        Log.d("Rating", "" + rate);
    }
}
