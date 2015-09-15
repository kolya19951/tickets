package Model.Observer;

/**
 * Created by Коля on 14.09.2015.
 */
public class SeatViewer {
    private int seatId;
    private int seatNum;

    public SeatViewer(int seatId, int seatNum) {
        this.seatId = seatId;
        this.seatNum = seatNum;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getSeatNum() {
        return seatNum;
    }
}
