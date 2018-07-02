package com.anshulvyas.remote.mapper

import com.anshulvyas.data.model.ProjectEntity
import com.anshulvyas.remote.model.ProjectModel

class ProjectsResponseModelMapper: ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name, model.fullName, model.starCount.toString(),
                model.dateCreated, model.owner.ownerName, model.owner.ownerAvatar)
    }
}