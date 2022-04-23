package myFirstProject.service.impl;

import lombok.RequiredArgsConstructor;
import myFirstProject.domain.entity.Cliente;
import myFirstProject.domain.entity.ItemPedido;
import myFirstProject.domain.entity.Pedido;
import myFirstProject.domain.entity.Produto;
import myFirstProject.domain.repository.Clientes;
import myFirstProject.domain.repository.ItemsPedido;
import myFirstProject.domain.repository.Pedidos;
import myFirstProject.domain.repository.Produtos;
import myFirstProject.exception.RegraNegocioException;
import myFirstProject.rest.dto.ItemPedidoDTO;
import myFirstProject.rest.dto.PedidoDTO;
import myFirstProject.service.PedidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItemsPedido itemsPedidoRepository;

    @Override
    @Transactional //--> NÃO SALVA O PEDIDO SEM OS ITEMS CASO DÊ ALGO ERRADO DURANTE CADASTRO
    public Pedido salvar(PedidoDTO dto) {
        Integer idClientes = dto.getCliente();
        Cliente cliente = clientesRepository.findById(idClientes).orElseThrow(()-> new RegraNegocioException("Código cliente inválido!"));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List <ItemPedido> itemsPedido= converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemsPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);
        return pedido;
    }

    private List <ItemPedido>converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não é possivel realizar pedido sem itens.");
        }

        return items.stream().map(dto->{
            Integer idProduto = dto.getProduto();
            Produto produto = produtosRepository.findById(idProduto)
                    .orElseThrow(()-> new RegraNegocioException("Código produto inválido!: "+ idProduto));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);

            return itemPedido;
        }).collect(Collectors.toList());
    }
}
