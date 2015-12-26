package es.carlostessier.yep2016;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by carlosfernandez on 26/12/15.
 * Connection with Parse
 */
public class YepApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // [Optional] Power your app with Local Datastore. For more info, go to
        // https://parse.com/docs/android/guide#local-datastore Parse.enableLocalDatastore(this);
        Parse.initialize(this);

    }
}
