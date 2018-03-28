package customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.roadster.sakhala.ratingview.R;

/**
 * Created by atulsakhala on 17/09/17.
 */

public class Rating extends RelativeLayout implements RatingView, View.OnClickListener {

    protected RatingPresenter presenter;
    protected View view;
    protected boolean isTouchMode;
    protected float ratingNumber;
    private Context context;
    private OnRatingChangeListener listener;

    public Rating(Context context) {
        super(context);
        init(context);
    }

    public Rating(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setAttributes(context, attrs);
    }

    public Rating(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        setAttributes(context, attrs);
    }

    private void init(Context context) {
        this.context = context;
        view = inflate(getContext(), R.layout.rating, this);
        presenter = new RatingPresenter(this);
    }

    private void setAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RatingView,
                0, 0);
        try {
            isTouchMode = a.getBoolean(R.styleable.RatingView_isTouchMode, false);
            ratingNumber = a.getFloat(R.styleable.RatingView_rating_text, 0.0f);
            presenter.setRating(ratingNumber);
        } finally {
            a.recycle();
        }
    }

    @Override
    public void setUpViews() {
        view.findViewById(R.id.one_star).setOnClickListener(this);
        view.findViewById(R.id.two_star).setOnClickListener(this);
        view.findViewById(R.id.three_star).setOnClickListener(this);
        view.findViewById(R.id.four_star).setOnClickListener(this);
        view.findViewById(R.id.five_star).setOnClickListener(this);
    }

    @Override
    public void setRatingTextColor(int color) {
        ((TextView) view.findViewById(R.id.rating_number)).setTextColor(getResources().getColor(color));
    }

    @Override
    public void setClickMode(boolean isClickable) {
        this.isTouchMode = isClickable;
    }

    @Override
    public void setRatingBackdround(int rsId, Boolean isRatingSetColor) {
        if (isRatingSetColor == null)
            ((ImageView) (view).findViewById(rsId)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_hollow));
        else if (isRatingSetColor == false)
            ((ImageView) (view).findViewById(rsId)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_red_filled));
        else
            ((ImageView) (view).findViewById(rsId)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_green_filled));
    }

    @Override
    public void performFirstClick() {
        view.findViewById(R.id.one_star).performClick();
    }

    @Override
    public void performSecondClick() {
        view.findViewById(R.id.two_star).performClick();
    }

    @Override
    public void performThirdClick() {
        view.findViewById(R.id.three_star).performClick();
    }

    @Override
    public void performFourthClick() {
        view.findViewById(R.id.four_star).performClick();
    }

    @Override
    public void performFiveClick() {
        view.findViewById(R.id.five_star).performClick();
    }

    @Override
    public void setHalfRatingFirst() {
        ((ImageView) (view).findViewById(R.id.one_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_red_half_filled));
        setRatingTextColor(R.color.v2_red);

    }

    @Override
    public void setHalfRatingSecond() {
        ((ImageView) (view).findViewById(R.id.one_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_red_filled));
        ((ImageView) (view).findViewById(R.id.two_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_red_half_filled));
        setRatingTextColor(R.color.v2_red);

    }

    @Override
    public void setHalfRatingThird() {
        ((ImageView) (view).findViewById(R.id.one_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_red_filled));
        ((ImageView) (view).findViewById(R.id.two_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_red_filled));
        ((ImageView) (view).findViewById(R.id.three_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_red_half_filled));
        setRatingTextColor(R.color.v2_red);

    }

    @Override
    public void setHalfRatingFourth() {
        ((ImageView) (view).findViewById(R.id.one_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_green_filled));
        ((ImageView) (view).findViewById(R.id.two_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_green_filled));
        ((ImageView) (view).findViewById(R.id.three_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_green_filled));
        ((ImageView) (view).findViewById(R.id.four_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_half_green_filled));
        setRatingTextColor(R.color.v2_green);

    }

    @Override
    public void setHalfRatingFifth() {
        ((ImageView) (view).findViewById(R.id.one_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_green_filled));
        ((ImageView) (view).findViewById(R.id.two_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_green_filled));
        ((ImageView) (view).findViewById(R.id.three_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_green_filled));
        ((ImageView) (view).findViewById(R.id.four_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_green_filled));
        ((ImageView) (view).findViewById(R.id.five_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_half_green_filled));
        setRatingTextColor(R.color.v2_green);

    }

    @Override
    public void onClick(View view) {
        if(!isTouchMode){
            return;
        }
        int i = view.getId();
        if (i == R.id.one_star) {
            presenter.updateRating(1.0f,
                    R.id.one_star,
                    R.id.two_star,
                    R.id.three_star,
                    R.id.four_star,
                    R.id.five_star,
                    R.color.v2_red);

        } else if (i == R.id.two_star) {
            presenter.updateRating(2.0f,
                    R.id.one_star,
                    R.id.two_star,
                    R.id.three_star,
                    R.id.four_star,
                    R.id.five_star,
                    R.color.v2_red);

        } else if (i == R.id.three_star) {
            presenter.updateRating(3.0f,
                    R.id.one_star,
                    R.id.two_star,
                    R.id.three_star,
                    R.id.four_star,
                    R.id.five_star,
                    R.color.v2_green);

        } else if (i == R.id.four_star) {
            presenter.updateRating(4.0f,
                    R.id.one_star,
                    R.id.two_star,
                    R.id.three_star,
                    R.id.four_star,
                    R.id.five_star,
                    R.color.v2_green);

        } else if (i == R.id.five_star) {
            presenter.updateRating(5.0f,
                    R.id.one_star,
                    R.id.two_star,
                    R.id.three_star,
                    R.id.four_star,
                    R.id.five_star,
                    R.color.v2_green);

        }
    }

    @Override
    public void OnRatingChange(float rating) {
        listener.onRatingChange(rating);
    }

    @Override
    public void setOnRatingChangeListener(OnRatingChangeListener listener) {
        this.listener = listener;
    }

    @Override
    public float getRating() {
        return presenter.getRating();
    }

    @Override
    public void setRating(float rating) {
        ((TextView) view.findViewById(R.id.rating_number)).setText(String.valueOf(rating));
        if (!isTouchMode) {
            presenter.setRatingWithStars(rating);
        }
    }

    @Override
    public void setRatingBackground(String color) {
        findViewById(R.id.rating_layout).setBackgroundColor(Color.parseColor(color));
    }

    @Override
    public void setVisiblity(int visible) {
        findViewById(R.id.rating_layout).setVisibility(visible);
    }

    @Override
    public void resetAll() {
        ((ImageView) (view).findViewById(R.id.one_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_hollow));
        ((ImageView) (view).findViewById(R.id.two_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_hollow));
        ((ImageView) (view).findViewById(R.id.three_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_hollow));
        ((ImageView) (view).findViewById(R.id.four_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_hollow));
        ((ImageView) (view).findViewById(R.id.five_star)).setImageDrawable(context.getResources().getDrawable(R.drawable.ic_star_hollow));
    }
}
