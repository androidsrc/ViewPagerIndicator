package com.androidsrc.viewpagerindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class MainActivity extends FragmentActivity {

	private ViewPager viewPager;
	private View indicator1;
	private View indicator2;
	private View indicator3;
	private View indicator4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		indicator1 = (View) findViewById(R.id.indicator1);
		indicator2 = (View) findViewById(R.id.indicator2);
		indicator3 = (View) findViewById(R.id.indicator3);
		indicator4 = (View) findViewById(R.id.indicator4);

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(new WizardPageChangeListener());
		updateIndicators(0);
	}

	@Override
	public void onBackPressed() {
		if (viewPager.getCurrentItem() == 0) {
			// If the user is currently looking at the first step, allow the
			// system to handle the
			// Back button. This calls finish() on this activity and pops the
			// back stack.
			super.onBackPressed();
		} else {
			// Otherwise, select the previous step.
			viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
		}
	}

	private class ViewPagerAdapter extends FragmentPagerAdapter {

		private int WIZARD_PAGES_COUNT = 4;

		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return new WizardFragment(position);
		}

		@Override
		public int getCount() {
			return WIZARD_PAGES_COUNT;
		}

	}

	private class WizardPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int position) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			updateIndicators(position);
		}

	}

	public void updateIndicators(int position) {
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		int resizeValue = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 25, metrics);
		int defaultValue = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 15, metrics);
		switch (position) {
		case 0:
			indicator1.getLayoutParams().height = resizeValue;
			indicator1.getLayoutParams().width = resizeValue;
			indicator1.requestLayout();

			indicator2.getLayoutParams().height = defaultValue;
			indicator2.getLayoutParams().width = defaultValue;
			indicator2.requestLayout();

			indicator3.getLayoutParams().height = defaultValue;
			indicator3.getLayoutParams().width = defaultValue;
			indicator3.requestLayout();

			indicator4.getLayoutParams().height = defaultValue;
			indicator4.getLayoutParams().width = defaultValue;
			indicator4.requestLayout();

			break;

		case 1:
			indicator1.getLayoutParams().height = defaultValue;
			indicator1.getLayoutParams().width = defaultValue;
			indicator1.requestLayout();

			indicator2.getLayoutParams().height = resizeValue;
			indicator2.getLayoutParams().width = resizeValue;
			indicator2.requestLayout();

			indicator3.getLayoutParams().height = defaultValue;
			indicator3.getLayoutParams().width = defaultValue;
			indicator3.requestLayout();

			indicator4.getLayoutParams().height = defaultValue;
			indicator4.getLayoutParams().width = defaultValue;
			indicator4.requestLayout();
			break;

		case 2:
			indicator1.getLayoutParams().height = defaultValue;
			indicator1.getLayoutParams().width = defaultValue;
			indicator1.requestLayout();

			indicator2.getLayoutParams().height = defaultValue;
			indicator2.getLayoutParams().width = defaultValue;
			indicator2.requestLayout();

			indicator3.getLayoutParams().height = resizeValue;
			indicator3.getLayoutParams().width = resizeValue;
			indicator3.requestLayout();

			indicator4.getLayoutParams().height = defaultValue;
			indicator4.getLayoutParams().width = defaultValue;
			indicator4.requestLayout();
			break;

		case 3:
			indicator1.getLayoutParams().height = defaultValue;
			indicator1.getLayoutParams().width = defaultValue;
			indicator1.requestLayout();

			indicator2.getLayoutParams().height = defaultValue;
			indicator2.getLayoutParams().width = defaultValue;
			indicator2.requestLayout();

			indicator3.getLayoutParams().height = defaultValue;
			indicator3.getLayoutParams().width = defaultValue;
			indicator3.requestLayout();

			indicator4.getLayoutParams().height = resizeValue;
			indicator4.getLayoutParams().width = resizeValue;
			indicator4.requestLayout();
			break;
		}

	}
}
