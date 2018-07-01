package com.anshulvyas.domain.test

import com.anshulvyas.domain.model.Project
import java.util.*

object ProjectDataFactory {

    // Generic data types
    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }

    // returns a project instance with random
    fun makeProject(): Project {
        return Project(randomUuid(), randomUuid(), randomUuid(),
                randomUuid(), randomUuid(), randomUuid(),
                randomUuid(), randomBoolean())
    }

    // returns List of projects with a size of our choosing
    fun makeProjectList(count: Int): List<Project> {
        val projects = mutableListOf<Project>()
        repeat(count) {
            projects.add(makeProject())
        }
        return projects
    }
}