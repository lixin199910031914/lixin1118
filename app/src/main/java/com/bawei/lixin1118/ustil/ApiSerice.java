package com.bawei.lixin1118.ustil;

import com.bawei.lixin1118.entity.ChuanEntity;
import com.bawei.lixin1118.entity.HomeEntity;
import com.bawei.lixin1118.entity.ShangEntity;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface  ApiSerice {
    //https://172.17.8.100/techApi/information/v1/findInformationByTitle
    @GET("information/v1/findInformationByTitle")
    Observable<HomeEntity> getBy(@Query("title") String title,@Query("page") int page,@Query("count") int count);
   // https://172.17.8.100/techApi/user/verify/v1/getUserInfoByUserId
    @GET("user/verify/v1/getUserInfoByUserId")
    Observable<ShangEntity> getUser(@Header("userId") int userId,@Header("sessionId") String sessionId);
    //https://172.17.8.100/techApi/user/verify/v1/modifyHeadPic
    @POST("user/verify/v1/modifyHeadPic")
    @FormUrlEncoded
    Observable<ChuanEntity> HeandPic(@Header("userId") int userId, @Header("sessionId") String sessionId, @Part MultipartBody.Part file);
}
