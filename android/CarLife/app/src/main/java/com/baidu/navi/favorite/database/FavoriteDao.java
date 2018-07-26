package com.baidu.navi.favorite.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.carlife.core.C1260i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FavoriteDao {
    public static final String TAG = FavoriteDao.class.getSimpleName();
    private SQLiteDatabase mDatabase;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isExist(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0006 in list [B:18:0x0053]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r8 = this;
        r4 = 1;
        r3 = 0;
        r5 = r8.mDatabase;
        if (r5 != 0) goto L_0x0007;
    L_0x0006:
        return r3;
    L_0x0007:
        r0 = 0;
        r5 = "SELECT key FROM Fvorite_Poi WHERE key='%s'";
        r6 = new java.lang.Object[r4];
        r6[r3] = r9;
        r2 = java.lang.String.format(r5, r6);
        r5 = TAG;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "isExist: ";
        r6 = r6.append(r7);
        r6 = r6.append(r2);
        r6 = r6.toString();
        com.baidu.carlife.core.C1260i.b(r5, r6);
        r5 = r8.mDatabase;	 Catch:{ Exception -> 0x0048, all -> 0x0057 }
        r6 = 0;	 Catch:{ Exception -> 0x0048, all -> 0x0057 }
        r0 = r5.rawQuery(r2, r6);	 Catch:{ Exception -> 0x0048, all -> 0x0057 }
        if (r0 == 0) goto L_0x0042;	 Catch:{ Exception -> 0x0048, all -> 0x0057 }
    L_0x0035:
        r5 = r0.getCount();	 Catch:{ Exception -> 0x0048, all -> 0x0057 }
        if (r5 <= 0) goto L_0x0042;
    L_0x003b:
        if (r0 == 0) goto L_0x0040;
    L_0x003d:
        r0.close();
    L_0x0040:
        r3 = r4;
        goto L_0x0006;
    L_0x0042:
        if (r0 == 0) goto L_0x0006;
    L_0x0044:
        r0.close();
        goto L_0x0006;
    L_0x0048:
        r1 = move-exception;
        r4 = TAG;	 Catch:{ Exception -> 0x0048, all -> 0x0057 }
        r5 = "isExist DB Exception";	 Catch:{ Exception -> 0x0048, all -> 0x0057 }
        com.baidu.carlife.core.C1260i.b(r4, r5);	 Catch:{ Exception -> 0x0048, all -> 0x0057 }
        if (r0 == 0) goto L_0x0006;
    L_0x0053:
        r0.close();
        goto L_0x0006;
    L_0x0057:
        r3 = move-exception;
        if (r0 == 0) goto L_0x005d;
    L_0x005a:
        r0.close();
    L_0x005d:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navi.favorite.database.FavoriteDao.isExist(java.lang.String):boolean");
    }

    public FavoriteDao(SQLiteDatabase database) {
        this.mDatabase = database;
    }

    public boolean add(String key, String value) {
        boolean z = false;
        if (this.mDatabase == null) {
            return 0;
        }
        try {
            this.mDatabase.beginTransaction();
            z = addToDB(key, value);
            this.mDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            return z;
        } finally {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e2) {
                return false;
            }
        }
        return z;
    }

    public boolean addAll(Map<String, String> map) {
        boolean ret = false;
        if (map == null) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        try {
            this.mDatabase.beginTransaction();
            for (Entry<String, String> entry : map.entrySet()) {
                addToDB((String) entry.getKey(), (String) entry.getValue());
            }
            this.mDatabase.setTransactionSuccessful();
            ret = true;
        } catch (Exception e) {
        } finally {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e2) {
                return false;
            }
        }
        return ret;
    }

    private boolean addToDB(String key, String value) {
        try {
            this.mDatabase.execSQL(FavoriteDataBaseConstants.INSERT_OR_REPLACE_FAVORITE_POI, new String[]{key, value});
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(String key) {
        boolean ret = false;
        if (this.mDatabase == null) {
            return 0;
        }
        try {
            this.mDatabase.beginTransaction();
            String[] whereArgs = new String[]{key + ""};
            if (this.mDatabase.delete(FavoriteDataBaseConstants.FAVORITE_POI_TABLE, "key=?", whereArgs) > 0) {
                ret = true;
            } else {
                ret = false;
            }
            this.mDatabase.setTransactionSuccessful();
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                ret = false;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                ret = false;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return ret;
    }

    public boolean removeAll(List<String> keys) {
        boolean ret = false;
        if (this.mDatabase == null) {
            return 0;
        }
        try {
            this.mDatabase.beginTransaction();
            String whereClause = "key=?";
            for (String key : keys) {
                this.mDatabase.delete(FavoriteDataBaseConstants.FAVORITE_POI_TABLE, whereClause, new String[]{key + ""});
            }
            this.mDatabase.setTransactionSuccessful();
            ret = true;
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                ret = false;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                ret = false;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return ret;
    }

    public boolean update(String key, String value) {
        boolean z = false;
        if (this.mDatabase == null) {
            return 0;
        }
        try {
            this.mDatabase.beginTransaction();
            z = updateToDB(key, value);
            this.mDatabase.setTransactionSuccessful();
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e) {
                z = false;
            }
        } catch (Exception e2) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e3) {
                z = false;
            }
        } catch (Throwable th) {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
        return z;
    }

    public boolean updateAll(Map<String, String> map) {
        boolean ret = false;
        if (map == null) {
            return 0;
        }
        if (this.mDatabase == null) {
            return 0;
        }
        try {
            this.mDatabase.beginTransaction();
            for (Entry<String, String> entry : map.entrySet()) {
                updateToDB((String) entry.getKey(), (String) entry.getValue());
            }
            this.mDatabase.setTransactionSuccessful();
            ret = true;
        } catch (Exception e) {
        } finally {
            try {
                this.mDatabase.endTransaction();
            } catch (Exception e2) {
                return false;
            }
        }
        return ret;
    }

    private boolean updateToDB(String key, String value) {
        try {
            this.mDatabase.execSQL(FavoriteDataBaseConstants.UPDATE_FAVORITE_POI, new String[]{key, value});
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getValue(String key) {
        String str = null;
        if (this.mDatabase != null) {
            Cursor cursor = null;
            String selectQuery = String.format(FavoriteDataBaseConstants.SELECT_VALUE_BY_KEY, new Object[]{key});
            C1260i.b(TAG, "getValue: " + selectQuery);
            try {
                cursor = this.mDatabase.rawQuery(selectQuery, null);
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    str = cursor.getString(cursor.getColumnIndex("value"));
                    if (cursor != null) {
                        cursor.close();
                    }
                } else if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                C1260i.b(TAG, "getValue DB Exception");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return str;
    }

    public List<String> getAllKey() {
        Throwable th;
        ArrayList<String> arrayList = null;
        if (this.mDatabase == null) {
            return null;
        }
        Cursor cursor = null;
        try {
            cursor = this.mDatabase.rawQuery(FavoriteDataBaseConstants.SELECT_ALL_KEY, null);
            C1260i.b(TAG, "getAllKey: SELECT key FROM Fvorite_Poi ORDER BY key DESC");
            if (cursor != null && cursor.getCount() > 0) {
                ArrayList<String> list = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        list.add(cursor.getString(cursor.getColumnIndex("key")));
                    } catch (Exception e) {
                        arrayList = list;
                    } catch (Throwable th2) {
                        th = th2;
                        arrayList = list;
                    }
                }
                arrayList = list;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            try {
                C1260i.b(TAG, "getAllKey DB Exception");
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return arrayList;
    }

    public boolean clear() {
        return true;
    }
}
