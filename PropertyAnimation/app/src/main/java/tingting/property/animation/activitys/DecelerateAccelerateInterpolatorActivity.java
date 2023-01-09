package tingting.property.animation.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.widget.TextView;

import tingting.property.animation.R;

/**
 * 自定义插值器
 *
 * 参考：https://www.jianshu.com/p/2f19fe1e3ca1
 */
public class DecelerateAccelerateInterpolatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decelerate_accelerate_interpolator);

        // 1. 创建动画作用对象：此处以Button为例
        TextView text = findViewById(R.id.text);

        // 2. 获得当前按钮的位置
        float curTranslationX = text.getTranslationX();

        // 3. 创建动画对象 & 设置动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(text, "translationX", curTranslationX, 300,curTranslationX);
        // 表示的是:
        // 动画作用对象是text
        // 动画作用的对象的属性是X轴平移
        // 动画效果是:从当前位置平移到 x=1500 再平移到初始位置

        animator.setDuration(3000);

        // 4. 设置步骤1中设置好的插值器：先减速后加速
        animator.setInterpolator(new DecelerateAccelerateInterpolator());

        // 5. 启动动画
        animator.start();

    }

    /**
     * 自定义Interpolator：先减速后加速
     */
    public class DecelerateAccelerateInterpolator implements TimeInterpolator {
        @Override
        public float getInterpolation(float input) {
            float result;
            if (input <= 0.5) {
                result = (float) (Math.sin(Math.PI * input)) / 2;
                // 使用正弦函数来实现先减速后加速的功能，逻辑如下：
                // 因为正弦函数初始弧度变化值非常大，刚好和余弦函数是相反的
                // 随着弧度的增加，正弦函数的变化值也会逐渐变小，这样也就实现了减速的效果。
                // 当弧度大于π/2之后，整个过程相反了过来，现在正弦函数的弧度变化值非常小，渐渐随着弧度继续增加，变化值越来越大，弧度到π时结束，这样从0过度到π，也就实现了先减速后加速的效果
            } else {
                result = (float) (2 - Math.sin(Math.PI * input)) / 2;
            }
            return result;
            // 返回的result值 = 随着动画进度呈先减速后加速的变化趋势
        }
    }

}