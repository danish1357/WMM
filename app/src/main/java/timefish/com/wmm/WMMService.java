package timefish.com.wmm;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by danish on 6/29/17.
 */

public class WMMService extends Service {
    private WMMContentObserver contentObserver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(WMMApplication.TAG, "service started ...");

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        contentObserver = new WMMContentObserver(new Handler(), this);
        getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, contentObserver);
        return START_STICKY;
    }
}
