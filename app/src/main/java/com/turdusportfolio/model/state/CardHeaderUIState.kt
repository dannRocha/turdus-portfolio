package com.turdusportfolio.model.state

data class CardHeaderUIState(
    val open: Boolean = false,
    val options: List<RadioChooseButtonUIState>
)