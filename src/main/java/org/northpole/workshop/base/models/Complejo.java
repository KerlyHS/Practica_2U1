package org.northpole.workshop.base.models;

public class Complejo {
    private float num;
    private float img;

    public Complejo(float num, float img) {
        this.num = num;
        this.img = img;
    }
    public Complejo() {}

    public float getImg() {
        return img;
    }
    public void setImg(float img) {
        this.img = img;
    }
    public float getNum() {
        return num;
    }
    public void setNum(float num) {
        this.num = num;
    }
}
