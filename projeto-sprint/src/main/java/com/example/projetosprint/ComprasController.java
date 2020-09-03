package com.example.projetosprint;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    private List<LivroCompra> livros = new ArrayList<>();

    @GetMapping("/listar")
    public List<LivroCompra> getLivros () {
        return livros;
    }

    @PostMapping("/cadastrar")
    public void cadastrarLivro ( @RequestBody LivroCompra livro ) {
        livros.add(livro);
    }

    @GetMapping("/recuperar/{id}")
    public LivroCompra getLivro ( @PathVariable int id ) {
        return livros.get(id - 1);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirLivro ( @PathVariable int id ) {
        livros.remove(id - 1);
    }

    @PutMapping("/alterar/{id}")
    public void alterarLivro ( @PathVariable int id, @RequestBody LivroCompra livro) {
        livros.remove(id - 1);
        livros.add(id - 1, livro);
    }
}