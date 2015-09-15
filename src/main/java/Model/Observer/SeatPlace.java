package Model.Observer;

import java.util.ArrayList;

/**
 * Created by ????? on 14.09.2015.
 */
public class SeatPlace {
    int seatId;
    int seat_num;
    int row;
    int place;

    public SeatPlace(int seatId, int seat_num, int row, int place) {
        this.seatId = seatId;
        this.seat_num = seat_num;
        this.row = row;
        this.place = place;
    }

    public SeatPlace(int seat_num, int row, int place) {
        this.seat_num = seat_num;
        this.row = row;
        this.place = place;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getRow() {
        return row;
    }

    public int getPlace() {
        return place;
    }

    public int getSeat_num() {
        return seat_num;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public static SeatViewer getIdXY(ArrayList<SeatPlace> seatPlaces, int row, int place){
        for (SeatPlace item: seatPlaces){
            if (item.getRow() == row && item.getPlace() == place)
                return new SeatViewer(item.getSeatId(), item.getSeat_num());
        }
        return new SeatViewer(0,0);
    }

}