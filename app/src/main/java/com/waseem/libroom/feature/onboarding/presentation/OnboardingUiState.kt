package com.waseem.libroom.feature.onboarding.presentation

import androidx.annotation.DrawableRes
import com.waseem.libroom.R

data class OnboardingUiState(
    val currentStep: Int = 0,
    val pages: List<PageUiState> = listOf(
        PageUiState(
            title = "Explore Thousands of Books",
            description = "Dive into a world of endless possibilities.\n" +
                    "Browse through our vast collection of books, spanning genres and topics.",
            image = R.drawable.img_onboard_1
        ),
        PageUiState(
            title = "Create Your Reading Haven",
            description = "Personalize your reading experience by adding books to your favorites. With just a tap, build a library of books that speak to you.",
            image = R.drawable.img_onboard_2
        ),
        PageUiState(
            title = "Read or Listen, Your Choice!",
            description = "Enjoy the flexibility of reading or listening to your favorite books. Whether you prefer the tactile sensation of turning pages or the convenience of audiobooks.",
            image = R.drawable.img_onboard_3
        )
    )
) {
    val isLastStep: Boolean
        get() = currentStep == pages.size - 1
}

data class PageUiState(
    val title: String = "",
    val description: String = "",
    @DrawableRes val image: Int = 0,
)