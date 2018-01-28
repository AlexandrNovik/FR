package com.aliak.dev.fastreading.ui.base

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.afollestad.appthemeengine.ATE
import com.afollestad.appthemeengine.Config
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.LifecyclePresenter
import com.aliak.dev.fastreading.utils.adjustAlpha

abstract class BaseLifecycleThemedActivity<Presenter : LifecyclePresenter> : BaseThemedActivity() {
    lateinit var presenter: Presenter
    abstract fun initPresenter(): Presenter
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

    protected fun View.setAccentBackground() {
        this.setBackgroundColor(Config.accentColor(this@BaseLifecycleThemedActivity, ateKey))
    }

    protected fun View.setPrimaryBackground() {
        this.setBackgroundColor(Config.primaryColor(this@BaseLifecycleThemedActivity, ateKey))
    }

    protected fun TextView.setAccentTextColor() {
        this.setTextColor(Config.accentColor(this@BaseLifecycleThemedActivity, ateKey))
    }

    protected fun View.setAccentAlphaBackgroundColor(alpha: Float) {
        this.setBackgroundColor(
                adjustAlpha(
                        Config.accentColor(this@BaseLifecycleThemedActivity, ateKey),
                        alpha)
        )
    }

    protected fun getAccentColor() = Config.accentColor(this@BaseLifecycleThemedActivity, ateKey)
    protected fun getPrimaryColor() = Config.accentColor(this@BaseLifecycleThemedActivity, ateKey)
}