package com.example.organizeme.ui.home

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * Un [Fragment] simple que representa la pantalla de inicio.
 */
class HomeFragment : Fragment() {

    /**
     * Llamado para que el fragmento instancie su vista de interfaz de usuario.
     *
     * @param inflater El objeto LayoutInflater que se puede usar para inflar cualquier vista en el fragmento.
     * @param container Si no es nulo, esta es la vista principal a la que debe adjuntarse la interfaz de usuario del fragmento.
     * @param savedInstanceState Si no es nulo, este fragmento se está reconstruyendo a partir de un estado guardado anterior proporcionado aquí.
     * @return Devuelve la Vista para la interfaz de usuario del fragmento.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return LinearLayout(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER

            addView(TextView(requireContext()).apply {
                text = "Pantalla de Inicio"
                textSize = 18f
                gravity = Gravity.CENTER
            })
        }
    }
}