package com.shah.myapplication.fragment

import android.annotation.SuppressLint
import androidx.navigation.Navigation.findNavController
import androidx.navigation.NavController
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shah.myapplication.BaseApplication
import com.shah.myapplication.R
import com.shah.myapplication.databinding.FragmentLoginBinding
import com.shah.myapplication.model.Profile
import com.shah.myapplication.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController
    @Inject
    lateinit var context: BaseApplication

    @OptIn(ExperimentalCoroutinesApi::class)
    private val viewModel: HomeViewModel by viewModels()

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        initializeComponents()
        return binding.root
    }

    /**
     * method to initialize components.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    private fun initializeComponents() {
        binding.btnLogin.setOnClickListener {
            if (binding.etEmail.text.toString().isNotEmpty() && binding.etPassword.text.toString().isNotEmpty()){
                val profile= Profile()
                profile.email = binding.etEmail.text.toString()
                profile.password = binding.etPassword.text.toString()
                viewModel.insertProfile(profile)
                val bundle = bundleOf("name" to binding.etEmail.text.toString())
                navController.navigate(R.id.action_loginFragment_to_homeFragment,bundle)
            }else{
                Toast.makeText(context, R.string.empty_values_are_not_accepted,Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController(view)
    }
}