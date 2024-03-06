package com.jorge.app_api_tmdb_flix.presentation.auth.login

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jorge.app_api_tmdb_flix.R
import com.jorge.app_api_tmdb_flix.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
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

        }


        binding.btnLogin.setOnClickListener {
            binding.tilEmail.helperText = null
            binding.tilSenha.helperText = null

            val email = binding.tieEmail.text.toString()
            val senha = binding.tieSenha.text.toString()

            when {
                email.isEmpty() -> {
                    binding.tilEmail.helperText = getString(R.string.preencha_o_email)
                    binding.tilEmail.boxStrokeColor = Color.parseColor("#FF9800")
                }

                senha.isEmpty() -> {
                    binding.tilSenha.helperText = getString(R.string.preencha_a_senha)
                    binding.tilSenha.boxStrokeColor = Color.parseColor("#FF9800")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}