package com.example.organizeme.ui.search

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val searchBox = EditText(requireContext()).apply {
            hint = "Buscar tareas..."
        }

        val searchResults = TextView(requireContext()).apply {
            text = "Resultados de búsqueda aparecerán aquí."
        }

        return LinearLayout(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.TOP
            addView(searchBox)
            addView(searchResults)
        }
    }
}
