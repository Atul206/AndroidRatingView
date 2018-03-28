package customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import activity.MainActivity;

/**
 * Created by atulsakhala on 17/09/17.
 */

public interface RatingView {

    void setRating(float v);

    void setRatingBackground(String color);

    void setRatingBackdround(int one_star, Boolean isRatingSetColor);

    void setClickMode(boolean isClickable);

    void performFirstClick();

    void performSecondClick();

    void performThirdClick();

    void performFourthClick();

    void performFiveClick();

    void setUpViews();

    void OnRatingChange(float rating);

    void setOnRatingChangeListener(OnRatingChangeListener listener);

    void setRatingTextColor(int color);

    void setHalfRatingFirst();

    void setHalfRatingSecond();

    void setHalfRatingThird();

    void setHalfRatingFourth();

    void setHalfRatingFifth();

    float getRating();

    void setVisiblity(int visible);

    void resetAll();
}
