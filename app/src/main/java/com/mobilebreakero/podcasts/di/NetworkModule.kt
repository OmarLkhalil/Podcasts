package com.mobilebreakero.podcasts.di

import com.mobilebreakero.data.remote.PodcastApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://listen-api.listennotes.com/api/v2/"

    private const val HEADER_KEY = "X-ListenAPI-Key"
    private const val HEADER_VALUE = "28aede4c183c4d58b08680d5eaead2c9"

    @Provides
    @Singleton
    fun provideHttp(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .header(HEADER_KEY, HEADER_VALUE)
            val request = requestBuilder.build()
            chain.proceed(request)
        }

        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): PodcastApi {
        return retrofit.create(PodcastApi::class.java)
    }
}
