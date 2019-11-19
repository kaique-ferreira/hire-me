package com.aruana.hireme.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.aruana.hireme.MyApplication
import com.aruana.hireme.mywork.MyWorkViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [MyWorkModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    val myWorkViewModel: MyWorkViewModel
}

inline fun <reified T : ViewModel> AppCompatActivity.createViewModel(crossinline factory: () -> T): T = T::class.java.let { clazz ->
    ViewModelProviders.of(this, object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == clazz) {
                @Suppress("UNCHECKED_CAST")
                return factory() as T
            }
            throw IllegalArgumentException("Unexpected argument: $modelClass")
        }
    }).get(clazz)
}

fun Fragment.createWorkViewModel() =
        (requireActivity() as AppCompatActivity).createViewModel {
            (requireActivity().application as MyApplication).appComponent.myWorkViewModel
        }
