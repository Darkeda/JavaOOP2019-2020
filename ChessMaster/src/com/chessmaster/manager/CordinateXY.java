package com.chessmaster.manager;

public class CordinateXY {

    int coordinateX;

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    int coordinateY;

    public CordinateXY(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public boolean isCoordinateValid() {
        if ((coordinateX > 10 && coordinateX <= 0) &&
                (coordinateY > 10 && coordinateY <= 0)) {
            return true;
        }
        return false;
    }


}
