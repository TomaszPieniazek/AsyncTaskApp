package com.example.tomasz.asynctaskapp;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by Tomasz on 03.12.2017.
 */

public class AsyncTaskComputing extends AsyncTask<Integer, Integer, Integer> {
    public MainActivity a;


    public AsyncTaskComputing(MainActivity m) {
        this.a=m;
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        Integer total=0;
        for(int i=0;i<integers[0];i++){
            total +=10;
            try {
                Thread.sleep(1000);
                publishProgress(total);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return total;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        TextView tv=a.findViewById(R.id.textView);
        tv.append("\nResult"+integer.toString());
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        TextView tv=a.findViewById(R.id.textView);
        tv.append("\nProgress : "+values[0].toString());
    }
}
