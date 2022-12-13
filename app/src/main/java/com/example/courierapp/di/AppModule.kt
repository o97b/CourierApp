package com.example.courierapp.di

import com.example.courierapp.BuildConfig
import com.example.courierapp.data.remote.CourierApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_API_URL)
        .build()


    @Provides
    @Singleton
    fun provideCourierApi(retrofit: Retrofit): CourierApi =
        retrofit.create(CourierApi::class.java)


//    @Provides
//    @Singleton
//    fun provideDataStoreRepository(
//        @ApplicationContext appContext: Context
//    ) = DataStoreRepository(context = appContext)



}