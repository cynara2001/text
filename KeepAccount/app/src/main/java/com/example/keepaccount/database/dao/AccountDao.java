package com.example.keepaccount.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.keepaccount.database.AccountOpenHelper;
import com.example.keepaccount.database.domain.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDao {

    private final AccountOpenHelper accountOpenHelper;

    private static AccountDao accountDao = null;

    /**
     * 这是一个私有的构造方法
     *
     * @param context
     */
    private AccountDao(Context context) {
        accountOpenHelper = new AccountOpenHelper(context);
    }

    public static AccountDao getInstance(Context context) {
        if (accountDao == null) {
            accountDao = new AccountDao(context);
        }
        return accountDao;
    }

    //保存数据
    public void insert(Account account) {
        //我们使用accountOpenHelper获取一个可写的数据库实例

        //实例化数据库对象
        SQLiteDatabase database = accountOpenHelper.getWritableDatabase();

        //构造保存数据
        ContentValues values = new ContentValues();
        values.put("sum", account.getSum());
        values.put("remark", account.getRemark());

        //插入数据
        database.insert("account", null, values);

        //关闭数据库
        database.close();
    }


    public List<Account> findAll() {
        //实例化数据库对象
        SQLiteDatabase database = accountOpenHelper.getWritableDatabase();

        Cursor cursor = database.query("account", new String[]{"_id", "sum", "remark"}, null, null, null, null, null);

        List<Account> accountList = new ArrayList<>();

        while (cursor.moveToNext()) {
            Account account = new Account();
            account.setId(cursor.getInt(0));
            //第0是id，第1是sum，第2是remark
            account.setSum(cursor.getInt(1));
            account.setRemark(cursor.getString(2));
            accountList.add(account);
        }

        //关闭数据库
        database.close();

        return accountList;


    }

}

























