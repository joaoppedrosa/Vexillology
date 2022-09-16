package com.jppedrosa.vexillology.di.modules

import com.jppedrosa.vexillology.di.scopes.ActivityScoped
import com.jppedrosa.vexillology.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 15/09/2022.
 */

@Module
interface ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity
}