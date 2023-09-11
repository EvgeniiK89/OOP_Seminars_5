package models;

import presenters.Model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

public class TableModel implements Model {

    private Collection<Table> tables;
    public Collection<Table> loadTables(){

        if(tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table : loadTables()) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        //throw new RuntimeException("Некорректный номер столика");
    }

    /*
    Замена столика.
    Здесь добавляем на вход параметр в виде номера старой брони.
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    table.getReservations().remove(reservation);
                    return reservationTable(reservationDate, tableNo, name);
                }
            }
        }
        return -1;
    }
}
