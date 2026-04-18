package com.barbeariapremium.app.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.barbeariapremium.app.R
import com.barbeariapremium.app.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSchedule.setOnClickListener {
            // Since you are using Compose Navigation, you should probably be 
            // navigating using the NavController from MainActivity or 
            // a shared component. For now, I'll comment this out or 
            // you can handle navigation manually if this Fragment is still used.
        }

        binding.btnServices.setOnClickListener {
            // Navigate to services
        }

        binding.btnLogin.setOnClickListener {
            // Navigate to login
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
