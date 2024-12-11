package com.example.organizeme.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.organizeme.R

data class Task(val title: String, val category: String, val isCompleted: Boolean)

class TaskAdapter(
    private val tasks: List<Task>,
    private val onTaskCompleted: (Task) -> Unit,
    private val onTaskEdit: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskTitle: TextView = view.findViewById(R.id.taskTitle)
        val completeButton: Button = view.findViewById(R.id.completeButton)
        val editButton: Button = view.findViewById(R.id.editButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

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

    override fun getItemCount() = tasks.size
}
