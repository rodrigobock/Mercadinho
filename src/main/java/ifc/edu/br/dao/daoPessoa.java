package ifc.edu.br.dao;

import java.util.ArrayList;
import ifc.edu.br.models.Pessoa;

public class daoPessoa {

    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public ArrayList<Pessoa> returnPessoas(){
        return pessoas;
    }

    public boolean addPessoa(Pessoa nova){
        try {
            pessoas.add(nova);
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    public boolean removePessoa(String cpf){
        try {
            for (Pessoa pessoa : pessoas) {
                if (pessoa.getCpf().equals(cpf)) {
                    pessoas.remove(pessoa);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    public Pessoa findPessoa(String cpf){
        try {
            for (Pessoa pessoa : pessoas) {
                if (pessoa.getCpf().equals(cpf)) {
                    return pessoa;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public boolean updatePessoa(Pessoa updatedData){
        try {
            for (int i = 0; i < pessoas.size(); i++) {
                if (pessoas.get(i).getCpf().equals(updatedData.getCpf())) {
                    pessoas.set(i, updatedData);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

}
