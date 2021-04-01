package com.anandm.injection.network.model

data class SearchModel(
    var total_count: Int = 0,
    var incomplete_results: Boolean = false
)