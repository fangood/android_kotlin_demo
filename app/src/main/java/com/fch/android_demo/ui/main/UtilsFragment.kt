package com.fch.android_demo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fch.android_demo.R
import com.fch.android_demo.recyclerview.CustomAdapter

/**
 * 工具类
 */
class UtilsFragment: Fragment() {

    private lateinit var dataSet:Array<String>
    private lateinit var recyclerView: RecyclerView
    private lateinit var pageViewModel: PageViewModel
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
        initDataset()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_utils, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        recyclerView = root.findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = CustomAdapter(dataSet)
        pageViewModel.text.observe(viewLifecycleOwner, Observer<String> {
            textView.text = it
        })
        return root
    }
    private fun initDataset() {
        dataSet = arrayOf("1、获取进程名称")
    }


    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): UtilsFragment {
            return UtilsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}