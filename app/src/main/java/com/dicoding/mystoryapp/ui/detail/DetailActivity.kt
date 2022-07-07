package com.dicoding.mystoryapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.mystoryapp.data.response.ListStoryItem
import com.dicoding.mystoryapp.databinding.ActivityDetailBinding
import com.dicoding.mystoryapp.utils.setLocalDateFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Story Detail"

        val story = intent.getParcelableExtra<ListStoryItem>(EXTRA_STORY)
        binding.apply {
            txUsername.text = story?.name
            txCreatedAt.setLocalDateFormat(story?.createdAt.toString())
            txDescription.text = story?.description
        }
        Glide.with(this)
            .load(story?.photoUrl)
            .into(binding.imgAvatar)
    }

    companion object {
        const val EXTRA_STORY = "extra_story"
    }
}