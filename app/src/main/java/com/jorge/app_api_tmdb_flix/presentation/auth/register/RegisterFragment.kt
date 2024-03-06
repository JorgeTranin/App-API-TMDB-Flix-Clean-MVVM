package com.jorge.app_api_tmdb_flix.presentation.auth.register

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.jorge.app_api_tmdb_flix.R
import com.jorge.app_api_tmdb_flix.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etEmail.requestFocus()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnCadastrarEmail.setOnClickListener {
            val email = binding.etEmail.text.toString()
            if (email.isEmpty()) {

                getErroImputLayout(binding.tilEmail, getString(R.string.preencha_o_email))
            }
        }
    }

    private fun getErroImputLayout(inputLayout: TextInputLayout, msg: String) {
        inputLayout.helperText = null
        inputLayout.helperText = msg
        inputLayout.boxStrokeColor = Color.parseColor("#FF0000")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}