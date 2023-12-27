package com.android.supraweey.tmdbclient

import android.os.Build
import androidx.annotation.RequiresApi
import com.android.supraweey.tmdbclient.data.MovieDataService
import com.android.supraweey.tmdbclient.network.NetworkManager
import com.android.supraweey.tmdbclient.network.Networkable
import com.android.supraweey.tmdbclient.service.MovieHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

@RequiresApi(Build.VERSION_CODES.M)
val appModule = module {

    single<Networkable> { NetworkManager.init(get()) }
    single(named("RETROFIT")) {
        MovieHttpClient().createRetrofit(context = androidContext())
    }

    single { get<Retrofit>(named("RETROFIT")).create(MovieDataService::class.java) }

    single<MovieDataRepository> { MovieDataRepositoryImpl(get(), get()) }

    factory { MoviePopularUseCase(get()) }

    viewModel{ PopularViewModel(get()) }
}