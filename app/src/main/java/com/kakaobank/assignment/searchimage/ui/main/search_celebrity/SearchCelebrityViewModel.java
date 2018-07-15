package com.kakaobank.assignment.searchimage.ui.main.search_celebrity;

import android.annotation.SuppressLint;
import android.databinding.ObservableField;
import android.support.v4.util.Pair;
import android.util.Log;

import com.kakaobank.assignment.searchimage.common.App;
import com.kakaobank.assignment.searchimage.data.KakaoSearchApi;
import com.kakaobank.assignment.searchimage.data.CelebrityResult;
import com.kakaobank.assignment.searchimage.data.model.image.Document;
import com.kakaobank.assignment.searchimage.data.model.image.ImageResult;
import com.kakaobank.assignment.searchimage.data.model.video.VideoClipResult;

import java.util.ArrayList;
import java.util.Collections;


import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import retrofit2.Retrofit;

public class SearchCelebrityViewModel {

    private final String CLASS = "SearchCelebrityViewModel";

    public ObservableField<String> mCelebrityName = new ObservableField<>();
    ArrayList<CelebrityResult> mCelebrityResultList = new ArrayList<>();
    ImageResult mImageResult = null;
    VideoClipResult mVideoClipResult = null;

    public PublishSubject<Pair<SearchCelebrityViewEvent, Object>> mSearchCelebrityEventSender = PublishSubject.create();

    private Retrofit mRetrofit;
    private KakaoSearchApi mSearchApi;


    public SearchCelebrityViewModel(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    public void init() {
        mSearchCelebrityEventSender.subscribeOn(Schedulers.io());

    }

    private void sendEvent(SearchCelebrityViewEvent viewEvent, Object object) {
        mSearchCelebrityEventSender.onNext(new Pair<>(viewEvent, object));
    }

    private boolean isGetImageResult = false;
    private boolean isGetVideoClipResult = false;

    @SuppressLint("CheckResult")
    public void loadData(String celebrityName) {
        mImageResult = null;
        mVideoClipResult = null;

        Log.d(App.TAG, CLASS + ", celebrityName: " + celebrityName);

        mRetrofit.create(KakaoSearchApi.class).searchImage(celebrityName)
                .subscribe(imageResult -> {
                    mImageResult = imageResult;

                    for (Document one : imageResult.getDocuments()) {
                        CelebrityResult celebrityResult = new CelebrityResult(one.getDatetime(), one.getThumbnail_url());
                        mCelebrityResultList.add(celebrityResult);
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                    Log.e(App.TAG, CLASS + ", Get ImageResults error: " + throwable.getMessage());
                }, () -> {
                    isGetImageResult = true;
                    if (isGetImageResult && isGetVideoClipResult)
                        sortDateTime();

                    Log.d(App.TAG, CLASS + ", Get ImageResults finished");
                });

        mRetrofit.create(KakaoSearchApi.class).searchVideo(celebrityName)
                .subscribe(videoResult -> {
                    mVideoClipResult = videoResult;

                    for (com.kakaobank.assignment.searchimage.data.model.video.Document one : mVideoClipResult.getDocuments()) {
                        CelebrityResult celebrityResult = new CelebrityResult(one.getDatetime(), one.getThumbnail());
                        mCelebrityResultList.add(celebrityResult);
                    }

                }, throwable -> {
                    throwable.printStackTrace();
                    Log.e(App.TAG, CLASS + ", Get VideoClipResults error: " + throwable.getMessage());
                }, () -> {
                    isGetVideoClipResult = true;
                    if (isGetImageResult && isGetVideoClipResult)
                        sortDateTime();
                    Log.d(App.TAG, CLASS + ", Get VideoClipResults finished");
                });


    }

    private void sortDateTime() {
        Collections.sort(mCelebrityResultList, CelebrityResult.dateTimeComparator);

        App.mCelebrityResultList.clear();
        App.mCelebrityResultList.addAll(mCelebrityResultList);

        sendEvent(SearchCelebrityViewEvent.REFRESH_SEARCH_RESULT_LIST, 0);
    }

    public void btnSearchClicked() {
        Log.d(App.TAG, "btnSearchClicked");
        loadData(mCelebrityName.get());
        sendEvent(SearchCelebrityViewEvent.HIDE_KEYBOARD, 0);
    }
}
