package com.anshulvyas.domain.interactor

import com.anshulvyas.domain.executor.PostExecutionThread
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCase<T, in Params> constructor(
        private val postExecutionThread: PostExecutionThread) {

    protected abstract fun buildUseCaseObservable(param: Params? = null): Observable<T>

    private val disposables = CompositeDisposable()

    open fun execute (observer: DisposableObserver<T>, params: Params? = null ) {
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)   //only accessing the abstraction

        addDisposable(observable.subscribeWith(observer))
    }

    // way to unsubscribe from the use case
    fun dispose() {
        disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}