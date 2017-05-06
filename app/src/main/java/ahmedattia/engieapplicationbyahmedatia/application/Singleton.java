package ahmedattia.engieapplicationbyahmedatia.application;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ahmed Attia on 06/05/2017.
 */

public class Singleton {
    private static Singleton mInstance;
    private static Context mCtx;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private Singleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

    }

    public static synchronized Singleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Singleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
