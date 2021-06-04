package com.anandmali.hilt_mvvm.search

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.anandmali.hilt_mvvm.R
import com.anandmali.hilt_mvvm.databinding.ActivitySearchBinding
import com.anandmali.hilt_mvvm.network.Status

import com.anandmali.hilt_mvvm.network.model.RepoModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val viewModel: SearchViewModel by viewModels()

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