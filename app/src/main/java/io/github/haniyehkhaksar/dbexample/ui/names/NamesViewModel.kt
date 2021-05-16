package io.github.haniyehkhaksar.dbexample.ui.names

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.haniyehkhaksar.dbexample.domain.domainmodel.Name
import io.github.haniyehkhaksar.dbexample.domain.usecase.AddNameUseCase
import io.github.haniyehkhaksar.dbexample.domain.usecase.NameUseCase
import io.github.haniyehkhaksar.dbexample.utils.NonNullLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NamesViewModel @Inject constructor(
    private val nameUseCase: NameUseCase,
    private val addNameUseCase: AddNameUseCase
) : ViewModel() {

    val names: NonNullLiveData<List<Name>> = NonNullLiveData(listOf())

    val newName: NonNullLiveData<String> = NonNullLiveData("")

    val message: NonNullLiveData<String> = NonNullLiveData("")

    init {
        getNames()
    }

    fun getNames() {
        viewModelScope.launch(Dispatchers.IO) {
            nameUseCase.execute().also { result ->
                when (result) {
                    is NameUseCase.Result.Success -> {
                        names.postValue(result.data)
                        message.postValue("Successfully fetch: ${names.value.size}")
                    }

                    is NameUseCase.Result.Error -> {
                        message.postValue("Couldn't fetch")
                    }
                }
            }
        }
    }

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
                    val temp = names.value.toMutableList()
                    temp.add(Name(-1, newName.value))
                    names.postValue(temp)
                    newName.postValue("")
                }
            }
    }

}