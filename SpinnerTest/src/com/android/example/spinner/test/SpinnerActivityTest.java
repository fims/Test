package com.android.example.spinner.test;

import com.android.example.spinner.SpinnerActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class SpinnerActivityTest extends ActivityInstrumentationTestCase2<SpinnerActivity> {
	private SpinnerActivity mActivity;
	private Spinner mSpinner;
	private SpinnerAdapter mPlanetData;
	private static final int ADAPTER_COUNT = 9;
	protected static final int INITIAL_POSITION = 0;
	protected static final int TEST_POSITION = 5;
	private String mSelection;
	private int mPos;

	public SpinnerActivityTest() {
		super(SpinnerActivity.class);
	}

	@Override
	protected void setUp() throws Exception{
		super.setUp();

		setActivityInitialTouchMode(false);

		mActivity = getActivity();

		mSpinner = (Spinner) mActivity.findViewById(com.android.example.spinner.R.id.Spinner01);

		mPlanetData = mSpinner.getAdapter();
	}

	public void testPreConditions() {
		assertTrue(mSpinner.getOnItemSelectedListener() != null);
		assertTrue(mPlanetData != null);
		assertEquals(mPlanetData.getCount(),ADAPTER_COUNT);
	}

	public void testSpinnerUI() {

		mActivity.runOnUiThread(
				new Runnable() {
					public void run() {
						mSpinner.requestFocus();
						mSpinner.setSelection(INITIAL_POSITION);
					} // end of run() method definition
				} // end of anonymous Runnable object instantiation
				); // end of invocation of runOnUiThread

		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		for (int i = 1; i <= TEST_POSITION; i++) {
			this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
		} // end of for loop

		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);

		mPos = mSpinner.getSelectedItemPosition();
		mSelection = (String)mSpinner.getItemAtPosition(mPos);
		TextView resultView =
				(TextView) mActivity.findViewById(
						com.android.example.spinner.R.id.SpinnerResult
						);

		String resultText = (String) resultView.getText();

		assertEquals(resultText,mSelection);

	}
}
