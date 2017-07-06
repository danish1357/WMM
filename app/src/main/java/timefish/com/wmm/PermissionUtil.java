package timefish.com.wmm;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.util.ArrayList;


public class PermissionUtil {

    private static final String[] REQUIRED_PERMISSIONS = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    public static int REQUEST_CODE_MULTIPLE_PERMISSIONS = 2;
    private Context mContext;

    public PermissionUtil(Context context) {
        mContext = context;
    }

    public static boolean checkAllRequiredPermissionsGranted(Activity activity) {

        ArrayList<String> permissions = new ArrayList<>();

        for (String toiPermission : REQUIRED_PERMISSIONS
                ) {
            if (PermissionUtil.checkPermission(activity, toiPermission) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(toiPermission);
            }
        }

        String[] permissionsArray = new String[permissions.size()];
        permissions.toArray(permissionsArray);

        if (permissionsArray.length != 0) {
            requestPermissions(activity, permissionsArray, REQUEST_CODE_MULTIPLE_PERMISSIONS);
            return false;
        }

        return true;
    }

    public static int checkPermission(Context context, String permission) {
        //all popups related to permission will come here. After successful check call PermissionUtil

        return ContextCompat.checkSelfPermission(context, permission);

    }

    public static void requestPermission(Activity activity, String permission, int requestPermissionCode) {
        ActivityCompat.requestPermissions(activity,
                new String[]{permission},
                requestPermissionCode);
    }

    public static void requestPermissions(Activity activity, String[] permissions, int requestPermissionCode) {
        ActivityCompat.requestPermissions(activity,
                permissions,
                requestPermissionCode);
    }


}
