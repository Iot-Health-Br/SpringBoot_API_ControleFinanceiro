package com.SpringBoot_API_ControleFinanceiro.Service;

import com.SpringBoot_API_ControleFinanceiro.Entity.Pessoa;
import com.SpringBoot_API_ControleFinanceiro.Exception.UserWasRegistred;
import com.SpringBoot_API_ControleFinanceiro.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll() {
        return this.repository.findAll();
    }

    public Pessoa findById(Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    // Verifica se a pessoa ja está cadastrado, só dps salva.
    public String save(Pessoa pessoa)throws UserWasRegistred {
        boolean cpf = repository.existsByCpf(pessoa.getCpf());
        boolean nome = repository.existsByNome(pessoa.getNome());

        if (cpf && nome) {
            throw new UserWasRegistred("Pessoa já cadastrada com o nome e CPF informados!");
        } else if (cpf) {
            throw new UserWasRegistred("CPF já cadastrado!");
        } else if (nome) {
            throw new UserWasRegistred("Nome já cadastrado!");
        } else {
            repository.save(pessoa);
            return "Usuário cadastrado com sucesso!";
        }
    }

    public String update(Pessoa pessoa)throws UserWasRegistred {
        repository.save(pessoa);
        return "Usuário atualizado com sucesso!";
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
