package com.anshulvyas.domain.repository

import com.anshulvyas.domain.model.Project
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Abstraction for use-cases in domain layer
 * Contract and enforcement by domain layer to other data layer implementations
 *
 * Actual implementation of interface will be injected from the data layer
 */
interface ProjectsRepository {

    fun getProjects(): Observable<List<Project>>

    fun bookmarkProject(projectId: String): Completable

    fun unbookmarkProject(projectId: String): Completable

    fun getBookmarkedProjects(): Observable<List<Project>>
}