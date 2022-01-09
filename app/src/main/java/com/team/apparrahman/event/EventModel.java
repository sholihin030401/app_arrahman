package com.team.apparrahman.event;

import android.media.metrics.Event;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class EventModel extends ViewModel {

    private static final String ID_KEY = "AIzaSyBOdyRA8ieRNcSSuSWmG20FutnaHqbDBPU";
    private static final String ID_BLOG = "7367174984702670435";
    private MutableLiveData<ArrayList<EventItem>> liveDataEvent = new MutableLiveData<>();

    public void setEvent(final String events){
        AsyncHttpClient httpClient = new AsyncHttpClient();
        final ArrayList<EventItem> list = new ArrayList<>();

        String urlEvent = "https://www.googleapis.com/blogger/v3/blogs/"+ID_BLOG+"/posts?key="+ID_KEY;
        httpClient.get(urlEvent, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject json = new JSONObject(result);
                    JSONArray array = json.getJSONArray("items");

                    for (int i = 0; i < array.length(); i++){
                        JSONObject object = array.getJSONObject(i);
                        EventItem item = new EventItem(object);
                        list.add(item);
                    }

                    liveDataEvent.postValue(list);

                } catch (Exception e){
                    Log.d("Exception",e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure",error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<EventItem>> getLiveEvent(){
        return liveDataEvent;
    }
}
