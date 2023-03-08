package com.shah.myapplication.fragment

import android.annotation.SuppressLint
import androidx.navigation.Navigation.findNavController
import androidx.navigation.NavController
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment


class NewFragmentDemo : Fragment() {
    //private var binding: FragmentNewDemoBinding? = null
    private var navController: NavController? = null
    @SuppressLint("SetJavaScriptEnabled")
    /*override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       *//* binding = FragmentNewDemoBinding.inflate(inflater, container, false)
        binding?.customToolbar?.title?.text = resources.getString(R.string.change_text)
        binding?.customToolbar?.imgBackArrow?.setOnClickListener { e: View? -> navController?.popBackStack() }
        return binding?.root*//*
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController(view)
    }
}