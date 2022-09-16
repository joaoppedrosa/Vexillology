package com.jppedrosa.vexillology.di.component

import android.app.Application
import com.jppedrosa.vexillology.VexillologyApplication
import com.jppedrosa.vexillology.di.modules.AppModule
import com.jppedrosa.vexillology.di.modules.ActivityBuilderModule
import com.jppedrosa.vexillology.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 15/09/2022.
 */
@Singleton
@Component(
    modules = [
        (AndroidInjectionModule::class),
        (AndroidSupportInjectionModule::class),
        (AppModule::class),
        (ViewModelModule::class),
        (ActivityBuilderModule::class)
    ]
)
interface AppComponent : AndroidInjector<VexillologyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}