package com.example.organizeme.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.organizeme.R

/**
 * Datos de la tarea.
 *
 * @property title El título de la tarea.
 * @property category La categoría de la tarea.
 * @property isCompleted Indica si la tarea está completada.
 */
data class Task(val title: String, val category: String, val isCompleted: Boolean)

/**
 * Adaptador para mostrar una lista de tareas en un RecyclerView.
 *
 * @property tasks Lista de tareas a mostrar.
 * @property onTaskCompleted Función a ejecutar cuando una tarea se marca como completada.
 * @property onTaskEdit Función a ejecutar cuando se edita una tarea.
 */
class TaskAdapter(
    private val tasks: List<Task>,
    private val onTaskCompleted: (Task) -> Unit,
    private val onTaskEdit: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    /**
     * ViewHolder para los elementos de la lista de tareas.
     *
     * @param view La vista del elemento de la lista.
     */
    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskTitle: TextView = view.findViewById(R.id.taskTitle)
        val completeButton: Button = view.findViewById(R.id.completeButton)
        val editButton: Button = view.findViewById(R.id.editButton)
    }

    /**
     * Crea un nuevo ViewHolder cuando no hay suficientes ViewHolders existentes.
     *
     * @param parent El ViewGroup al que se añadirá la nueva vista.
     * @param viewType El tipo de vista del nuevo ViewHolder.
     * @return Un nuevo TaskViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    /**
     * Vincula los datos de una tarea a un ViewHolder.
     *
     * @param holder El ViewHolder que se va a vincular.
     * @param position La posición de la tarea en la lista.
     */
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskTitle.text = task.title

        holder.completeButton.setOnClickListener {
            onTaskCompleted(task)
        }

        holder.editButton.setOnClickListener {
            onTaskEdit(task)
        }
    }

    /**
     * Devuelve el número total de tareas en la lista.
     *
     * @return El tamaño de la lista de tareas.
     */
    override fun getItemCount() = tasks.size
}