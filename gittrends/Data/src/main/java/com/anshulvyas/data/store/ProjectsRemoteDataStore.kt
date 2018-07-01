package com.anshulvyas.data.store

import com.anshulvyas.data.model.ProjectEntity
import com.anshulvyas.data.repository.ProjectsDataStore
import com.anshulvyas.data.repository.ProjectsRemote
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Advantage: Remote and Cache layer functions in the data layer
 * Data layer handles the implementation of the abstract methods in one place,
 * even if they are not supported by outside layers
 */
class ProjectsRemoteDataStore @Inject constructor(
        private val projectsRemote: ProjectsRemote): ProjectsDataStore {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsRemote.getProjects()
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        throw UnsupportedOperationException("Saving projects isn't supported here...")
    }

    override fun clearProjects(): Completable {
        throw UnsupportedOperationException("Clearing projects isn't supported here...")
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        throw UnsupportedOperationException("Getting bookmarked projects isn't supported here...")
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Setting bookmarked projects isn't supported here...")
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Setting projects as not bookmarked isn't supported here...")
    }
}