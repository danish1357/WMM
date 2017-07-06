package timefish.com.wmm;

import android.app.Application;
import android.content.Intent;
import android.os.FileObserver;

/**
 * Created by danish on 6/29/17.
 */

public class WMMApplication extends Application {
    public static String TAG = "WMMApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, WMMService.class));
    }
}
