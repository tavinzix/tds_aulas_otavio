package br.edu.ifsul.cstsi.tds_otavio.endereco;

import br.edu.ifsul.cstsi.tds_otavio.produto.Produto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/enderecos")
public class EnderecoController {

    private final EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> findAll(){
        return ResponseEntity.ok(
                enderecoRepository.findAll().stream()
                        .map(EnderecoDto::new)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> findById(@PathVariable(value = "id") Long id){
        var endereco = enderecoRepository.findById(id);
        if (endereco.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco.map(EnderecoDto::new).get());
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<List<Endereco>> findByCep(@PathVariable(value = "cep") String cep){
        return  ResponseEntity.ok(enderecoRepository.findByCepQuerySpeakSQL(cep).get());
    }

    @PostMapping
    public ResponseEntity<String> insert (@RequestBody Endereco endereco, UriComponentsBuilder uriBuilder){
        var e = enderecoRepository.save(endereco);
        URI location = uriBuilder.path("api/v1/produtos/{id}").buildAndExpand(e.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Endereco endereco, UriComponentsBuilder uriBuilder) {
        if (!enderecoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        endereco.setId(id);
        enderecoRepository.save(endereco);
        URI location = uriBuilder.path("api/v1/enderecos/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.ok("Endereço atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (enderecoRepository.existsById(id)){
            enderecoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}