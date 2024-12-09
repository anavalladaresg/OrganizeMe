package com.example.organizeme.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.organizeme.R

/**
 * Un [Fragment] simple que representa la pantalla de notificaciones.
 */
class NotificationsFragment : Fragment() {

    /**
     * Llamado para que el fragmento instancie su vista de interfaz de usuario.
     *
     * @param inflater El objeto LayoutInflater que se puede usar para inflar cualquier vista en el fragmento.
     * @param container Si no es nulo, esta es la vista principal a la que debe adjuntarse la interfaz de usuario del fragmento.
     * @param savedInstanceState Si no es nulo, este fragmento se está reconstruyendo a partir de un estado guardado anterior proporcionado aquí.
     * @return Devuelve la Vista para la interfaz de usuario del fragmento, o nulo.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño para este fragmento
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }
}