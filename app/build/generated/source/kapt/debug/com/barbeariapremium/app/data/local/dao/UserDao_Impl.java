package com.barbeariapremium.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.barbeariapremium.app.data.model.User;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfClearAllUsers;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserStatus;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `users` (`uid`,`name`,`email`,`phone`,`isAdmin`,`profileImageUrl`,`loyaltyPoints`,`cashbackAmount`,`birthDate`,`favoriteBarberId`,`address`,`status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        if (entity.getUid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUid());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        final int _tmp = entity.isAdmin() ? 1 : 0;
        statement.bindLong(5, _tmp);
        if (entity.getProfileImageUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getProfileImageUrl());
        }
        statement.bindLong(7, entity.getLoyaltyPoints());
        statement.bindDouble(8, entity.getCashbackAmount());
        if (entity.getBirthDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getBirthDate());
        }
        if (entity.getFavoriteBarberId() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getFavoriteBarberId());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getAddress());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getStatus());
        }
      }
    };
    this.__preparedStmtOfClearAllUsers = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM users";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUserStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET status = ? WHERE uid = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertUser(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUser.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearAllUsers(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllUsers.acquire();
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
          __preparedStmtOfClearAllUsers.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUserStatus(final String uid, final String newStatus,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserStatus.acquire();
        int _argIndex = 1;
        if (newStatus == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, newStatus);
        }
        _argIndex = 2;
        if (uid == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, uid);
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
          __preparedStmtOfUpdateUserStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserById(final String uid, final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM users WHERE uid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfIsAdmin = CursorUtil.getColumnIndexOrThrow(_cursor, "isAdmin");
          final int _cursorIndexOfProfileImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImageUrl");
          final int _cursorIndexOfLoyaltyPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "loyaltyPoints");
          final int _cursorIndexOfCashbackAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "cashbackAmount");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfFavoriteBarberId = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteBarberId");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final User _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUid;
            if (_cursor.isNull(_cursorIndexOfUid)) {
              _tmpUid = null;
            } else {
              _tmpUid = _cursor.getString(_cursorIndexOfUid);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final boolean _tmpIsAdmin;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAdmin);
            _tmpIsAdmin = _tmp != 0;
            final String _tmpProfileImageUrl;
            if (_cursor.isNull(_cursorIndexOfProfileImageUrl)) {
              _tmpProfileImageUrl = null;
            } else {
              _tmpProfileImageUrl = _cursor.getString(_cursorIndexOfProfileImageUrl);
            }
            final int _tmpLoyaltyPoints;
            _tmpLoyaltyPoints = _cursor.getInt(_cursorIndexOfLoyaltyPoints);
            final double _tmpCashbackAmount;
            _tmpCashbackAmount = _cursor.getDouble(_cursorIndexOfCashbackAmount);
            final String _tmpBirthDate;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmpBirthDate = null;
            } else {
              _tmpBirthDate = _cursor.getString(_cursorIndexOfBirthDate);
            }
            final String _tmpFavoriteBarberId;
            if (_cursor.isNull(_cursorIndexOfFavoriteBarberId)) {
              _tmpFavoriteBarberId = null;
            } else {
              _tmpFavoriteBarberId = _cursor.getString(_cursorIndexOfFavoriteBarberId);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _result = new User(_tmpUid,_tmpName,_tmpEmail,_tmpPhone,_tmpIsAdmin,_tmpProfileImageUrl,_tmpLoyaltyPoints,_tmpCashbackAmount,_tmpBirthDate,_tmpFavoriteBarberId,_tmpAddress,_tmpStatus);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<User> getLoggedUser() {
    final String _sql = "SELECT * FROM users LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"users"}, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfIsAdmin = CursorUtil.getColumnIndexOrThrow(_cursor, "isAdmin");
          final int _cursorIndexOfProfileImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImageUrl");
          final int _cursorIndexOfLoyaltyPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "loyaltyPoints");
          final int _cursorIndexOfCashbackAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "cashbackAmount");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfFavoriteBarberId = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteBarberId");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final User _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUid;
            if (_cursor.isNull(_cursorIndexOfUid)) {
              _tmpUid = null;
            } else {
              _tmpUid = _cursor.getString(_cursorIndexOfUid);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final boolean _tmpIsAdmin;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAdmin);
            _tmpIsAdmin = _tmp != 0;
            final String _tmpProfileImageUrl;
            if (_cursor.isNull(_cursorIndexOfProfileImageUrl)) {
              _tmpProfileImageUrl = null;
            } else {
              _tmpProfileImageUrl = _cursor.getString(_cursorIndexOfProfileImageUrl);
            }
            final int _tmpLoyaltyPoints;
            _tmpLoyaltyPoints = _cursor.getInt(_cursorIndexOfLoyaltyPoints);
            final double _tmpCashbackAmount;
            _tmpCashbackAmount = _cursor.getDouble(_cursorIndexOfCashbackAmount);
            final String _tmpBirthDate;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmpBirthDate = null;
            } else {
              _tmpBirthDate = _cursor.getString(_cursorIndexOfBirthDate);
            }
            final String _tmpFavoriteBarberId;
            if (_cursor.isNull(_cursorIndexOfFavoriteBarberId)) {
              _tmpFavoriteBarberId = null;
            } else {
              _tmpFavoriteBarberId = _cursor.getString(_cursorIndexOfFavoriteBarberId);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _result = new User(_tmpUid,_tmpName,_tmpEmail,_tmpPhone,_tmpIsAdmin,_tmpProfileImageUrl,_tmpLoyaltyPoints,_tmpCashbackAmount,_tmpBirthDate,_tmpFavoriteBarberId,_tmpAddress,_tmpStatus);
          } else {
            _result = null;
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
