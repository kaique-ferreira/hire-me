package com.aruana.hireme.mywork

import com.aruana.hireme.R
import javax.inject.Inject

class MyWorkRepositoryInMemory @Inject constructor() : MyWorkRepository {

    private val workExperienceList: List<WorkExperienceItem> = listOf(
            WorkExperienceItem(companyName = "Adidas",
                    title = "Software Engineer",
                    description = "● Working mainly on releasing the Adidas App into new markets\n" +
                            "● A remarkable work was creating a set of reusable components to be used across all Adidas\n" +
                            "apps and speed up the development of custom feature for specific markets",
                    image = R.drawable.adidas,
                    googlePlayLink = "https://play.google.com/store/apps/details?id=com.adidas.app"),
            WorkExperienceItem(companyName = "Disney",
                    title = "Software Engineer",
                    description = "● The work consisted of completely rewriting from scratch their client app for Disney ABC streaming service",
                    image = R.drawable.disney,
                    googlePlayLink = "https://play.google.com/store/apps/details?id=com.disney.datg.videoplatforms.android.abc&hl=en_ US"),
            WorkExperienceItem(companyName = "Quizlet",
                    title = "Software Engineer",
                    description = "● Working mainly on improving monetization features on Quizlet Android app\n" +
                            "● A remarkable work was creating an a/b test structure to allow better understanding of the\n" +
                            "newly implemented flows",
                    image = R.drawable.quizlet,
                    googlePlayLink = "https://play.google.com/store/apps/details?id=com.quizlet.quizletandroid")
    )

    override fun getAllWorkExperience(): List<WorkExperienceItem> {
        return workExperienceList
    }
}