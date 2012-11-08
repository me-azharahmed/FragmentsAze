package aze.android.fragmentsaze;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private FragmentManager mFragmentManager;
	private FragmentTransaction mFragmentTransaction;
	private Button mButtonFragment1;
	private Button mButtonFragment2;
	private Button mButtonFragment3;
	public Fragment1 mFragment1;
	public Fragment2 mFragment2;
	public Fragment3 mFragment3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mButtonFragment1 = (Button) findViewById(R.id.main_button1);
		mButtonFragment2 = (Button) findViewById(R.id.main_button2);
		mButtonFragment3 = (Button) findViewById(R.id.main_button3);

		mFragmentManager = getSupportFragmentManager();

		mFragment1 = (Fragment1) mFragmentManager.findFragmentById(R.id.main_fragment1);
		mFragment2 = (Fragment2) mFragmentManager.findFragmentById(R.id.main_fragment2);
		mFragment3 = (Fragment3) mFragmentManager.findFragmentById(R.id.main_fragment3);

		mFragmentTransaction = mFragmentManager.beginTransaction();
		mFragmentTransaction.show(mFragment1);
		mFragmentTransaction.hide(mFragment2);
		mFragmentTransaction.hide(mFragment3);
		mFragmentTransaction.commit();

		mButtonFragment1.setOnClickListener(this);
		mButtonFragment2.setOnClickListener(this);
		mButtonFragment3.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		mFragmentTransaction = mFragmentManager.beginTransaction();

		switch (v.getId()) {
		case R.id.main_button1:
			mFragmentTransaction.show(mFragment1);
			mFragmentTransaction.hide(mFragment2);
			mFragmentTransaction.hide(mFragment3);
			mFragmentTransaction.commit();
			break;

		case R.id.main_button2:
			mFragmentTransaction.hide(mFragment1);
			mFragmentTransaction.show(mFragment2);
			mFragmentTransaction.hide(mFragment3);
			mFragmentTransaction.commit();
			break;

		case R.id.main_button3:
			mFragmentTransaction.hide(mFragment1);
			mFragmentTransaction.hide(mFragment2);
			mFragmentTransaction.show(mFragment3);
			mFragmentTransaction.commit();
			break;

		default:
			break;
		}

	}
}
