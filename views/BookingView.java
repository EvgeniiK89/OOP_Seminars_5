package views;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void showTables(Collection<Table> tables){
        for(Table table : tables){
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void printReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        } else {
            System.out.println("Не удалось забронировать столик. Попробуйте выполнить операцию позже.");
        }
    }

    @Override
    public void printChangeReservationTableResult(int reservationId) {
        if (reservationId > 0) {
            System.out.printf("Столик был изменен! Новый номер брони: #%d\n", reservationId);
        } else {
            System.out.printf("Данная бронь или столик не найдены. Повторите попытку ввода");
        }
    }

    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);
    }


    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }
}
