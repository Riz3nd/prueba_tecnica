package com.rizend.prueba_tecnica.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {

    /**
     * Método que devuelve las 3 primeras iniciales un texto
     * @author Oscar Argaez
     * @param string
     * @return String
     */
    public static String getInitals(String string){
        String myInitials = "";
        String[] initials = string.split(" ");
        for (String initial : initials) {
            myInitials += initial.substring(0,1);
        }
        return (myInitials.length() < 4 ? myInitials : myInitials.substring(0, 3));
    }

    /**
     * Método que comprueba si hay conexión a internet
     * @author Oscar Argaez
     * @param context
     * @return Boolean
     */
    public static boolean isOnline(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        if(connectivityManager != null){
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null){
                return networkInfo.isConnected();
            }
        }
        return false;
    }
}
