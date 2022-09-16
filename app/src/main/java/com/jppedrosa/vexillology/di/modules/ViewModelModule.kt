package com.jppedrosa.vexillology.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jppedrosa.vexillology.di.factories.ViewModelFactory
import com.jppedrosa.vexillology.di.keys.ViewModelKey
import com.jppedrosa.vexillology.ui.vm.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 15/09/2022.
 */

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun postMainViewModel(viewModel: MainViewModel): ViewModel
}