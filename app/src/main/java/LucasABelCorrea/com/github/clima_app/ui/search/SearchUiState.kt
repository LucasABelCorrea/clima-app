package LucasABelCorrea.com.github.clima_app.ui.search

import LucasABelCorrea.com.github.clima_app.domain.model.City

sealed class SearchUiState {
    data object Idle : SearchUiState()
    data object Loading : SearchUiState()
    data class Success(val cities: List<City>) : SearchUiState()
    data class Error(val message: String) : SearchUiState()
}