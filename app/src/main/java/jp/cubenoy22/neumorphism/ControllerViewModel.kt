package jp.cubenoy22.neumorphism

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ControllerViewModel : ViewModel() {
    val size = MutableLiveData(300)
    val maxSize = MutableLiveData(300)
    val radius = MutableLiveData(50)
    val distance = MutableLiveData(20)
    val blur = MutableLiveData(60)
}