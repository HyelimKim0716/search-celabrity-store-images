package com.kakaobank.assignment.searchimage.data;

import com.kakaobank.assignment.searchimage.data.model.image.ImageResult;
import com.kakaobank.assignment.searchimage.data.model.video.VideoClipResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KakaoSearchApi {

    String SEARCH = "v2/search";

    @GET(SEARCH + "/image")
    Observable<ImageResult> searchImage(@Query("query") String name);

    @GET(SEARCH + "/vclip")
    Observable<VideoClipResult> searchVideo(@Query("query") String name);


}
