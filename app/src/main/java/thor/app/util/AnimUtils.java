package thor.app.util;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

/**
 * Created by Sylwester Tor on 03.04.2015.
 */
public class AnimUtils {
    public static void showViewAnimated(View view, Integer duration, Animator.AnimatorListener listener) {
        if (duration == null)
            duration = 300;

        if (view.getVisibility() != View.VISIBLE) {
            view.setAlpha(0f);
            view.setVisibility(View.VISIBLE);
            view.animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(listener);
        }
    }

    public static void showViewAnimated(View view, Integer duration) {
        showViewAnimated(view, duration, null);
    }

    public static void showViewAnimated(View view, Animator.AnimatorListener listener) {
        showViewAnimated(view, null, listener);
    }

    public static void showViewAnimated(View view) {
        showViewAnimated(view, null, null);
    }

    public static void hideViewAnimated(final View view, Integer duration) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setAlpha(1f);
            view.setVisibility(View.VISIBLE);
            view.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            view.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
        }
    }

    public static void hideViewAnimated(final View view, int duration, Animator.AnimatorListener listener) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setAlpha(1f);
            view.setVisibility(View.VISIBLE);
            view.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(listener);
        }
    }

    public static void hideViewAnimated(final View view) {
        hideViewAnimated(view, 300);
    }

    public static void hideViewAnimated(final View view, Animator.AnimatorListener listener) {
        hideViewAnimated(view, 300, listener);
    }

    public static void hideViewAnimatedInvisible(final View view, Integer duration) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setAlpha(1f);
            view.setVisibility(View.VISIBLE);
            view.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            view.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
        }
    }

    public static void hideViewAnimatedInvisible(final View view, int duration, Animator.AnimatorListener listener) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setAlpha(1f);
            view.setVisibility(View.VISIBLE);
            view.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(listener);
        }
    }

    public static void hideViewAnimatedInvisible(final View view) {
        hideViewAnimatedInvisible(view, 300);
    }

    public static void hideViewAnimatedInvisible(final View view, Animator.AnimatorListener listener) {
        hideViewAnimatedInvisible(view, 300, listener);
    }

    /**
     * an animation for resizing the view.
     */
    public static class ResizeAnimation extends Animation {
        private View mView;
        private float mToHeight;
        private float mFromHeight;

        private float mToWidth;
        private float mFromWidth;

        public ResizeAnimation(View v, float fromWidth, float fromHeight, float toWidth, float toHeight, int duration) {
            mToHeight = toHeight;
            mToWidth = toWidth;
            mFromHeight = fromHeight;
            mFromWidth = fromWidth;
            mView = v;
            setDuration(duration);
        }

        public ResizeAnimation(View v, float fromWidth, float fromHeight, float toWidth, float toHeight) {
            mToHeight = toHeight;
            mToWidth = toWidth;
            mFromHeight = fromHeight;
            mFromWidth = fromWidth;
            mView = v;
            setDuration(300);
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            float height = (mToHeight - mFromHeight) * interpolatedTime + mFromHeight;
            float width = (mToWidth - mFromWidth) * interpolatedTime + mFromWidth;
            ViewGroup.LayoutParams p = mView.getLayoutParams();
            p.height = (int) height;
            p.width = (int) width;
            mView.requestLayout();
        }
    }

    public static void changeImageFade(final ImageView imageView, final Integer duration, final Bitmap loadedImage) {
        imageView.setAlpha(1f);
        imageView.setVisibility(View.VISIBLE);
        imageView.animate()
                .alpha(0f)
                .setDuration(duration)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        imageView.setImageBitmap(loadedImage);
                        imageView.animate()
                                .alpha(1f)
                                .setDuration(duration);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) { }
                    @Override
                    public void onAnimationRepeat(Animator animator) { }
                    @Override
                    public void onAnimationStart(Animator animator) { }

                });
    }

    public static void changeImageResize(final ImageView imageView, final Bitmap newImage) {
        ResizeAnimation animation = new ResizeAnimation(imageView, imageView.getWidth(), imageView.getHeight(), newImage.getWidth(), newImage.getHeight(), 250);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setImageBitmap(newImage);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(animation);
    }

    public static void expandView(final View v) {
        v.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapseView(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                    v.getLayoutParams().height = initialHeight;
                    v.requestLayout();
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }
}

