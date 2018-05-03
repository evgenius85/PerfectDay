package com.klopkov.evgeny.perfectday;

import android.support.v4.app.Fragment;

import com.klopkov.evgeny.perfectday.fragment.CategoryFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CategoryFragment();
    }
}
