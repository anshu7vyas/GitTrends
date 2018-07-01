package com.anshulvyas.data.mapper

import com.anshulvyas.data.model.ProjectEntity
import com.anshulvyas.domain.model.Project
import javax.inject.Inject

/**
 * implementation of Mapper class for Project data object to and from the domain layer
 */
class ProjectMapper @Inject constructor() : EntityMapper<ProjectEntity, Project> {

    override fun mapFromEntity(entity: ProjectEntity): Project {
        return Project(entity.id, entity.name, entity.fullName, entity.starCount,
                entity.dateCreated, entity.ownerName, entity.ownerAvatar)
    }

    override fun mapToEntity(domain: Project): ProjectEntity {
        return ProjectEntity(domain.id, domain.name, domain.fullName, domain.starCount,
                domain.dateCreated, domain.ownerName, domain.ownerAvatar)
    }
}