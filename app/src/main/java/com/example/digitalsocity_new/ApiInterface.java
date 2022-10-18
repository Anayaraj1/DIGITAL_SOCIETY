package com.example.digitalsocity_new;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface
{

    @GET("login_chairman.php")
    Call<List<Chairman_Model>> chairman_login(@Query("email")String email,
                                              @Query("password")String password);

    @GET("member_request.php")
    Call<List<MemberRequest_model>> getMemberRequest(@Query("name")String name,
                                                     @Query("house_no")String house_no,
                                                     @Query("email")String email);
}
