package model;


public class Dog {

    private int dogId;
    private int ownerId;
    private String dogName;
    private String dogBreed;
    private int dogAge;
    private int dogWeight;
    private String dogMOrF;

    @Override
    public String toString() {
        return super.toString();
    }

    public int getDogId() {
        return dogId;
    }
    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getDogName() {
        return dogName;
    }
    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
    public String getDogBreed() {
        return dogBreed;
    }
    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }
    public int getDogAge() {
        return dogAge;
    }
    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }
    public int getDogWeight() {
        return dogWeight;
    }
    public void setDogWeight(int dogWeight) {
        this.dogWeight = dogWeight;
    }
    public String getDogMOrF() {
        return dogMOrF;
    }
    public void setDogMOrF(String dogMOrF) {
        this.dogMOrF = dogMOrF;
    }
}
