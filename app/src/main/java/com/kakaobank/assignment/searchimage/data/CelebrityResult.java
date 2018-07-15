package com.kakaobank.assignment.searchimage.data;

import android.util.Log;

import com.kakaobank.assignment.searchimage.common.App;

import java.util.Comparator;

public class CelebrityResult {

    private boolean isSelected = false;
    private String dateTime = "";
    private String thumbnailUrl = "";

    public CelebrityResult(String dateTime, String thumbnailUrl) {
        this.dateTime = dateTime;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public static Comparator<CelebrityResult> dateTimeComparator = (item1, item2) -> {
        String firstItem = item1.getDateTime();
        String secondItem = item2.getDateTime();

        Log.d(App.TAG, "first = " + firstItem + ", second = " + secondItem + ", compare = " + secondItem.compareTo(firstItem));
        if (firstItem == null) return Integer.MAX_VALUE;
        if (secondItem == null) return Integer.MAX_VALUE;
        // descending order
        return secondItem.compareTo(firstItem);
    };

}
