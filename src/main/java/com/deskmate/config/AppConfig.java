package com.deskmate.config;

import com.deskmate.controller.BookingController;
import com.deskmate.controller.DeskController;
import com.deskmate.dao.BookingDao;
import com.deskmate.dao.DeskDao;
import com.deskmate.dao.PaymentDao;
import com.deskmate.dao.impl.JdbcBookingDao;
import com.deskmate.dao.impl.JdbcDeskDao;
import com.deskmate.dao.impl.JdbcPaymentDao;
import com.deskmate.services.BookingService;
import com.deskmate.services.DeskService;

public class AppConfig {
	public DeskController deskController() {
        DeskDao deskDao = new JdbcDeskDao();
        DeskService deskService = new DeskService(deskDao);
        return new DeskController(deskService);
    }

	public BookingController bookingController() {
        DeskDao deskDao = new JdbcDeskDao();
        BookingDao bookingDao = new JdbcBookingDao();
        PaymentDao paymentDao = new JdbcPaymentDao();
        BookingService bookingService = new BookingService(deskDao, bookingDao, paymentDao);
        return new BookingController(bookingService);
    }

}
