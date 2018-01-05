package com.aliak.dev.fastreading.data

/**
 * @author Aliaksandr Novik
 */
sealed class TrainingModel(val title: String) {
    class SchulteTraining(title: String) : TrainingModel(title)
    class RememberTheNumber(title: String) : TrainingModel(title)
    class LineOfSight(title: String) : TrainingModel(title)
    class SpeedReading(title: String) : TrainingModel(title)
    class WordPairs(title: String) : TrainingModel(title)
    class EvenNumbers(title: String) : TrainingModel(title)
    class GreenDot(title: String) : TrainingModel(title)
}