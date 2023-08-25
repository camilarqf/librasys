package br.com.librasys.domain.enums;

import lombok.Getter;

@Getter
public enum TipoPerfil {
    ADMIN(1, "ROLE_ADMIN"),
    MODERADOR(2, "ROLE_MODERADOR"),
    USUARIO(3, "ROLE_USUARIO");

    private Integer codigo;
    private String descricao;

    TipoPerfil(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoPerfil fromCode(int codigo){
        for(TipoPerfil perfil: TipoPerfil.values()){
            if(perfil.getCodigo() == codigo){
                return perfil;
            }
        }
        throw new IllegalArgumentException("Invalid Perfil code: " + codigo);
    }
}
