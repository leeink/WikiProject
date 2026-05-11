package com.example.wikiapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel: ViewModel() {
    private val _profile = MutableStateFlow(ProfileUiState())
    val profile: StateFlow<ProfileUiState> = _profile.asStateFlow()

    fun updateProfile(name: String, job: String, email: String, location: String) {
        _profile.update {
            it.copy(
                name = name,
                job = job,
                email = email,
                location = location
            )
        }
    }
}