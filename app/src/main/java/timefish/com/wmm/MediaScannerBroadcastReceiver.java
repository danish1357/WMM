package timefish.com.wmm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MediaScannerBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        android.util.Log.d(WMMApplication.TAG, "gallery has new images");
    }
}
