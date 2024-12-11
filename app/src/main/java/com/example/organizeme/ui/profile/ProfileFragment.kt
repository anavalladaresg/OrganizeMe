package com.example.organizeme.ui.profile

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val userName = TextView(requireContext()).apply {
            text = "Nombre de Usuario: Ana Valladares"
            textSize = 18f
        }

        val statistics = TextView(requireContext()).apply {
            text = "Tareas completadas: 25\nDías activos: 7\nProgreso semanal: 85%"
            textSize = 16f
        }

        return LinearLayout(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            addView(userName)
            addView(statistics)
        }
    }
}
