package com.anshulvyas.domain.interactor.browse

import com.anshulvyas.domain.executor.PostExecutionThread
import com.anshulvyas.domain.interactor.ObservableUseCase
import com.anshulvyas.domain.model.Project
import com.anshulvyas.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject


/**
 * Required operations for applications
 * 2 params: ProjectRepository - abstracted access point to outside data layers
 *           instance of postExecutionThread - inherited base class use case
 *
 * return instance of RxObservable class
 */
class GetProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing>(postExecutionThread) {

    // no mapping of modules here, as the domain layer is the central layer
    public override fun buildUseCaseObservable(param: Nothing?): Observable<List<Project>> {
        return projectsRepository.getProjects()
    }
}