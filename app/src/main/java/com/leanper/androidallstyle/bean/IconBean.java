package com.leanper.androidallstyle.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class IconBean  implements Parcelable {
    private String url;
    private Context context;

    protected IconBean(Parcel in) {
        url = in.readString();
    }

    public static final Creator<IconBean> CREATOR = new Creator<IconBean>() {
        @Override
        public IconBean createFromParcel(Parcel in) {
            return new IconBean(in);
        }

        @Override
        public IconBean[] newArray(int size) {
            return new IconBean[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public IconBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
    }
}
