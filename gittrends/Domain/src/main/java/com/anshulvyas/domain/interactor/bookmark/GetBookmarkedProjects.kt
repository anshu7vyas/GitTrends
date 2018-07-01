package com.anshulvyas.domain.interactor.bookmark

import com.anshulvyas.domain.executor.PostExecutionThread
import com.anshulvyas.domain.interactor.ObservableUseCase
import com.anshulvyas.domain.model.Project
import com.anshulvyas.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBookmarkedProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing>(postExecutionThread) {

    override fun buildUseCaseObservable(param: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }
}