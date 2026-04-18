package com.barbeariapremium.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.barbeariapremium.app.data.model.Barber;
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
public final class BarberDao_Impl implements BarberDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Barber> __insertionAdapterOfBarber;

  private final SharedSQLiteStatement __preparedStmtOfDeleteBarberById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllBarbers;

  public BarberDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBarber = new EntityInsertionAdapter<Barber>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `barbers` (`id`,`name`,`photoUrl`,`specialties`,`rating`,`active`,`commissionRate`,`monthlyGoal`,`unitId`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Barber entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getPhotoUrl() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhotoUrl());
        }
        if (entity.getSpecialties() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSpecialties());
        }
        statement.bindDouble(5, entity.getRating());
        final int _tmp = entity.getActive() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindDouble(7, entity.getCommissionRate());
        statement.bindDouble(8, entity.getMonthlyGoal());
        if (entity.getUnitId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getUnitId());
        }
      }
    };
    this.__preparedStmtOfDeleteBarberById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM barbers WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllBarbers = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM barbers";
        return _query;
      }
    };
  }

  @Override
  public Object insertBarber(final Barber barber, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBarber.insert(barber);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertBarbers(final List<Barber> barbers,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBarber.insert(barbers);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteBarberById(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteBarberById.acquire();
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
          __preparedStmtOfDeleteBarberById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllBarbers(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllBarbers.acquire();
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
          __preparedStmtOfDeleteAllBarbers.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Barber>> getAllBarbers() {
    final String _sql = "SELECT * FROM barbers";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"barbers"}, new Callable<List<Barber>>() {
      @Override
      @NonNull
      public List<Barber> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfSpecialties = CursorUtil.getColumnIndexOrThrow(_cursor, "specialties");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfCommissionRate = CursorUtil.getColumnIndexOrThrow(_cursor, "commissionRate");
          final int _cursorIndexOfMonthlyGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "monthlyGoal");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final List<Barber> _result = new ArrayList<Barber>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Barber _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final String _tmpSpecialties;
            if (_cursor.isNull(_cursorIndexOfSpecialties)) {
              _tmpSpecialties = null;
            } else {
              _tmpSpecialties = _cursor.getString(_cursorIndexOfSpecialties);
            }
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final boolean _tmpActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfActive);
            _tmpActive = _tmp != 0;
            final double _tmpCommissionRate;
            _tmpCommissionRate = _cursor.getDouble(_cursorIndexOfCommissionRate);
            final double _tmpMonthlyGoal;
            _tmpMonthlyGoal = _cursor.getDouble(_cursorIndexOfMonthlyGoal);
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            _item = new Barber(_tmpId,_tmpName,_tmpPhotoUrl,_tmpSpecialties,_tmpRating,_tmpActive,_tmpCommissionRate,_tmpMonthlyGoal,_tmpUnitId);
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
  public Object getAllBarbersList(final Continuation<? super List<Barber>> $completion) {
    final String _sql = "SELECT * FROM barbers";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Barber>>() {
      @Override
      @NonNull
      public List<Barber> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfSpecialties = CursorUtil.getColumnIndexOrThrow(_cursor, "specialties");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfCommissionRate = CursorUtil.getColumnIndexOrThrow(_cursor, "commissionRate");
          final int _cursorIndexOfMonthlyGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "monthlyGoal");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final List<Barber> _result = new ArrayList<Barber>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Barber _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final String _tmpSpecialties;
            if (_cursor.isNull(_cursorIndexOfSpecialties)) {
              _tmpSpecialties = null;
            } else {
              _tmpSpecialties = _cursor.getString(_cursorIndexOfSpecialties);
            }
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final boolean _tmpActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfActive);
            _tmpActive = _tmp != 0;
            final double _tmpCommissionRate;
            _tmpCommissionRate = _cursor.getDouble(_cursorIndexOfCommissionRate);
            final double _tmpMonthlyGoal;
            _tmpMonthlyGoal = _cursor.getDouble(_cursorIndexOfMonthlyGoal);
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            _item = new Barber(_tmpId,_tmpName,_tmpPhotoUrl,_tmpSpecialties,_tmpRating,_tmpActive,_tmpCommissionRate,_tmpMonthlyGoal,_tmpUnitId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
