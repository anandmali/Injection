package com.anandmali.dagger_mvp.network.model

import com.anandmali.dagger_mvp.network.model.RepoModel

data class SearchModel(
    var total_count: Int = 0,
    var incomplete_results: Boolean = false,
    val items: List<RepoModel> = emptyList()
)