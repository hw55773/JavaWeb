package com.kxdk.pojo;

import jdk.jfr.DataAmount;
import lombok.*;

/**
 * className:       depte
 * author:          wenhao2002
 * date:            2024/4/26 20:54
 */

//@Setter
//@Getter
//@EqualsAndHashCode
//@ToString

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depte {

    private Integer id;
    private String depte_name;
    private String cagrotery;

   /* public Depte() {
    }

    public Depte(Integer id, String depte_name, String cartoery) {
        this.id = id;
        this.depte_name = depte_name;
        this.cartoery = cartoery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepte_name() {
        return depte_name;
    }

    public void setDepte_name(String depte_name) {
        this.depte_name = depte_name;
    }

    public String getCartoery() {
        return cartoery;
    }

    public void setCartoery(String cartoery) {
        this.cartoery = cartoery;
    }

    @Override
    public String toString() {
        return "depte{" +
                "id=" + id +
                ", depte_name='" + depte_name + '\'' +
                ", cartoery='" + cartoery + '\'' +
                '}';
    }*/
}
