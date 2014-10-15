package com.embarkmobile.androidexample.tests;

import com.embarkmobile.androidexample.ExampleActivity;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.KeyEvent;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


/**
 *
 */
public class ExampleTest extends ActivityInstrumentationTestCase2<ExampleActivity> {

    // Number of items in the spinner's backing mLocalAdapter

    public static final int ADAPTER_COUNT = 9;

    // The location of Saturn in the backing mLocalAdapter array (0-based)

    public static final int TEST_POSITION = 5;

    // Set the initial position of the spinner to zero

    public static final int INITIAL_POSITION = 0;

    // The initial position corresponds to Mercury

    public static final String INITIAL_SELECTION = "Mercury";

    // Test values of position and selection for the testStateDestroy test

    public static final int TEST_STATE_DESTROY_POSITION = 2;
    public static final String TEST_STATE_DESTROY_SELECTION = "Earth";

    // Test values of position and selection for the testStatePause test

    public static final int TEST_STATE_PAUSE_POSITION = 4;
    public static final String TEST_STATE_PAUSE_SELECTION = "Jupiter";

    // The Application object for the application under test

    private ExampleActivity mActivity;

    // String displayed in the spinner in the app under test

    private String mSelection;

    // The currently selected position in the spinner in the app under test

    private int mPos;

    /*
     * The data backing the Spinner in the app under test.
     */

    private SpinnerAdapter mPlanetData;

    /*
     * Constructor for the test class. Required by Android test classes. The constructor
     * must call the super constructor, providing the Android package name of the app under test
     * and the Java class name of the activity in that application that handles the MAIN intent.
     */
    public ExampleTest() {

        super("com.embarkmobile.androidexample", ExampleActivity.class);
    }

    /*
     * Sets up the test environment before each test.
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
    @Override
    protected void setUp() throws Exception {

        /*
         * Call the super constructor (required by JUnit)
         */

        super.setUp();

        /*
         * prepare to send key events to the app under test by turning off touch mode.
         * Must be done before the first call to getActivity()
         */

        setActivityInitialTouchMode(false);

        /*
         * Start the app under test by starting its main activity. The test runner already knows
         * which activity this is from the call to the super constructor, as mentioned
         * previously. The tests can now use instrumentation to directly access the main
         * activity through mActivity.
         */
        mActivity = getActivity();


    }


}

