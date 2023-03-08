package com.shah.myapplication.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.shah.myapplication.BaseApplication
import com.shah.myapplication.databinding.FragmentMedicalDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MedicineDetailsFragment : Fragment(){

    private lateinit var binding: FragmentMedicalDetailsBinding
    private lateinit var navController: NavController
    @Inject
    lateinit var context: BaseApplication

    private val args : MedicineDetailsFragmentArgs by navArgs()

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMedicalDetailsBinding.inflate(inflater, container, false)
        initializeComponents()
        return binding.root
    }

    private fun initializeComponents() {
        binding.imgGoBack.setOnClickListener {
            navController.popBackStack()
        }

        binding.tvMedicineDose.text = args.obj.dose
        binding.tvMedicineStrength.text = args.obj.strength
        binding.tvMedicineName.text = args.obj.name

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController(view)
    }

}