package com.mathan.portfolio.di

import com.mathan.portfolio.store.AppAction
import com.mathan.portfolio.store.AppState
import com.mathan.portfolio.store.Store
import com.mathan.portfolio.store.appReducer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStore(): Store<AppState, AppAction> {
        return Store(AppState(), ::appReducer, CoroutineScope(Dispatchers.Main))
    }
}
