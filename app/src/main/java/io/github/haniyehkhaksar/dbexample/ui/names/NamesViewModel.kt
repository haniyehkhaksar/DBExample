package io.github.haniyehkhaksar.dbexample.ui.names

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import io.github.haniyehkhaksar.dbexample.domain.usecase.AddNameUseCase
import io.github.haniyehkhaksar.dbexample.domain.usecase.NameUseCase
import io.github.haniyehkhaksar.dbexample.utils.NonNullLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NamesViewModel @Inject constructor(
    nameUseCase: NameUseCase,
    private val addNameUseCase: AddNameUseCase
) : ViewModel() {

    val names = nameUseCase.execute().asLiveData()

    val newName: NonNullLiveData<String> = NonNullLiveData("")

    val message : NonNullLiveData<String> = NonNullLiveData("")

    fun addName() {
        if (newName.value.isNotEmpty())
        viewModelScope.launch(Dispatchers.IO) {
            addNameUseCase.execute(newName.value).also { result ->
                when (result) {
                    is AddNameUseCase.Result.Success -> {
                        message.postValue("Successfully added")
                    }

                    is AddNameUseCase.Result.Error -> {
                        message.postValue("Couldn't add")
                    }
                }
                newName.postValue("")
            }
        }
    }

}