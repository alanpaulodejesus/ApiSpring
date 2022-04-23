package myFirstProject.rest;

import lombok.Data;
import lombok.Getter;
import myFirstProject.domain.entity.Pedido;

import java.util.Arrays;
import java.util.List;


public class ApiErrors {

    @Getter
    private List<String>errors;

    public ApiErrors(String mensagemErro){
        this.errors= Arrays.asList(mensagemErro);
    }

}
