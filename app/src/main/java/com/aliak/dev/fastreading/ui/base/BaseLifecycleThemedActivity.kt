package com.aliak.dev.fastreading.ui.base

import android.os.Bundle
import com.afollestad.appthemeengine.ATE
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.PresenterLifecycle

abstract class BaseLifecycleThemedActivity : BaseThemedActivity() {
    lateinit var presenter: PresenterLifecycle
    abstract fun initPresenter(): PresenterLifecycle
    abstract fun initView()
    abstract fun getResId(): Int
    override fun onCreate(savedInstanceState: Bundle?) {
        if (!ATE.config(this, "light_theme").isConfigured(4)) {
            ATE.config(this, "light_theme")
                    .activityTheme(R.style.AppTheme)
                    .primaryColorRes(R.color.colorPrimaryLightDefault)
                    .accentColorRes(R.color.colorAccentLightDefault)
                    .coloredNavigationBar(false)
                    .navigationViewSelectedIconRes(R.color.colorAccentLightDefault)
                    .navigationViewSelectedTextRes(R.color.colorAccentLightDefault)
                    .commit()
        }
        if (!ATE.config(this, "dark_theme").isConfigured(4)) {
            ATE.config(this, "dark_theme")
                    .activityTheme(R.style.AppThemeDark)
                    .primaryColorRes(R.color.colorPrimaryDarkDefault)
                    .accentColorRes(R.color.colorAccentDarkDefault)
                    .coloredNavigationBar(true)
                    .navigationViewSelectedIconRes(R.color.colorAccentDarkDefault)
                    .navigationViewSelectedTextRes(R.color.colorAccentDarkDefault)
                    .commit()
        }
        super.onCreate(savedInstanceState)
        setContentView(getResId())
        presenter = initPresenter()
        initView()
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.release()
    }
}