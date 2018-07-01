package com.anshulvyas.data.repository

import com.anshulvyas.data.model.ProjectEntity
import io.reactivex.Observable

/**
 * Collections of remote functions
 */
interface ProjectsRemote {

    fun getProjects(): Observable<List<ProjectEntity>>
}