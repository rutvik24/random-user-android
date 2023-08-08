package com.moontowertickets.randomuser.module

import com.moontowertickets.randomuser.network.UserData
import com.moontowertickets.randomuser.network.UserDto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): UserData {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
}