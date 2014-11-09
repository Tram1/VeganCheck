package vscanner.android.ui.scan;

import android.content.Intent;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;

import vscanner.android.ui.CardboardActivityBase;

// TODO: handle back button?
public class ScanActivity extends CardboardActivityBase implements ScanActivityState.Listener {
    private ScanActivityState state = new ActivityFirstState(this);

    public ScanActivityState getState() {
        return state;
    }

    @Override
    public void onStateRequestsChangeTo(final ScanActivityState otherState) {
        this.state = otherState;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Crashlytics.start(this);
        state.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        state.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        state.onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        state.onResumeFragments();
    }
}
