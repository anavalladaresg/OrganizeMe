package com.example.organizeme.ui.home

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val tasks = listOf(
            Task("Finalizar reporte mensual", "Trabajo", false),
            Task("Comprar regalo de cumpleaños", "Personal", false),
            Task("Revisar documentos legales", "Urgente", true)
        )

        val recyclerView = RecyclerView(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            layoutManager = LinearLayoutManager(context)
            adapter = TaskAdapter(tasks,
                onTaskCompleted = { task ->
                    // Acción para marcar como completada
                },
                onTaskEdit = { task ->
                    // Acción para editar la tarea
                }
            )
        }

        return LinearLayout(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            addView(recyclerView)
        }
    }
}
