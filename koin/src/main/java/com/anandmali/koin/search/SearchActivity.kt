package com.anandmali.koin.search

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.anandmali.koin.R

import com.anandmali.koin.databinding.ActivitySearchBinding
import com.anandmali.koin.network.Status
import com.anandmali.koin.network.model.RepoModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : AppCompatActivity() {

    private val viewModel by viewModel<SearchViewModel>()

    private var binding: ActivitySearchBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        observeSearchStatus()
    }

    private fun observeSearchStatus() {
        viewModel.getSearchStatus().observe(this, {
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