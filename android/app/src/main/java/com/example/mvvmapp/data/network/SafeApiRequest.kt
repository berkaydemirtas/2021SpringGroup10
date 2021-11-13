package com.example.mvvmapp.data.network

import android.util.Log
import com.example.mvvmapp.util.ApiException
import com.google.gson.JsonObject
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class SafeApiRequest {

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        }
        else {
            val error = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let{
                try {
                    // TODO(there should be a JSON key called "message" in the API)
                    message.append(JSONObject(it).getString("message"))
                }
                catch (e: JSONException) { }
                message.append("\n")
            }

            message.append("Error Code: ${response.code()}")

            throw ApiException(message.toString())
        }
    }
}