package com.jorge.app_api_tmdb_flix.presentation.auth.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.jorge.app_api_tmdb_flix.R
import com.jorge.app_api_tmdb_flix.databinding.FragmentLoginBinding
import com.jorge.app_api_tmdb_flix.presentation.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    //private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tilEmail.requestFocus()
        setupListeners()


    }

    private fun setupListeners() {
        binding.txtNovoCadastro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


        binding.btnLogin.setOnClickListener {

            val email = binding.tieEmail.text.toString()
            val senha = binding.tieSenha.text.toString()

            when {
                email.isEmpty() -> {
                    getErroImputLayout(binding.tilEmail, getString(R.string.preencha_o_email))
                }

                senha.isEmpty() -> {
                    getErroImputLayout(binding.tilSenha, getString(R.string.preencha_a_senha))
                }
                else -> {
                    val intent = Intent(requireContext(), HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun getErroImputLayout(inputLayout: TextInputLayout, msg: String) {
        inputLayout.helperText = null
        inputLayout.helperText = msg
        inputLayout.boxStrokeColor = Color.parseColor("#FF9800")
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}