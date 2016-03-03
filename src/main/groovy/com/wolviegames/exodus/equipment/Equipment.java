package com.wolviegames.exodus.equipment;

public class Equipment {

    private String name;
    private String description;
    private Double weight;
    private Integer cost;
    public EquipmentCategory equipmentCategory;
    public Scarcity scarcity;

    public Equipment() {
        this.name = "Name";
        this.description = "Description";
        this.weight = 0.0;
        this.cost = 0;
        this.equipmentCategory = EquipmentCategory.NONE;
        this.scarcity = Scarcity.COMMON;
    }

    public Equipment(String name, String description, Double weight, Integer cost, EquipmentCategory equipmentCategory, Scarcity scarcity) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.cost = cost;
        this.equipmentCategory = equipmentCategory;
        this.scarcity = scarcity;
    }

    public Equipment(String name, String description, Double weight, Integer cost, EquipmentCategory equipmentCategory) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.cost = cost;
        this.equipmentCategory = equipmentCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public EquipmentCategory getEquipmentCategory() {
        return equipmentCategory;
    }

    public void setEquipmentCategory(EquipmentCategory equipmentCategory) {
        this.equipmentCategory = equipmentCategory;
    }

    public Scarcity getScarcity() {
        return scarcity;
    }

    public void setScarcity(Scarcity scarcity) {
        this.scarcity = scarcity;
    }
}
