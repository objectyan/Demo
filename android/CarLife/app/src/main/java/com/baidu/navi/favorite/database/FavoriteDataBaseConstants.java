package com.baidu.navi.favorite.database;

public class FavoriteDataBaseConstants {
    public static final String CREATE_FAVORITE_POI_TABLE = "CREATE TABLE IF NOT EXISTS Fvorite_Poi( key TEXT PRIMARY KEY UNIQUE ,value TEXT )";
    public static final String DATABASE_NAME = "favorites.db";
    public static final int DATABASE_VERSION = 1;
    public static final String FAVORITE_POI_TABLE = "Fvorite_Poi";
    public static final String INSERT_OR_REPLACE_FAVORITE_POI = "INSERT OR REPLACE INTO [Fvorite_Poi] (key, value) values (?, ?);";
    private static final String INTEGER_TYPE = "INTEGER";
    public static final String IS_EXIST = "SELECT key FROM Fvorite_Poi WHERE key='%s'";
    public static final String KEY = "key";
    private static final String NUMERIC_TYPE = "NUMERIC";
    private static final String PRIMARY_TEXT_KEY = "TEXT PRIMARY KEY";
    private static final String REAL_TYPE = "REAL";
    public static final String SELECT_ALL_KEY = "SELECT key FROM Fvorite_Poi ORDER BY key DESC";
    public static final String SELECT_ALL_KEY_LIMIT = "SELECT key FROM Fvorite_Poi ORDER BY key DESC LIMIT %d";
    public static final String SELECT_VALUE_BY_KEY = "SELECT * FROM Fvorite_Poi WHERE key='%s'";
    private static final String TEXT_TYPE = "TEXT";
    private static final String UNIQUE = "UNIQUE";
    public static final String UPDATE_FAVORITE_POI = "REPLACE INTO [Fvorite_Poi] (key, value)values (?, ?)";
    public static final String VALUE = "value";
}
