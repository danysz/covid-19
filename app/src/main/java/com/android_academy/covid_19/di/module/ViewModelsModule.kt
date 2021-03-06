@file:Suppress("RemoveExplicitTypeArguments")

package com.android_academy.covid_19.di.module

import com.android_academy.covid_19.ui.fragment.main.MainViewModelImpl
import com.android_academy.covid_19.ui.fragment.main.UsersLocationListViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel<MainViewModelImpl> {
        MainViewModelImpl()
    }

    viewModel<UsersLocationListViewModelImpl> {
        UsersLocationListViewModelImpl(usersLocRepo = get())
    }
}
