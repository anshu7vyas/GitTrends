package com.anshulvyas.data.store

import com.anshulvyas.data.repository.ProjectsDataStore
import javax.inject.Inject

/**
 * Decision handling for which data store needed by Data Repository
 */
open class ProjectsDataStoreFactory @Inject constructor(
        private val projectsCacheDataStore: ProjectsCacheDataStore,
        private val projectsRemoteDataStore: ProjectsRemoteDataStore) {

    open fun getDataStore(projectsCached: Boolean,
                          cacheExpired: Boolean): ProjectsDataStore {
        return if (projectsCached &&  !cacheExpired) {
            projectsCacheDataStore
        } else {
            projectsRemoteDataStore
        }
    }

    // times when we always have to use the cache data store => for saving or retrieving of projects
    open fun getCachedDataStore(): ProjectsDataStore {
        return projectsCacheDataStore
    }
}