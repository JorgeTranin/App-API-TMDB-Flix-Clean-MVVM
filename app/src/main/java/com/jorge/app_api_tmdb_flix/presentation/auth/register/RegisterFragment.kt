package com.jorge.app_api_tmdb_flix.presentation.auth.register

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.textfield.TextInputLayout
import com.jorge.app_api_tmdb_flix.R
import com.jorge.app_api_tmdb_flix.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by viewModels()
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
            //binding.tilEmail.setHelperTextColor()
            val email = binding.etEmail.text.toString()
            if (email.isEmpty()) {
                getErroImputLayout(binding.tilEmail, getString(R.string.preencha_o_email))
            }else{
                setViewVisibiliti()
            }
        }
    }

    private fun setViewVisibiliti() {
        binding.containerTitles.isVisible = true
        binding.tilSenha.isVisible = true
        binding.btnCadastrarUser.isVisible = true
        binding.btnCadastrarEmail.isVisible = false
        binding.btnCadastrarEmail.text = "Cadastrar"
        binding.txtTitle.text = "Um mundo de Séries e filmes espera por você"
        binding.textInfo.text = "Crie uma conta para saber mais sobre o App"
    }

    private fun getErroImputLayout(inputLayout: TextInputLayout, msg: String) {
        inputLayout.helperText = msg
        inputLayout.boxStrokeColor = Color.parseColor("#FF0000")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}