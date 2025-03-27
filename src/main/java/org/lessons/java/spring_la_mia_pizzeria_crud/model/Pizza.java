package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizzas")
public class Pizza {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Length(min = 3, message = "Il nome deve avere almeno 3 caratteri e massimo 50", max = 50)
  @NotBlank(message = "Inserisci un nome valido")
  private String name;

  @Lob
  @Length(min = 5, message = "Il nome deve avere almeno 5 caratteri e massimo 100", max = 100)
  @NotBlank(message = "Inserisci una descrizione valida")
  private String description;

  @Lob
  @NotBlank(message = "Inserisci una immagine valida")
  private String image;

  @Min(value = 0, message = "Il prezzo deve essere positivo")
  @NotNull(message = "Inserisci un prezzo valido")
  private Integer price;

  public Pizza() {
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Integer getPrice() {
    return this.price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String toString() {
    return "Nome: " + name;
  }
}
