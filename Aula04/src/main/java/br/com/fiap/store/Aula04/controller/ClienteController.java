package br.com.fiap.store.Aula04.controller;

//Essa classe serve para mapear endpoints

import br.com.fiap.store.Aula04.dto.cliente.CadastroClienteDto;
import br.com.fiap.store.Aula04.model.Cliente;
import br.com.fiap.store.Aula04.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fiap.store.Aula04.dto.DetalhesClienteDto;

@RestController
@RequestMapping("Clientes") //mapeia url's
public class ClienteController {

    // serve para não instanciar o repository
    @Autowired
    private ClienteRepository clienteRepository;

//UriComponentsBuilder uriBuilder Esta criando a url
    @PostMapping
    @Transactional //faz alteração no banco
    public ResponseEntity<DetalhesClienteDto> cadastrar(@RequestBody CadastroClienteDto clienteDto,
                                                        UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(clienteDto);
        clienteRepository.save(cliente);
        var url = uriBuilder.path("clientes/{codigo}").buildAndExpand(cliente.getCodigo()).toUri();

        return ResponseEntity.created(url).body(new DetalhesClienteDto(cliente));
    }
}
