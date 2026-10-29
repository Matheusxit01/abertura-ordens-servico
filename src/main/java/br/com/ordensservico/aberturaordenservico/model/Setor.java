import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity 
@Table (name= "Setor")
public class Setor {

@jakarta.persistence.Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int Id;

private String nome;

public int getId() {
    return Id;

 }

 public String getNome() {
    return nome;
    
}

public void setNome(String nome) {
     this.nome = nome;
 }
}