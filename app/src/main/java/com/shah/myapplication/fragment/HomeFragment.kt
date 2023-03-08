package com.shah.myapplication.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.shah.myapplication.BaseApplication
import com.shah.myapplication.adapter.MedicineAdapter
import com.shah.myapplication.databinding.FragmentHomeBinding
import com.shah.myapplication.model.MedicationItem
import com.shah.myapplication.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(),MedicineAdapter.OnMyOwnClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    @OptIn(ExperimentalCoroutinesApi::class)
    private val viewModel: HomeViewModel by viewModels()
    @Inject
    lateinit var context: BaseApplication

    private lateinit var adapter:MedicineAdapter
    private lateinit var list:List<MedicationItem>

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initializeComponents()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    @OptIn(ExperimentalCoroutinesApi::class)
    private fun initializeComponents() {
        viewModel.medicationListLive.observe(viewLifecycleOwner){
            list = it
            adapter = MedicineAdapter(context,it, this)
            binding.rvMedication.layoutManager = GridLayoutManager(requireContext(), 1)
            binding.rvMedication.setHasFixedSize(true)
            binding.rvMedication.adapter = adapter
        }

        viewModel.loadingLive.observe(viewLifecycleOwner){
            if(it){
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.GONE
            }
        }

        if(arguments!=null){
            val email = requireArguments().getString("name").toString()
            binding.tvGreeting.text = getGreetingMessage()+" $email"
        }
        /*binding.tvGreeting.text = getGreetingMessage()+" "
    */
    }

    private fun getGreetingMessage():String{
        val c = Calendar.getInstance()

        return when (c.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Good Morning"
            in 12..15 -> "Good Afternoon"
            in 16..20 -> "Good Evening"
            in 21..23 -> "Good Night"
            else -> "Hello"
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController(view)
    }

    override fun onMyOwnClick(position: Int) {
        val obj = list[position]
        navController.navigate(HomeFragmentDirections.actionHomeFragmentToMedicineDetailsFragment(obj))
    }
}