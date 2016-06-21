package info.devexchanges.carousellayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qslll.library.fragments.QsContainFragment;

import java.util.List;

public class QsFragmentAdapter extends FragmentPagerAdapter {
    private List<QsContainFragment> fragments;

    public QsFragmentAdapter(FragmentManager fm, List<QsContainFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
