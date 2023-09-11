import models.TableModel;
import presenters.BookingPresenter;
import views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);
        bookingPresenter.updateTablesUI();

        view.reservationTable(new Date(), 5 , "Станислав");
        System.out.println("");
        /*
        Вызываем метод changeReservationTable() для замены столика. При попытке ввода некорректной брони или некорректного
        номера столика получим сообщение о необходимости попытке ввода.
         */
        view.changeReservationTable(101,new Date(),4,"Станислав");
    }
}
