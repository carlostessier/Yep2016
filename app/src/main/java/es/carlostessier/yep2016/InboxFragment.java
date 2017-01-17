package es.carlostessier.yep2016;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * Created by carlosfernandez on 26/12/15.
 * List of messages
 */
public class InboxFragment extends android.support.v4.app.ListFragment{
    ProgressBar spinner;
//    protected SwipeRefreshLayout mSwipe;


    final static String TAG = InboxFragment.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inbox, container, false);

        spinner = (ProgressBar)
                rootView.findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        return rootView;
    }
}

