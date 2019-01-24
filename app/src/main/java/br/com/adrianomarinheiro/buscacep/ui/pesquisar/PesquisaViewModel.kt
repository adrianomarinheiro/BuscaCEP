package br.com.adrianomarinheiro.buscacep.ui.pesquisar

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.adrianomarinheiro.buscacep.model.Endereco
import br.com.adrianomarinheiro.buscacep.repository.EnderecoRepository

class PesquisaViewModel : ViewModel (){

    val enderecoRepository = EnderecoRepository()

    val endereco = MutableLiveData<Endereco>()
    val mensagemErro = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun buscar(cep: String) {

        isLoading.value = true

        enderecoRepository.buscar(
                cep,
                onComplete = {
                    endereco.value = it
                    mensagemErro.value = ""
                    isLoading.value = false
                },
                onError = {
                    endereco.value = null
                    mensagemErro.value = it?.message
                    isLoading.value = false
                }
        )

    }

}