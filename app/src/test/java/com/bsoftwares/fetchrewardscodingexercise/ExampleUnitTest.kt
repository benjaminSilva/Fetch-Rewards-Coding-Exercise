package com.bsoftwares.fetchrewardscodingexercise

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bsoftwares.fetchrewardscodingexercise.utils.correctDummyList
import com.bsoftwares.fetchrewardscodingexercise.utils.dummyList
import com.bsoftwares.fetchrewardscodingexercise.viewModel.AppViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    private lateinit var viewModel: AppViewModel

    @get:Rule
    var hiltRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = AppViewModel(FakeRepository())
    }


    @Test
    fun `Test organize list` () {
        viewModel.getData()
        viewModel.data.observeForever {
            assertEquals(correctDummyList(), it)
        }
    }
}