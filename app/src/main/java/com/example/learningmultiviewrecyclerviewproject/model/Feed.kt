package com.example.learningmultiviewrecyclerviewproject.model

sealed class Feed{
    data class ImagePost(
        val image: Int,
        val description: String,
        val author: String
    ): Feed()
    data class TextPost(
        val author: String,
        val description: String,
        val feeling: String
    ):Feed()
}



