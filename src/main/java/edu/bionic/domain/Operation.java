package edu.bionic.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Operation {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Обязательное поле")
    private String name;
    @NotNull(message = "Обязательное поле")
    @Min(value = 0, message = "Цена должна быть больше 0")
    private BigDecimal price;
    @NotNull(message = "Обязательное поле")
    private Color color;
    @NotNull(message = "Обязательное поле")
    @Min(value = 0, message = "Память должна быть больше 0")
    private Integer capacity;
    @NotBlank(message = "Обязательное поле")
    private OperationType operationType;
    private String display;
    private String description;

    public Operation() {
    }

    public Operation(Integer id) {
        this.id = id;
    }

    public Operation(Integer id, String name, BigDecimal price, Color color, Integer capacity, String display, String description) {
        this.id = id;
        this.name = name;
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.color = color;
        this.capacity = capacity;
        this.display = display;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (id != null ? !id.equals(operation.id) : operation.id != null) return false;
        if (name != null ? !name.equals(operation.name) : operation.name != null) return false;
        if (price != null ? !price.equals(operation.price) : operation.price != null) return false;
        if (color != operation.color) return false;
        if (capacity != null ? !capacity.equals(operation.capacity) : operation.capacity != null) return false;
        if (display != null ? !display.equals(operation.display) : operation.display != null) return false;
        return description != null ? description.equals(operation.description) : operation.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color=" + color +
                ", capacity=" + capacity +
                ", display='" + display + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String printInfo() {
        return String.format("<span>id: %d</span><h3>%s</h3><span>цвет: %s</span><span>объем: %d</span><span class=\"price\">%.2f USD<span>", id, name, color, capacity, price);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
