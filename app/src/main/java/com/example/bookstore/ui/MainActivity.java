package com.example.bookstore.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import com.example.bookstore.R;
import com.example.bookstore.ui.fragment.DiscoverFragment;
import com.example.bookstore.ui.fragment.HomeFragment;
import com.example.bookstore.ui.fragment.PersonalFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity{

    private Button button_tab_home,button2_tab_discover,button3_tab_personal;
    private ViewPager viewPager;

    private MyPagerAdapter myPagerAdapter;
    private HomeFragment homeFragment;
    private DiscoverFragment discoverFragment;
    private PersonalFragment personalFragment;
    private ArrayList<Fragment> fragments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button_tab_home = (Button) findViewById(R.id.button_tab_home);
        button2_tab_discover = (Button) findViewById(R.id.button2_tab_discover);
        button3_tab_personal = (Button) findViewById(R.id.button3_tab_personal);
        defaultButton();
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        homeFragment = new HomeFragment();
        discoverFragment = new DiscoverFragment();
        personalFragment = new PersonalFragment();
        fragments.add(homeFragment);
        fragments.add(discoverFragment);
        fragments.add(personalFragment);


        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(myPagerAdapter);
        viewPager.setCurrentItem(0);
    }

    public void tabSelectClick(View view){
        changeTab(view);
    }


    public void defaultButton(){
        button_tab_home.setSelected(true);
        button2_tab_discover.setSelected(false);
        button3_tab_personal.setSelected(false);
    }

    private void changeTab(View view) {
        switch (view.getId()){
            case R.id.button_tab_home:
                button_tab_home.setSelected(true);
                button2_tab_discover.setSelected(false);
                button3_tab_personal.setSelected(false);
                break;
            case R.id.button2_tab_discover:
                button_tab_home.setSelected(false);
                button2_tab_discover.setSelected(true);
                button3_tab_personal.setSelected(false);
                break;
            case R.id.button3_tab_personal:
                button_tab_home.setSelected(false);
                button2_tab_discover.setSelected(false);
                button3_tab_personal.setSelected(true);
                break;
            default:
                break;
        }
    }


    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
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
}
