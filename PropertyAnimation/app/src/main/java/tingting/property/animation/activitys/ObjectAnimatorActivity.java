package tingting.property.animation.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import tingting.property.animation.R;

/**
 * 属性动画中，最常用的四种动画及其组合
 */
public class ObjectAnimatorActivity extends AppCompatActivity {

    private TextView center_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);

        center_text = findViewById(R.id.center_text);

        findViewById(R.id.button1).setOnClickListener(v -> {
            float curTranslationX = center_text.getTranslationX();
            ObjectAnimator animator = ObjectAnimator.ofFloat(center_text, "translationX", curTranslationX, -1000f, curTranslationX);
            animator.setDuration(3000);
            animator.start();
        });

        findViewById(R.id.button2).setOnClickListener(v -> {
            ObjectAnimator animator = ObjectAnimator.ofFloat(center_text, "rotation", 0f, 360f);
            animator.setDuration(3000);

            /**
             * 监听动画，可以只监听其中一个动作
             */
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                }
            });

            animator.start();
        });

        findViewById(R.id.button3).setOnClickListener(v -> {
            ObjectAnimator animator = ObjectAnimator.ofFloat(center_text, "alpha", 1f, 0f, 1f);
            animator.setDuration(3000);

            /**
             * 监听动画的所有动作
             */
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            animator.start();
        });

        findViewById(R.id.button4).setOnClickListener(v -> {
            ObjectAnimator animator = ObjectAnimator.ofFloat(center_text, "scaleY", 1f, 3f, 1f);
            animator.setDuration(3000);
            animator.start();
        });

        /**
         * 实现组合动画功能主要需要借助AnimatorSet这个类，这个类提供了一个play()方法，
         * 如果我们向这个方法中传入一个Animator对象(ValueAnimator或ObjectAnimator)
         * 将会返回一个AnimatorSet.Builder的实例，AnimatorSet.Builder中包括以下四个方法：
         *
         * after(Animator anim)    将现有动画插入到传入的动画之后执行
         * after(long delay)       将现有动画延迟指定毫秒后执行
         * before(Animator anim)   将现有动画插入到传入的动画之前执行
         * with(Animator anim)     将现有动画和传入的动画同时执行
         */
        findViewById(R.id.button5).setOnClickListener(v -> {
            ObjectAnimator moveIn = ObjectAnimator.ofFloat(center_text, "translationX", -1000f, 0f);
            ObjectAnimator rotate = ObjectAnimator.ofFloat(center_text, "rotation", 0f, 360f);
            ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(center_text, "alpha", 1f, 0f, 1f);
            AnimatorSet animSet = new AnimatorSet();
            animSet.play(rotate).with(fadeInOut).after(moveIn);
            animSet.setDuration(5000);
            animSet.start();
        });

        findViewById(R.id.button6).setOnClickListener(v -> {
            Animator animator = AnimatorInflater.loadAnimator(ObjectAnimatorActivity.this, R.animator.rotate_anim);
            animator.setTarget(center_text);
            animator.start();
        });

        findViewById(R.id.button7).setOnClickListener(v -> {
            Animator animator = AnimatorInflater.loadAnimator(ObjectAnimatorActivity.this, R.animator.alpha_anim);
            animator.setTarget(center_text);
            animator.start();
        });

        findViewById(R.id.button8).setOnClickListener(v -> {
            Animator animator = AnimatorInflater.loadAnimator(ObjectAnimatorActivity.this, R.animator.muitle_anim);
            animator.setTarget(center_text);
            animator.start();
        });


    }
}