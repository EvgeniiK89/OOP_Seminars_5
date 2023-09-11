package presenters;

import models.Table;
import models.TableModel;
import views.BookingView;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model tableModel;
    private final View bookingView;

    public BookingPresenter(Model tableModel, View bookingView) {
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }
    public Collection<Table> loadTables(){
        return tableModel.loadTables();
    }

    public void updateTablesUI() {

        bookingView.showTables(loadTables());
    }

    public void printChangeReservationTableResult(int reservationId) {
        bookingView.printChangeReservationTableResult(reservationId);
    }

    public void updateReservationResultUI(int reservationId){

        bookingView.printReservationTableResult(reservationId);
    }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        int reservationId = tableModel.reservationTable(reservationDate, tableNo, name);
        updateReservationResultUI(reservationId);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {

        int reservationId = tableModel.changeReservationTable(oldReservation, reservationDate, tableNo,name);
        printChangeReservationTableResult(reservationId);
    }
}
