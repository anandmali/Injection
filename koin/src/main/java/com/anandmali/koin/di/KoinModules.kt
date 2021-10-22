package com.anandmali.koin.di

import androidx.viewbinding.BuildConfig
import com.anandmali.koin.network.GithubService
import com.anandmali.koin.network.SearchRepository
import com.anandmali.koin.search.SearchViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private fun getBaseUrl() = "https://api.github.com/"

val viewModelModule = module {
    viewModel {
        SearchViewModel(get())
    }
}

val repositoryModule = module {
    single {
        SearchRepository(get())
    }
}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

    single { provideUseApi(get()) }
}

val retrofitModule = module {
    fun provideHttpClient(): OkHttpClient = if (BuildConfig.DEBUG) {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply { HttpLoggingInterceptor.Level.BODY }
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }


    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(getBaseUrl())
            .client(client)
            .build()
    }

    single { provideHttpClient() }
    single { provideRetrofit(get()) }
}