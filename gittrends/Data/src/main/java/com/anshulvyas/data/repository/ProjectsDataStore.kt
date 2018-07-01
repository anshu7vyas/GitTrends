package com.anshulvyas.data.repository

import com.anshulvyas.data.model.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Implemented by CacheDataStore and RemoteDataStore => same data access methods available
 * => for accesssing same data from cache and remote
 */
interface ProjectsDataStore {

    fun getProjects(): Observable<List<ProjectEntity>>

    fun saveProjects(projects: List<ProjectEntity>): Completable

    fun clearProjects(): Completable

    fun getBookmarkedProjects(): Observable<List<ProjectEntity>>

    fun setProjectAsBookmarked(projectId: String): Completable

    fun setProjectAsNotBookmarked(projectId: String): Completable
}