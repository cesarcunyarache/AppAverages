package com.example.myappprom;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {


    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        // this.context = context;
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0: return new Modulo1();
            case 1: return new Module2();
            case 2: return new Modulo3();
            default: return new Modulo1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }



}
