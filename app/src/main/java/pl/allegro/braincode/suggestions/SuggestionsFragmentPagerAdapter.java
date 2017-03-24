package pl.allegro.braincode.suggestions;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SuggestionsFragmentPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;

    public SuggestionsFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return SelectCategoryFragment.newInstance();
            case 1: // Fragment # 1 - This will show SecondFragment
                return GetSuggestionsFragment.newInstance();
            default:
                return null;
        }
    }
}
