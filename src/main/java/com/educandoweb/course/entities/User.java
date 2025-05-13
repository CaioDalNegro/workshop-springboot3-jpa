// Pacote onde a classe está localizada
package com.educandoweb.course.entities;

// Importações necessárias para a funcionalidade da classe
import java.io.Serializable; // Interface para permitir que objetos da classe sejam serializados
import java.util.Objects;    // Utilitário para implementação de equals e hashCode

// Anotações JPA para mapeamento com o banco de dados
import jakarta.persistence.Entity; // Indica que a classe é uma entidade JPA
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;  // Define o nome da tabela correspondente no banco de dados

// Marca a classe como uma entidade JPA e mapeia para a tabela "tb_user"
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    // Número de versão da classe para fins de serialização (boas práticas com Serializable)
    private static final long serialVersionUID = 1L;
    
    // Atributos da entidade (campos da tabela no banco de dados)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    
    // Construtor padrão obrigatório pelo JPA
    public User() {
    }

    // Construtor com todos os campos, facilita a criação de objetos User com dados prontos
    public User(Long id, String name, String email, String phone, String password) {
        super(); // Chama o construtor da superclasse (opcional aqui)
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Métodos getters e setters — acesso e modificação dos atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método hashCode sobrescrito — usado em coleções (HashSet, HashMap) para localizar objetos
    @Override
    public int hashCode() {
        return Objects.hash(id); // Usa apenas o ID para gerar o hash
    }

    // Método equals sobrescrito — define a lógica de comparação entre objetos User
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // Se os objetos forem a mesma instância, são iguais
            return true;
        if (obj == null) // Se o objeto for nulo, não são iguais
            return false;
        if (getClass() != obj.getClass()) // Se forem de classes diferentes, não são iguais
            return false;
        User other = (User) obj; // Cast para comparar os IDs
        return Objects.equals(id, other.id); // Compara os IDs para verificar igualdade
    }
}
