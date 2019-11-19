package com.aruana.hireme.mywork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MyWorkViewModel @Inject constructor(getWorks: GetWorks) : ViewModel() {

    private val _workExperienceList = MutableLiveData<List<WorkExperienceItem>>()
    val workExperienceList: LiveData<List<WorkExperienceItem>> get() = _workExperienceList

    private val _selectedWorkExperienceItem = MutableLiveData<WorkExperienceItem>()
    val selectedWorkExperienceItem: LiveData<WorkExperienceItem> get() = _selectedWorkExperienceItem

    init {
        _workExperienceList.value = getWorks.invoke()
    }

    fun selectItem(position: Int) {
        if (_workExperienceList.value.isNullOrEmpty()) {
            return
        }

        _selectedWorkExperienceItem.value = (_workExperienceList.value as List<WorkExperienceItem>)[position]
    }
}