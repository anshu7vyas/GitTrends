package com.anshulvyas.data.repository

import com.anshulvyas.data.model.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Collection of cache functions for the cache module, passes responsibility to the cache layer
 */
interface ProjectsCache {

    // way to clear the cache
    fun clearProjects(): Completable

    fun saveProjects(projects: List<ProjectEntity>): Completable

    fun getProjects(): Observable<List<ProjectEntity>>

    fun getBookmarkedProjects(): Observable<List<ProjectEntity>>

    fun setProjectAsBookmarked(projectId: String): Completable

    fun setProjectAsNotBookmarked(projectId: String): Completable

    // cache information related methods
    fun areProjectsCached(): Single<Boolean>

    fun setLastCacheTime(lastCache: Long): Completable

    // means we need to fetch new data
    fun isProjectsCacheExpired(): Single<Boolean>
}