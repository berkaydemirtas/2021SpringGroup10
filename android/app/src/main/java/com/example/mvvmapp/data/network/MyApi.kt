package com.example.mvvmapp.data.network

import com.example.mvvmapp.data.network.responses.AuthResponse
import com.example.mvvmapp.data.network.responses.QuotesResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    // TODO("Field annotations are for http request keys. They must match")

    @FormUrlEncoded
    @POST("login") // "login" is endpoint we add to root url
    suspend fun userLogin(
        @Field("login") email: String,
        @Field("password") password: String
    ) : Response<AuthResponse>


    @FormUrlEncoded
    @POST("signup")
    suspend fun userSignup(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ) : Response<AuthResponse>

    @GET("quotes")
    suspend fun getQuotes() : Response<QuotesResponse>

    // TODO(fix the base url according to backend API)
    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : MyApi {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()


            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://xxxx.backendless.app/api/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}