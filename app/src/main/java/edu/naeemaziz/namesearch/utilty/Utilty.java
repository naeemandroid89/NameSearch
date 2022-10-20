package edu.naeemaziz.namesearch.utilty;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Utilty {

    public static void showExitDialogue(AppCompatActivity ctx) {
        //AlertDialog.Builder builder = new AlertDialog.Builder(ctx, R.style.CustomDialogTheme);
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure to exit? ");
        builder.setNegativeButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ctx.finish();
                    }
                });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();

    }
    public static void showNetworkErrorDialogue(Activity ctx) {
      //  AlertDialog.Builder builder = new AlertDialog.Builder(ctx, R.style.CustomDialogTheme);
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("No internet connection!");
        builder.setMessage("Check your internet connection or try again.");
        builder.setNegativeButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ctx.finish();
                    }
                });
        builder.show();

    }
    public static boolean isNetwork(Activity ctx) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public static String generateQuery(String name1, String name2, String name3) {
        //?name[]=michael&name[]=matthew&name[]=jane
        StringBuilder sb = new StringBuilder();
        sb.append("?");

        if(!name1.isEmpty()){
            sb.append("name[]=");
            sb.append(name1);
            if(!name2.isEmpty() && name2.length()> 0 || !name3.isEmpty() && name3.length()> 0)
                sb.append("&");
        }
        if(!name2.isEmpty()) {
            sb.append("name[]=");
            sb.append(name2);
            if(!name3.isEmpty() && name3.length()> 0)
                sb.append("&");
        }
        if(!name3.isEmpty()){
            sb.append("name[]=");
            sb.append(name3);
        }
        return sb.toString();
    }
}
