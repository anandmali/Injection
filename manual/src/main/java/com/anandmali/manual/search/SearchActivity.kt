package com.anandmali.manual.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.anandmali.manual.R
import com.anandmali.manual.databinding.ActivitySearchBinding
import com.anandmali.manual.di.Injector
import com.anandmali.manual.network.model.RepoModel

class SearchActivity : AppCompatActivity(), SearchContract.View {

    private val searchPresenterImpl: SearchPresenterImpl by lazy {
        Injector.searchPresenter(this)
    }

    private var binding: ActivitySearchBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        searchPresenterImpl.fetchValue()
    }

    override fun updateList(list: List<RepoModel>) {
        val repoListAdapter = RepoListAdapter(list)
        binding?.list?.apply {
            adapter = repoListAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
        }
    }

    override fun onDestroy() {
        searchPresenterImpl.onDestroy()
        super.onDestroy()
    }
}