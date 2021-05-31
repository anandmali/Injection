package com.anandmali.manual_injection.network.model

data class SearchModel(
    var total_count: Int = 0,
    var incomplete_results: Boolean = false,
    val items: List<RepoModel> = emptyList()
)