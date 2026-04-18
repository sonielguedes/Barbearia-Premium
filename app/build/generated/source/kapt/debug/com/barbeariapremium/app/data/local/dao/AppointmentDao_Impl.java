package com.barbeariapremium.app.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.barbeariapremium.app.data.model.Appointment;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppointmentDao_Impl implements AppointmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Appointment> __insertionAdapterOfAppointment;

  private final EntityDeletionOrUpdateAdapter<Appointment> __updateAdapterOfAppointment;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAppointment;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllAppointments;

  public AppointmentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAppointment = new EntityInsertionAdapter<Appointment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `appointments` (`id`,`userId`,`userName`,`serviceId`,`serviceName`,`barberId`,`barberName`,`date`,`time`,`status`,`price`,`unitId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Appointment entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserId());
        }
        if (entity.getUserName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUserName());
        }
        if (entity.getServiceId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getServiceId());
        }
        if (entity.getServiceName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getServiceName());
        }
        if (entity.getBarberId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getBarberId());
        }
        if (entity.getBarberName() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBarberName());
        }
        if (entity.getDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDate());
        }
        if (entity.getTime() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getTime());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getStatus());
        }
        statement.bindDouble(11, entity.getPrice());
        if (entity.getUnitId() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getUnitId());
        }
      }
    };
    this.__updateAdapterOfAppointment = new EntityDeletionOrUpdateAdapter<Appointment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `appointments` SET `id` = ?,`userId` = ?,`userName` = ?,`serviceId` = ?,`serviceName` = ?,`barberId` = ?,`barberName` = ?,`date` = ?,`time` = ?,`status` = ?,`price` = ?,`unitId` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Appointment entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUserId());
        }
        if (entity.getUserName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUserName());
        }
        if (entity.getServiceId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getServiceId());
        }
        if (entity.getServiceName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getServiceName());
        }
        if (entity.getBarberId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getBarberId());
        }
        if (entity.getBarberName() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBarberName());
        }
        if (entity.getDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDate());
        }
        if (entity.getTime() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getTime());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getStatus());
        }
        statement.bindDouble(11, entity.getPrice());
        if (entity.getUnitId() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getUnitId());
        }
        if (entity.getId() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAppointment = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM appointments WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllAppointments = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM appointments";
        return _query;
      }
    };
  }

  @Override
  public Object insertAppointments(final List<Appointment> appointments,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAppointment.insert(appointments);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAppointment(final Appointment appointment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAppointment.insert(appointment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAppointment(final Appointment appointment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAppointment.handle(appointment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAppointment(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAppointment.acquire();
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAppointment.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllAppointments(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllAppointments.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllAppointments.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Appointment>> getUserAppointments(final String userId) {
    final String _sql = "SELECT * FROM appointments WHERE userId = ? ORDER BY date DESC, time DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"appointments"}, new Callable<List<Appointment>>() {
      @Override
      @NonNull
      public List<Appointment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final int _cursorIndexOfServiceId = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceId");
          final int _cursorIndexOfServiceName = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceName");
          final int _cursorIndexOfBarberId = CursorUtil.getColumnIndexOrThrow(_cursor, "barberId");
          final int _cursorIndexOfBarberName = CursorUtil.getColumnIndexOrThrow(_cursor, "barberName");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final List<Appointment> _result = new ArrayList<Appointment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Appointment _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpUserName;
            if (_cursor.isNull(_cursorIndexOfUserName)) {
              _tmpUserName = null;
            } else {
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            }
            final String _tmpServiceId;
            if (_cursor.isNull(_cursorIndexOfServiceId)) {
              _tmpServiceId = null;
            } else {
              _tmpServiceId = _cursor.getString(_cursorIndexOfServiceId);
            }
            final String _tmpServiceName;
            if (_cursor.isNull(_cursorIndexOfServiceName)) {
              _tmpServiceName = null;
            } else {
              _tmpServiceName = _cursor.getString(_cursorIndexOfServiceName);
            }
            final String _tmpBarberId;
            if (_cursor.isNull(_cursorIndexOfBarberId)) {
              _tmpBarberId = null;
            } else {
              _tmpBarberId = _cursor.getString(_cursorIndexOfBarberId);
            }
            final String _tmpBarberName;
            if (_cursor.isNull(_cursorIndexOfBarberName)) {
              _tmpBarberName = null;
            } else {
              _tmpBarberName = _cursor.getString(_cursorIndexOfBarberName);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            _item = new Appointment(_tmpId,_tmpUserId,_tmpUserName,_tmpServiceId,_tmpServiceName,_tmpBarberId,_tmpBarberName,_tmpDate,_tmpTime,_tmpStatus,_tmpPrice,_tmpUnitId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Appointment>> getAllAppointments() {
    final String _sql = "SELECT * FROM appointments ORDER BY date DESC, time DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"appointments"}, new Callable<List<Appointment>>() {
      @Override
      @NonNull
      public List<Appointment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final int _cursorIndexOfServiceId = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceId");
          final int _cursorIndexOfServiceName = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceName");
          final int _cursorIndexOfBarberId = CursorUtil.getColumnIndexOrThrow(_cursor, "barberId");
          final int _cursorIndexOfBarberName = CursorUtil.getColumnIndexOrThrow(_cursor, "barberName");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final List<Appointment> _result = new ArrayList<Appointment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Appointment _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpUserName;
            if (_cursor.isNull(_cursorIndexOfUserName)) {
              _tmpUserName = null;
            } else {
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            }
            final String _tmpServiceId;
            if (_cursor.isNull(_cursorIndexOfServiceId)) {
              _tmpServiceId = null;
            } else {
              _tmpServiceId = _cursor.getString(_cursorIndexOfServiceId);
            }
            final String _tmpServiceName;
            if (_cursor.isNull(_cursorIndexOfServiceName)) {
              _tmpServiceName = null;
            } else {
              _tmpServiceName = _cursor.getString(_cursorIndexOfServiceName);
            }
            final String _tmpBarberId;
            if (_cursor.isNull(_cursorIndexOfBarberId)) {
              _tmpBarberId = null;
            } else {
              _tmpBarberId = _cursor.getString(_cursorIndexOfBarberId);
            }
            final String _tmpBarberName;
            if (_cursor.isNull(_cursorIndexOfBarberName)) {
              _tmpBarberName = null;
            } else {
              _tmpBarberName = _cursor.getString(_cursorIndexOfBarberName);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            _item = new Appointment(_tmpId,_tmpUserId,_tmpUserName,_tmpServiceId,_tmpServiceName,_tmpBarberId,_tmpBarberName,_tmpDate,_tmpTime,_tmpStatus,_tmpPrice,_tmpUnitId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
