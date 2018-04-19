package main.java.model;

public class FarmItem {
    private String name;
    private boolean isApproved;

    public enum FarmItemType {
        ANIMAL, FRUIT, FLOWER, VEGETABLE, NUT
    }

    private FarmItemType itemType;

    public FarmItem(String name, boolean isApproved, FarmItemType itemType) {
        this.name = name;
        this.isApproved = isApproved;
        this.itemType = itemType;
    }
}
