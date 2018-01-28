package com.aliak.dev.fastreading.ui.training.schulte

import android.view.MenuItem
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.training.schulte.SchulteDescriptionPresenter
import com.aliak.dev.fastreading.mvp.SchulteDescriptionContract
import com.aliak.dev.fastreading.mvp.SchulteDescriptionContract.SchulteSettingsButton
import com.aliak.dev.fastreading.mvp.SchulteDescriptionContract.SchulteSettingsButton.*
import com.aliak.dev.fastreading.ui.base.BaseLifecycleThemedActivity
import com.aliak.dev.fastreading.utils.click
import kotlinx.android.synthetic.main.activity_schulte_description.*

/**
 * @author Aliaksandr Novik
 */
class SchulteDescriptionActivity :
        BaseLifecycleThemedActivity<SchulteDescriptionContract.Presenter>(),
        SchulteDescriptionContract.View {

    override fun initPresenter() = SchulteDescriptionPresenter(this)

    override fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.description)

        schulte_description_5x5_text.click { presenter.click(Button5x5()) }
        schulte_description_6x6_text.click { presenter.click(Button6x6()) }
        schulte_description_7x7_text.click { presenter.click(Button7x7()) }
        schulte_description_8x8_text.click { presenter.click(Button8x8()) }
        schulte_description_start_btn.click { presenter.start(this) }
    }

    override fun getResId(): Int = R.layout.activity_schulte_description

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setSettingsButtonsColorWithAlpha(alpha: Float) {
        schulte_description_5x5_text.setAccentAlphaBackgroundColor(alpha)
        schulte_description_6x6_text.setAccentAlphaBackgroundColor(alpha)
        schulte_description_7x7_text.setAccentAlphaBackgroundColor(alpha)
        schulte_description_8x8_text.setAccentAlphaBackgroundColor(alpha)
    }

    override fun setStartButtonColorWithAlpha(alpha: Float) {
        schulte_description_start_btn.setAccentAlphaBackgroundColor(alpha)
    }

    override fun setSelectedButtonColorWithAlpha(button: SchulteSettingsButton,
                                                 alpha: Float) {
        when (button) {
            is Button5x5 -> schulte_description_5x5_text.setAccentAlphaBackgroundColor(alpha)
            is Button6x6 -> schulte_description_6x6_text.setAccentAlphaBackgroundColor(alpha)
            is Button7x7 -> schulte_description_7x7_text.setAccentAlphaBackgroundColor(alpha)
            is Button8x8 -> schulte_description_8x8_text.setAccentAlphaBackgroundColor(alpha)
        }
    }

}