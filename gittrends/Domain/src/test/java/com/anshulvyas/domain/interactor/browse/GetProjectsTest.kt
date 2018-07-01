package com.anshulvyas.domain.interactor.browse

import com.anshulvyas.domain.executor.PostExecutionThread
import com.anshulvyas.domain.model.Project
import com.anshulvyas.domain.repository.ProjectsRepository
import com.anshulvyas.domain.test.ProjectDataFactory
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations



class GetProjectsTest {

    // initialize once mocks are injected
    private lateinit var getProjects: GetProjects
    // controls the results which were returned to any of these classes
    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getProjects = GetProjects(projectsRepository, postExecutionThread)
    }

    // need to make sure that getProjects call completes, because it is interacting with the projectRepository
    @Test
    fun getProjectsCompletes() {

        // mock the results from the repository call
        stubGetProjects(Observable.just(ProjectDataFactory.makeProjectList(2)))

        // allows to check observer state for testing
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    // to test whether expected data is returned by the call
    @Test
    fun getProjectsReturnsData() {
        val projects = ProjectDataFactory.makeProjectList(2)
        // mock the results from the repository call
        stubGetProjects(Observable.just(projects))

        // allows to check observer state for testing
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertValue(projects)
    }

    // Handles mocking of Observable return using Mockito's whenever function
    private fun stubGetProjects(observable: Observable<List<Project>>) {
        whenever(projectsRepository.getProjects())
                .thenReturn(observable)
    }

}