/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gusta
 */
public class Ocorrencias {
    private Integer id;
    private int numeroOc;
    private int ano;
    private Apreensoes apreensoes;



    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
		this.id = id;
	}


	public int getNumeroOc() {
        return numeroOc;
    }

    public int getAno() {
        return ano;
    }

    public Apreensoes getApreensoes() {
        return apreensoes;
    }
    
    public void setNumeroOc(int numeroOc) {
		this.numeroOc = numeroOc;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setApreensoes(Apreensoes apreensoes) {
		this.apreensoes = apreensoes;
	}

	public void cadastroOc(int numeroOc, int ano, Apreensoes apreensoes){
        
        this.numeroOc = numeroOc;
        this.ano = ano;
        this.apreensoes = apreensoes;
    }
    //...
    public void listar(){};
    
}
