package myFirstProject.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //==> Equivale as anotações Getter Setter To String e EqualsAndHashCode
public class ItemPedidoDTO {

    private Integer produto;
    private Integer quantidade;
}
