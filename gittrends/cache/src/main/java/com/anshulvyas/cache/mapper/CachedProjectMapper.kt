package com.anshulvyas.cache.mapper

import com.anshulvyas.cache.model.CachedProject
import com.anshulvyas.data.model.ProjectEntity

class CachedProjectMapper: CacheMapper<CachedProject, ProjectEntity> {

    override fun mapFromCached(type: CachedProject): ProjectEntity {
        return ProjectEntity(type.id, type.name, type.fullName, type.starCount,
                type.dateCreated, type.ownerName, type.ownerAvatar, type.isBookmarked)
    }

    override fun mapToCached(type: ProjectEntity): CachedProject {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
        return CachedProject(type.id, type.name, type.fullName, type.starCount,
                type.dateCreated, type.ownerName, type.ownerAvatar, type.isBookmarked)
    }
}
