package com.anshulvyas.remote

import com.anshulvyas.data.model.ProjectEntity
import com.anshulvyas.data.repository.ProjectsRemote
import com.anshulvyas.remote.mapper.ProjectsResponseModelMapper
import com.anshulvyas.remote.service.GithubTrendingService
import io.reactivex.Observable
import javax.inject.Inject


class ProjectsRemoteImpl @Inject constructor(
        private val service: GithubTrendingService,
        private val mapper: ProjectsResponseModelMapper): ProjectsRemote {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
                .map {
                    it.items.map { mapper.mapFromModel(it)}
                }
    }
}