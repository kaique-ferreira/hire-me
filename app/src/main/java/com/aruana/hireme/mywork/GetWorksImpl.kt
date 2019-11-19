package com.aruana.hireme.mywork

import javax.inject.Inject

class GetWorksImpl @Inject constructor(private val repository: MyWorkRepository) : GetWorks {

    override fun invoke(): List<WorkExperienceItem> {
        return repository.getAllWorkExperience()
    }
}