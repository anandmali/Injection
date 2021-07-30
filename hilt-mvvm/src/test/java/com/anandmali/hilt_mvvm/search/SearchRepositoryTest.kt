package com.anandmali.hilt_mvvm.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anandmali.hilt_mvvm.MainCoroutineRule
import com.anandmali.hilt_mvvm.network.GithubService
import com.anandmali.hilt_mvvm.network.SearchRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchRepositoryTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @JvmField
    @Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var githubService: GithubService

    private lateinit var cut: SearchRepository

    @Before
    fun setUp() {
        cut = SearchRepository(githubService)
    }

    @Test
    fun `When execute then returns expected Repository List`() {
        runBlocking {

            whenever(githubService.getRepositories()).thenReturn(mock())

            cut.fetchValues(mock(), mock())

            // Then
            verify(githubService, times(1)).getRepositories()

        }
    }
}