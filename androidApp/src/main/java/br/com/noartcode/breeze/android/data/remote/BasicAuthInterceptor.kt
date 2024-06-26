package br.com.noartcode.breeze.android.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor(
    private val tokenType:String,
    private val accessToken:String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request
            .newBuilder()
            .header("Authorization", "$tokenType $accessToken")
            .build()
        return chain.proceed(request)
    }
}