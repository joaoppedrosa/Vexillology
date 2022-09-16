package com.jppedrosa.vexillology.di

import com.jppedrosa.vexillology.BuildConfig
import com.jppedrosa.vexillology.data.remote.VexillologyApi
import com.jppedrosa.vexillology.data.repository.VexillologyRepositoryImpl
import com.jppedrosa.vexillology.domain.VexillologyRepository
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 15/09/2022.
 */
@Module
class AppModule {

    private val BASE_URL = "https://restcountries.com"

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val original: Request = chain.request()
            val request: Request = original.newBuilder()
                .header("Content-Type", "application/json")
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        })
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideVexillologyApi(okHttpClient: OkHttpClient): VexillologyApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(VexillologyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideVexillologyRepository(api: VexillologyApi): VexillologyRepository {
        return VexillologyRepositoryImpl(api);
    }
}