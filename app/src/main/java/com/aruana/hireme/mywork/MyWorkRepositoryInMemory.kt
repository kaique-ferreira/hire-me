package com.aruana.hireme.mywork

import com.aruana.hireme.R
import javax.inject.Inject

class MyWorkRepositoryInMemory @Inject constructor() : MyWorkRepository {

    private val workExperienceList: List<WorkExperienceItem> = listOf(
            WorkExperienceItem(companyName = "Adidas", title = "Software Engineer", description = "to be written", image = R.drawable.adidas),
            WorkExperienceItem(companyName = "Disney", title = "Software Engineer", description = "to be written", image = R.drawable.disney),
            WorkExperienceItem(companyName = "Quizlet", title = "Software Engineer", description = "to be written", image = R.drawable.quizlet)
    )

    override fun getAllWorkExperience(): List<WorkExperienceItem> {
        return workExperienceList
    }
}