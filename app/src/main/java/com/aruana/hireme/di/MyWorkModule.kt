package com.aruana.hireme.di

import com.aruana.hireme.mywork.MyWorkRepository
import com.aruana.hireme.mywork.MyWorkRepositoryInMemory
import com.aruana.hireme.mywork.GetWorks
import com.aruana.hireme.mywork.GetWorksImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MyWorkModule {

    @Binds
    abstract fun provideUseCase(useCase: GetWorksImpl): GetWorks

    @Binds
    abstract fun provideRepository(repository: MyWorkRepositoryInMemory): MyWorkRepository
}