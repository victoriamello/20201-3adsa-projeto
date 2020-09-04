package com.example.projetosprint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    private List<LivroCompra> livros = new ArrayList<>();

    @GetMapping
    public ResponseEntity listarLivros () {
        if (livros.isEmpty()) {
           return ResponseEntity.status(204).build();
           // return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(livros);
        }
    }

    @PostMapping
    public ResponseEntity cadastrarLivro ( @RequestBody LivroCompra livro) {
        livros.add(livro);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity recuperarLivro ( @PathVariable int id ) {
        if (livros.size() >= id) {
            return ResponseEntity.ok(livros.get(id - 1));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirLivro ( @PathVariable int id ) {
        if (livros.size() >= id) {
            livros.remove(id - 1);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/alterar/{id}")
    public void alterarLivro ( @PathVariable int id, @RequestBody LivroCompra livro) {
        livros.remove(id - 1);
        livros.add(id - 1, livro);
    }
}