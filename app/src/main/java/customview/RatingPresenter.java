package customview;

/**
 * Created by atulsakhala on 17/09/17.
 */

public class RatingPresenter {

    private  RatingView view;
    private float rating;
    private float lastSelectedPosition = 0.0f;

    public RatingPresenter(RatingView ratingView){
        this.view = ratingView;
        view.setUpViews();
    }


    public void setRating(float rating) {
        this.rating = rating;
        //view.setRating(rating);
    }


    public void updateRating(float rating, int one_star, int two_star, int three_star, int four_star, int five_star, int color) {
        //view.OnRatingChange(rating);
        /*if(getLastSelectedPosition() == rating){
            return;
        }*/

        view.setRatingTextColor(color);

        if(rating == 0.0f){
            view.setRatingBackdround(one_star,null);
            view.setRatingBackdround(two_star,null);
            view.setRatingBackdround(three_star,null);
            view.setRatingBackdround(four_star,null);
            view.setRatingBackdround(five_star,null);
        }else if(rating == 1.0f){
            view.setRatingBackdround(one_star,false);
            view.setRatingBackdround(two_star,null);
            view.setRatingBackdround(three_star,null);
            view.setRatingBackdround(four_star,null);
            view.setRatingBackdround(five_star,null);
        }else if(rating == 2.0f){
            view.setRatingBackdround(one_star,false);
            view.setRatingBackdround(two_star,false);
            view.setRatingBackdround(three_star,null);
            view.setRatingBackdround(four_star,null);
            view.setRatingBackdround(five_star,null);
        }else if(rating == 3.0f){
            view.setRatingBackdround(one_star,true);
            view.setRatingBackdround(two_star,true);
            view.setRatingBackdround(three_star,true);
            view.setRatingBackdround(four_star,null);
            view.setRatingBackdround(five_star,null);
        }else if(rating == 4.0f){
            view.setRatingBackdround(one_star,true);
            view.setRatingBackdround(two_star,true);
            view.setRatingBackdround(three_star,true);
            view.setRatingBackdround(four_star,true);
            view.setRatingBackdround(five_star,null);
        }else if(rating == 5.0f){
            view.setRatingBackdround(one_star,true);
            view.setRatingBackdround(two_star,true);
            view.setRatingBackdround(three_star,true);
            view.setRatingBackdround(four_star,true);
            view.setRatingBackdround(five_star,true);
        }

        setLastSelectedPosition(rating);
        //view.setRating(rating);
    }

    public float getLastSelectedPosition() {
        return lastSelectedPosition;
    }

    public void setLastSelectedPosition(float lastSelectedPosition) {
        this.lastSelectedPosition = lastSelectedPosition;
    }

    public void setRatingWithStars(float rating) {
        this.rating = rating;
        view.resetAll();
        if(getInBetween(rating, 0.0f) > 0 && getInBetween(rating, 1.0f) < 0){
            view.OnRatingChange(rating);
            view.setHalfRatingFirst();
        }else if(rating == 1.0f){
            view.performFirstClick();
        }else if(getInBetween(rating, 1.0f) > 0 && getInBetween(rating, 2.0f) < 0) {
            view.OnRatingChange(rating);
            view.setHalfRatingSecond();
        }else if(rating == 2.0f){
            view.performSecondClick();
        }else if(getInBetween(rating, 2.0f) > 0 && getInBetween(rating, 3.0f) < 0){
            view.OnRatingChange(rating);
            view.setHalfRatingThird();
        }else if(rating == 3.0f){
            view.performThirdClick();
        }else if(getInBetween(rating, 3.0f) > 0 && getInBetween(rating, 4.0f) < 0){
            view.OnRatingChange(rating);
            view.setHalfRatingFourth();
        }else if(rating == 4.0f){
            view.performFourthClick();
        }else if(getInBetween(rating, 4.0f) > 0 && getInBetween(rating, 5.0f) < 0){
            view.OnRatingChange(rating);
            view.setHalfRatingFifth();
        }else if(rating == 5.0f){
            view.performFiveClick();
        }
    }

    private int getInBetween(float f1, float f2){
        return Float.compare(f1,f2);
    }

    public float getRating() {
        return this.rating;
    }
}
