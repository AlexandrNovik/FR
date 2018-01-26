package com.aliak.dev.fastreading.domain.training.schulte

import rx.Observable
import rx.subjects.BehaviorSubject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Aliaksandr Novik
 */
@Singleton
class SchulteManager @Inject constructor() {
    private val stateSubject = BehaviorSubject.create<State>()
    private val actionSubject = BehaviorSubject.create<Action>()

    init {
        actionSubject
                .scan(State(), { state, action -> action.execute(state) })
                .subscribe({ stateSubject.onNext(it) })
    }

    fun pickNumber(pickedNumber: Int) {
        actionSubject.onNext(Action.PickNumberAction(pickedNumber))
    }

    fun observeState() = stateSubject.asObservable()

    fun observePickNumberResult(): Observable<Result> = stateSubject
            .asObservable()
            .map { Result(it.pickedNumber, it.correctPick) }

    data class Result(val number: Int, val correct: Boolean)

    data class State(val nextNumber: Int = 1,
                     val currentNumber: Int = 0,
                     val missCounter: Int = 0,
                     val pickedNumber: Int = 0,
                     val correctPick: Boolean = false)

    abstract sealed class Action {
        abstract fun execute(state: State): State

        class PickNumberAction(private val pickedNumber: Int) : Action() {
            override fun execute(state: State): State {
                return if (state.nextNumber == pickedNumber) {
                    state.copy(
                            nextNumber = pickedNumber + 1,
                            currentNumber = pickedNumber,
                            pickedNumber = pickedNumber,
                            correctPick = true)
                } else {
                    state.copy(
                            missCounter = state.missCounter + 1,
                            pickedNumber = pickedNumber,
                            correctPick = false)
                }
            }
        }

        class ResetAction : Action() {
            override fun execute(state: State): State {
                return State()
            }
        }
    }
}