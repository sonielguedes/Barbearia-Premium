package com.barbeariapremium.app.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/barbeariapremium/app/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "appointmentDao", "Lcom/barbeariapremium/app/data/local/dao/AppointmentDao;", "barberDao", "Lcom/barbeariapremium/app/data/local/dao/BarberDao;", "couponDao", "Lcom/barbeariapremium/app/data/local/dao/CouponDao;", "serviceDao", "Lcom/barbeariapremium/app/data/local/dao/ServiceDao;", "userDao", "Lcom/barbeariapremium/app/data/local/dao/UserDao;", "app_debug"})
@androidx.room.Database(entities = {com.barbeariapremium.app.data.model.User.class, com.barbeariapremium.app.data.model.Barber.class, com.barbeariapremium.app.data.model.Service.class, com.barbeariapremium.app.data.model.Appointment.class, com.barbeariapremium.app.data.model.Coupon.class}, version = 4, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.barbeariapremium.app.data.local.dao.BarberDao barberDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.barbeariapremium.app.data.local.dao.ServiceDao serviceDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.barbeariapremium.app.data.local.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.barbeariapremium.app.data.local.dao.AppointmentDao appointmentDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.barbeariapremium.app.data.local.dao.CouponDao couponDao();
}