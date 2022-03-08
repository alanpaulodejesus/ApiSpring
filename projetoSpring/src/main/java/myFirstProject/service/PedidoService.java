package myFirstProject.service;

import myFirstProject.domain.entity.Pedido;
import myFirstProject.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar (PedidoDTO dto);
}
