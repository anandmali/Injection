package com.anandm.injection.repolist

import android.os.Bundle
import com.anandm.injection.R
import com.anandm.injection.di.ActivityScoped
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScoped
class MainActivity : DaggerAppCompatActivity(), RepoContract.View {

    @Inject
    lateinit var repoPresenterImpl: RepoPresenterImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = repoPresenterImpl.something()
    }
}