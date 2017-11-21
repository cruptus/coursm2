package data;

import android.os.AsyncTask;
import android.util.Log;
import org.apache.commons.io.IOUtils;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by sergio on 21/11/2017.
 */

public class GetItemsAsync extends AsyncTask<Void, Void, Void>
{
    private final static String TAG = GetItemsAsync.class.getSimpleName();
    private WeakReference<ItemsListener> listenerRef;
    private String                       mUrl;

    public interface ItemsListener
    {
        public void itemsRetrieved(List<DataModel> items);
        public void itemsNotRetrived();
    }


    public GetItemsAsync(ItemsListener itemsListener, String url)
    {
        this.listenerRef = new WeakReference<>(itemsListener);
        this.mUrl = url;
    }

    @Override
    protected Void doInBackground(Void... voids)
    {

        URL url = null;
        HttpURLConnection urlConnection;
        try
        {
            url = new URL(mUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
        }
        catch (Exception e)
        {
            notifyItemsNotRetrieved();
            Log.e(TAG, e.getMessage());
            return null;
        }
        try
        {
            String jsonString;
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            StringWriter writer = new StringWriter();
            IOUtils.copy(in, writer, "utf-8");
            jsonString = writer.toString();
            Log.i(TAG, jsonString);
        }
        catch (Exception e)
        {
            Log.e(TAG, e.getMessage());
        } finally
        {
            urlConnection.disconnect();
        }

        notifyItemsNotRetrieved();
        return null;
    }

    private void notifyItemsRetrieved(List<DataModel> items)
    {
        if (listenerRef.get() != null)
        {
            listenerRef.get().itemsRetrieved(items);
        }
    }

    private void notifyItemsNotRetrieved()
    {
        if (listenerRef.get() != null)
        {
            listenerRef.get().itemsNotRetrived();
        }
    }
}
