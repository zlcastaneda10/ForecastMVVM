package com.zaphier.forecastmvvm

import android.app.Application
import com.zaphier.forecastmvvm.data.db.ForecastDatabase
import com.zaphier.forecastmvvm.data.network.*
import com.zaphier.forecastmvvm.data.repository.ForecastRepository
import com.zaphier.forecastmvvm.data.repository.ForecastRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ForeCastApplication:Application(),KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForeCastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind< ConectivityInterceptor>() with singleton { ConectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance())}
        bind< WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind< ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(),instance()) }
    }

}