package com.aakash.netstatus;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;

import androidx.annotation.NonNull;

public class NetStatus{
    private static final String TAG = "NetCheck";

    public static boolean isConnectedToInternet(@NonNull Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (cm != null) {
                Network network = cm.getActiveNetwork();
                if (network != null) {
                    NetworkCapabilities nc = cm.getNetworkCapabilities(network);
                    return nc != null &&
                            nc.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                            nc.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "isConnectedToInternet: " + e.getMessage());
        }
        return false;
    }

    public static boolean hasWiFi(@NonNull Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (cm != null) {
                Network network = cm.getActiveNetwork();
                if (network != null) {
                    NetworkCapabilities nc = cm.getNetworkCapabilities(network);
                    return nc != null && nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "hasWiFi: " + e.getMessage());
        }
        return false;
    }

    public static boolean hasMobileData(@NonNull Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (cm != null) {
                Network network = cm.getActiveNetwork();
                if (network != null) {
                    NetworkCapabilities nc = cm.getNetworkCapabilities(network);
                    return nc != null && nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "hasMobileData: " + e.getMessage());
        }
        return false;
    }

    public static String getConnectionType(@NonNull Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (cm != null) {
                Network network = cm.getActiveNetwork();
                if (network != null) {
                    NetworkCapabilities nc = cm.getNetworkCapabilities(network);
                    if (nc != null) {
                        if (nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                            return "WIFI";
                        } else if (nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                            return "MOBILE";
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "getConnectionType: " + e.getMessage());
        }
        return "NONE";
    }
}
