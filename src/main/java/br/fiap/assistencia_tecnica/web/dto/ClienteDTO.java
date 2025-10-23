package br.fiap.assistencia_tecnica.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
}
