package com.anandm.injection.search

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anandm.injection.R
import com.anandm.injection.databinding.ActivitySearchBinding
import com.anandm.injection.di.ActivityScoped
import com.anandm.injection.di.AppViewModelFactory
import com.anandm.injection.network.Status
import com.anandm.injection.network.model.RepoModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

@ActivityScoped
class SearchActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: AppViewModelFactory

    private var binding: ActivitySearchBinding? = null

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        searchViewModel = ViewModelProvider(this, factory).get(SearchViewModel::class.java)

        observeSearchStatus()

    }

    private fun observeSearchStatus() {
        searchViewModel.getSearchStatus().observe(this, {
            it?.let {
                when (it) {
                    is Status.Success -> updateList(it.data)
                    else -> Log.e("Some error", "else part")
                }
            }
        })
    }

    private fun updateList(list: List<RepoModel>) {
        val repoListAdapter = RepoListAdapter(list)
        binding?.list?.apply {
            adapter = repoListAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
        }
    }
}