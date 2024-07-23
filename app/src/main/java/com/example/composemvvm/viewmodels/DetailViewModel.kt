package com.example.composemvvm.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemvvm.models.TweetListItem
import com.example.composemvvm.repository.TweetRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class DetailViewModel@Inject constructor(private val repository: TweetRepository,private val savedStateHandle: SavedStateHandle):ViewModel() {

    val tweets :StateFlow<List<TweetListItem>>
        get() = repository.tweets
    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category")?:"motivation"
            repository.getTweets(category)
        }
    }
}