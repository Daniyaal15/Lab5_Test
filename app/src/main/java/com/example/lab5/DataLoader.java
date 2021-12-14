package com.example.lab5;

import android.os.AsyncTask;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.lang.ref.WeakReference;


public class DataLoader extends AsyncTask<Void, Void, Void> {

    static ListView listView;
    WeakReference<MainActivity> weakReference;
    private ListAdapter adapter;
    private XmlParser xmlParser;

    public DataLoader(MainActivity activity) {
        weakReference = new WeakReference<>(activity);
        listView = weakReference.get().findViewById(R.id.currency_list_view);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        xmlParser = new XmlParser(weakReference.get());
        return null;
    }

    protected void onProgressUpdate(Void values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        adapter = new SimpleAdapter(weakReference.get(), xmlParser.getUserList(), R.layout.list_row, new String[]{"targetName", "targetCurrency", "inverseRate"},
                new int[]{R.id.targetName, R.id.targetCurrency, R.id.inverseRate});
        listView.setAdapter(adapter);
    }
}
