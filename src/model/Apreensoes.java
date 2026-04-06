/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gusta
 */
public class Apreensoes {
    private Integer id;
    private String descricao;
    private String tipo;


    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }
    public void cadastroApr(Integer id, String descricao, String tipo) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
}
