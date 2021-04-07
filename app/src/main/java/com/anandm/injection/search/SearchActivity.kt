package com.anandm.injection.search

import android.os.Bundle
import com.anandm.injection.R
import com.anandm.injection.di.ActivityScoped
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScoped
class SearchActivity : DaggerAppCompatActivity(), SearchContract.View {

    @Inject
    lateinit var searchPresenterImpl: SearchPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchPresenterImpl.fetchValue()
    }

    override fun showMessage(message: String) {
        textView.text = message
    }

    override fun onDestroy() {
        searchPresenterImpl.onDestroy()
        super.onDestroy()
    }
}