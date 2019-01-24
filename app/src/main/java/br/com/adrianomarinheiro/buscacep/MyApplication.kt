package br.com.adrianomarinheiro.buscacep

import com.facebook.stetho.Stetho
import android.app.Application


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}