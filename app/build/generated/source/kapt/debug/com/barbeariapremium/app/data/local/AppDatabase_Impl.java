package com.barbeariapremium.app.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.barbeariapremium.app.data.local.dao.AppointmentDao;
import com.barbeariapremium.app.data.local.dao.AppointmentDao_Impl;
import com.barbeariapremium.app.data.local.dao.BarberDao;
import com.barbeariapremium.app.data.local.dao.BarberDao_Impl;
import com.barbeariapremium.app.data.local.dao.CouponDao;
import com.barbeariapremium.app.data.local.dao.CouponDao_Impl;
import com.barbeariapremium.app.data.local.dao.ServiceDao;
import com.barbeariapremium.app.data.local.dao.ServiceDao_Impl;
import com.barbeariapremium.app.data.local.dao.UserDao;
import com.barbeariapremium.app.data.local.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile BarberDao _barberDao;

  private volatile ServiceDao _serviceDao;

  private volatile UserDao _userDao;

  private volatile AppointmentDao _appointmentDao;

  private volatile CouponDao _couponDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT NOT NULL, `isAdmin` INTEGER NOT NULL, `profileImageUrl` TEXT NOT NULL, `loyaltyPoints` INTEGER NOT NULL, `cashbackAmount` REAL NOT NULL, `birthDate` TEXT NOT NULL, `favoriteBarberId` TEXT NOT NULL, `address` TEXT NOT NULL, `status` TEXT NOT NULL, PRIMARY KEY(`uid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `barbers` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `photoUrl` TEXT NOT NULL, `specialties` TEXT NOT NULL, `rating` REAL NOT NULL, `active` INTEGER NOT NULL, `commissionRate` REAL NOT NULL, `monthlyGoal` REAL NOT NULL, `unitId` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `services` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `price` REAL NOT NULL, `durationMinutes` INTEGER NOT NULL, `description` TEXT NOT NULL, `imageUrl` TEXT NOT NULL, `category` TEXT NOT NULL, `rating` REAL NOT NULL, `reviewCount` INTEGER NOT NULL, `unitId` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `appointments` (`id` TEXT NOT NULL, `userId` TEXT NOT NULL, `userName` TEXT NOT NULL, `serviceId` TEXT NOT NULL, `serviceName` TEXT NOT NULL, `barberId` TEXT NOT NULL, `barberName` TEXT NOT NULL, `date` TEXT NOT NULL, `time` TEXT NOT NULL, `status` TEXT NOT NULL, `price` REAL NOT NULL, `unitId` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `coupons` (`code` TEXT NOT NULL, `discountPercentage` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, `expiryDate` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`code`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '000a5513e678a67c271bbe558b0fd1fd')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `barbers`");
        db.execSQL("DROP TABLE IF EXISTS `services`");
        db.execSQL("DROP TABLE IF EXISTS `appointments`");
        db.execSQL("DROP TABLE IF EXISTS `coupons`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(12);
        _columnsUsers.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("isAdmin", new TableInfo.Column("isAdmin", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("profileImageUrl", new TableInfo.Column("profileImageUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("loyaltyPoints", new TableInfo.Column("loyaltyPoints", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("cashbackAmount", new TableInfo.Column("cashbackAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("birthDate", new TableInfo.Column("birthDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("favoriteBarberId", new TableInfo.Column("favoriteBarberId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.barbeariapremium.app.data.model.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsBarbers = new HashMap<String, TableInfo.Column>(9);
        _columnsBarbers.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarbers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarbers.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarbers.put("specialties", new TableInfo.Column("specialties", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarbers.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarbers.put("active", new TableInfo.Column("active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarbers.put("commissionRate", new TableInfo.Column("commissionRate", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarbers.put("monthlyGoal", new TableInfo.Column("monthlyGoal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarbers.put("unitId", new TableInfo.Column("unitId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBarbers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBarbers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBarbers = new TableInfo("barbers", _columnsBarbers, _foreignKeysBarbers, _indicesBarbers);
        final TableInfo _existingBarbers = TableInfo.read(db, "barbers");
        if (!_infoBarbers.equals(_existingBarbers)) {
          return new RoomOpenHelper.ValidationResult(false, "barbers(com.barbeariapremium.app.data.model.Barber).\n"
                  + " Expected:\n" + _infoBarbers + "\n"
                  + " Found:\n" + _existingBarbers);
        }
        final HashMap<String, TableInfo.Column> _columnsServices = new HashMap<String, TableInfo.Column>(10);
        _columnsServices.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServices.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServices.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServices.put("durationMinutes", new TableInfo.Column("durationMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServices.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServices.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServices.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServices.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServices.put("reviewCount", new TableInfo.Column("reviewCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsServices.put("unitId", new TableInfo.Column("unitId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysServices = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesServices = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoServices = new TableInfo("services", _columnsServices, _foreignKeysServices, _indicesServices);
        final TableInfo _existingServices = TableInfo.read(db, "services");
        if (!_infoServices.equals(_existingServices)) {
          return new RoomOpenHelper.ValidationResult(false, "services(com.barbeariapremium.app.data.model.Service).\n"
                  + " Expected:\n" + _infoServices + "\n"
                  + " Found:\n" + _existingServices);
        }
        final HashMap<String, TableInfo.Column> _columnsAppointments = new HashMap<String, TableInfo.Column>(12);
        _columnsAppointments.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("userName", new TableInfo.Column("userName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("serviceId", new TableInfo.Column("serviceId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("serviceName", new TableInfo.Column("serviceName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("barberId", new TableInfo.Column("barberId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("barberName", new TableInfo.Column("barberName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("time", new TableInfo.Column("time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppointments.put("unitId", new TableInfo.Column("unitId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAppointments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAppointments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppointments = new TableInfo("appointments", _columnsAppointments, _foreignKeysAppointments, _indicesAppointments);
        final TableInfo _existingAppointments = TableInfo.read(db, "appointments");
        if (!_infoAppointments.equals(_existingAppointments)) {
          return new RoomOpenHelper.ValidationResult(false, "appointments(com.barbeariapremium.app.data.model.Appointment).\n"
                  + " Expected:\n" + _infoAppointments + "\n"
                  + " Found:\n" + _existingAppointments);
        }
        final HashMap<String, TableInfo.Column> _columnsCoupons = new HashMap<String, TableInfo.Column>(5);
        _columnsCoupons.put("code", new TableInfo.Column("code", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoupons.put("discountPercentage", new TableInfo.Column("discountPercentage", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoupons.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoupons.put("expiryDate", new TableInfo.Column("expiryDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoupons.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCoupons = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCoupons = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCoupons = new TableInfo("coupons", _columnsCoupons, _foreignKeysCoupons, _indicesCoupons);
        final TableInfo _existingCoupons = TableInfo.read(db, "coupons");
        if (!_infoCoupons.equals(_existingCoupons)) {
          return new RoomOpenHelper.ValidationResult(false, "coupons(com.barbeariapremium.app.data.model.Coupon).\n"
                  + " Expected:\n" + _infoCoupons + "\n"
                  + " Found:\n" + _existingCoupons);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "000a5513e678a67c271bbe558b0fd1fd", "56d5f8f8ba277cf0709c52e3787580c2");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","barbers","services","appointments","coupons");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `barbers`");
      _db.execSQL("DELETE FROM `services`");
      _db.execSQL("DELETE FROM `appointments`");
      _db.execSQL("DELETE FROM `coupons`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(BarberDao.class, BarberDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ServiceDao.class, ServiceDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AppointmentDao.class, AppointmentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CouponDao.class, CouponDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public BarberDao barberDao() {
    if (_barberDao != null) {
      return _barberDao;
    } else {
      synchronized(this) {
        if(_barberDao == null) {
          _barberDao = new BarberDao_Impl(this);
        }
        return _barberDao;
      }
    }
  }

  @Override
  public ServiceDao serviceDao() {
    if (_serviceDao != null) {
      return _serviceDao;
    } else {
      synchronized(this) {
        if(_serviceDao == null) {
          _serviceDao = new ServiceDao_Impl(this);
        }
        return _serviceDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public AppointmentDao appointmentDao() {
    if (_appointmentDao != null) {
      return _appointmentDao;
    } else {
      synchronized(this) {
        if(_appointmentDao == null) {
          _appointmentDao = new AppointmentDao_Impl(this);
        }
        return _appointmentDao;
      }
    }
  }

  @Override
  public CouponDao couponDao() {
    if (_couponDao != null) {
      return _couponDao;
    } else {
      synchronized(this) {
        if(_couponDao == null) {
          _couponDao = new CouponDao_Impl(this);
        }
        return _couponDao;
      }
    }
  }
}
