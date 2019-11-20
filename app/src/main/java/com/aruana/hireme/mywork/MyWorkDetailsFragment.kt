package com.aruana.hireme.mywork

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.aruana.hireme.R
import com.aruana.hireme.di.createWorkViewModel
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.mywork_detail_fragment.*

class MyWorkDetailsFragment : Fragment() {

    private lateinit var viewModel: MyWorkViewModel
    private val args: MyWorkDetailsFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mywork_detail_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = createWorkViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().findViewById<AppBarLayout>(R.id.app_bar).apply {
            setExpanded(false)
        }

        jobImage.transitionName = args.transitionName

        viewModel.selectedWorkExperienceItem.observe(this, Observer {
            jobImage.setImageResource(it.image)
            jobTitle.text = it.title
            jobDescription.text = it.description
            jobCompany.text = it.companyName
            googlePlayLink.text = it.googlePlayLink
        })
    }
}