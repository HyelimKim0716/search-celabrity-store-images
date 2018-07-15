package com.kakaobank.assignment.searchimage.ui.main.store_celebrity;

import android.support.v4.util.Pair;

import com.kakaobank.assignment.searchimage.common.App;
import com.kakaobank.assignment.searchimage.data.CelebrityResult;

import java.util.ArrayList;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class StoreCelebrityViewModel {
    private final String CLASS = "StoreCelebrityViewModel";

    ArrayList<CelebrityResult> mCelebrityResultList = new ArrayList<>();

    PublishSubject<Pair<StoreCelebrityViewEvent, Object>> mSearchCelebrityEventSender = PublishSubject.create();

    public void init() {
        mSearchCelebrityEventSender.subscribeOn(Schedulers.io());

    }

    private void sendEvent(StoreCelebrityViewEvent viewEvent, Object object) {
        mSearchCelebrityEventSender.onNext(new Pair<>(viewEvent, object));
    }

    public void loadData() {
        for (CelebrityResult one : App.mCelebrityResultList) {
            if (one.isSelected())
                mCelebrityResultList.add(one);
        }

        sendEvent(StoreCelebrityViewEvent.REFRESH_SEARCH_RESULT_LIST, 0);
    }
}
