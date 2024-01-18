package com.codigototal.notesformy.addtask.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codigototal.notesformy.addtask.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class TaskViewModel @Inject constructor() : ViewModel() {


    private val _showDialog = MutableLiveData<Boolean>();
    val showDialog: LiveData<Boolean> = _showDialog;



    //! Los live data para los listados no andan muy bien (Mejor mutable state list), porque sio no no llama a la reponposicion del item no es capas de barlo
    private val _tasks = mutableStateListOf<TaskModel>()
    val tasks: List<TaskModel> = _tasks;


    fun onDialogClose() {
        _showDialog.value = false
    }


    fun onTaskCreated(task: String) {
        _showDialog.value = false
        _tasks.add(TaskModel(task = task))
    }
    fun onShowDialogClick() {
        _showDialog.value = true;
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        val index = _tasks.indexOf(taskModel) //Encuentra la tea especifica
        _tasks[index] = _tasks[index].let {
            it.copy(selected = !it.selected);
        }
    }

    fun onItemRemove(taskModel: TaskModel) {
        val task = _tasks.find { it.id == taskModel.id }
        _tasks.remove(task)
    }


}