package com.team.apparrahman.event;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class EventItem implements Parcelable {

    private String title;
    private String content;
    private String label;

    public EventItem(JSONObject jsonObject) {
        try {
            String tl = jsonObject.getString("title");
            String ds = jsonObject.getString("content");
            String lb = jsonObject.getString("labels");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected EventItem(Parcel in) {
        title = in.readString();
        content = in.readString();
        label = in.readString();
    }

    public static final Creator<EventItem> CREATOR = new Creator<EventItem>() {
        @Override
        public EventItem createFromParcel(Parcel in) {
            return new EventItem(in);
        }

        @Override
        public EventItem[] newArray(int size) {
            return new EventItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(label);
    }
}
