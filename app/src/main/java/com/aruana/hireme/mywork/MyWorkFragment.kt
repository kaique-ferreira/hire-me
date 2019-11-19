package com.aruana.hireme.mywork

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.aruana.hireme.R
import com.aruana.hireme.di.createWorkViewModel
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.job_card.view.*
import kotlinx.android.synthetic.main.mywork_fragment.*

const val ADIDAS_POSITION = 0
const val DISNEY_POSITION = 1
const val QUIZLET_POSITION = 2

class MyWorkFragment : Fragment() {

    private lateinit var viewModel: MyWorkViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = createWorkViewModel()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mywork_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().findViewById<AppBarLayout>(R.id.app_bar).apply {
            setExpanded(false)
        }

        //TODO replace with a recycler view
        setUpCards()
    }

    private fun setUpCards() {
        viewModel.workExperienceList.observe(this, Observer { workList ->
            workList.forEachIndexed { index, workExperienceItem -> fillCard(index, workExperienceItem) }
        })
    }

    private fun fillCard(position: Int, workExperienceItem: WorkExperienceItem) {
        val cardView =
                when (position) {
                    ADIDAS_POSITION -> adidasCardView
                    DISNEY_POSITION -> disneyCardView
                    QUIZLET_POSITION -> quizletCardView
                    else -> null
                }

        cardView?.let { jobCardView ->
            jobCardView.jobTitle?.text = "${workExperienceItem.companyName} - ${workExperienceItem.title}"
            jobCardView.jobImage?.setImageResource(workExperienceItem.image)
            jobCardView.jobImage?.transitionName = workExperienceItem.companyName

            jobCardView.setOnClickListener {
                viewModel.selectItem(position)
                navigateWithTransition(it)
            }
        }
    }

    private fun navigateWithTransition(view: View) {
        with(view.jobImage) {
            val transitionName = this.transitionName
            val extras = FragmentNavigatorExtras(
                    this to transitionName
            )

            val action = MyWorkFragmentDirections.actionMyworkDestToMyWorkDetailFragment(this.transitionName)
            findNavController().navigate(action, extras)
        }
    }
}