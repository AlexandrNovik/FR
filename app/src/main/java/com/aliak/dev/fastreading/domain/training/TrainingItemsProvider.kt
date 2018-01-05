package com.aliak.dev.fastreading.domain.training

import android.content.Context
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.data.TrainingModel.*
import javax.inject.Inject

/**
 * @author Aliaksandr Novik
 */
class TrainingItemsProvider @Inject constructor() {
    fun provideItems(context: Context) = mutableListOf(
            SchulteTraining(context.getString(R.string.lbl_schulte)),
            RememberTheNumber(context.getString(R.string.lbl_remember_the_number)),
            LineOfSight(context.getString(R.string.lbl_line_of_sight)),
            SpeedReading(context.getString(R.string.lbl_speed_reading)),
            WordPairs(context.getString(R.string.lbl_word_pairs)),
            EvenNumbers(context.getString(R.string.lbl_even_numbers)),
            GreenDot(context.getString(R.string.lbl_green_dot))
    )

}