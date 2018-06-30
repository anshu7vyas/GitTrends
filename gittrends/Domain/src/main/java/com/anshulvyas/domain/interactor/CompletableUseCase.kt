package com.anshulvyas.domain.interactor

import com.anshulvyas.domain.executor.PostExecutionThread
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<T, in Params> constructor(
        private val postExecutionThread: PostExecutionThread) {

    protected abstract fun buildUseCaseObservable(param: Params? = null): Completable

    private val disposables = CompositeDisposable()

    open fun execute (observer: DisposableCompletableObserver, params: Params? = null ) {
        val completable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)   //only accessing the abstraction

        addDisposable(completable.subscribeWith(observer))
    }

    // way to unsubscribe from the use case
    fun dispose() {
        disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}