package com.anshulvyas.domain.interactor.bookmark

import com.anshulvyas.domain.executor.PostExecutionThread
import com.anshulvyas.domain.interactor.CompletableUseCase
import com.anshulvyas.domain.repository.ProjectsRepository
import io.reactivex.Completable
import javax.inject.Inject

class UnbookmarkProject @Inject constructor(
  private val projectsRepository: ProjectsRepository,
  postExecutionThread: PostExecutionThread)
    :CompletableUseCase<UnbookmarkProject.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.unbookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String) {
        companion object {
            fun forProject(projectId: String): Params {
                return Params(projectId)
            }
        }
    }

}