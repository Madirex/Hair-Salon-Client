package com.madirex.hairsalonclient.restcontroller;

import com.madirex.hairsalonclient.model.LoginUser;
import com.madirex.hairsalonclient.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RestApiLogin {
    @POST(APIRestConfig.API_PATH + "/users/login")
    Call<User> login(@Body LoginUser loginUser);
}
