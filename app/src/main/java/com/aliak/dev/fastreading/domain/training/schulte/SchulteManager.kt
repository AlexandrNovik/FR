package com.aliak.dev.fastreading.domain.training.schulte

import com.aliak.dev.fastreading.domain.AppSharedPreferences
import rx.Observable
import rx.subjects.BehaviorSubject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Aliaksandr Novik
 */
@Singleton
class SchulteManager @Inject constructor(private var preferences: AppSharedPreferences) {
    private val stateSubject = BehaviorSubject.create<State>()
    private val actionSubject = BehaviorSubject.create<Action>()

    init {
        actionSubject
                .scan(State(), { state, action -> action.execute(state) })
                .subscribe({ stateSubject.onNext(it) })

        observeFinish().subscribe { reset() }
    }

    fun pickNumber(pickedNumber: Int) {
        actionSubject.onNext(PickNumberAction(pickedNumber))
    }

    fun observeState(): Observable<State> = stateSubject.asObservable()

    fun observeFinish(): Observable<State> = observeState().filter { it.final }

    fun observePickNumberResult(): Observable<Result> = stateSubject
            .asObservable()
            .map { Result(it.pickedNumber, it.correctPick) }

    fun reset() {
        actionSubject.onNext(ResetAction())
    }

    private fun State.isFinal() = this.nextNumber >=
            Math.pow(preferences.getSchulteTableValue().toDouble(), 2.toDouble())

    data class Result(val number: Int, val correct: Boolean)

    data class State(val nextNumber: Int = 1,
                     val currentNumber: Int = 0,
                     val missCounter: Int = 0,
                     val pickedNumber: Int = 0,
                     val correctPick: Boolean = false,
                     val final: Boolean = false)

    private interface Action {
        fun execute(state: State): State
    }

    private inner class PickNumberAction(private val pickedNumber: Int) : Action {
        override fun execute(state: State): State {
            return if (state.nextNumber == pickedNumber) {
                state.copy(
                        nextNumber = pickedNumber + 1,
                        currentNumber = pickedNumber,
                        pickedNumber = pickedNumber,
                        correctPick = true,
                        final = state.isFinal())
            } else {
                state.copy(
                        missCounter = state.missCounter + 1,
                        pickedNumber = pickedNumber,
                        correctPick = false)
            }
        }
    }

    private inner class ResetAction : Action {
        override fun execute(state: State): State {
            return State()
        }
    }
}