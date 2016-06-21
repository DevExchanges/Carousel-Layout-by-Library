package info.devexchanges.carousellayout;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qslll.library.QsPagerTransformer;
import com.qslll.library.Util;
import com.qslll.library.fragments.QsContainFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements QsContainFragment.OnExpandingClickListener {

    private ViewPager viewPager;
    private List<QsContainFragment> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWindowAnimations();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setPageTransformer(true, new QsPagerTransformer());
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));
        lists.add(QsContainFragment.getInstance(new Fragment1(), new Fragment2()));

        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                QsContainFragment fragment = (QsContainFragment) lists.get(viewPager.getCurrentItem());
                fragment.close();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new QsFragmentAdapter(getSupportFragmentManager(), lists));
        Util.setupPager(viewPager);
    }

    public void setupViewPager(ViewPager v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        ((ViewGroup) v.getParent()).setClipChildren(false);
        v.setClipChildren(false);
        layoutParams.width = getWindowManager().getDefaultDisplay().getWidth() / 7 * 5;
        layoutParams.height = (int) ((layoutParams.width / 0.75));

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        Explode slideTransition = new Explode();
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }

    @Override
    public void onBackPressed() {
        if (!lists.get(viewPager.getCurrentItem()).isClosed()) {
            lists.get(viewPager.getCurrentItem()).close();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "clicked!", Toast.LENGTH_SHORT).show();
    }
}
